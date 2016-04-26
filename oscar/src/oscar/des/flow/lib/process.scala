/*******************************************************************************
  * OscaR is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Lesser General Public License as published by
  * the Free Software Foundation, either version 2.1 of the License, or
  * (at your option) any later version.
  *
  * OscaR is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Lesser General Public License  for more details.
  *
  * You should have received a copy of the GNU Lesser General Public License along with OscaR.
  * If not, see http://www.gnu.org/licenses/lgpl-3.0.en.html
  ******************************************************************************/

package oscar.des.flow.lib

import oscar.des.engine.Model
import oscar.des.flow.DoublyLinkedList
import oscar.des.flow.core.ItemClassHelper._
import oscar.des.flow.core._

import scala.collection.immutable.SortedMap
import scala.collection.mutable
import scala.language.implicitConversions

/**
  * a process inputs some inputs, and produces its outputs at a given rate.
  * notice that inputs and outputs are performed in parallel (thus might cause some deadlocks)
  *
  * @param m the simulation model
  * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
  * @param inputs the set of inputs (number of parts to input, storage)
  * @param outputs the set of outputs (number of parts, storage)
  * @param name the name of this process, for pretty printing
  * @param verbosity where verbosities should be sent, can be null
  * @author renaud.delandtsheer@cetic.be
  * */
case class SingleBatchProcess(m:Model,
                              batchDuration:() => Double,
                              inputs:Array[(() => Int, Fetchable)],
                              outputs:Array[(()=>Int, Putable)],
                              transformFunction:ItemClassTransformFunction,
                              override val name:String,
                              verbosity:(String*)=>Unit = null,
                              override val id:Int = -1) extends ActivableAtomicProcess(name,verbosity, id){

  private val myOutput = new Outputter(outputs)
  override val myInput = new Inputter(inputs)

  var performedBatches = 0
  var startedBatches = 0
  private var mTotalWaitDuration:Double = 0
  private var startWaitTime:Double = 0
  private var waiting = false

  def isWaiting = waiting

  override def cloneReset(newModel: Model, storages: SortedMap[Storage, Storage]): ActivableProcess = {
    SingleBatchProcess(newModel,
                       batchDuration,
                       inputs.map({case (fun,fetchable) => (fun,storages(fetchable.asInstanceOf[Storage]))}),
                       outputs.map({case (fun,putable) => (fun,storages(putable.asInstanceOf[Storage]))}),
                       transformFunction,
                       name,
                       verbosity,
                       id)
  }

  override def isRunning: Boolean = !waiting
  override def completedBatchCount: Int = performedBatches
  override def startedBatchCount: Int = startedBatches
  override def totalWaitDuration():Double = if (waiting) mTotalWaitDuration + m.clock() - startWaitTime else mTotalWaitDuration

  startBatches()

  private def startBatches(){
    if (verbosity!=null) verbosity("event", name, "Start inputting")
    startWaitTime = m.clock()
    waiting = true
    myInput.performInput((i:ItemClass) => {
      if (verbosity!=null) verbosity("event", name, "Start new batch")
      startedBatches += 1
      mTotalWaitDuration += (m.clock() - startWaitTime)
      waiting = false
      m.wait(batchDuration()){
        if (verbosity!=null) verbosity("event", name, "Finished batch")
        startWaitTime = m.clock()
        waiting = true
        performedBatches +=1
        myOutput.performOutput(transformFunction(i), () => {
          if (verbosity!=null) verbosity("event", name, "Finished outputting")
          mTotalWaitDuration += (m.clock() - startWaitTime)
          waiting = false
          startBatches()
        })
      }
    })
  }

  def mapInfo: Map[String, Double] = Map("Performed batches" -> performedBatches,
                                         "Total wait duration" -> totalWaitDuration)

  override def toString: String = {
    name + " " + this.getClass.getSimpleName + ":: performedBatches:" + performedBatches + " totalWaitDuration:" + totalWaitDuration + (if (waiting) " waiting" else " running")
  }
}

/**
  * This represents a batch process (see [[SingleBatchProcess]]) with multiple batch running in parallel.
  *
  * @param numberOfBatches the number of batches running in parallel.
  * @param m the simulation model
  * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
  * @param inputs the set of inputs (number of parts to input, storage)
  * @param outputs the set of outputs (number of parts, storage)
  * @param name the name of this process, for pretty printing, bath are named "name chain i" where i is the identifier of the batch process
  * @param verbosity to dispatch verbosities of the object. can be null
  * @author renaud.delandtsheer@cetic.be
  * */
case class BatchProcess(m:Model,
                        numberOfBatches:Int,
                        batchDuration:() => Double,
                        inputs:Array[(() => Int, Fetchable)],
                        outputs:Array[(() => Int,Putable)],
                        override val name:String,
                        transformFunction:ItemClassTransformFunction,
                        verbosity:(String*)=>Unit = null,
                        override val id:Int = -1) extends ActivableMultipleProcess(name,verbosity, id){

  override val childProcesses:Iterable[SingleBatchProcess] =
    (1 to numberOfBatches) map((batchNumber:Int) => SingleBatchProcess(m:Model,
                                                                       batchDuration,
                                                                       inputs,
                                                                       outputs,
                                                                       transformFunction,
                                                                       name + " chain " + batchNumber,
                                                                       verbosity,
                                                                       id))

  def mapInfo: Map[String, Double] = Map("Lines" -> numberOfBatches,
                                         "Performed batches" -> childProcesses.foldLeft(0)(_ + _.performedBatches),
                                         "Total wait duration" -> childProcesses.foldLeft(0.0)(_ + _.totalWaitDuration),
                                         "Waiting lines" -> childProcesses.foldLeft(0)((waitings:Int,p:SingleBatchProcess) => waitings + (if (p.isWaiting) 1 else 0)))

  override def toString: String = {
    name + " " + this.getClass.getSimpleName + ":: lines:" + numberOfBatches +" performedBatches:" + childProcesses.foldLeft(0)(_ + _.performedBatches) +
      " totalWaitDuration:" + childProcesses.foldLeft(0.0)(_ + _.totalWaitDuration) +
      " waitingLines:" + childProcesses.foldLeft(0)((waitings:Int,p:SingleBatchProcess) => waitings + (if (p.isWaiting) 1 else 0))
  }

  override def cloneReset(newModel: Model, storages: SortedMap[Storage, Storage]): ActivableProcess = {
    BatchProcess(newModel,
                 numberOfBatches,
                 batchDuration,
                 inputs.map({case (fun,fetchable) => (fun,storages(fetchable.asInstanceOf[Storage]))}),
                 outputs.map({case (fun,putable) => (fun,storages(putable.asInstanceOf[Storage]))}),
                 name,
                 transformFunction,
                 verbosity,
                 id)
  }
}

/**
  * A process inputs some inputs, and produces its outputs at a given rate.
  * notice that inputs and outputs are performed in parallel (thus might cause some deadlocks)
  * this process might fail. In this case, failure is assessed at the end of the batch duration,
  * and produces the failureOutputs
  *
  * @param m the simulation model
  * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
  * @param inputs the set of inputs (number of parts to input, storage)
  * @param outputs the set of outputs (number of parts, storage)
  * @param name the name of this process, for pretty printing
  * @param verbosity where verbosities should be sent, can be null
  * @author renaud.delandtsheer@cetic.be
  * */
case class SplittingSingleBatchProcess(m:Model,
                                       batchDuration:() => Double,
                                       inputs:Array[(() => Int, Fetchable)],
                                       outputs:Array[Array[(() => Int,Putable)]],
                                       transformFunction:ItemClassTransformWitAdditionalOutput,
                                       override val name:String,
                                       verbosity:(String*)=>Unit = null,
                                       override val id:Int = -1) extends ActivableAtomicProcess(name,verbosity, id){

  private val myOutputs = outputs.map(o => new Outputter(o))
  override val myInput = new Inputter(inputs)

  var performedBatches = 0
  var startedBatches = 0
  private val completedBatches:Array[Int]= Array.fill(outputs.length)(0)

  private var mTotalWaitDuration: Double = 0
  private var startWaitTime: Double = 0
  private var waiting = false //waiting at an input or output

  def isWaiting = waiting

  override def cloneReset(newModel: Model, storages: SortedMap[Storage, Storage]): ActivableProcess = {
    SplittingSingleBatchProcess(newModel,
                                batchDuration,
                                inputs.map({case (fun,fetchable) => (fun,storages(fetchable.asInstanceOf[Storage]))}),
                                outputs.map(_.map({case (fun,putable) => (fun,storages(putable.asInstanceOf[Storage]).asInstanceOf[Putable])})),
                                transformFunction,
                                name,
                                verbosity,
                                id)
  }

  override def isRunning: Boolean = !waiting

  override def completedBatchCount: Int = performedBatches

  override def startedBatchCount: Int = startedBatches

  override def totalWaitDuration():Double = if (waiting) mTotalWaitDuration + m.clock() - startWaitTime else mTotalWaitDuration

  startBatches()

  private def startBatches(){
    if (verbosity!=null) verbosity("event", name, "Start inputting")
    startWaitTime = m.clock()
    waiting = true
    myInput.performInput((i:ItemClass) => {
      if (verbosity!=null) verbosity("event", name, "Start new batch")
      startedBatches += 1
      mTotalWaitDuration += (m.clock() - startWaitTime)
      waiting = false
      m.wait(batchDuration()){
        startWaitTime = m.clock()
        waiting = true
        performedBatches +=1
        val (outputPort,outputi) = transformFunction(i)
        if (verbosity!=null) verbosity("event", name, "Finished batch, outputting to " + outputPort)
        completedBatches(outputPort) += 1
        myOutputs(outputPort).performOutput(outputi, () => {
          if (verbosity!=null) verbosity("event", name, "Finished outputting")
          mTotalWaitDuration += (m.clock() - startWaitTime)
          waiting = false
          startBatches()
        })
      }
    })
  }

  def mapInfo: Map[String, Double] = {
    var map = Map("Performed batches" -> performedBatches.toDouble,
                  "Total wait duration" -> totalWaitDuration)
    for (i <- completedBatches.indices) {
      map += (s"Output in batch $i" -> completedBatches(i).toDouble)
    }
    map
  }

  override def toString: String = {
    name + " " + this.getClass.getSimpleName + ":: performedBatches:" + performedBatches + " outputBatches:[" + completedBatches.mkString(";") + "] totalWaitDuration:" + totalWaitDuration + (if (waiting) " waiting" else " running")
  }
}

/**
  * This represents a failing batch process (see [[SplittingBatchProcess]]) with multiple batch running in parallel.
  *
  * @param m the simulation model
  * @param numberOfBatches the number of batches running in parallel.
  * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
  * @param inputs the set of inputs (number of parts to input, storage)
  * @param outputs the set of outputs (number of parts, storage)
  * @param name the name of this process, for pretty printing
  * @param verbosity where verbosities should be sent, can be null
  * @author renaud.delandtsheer@cetic.be
  * */
case class SplittingBatchProcess(m:Model,
                                 numberOfBatches:Int,
                                 batchDuration:() => Double,
                                 inputs:Array[(() => Int, Fetchable)],
                                 outputs:Array[Array[(()=>Int,Putable)]],
                                 override val name:String,
                                 transformFunction:ItemClassTransformWitAdditionalOutput,
                                 verbosity:(String*)=>Unit = null,
                                 override val id:Int = -1) extends ActivableMultipleProcess(name,verbosity, id){

  override val childProcesses:Iterable[SplittingSingleBatchProcess] =
    (1 to numberOfBatches) map((batchNumber:Int) => SplittingSingleBatchProcess(m,
                                                                                batchDuration,
                                                                                inputs,
                                                                                outputs,
                                                                                transformFunction,
                                                                                name + " chain " + batchNumber,
                                                                                verbosity,
                                                                                id))

  def mapInfo: Map[String, Double] = {
    var map = mutable.Map("Lines" -> numberOfBatches.toDouble,
                          "Performed batches" -> childProcesses.foldLeft(0D)(_ + _.performedBatches),
                          "Total wait duration" -> childProcesses.foldLeft(0D)(_ + _.totalWaitDuration),
                          "Waiting lines" -> childProcesses.foldLeft(0)((waitings:Int,
                                                                         p:SplittingSingleBatchProcess) => waitings + (if (p.isWaiting) 1 else 0)).toDouble)
    childProcesses.foreach((p:SplittingSingleBatchProcess) => {
      for (key <- p.mapInfo.keys) {
        if (map.keySet.contains(key)) {
          val newValueKey =  map.get(key).get + p.mapInfo.get(key).get
          map += (key -> newValueKey)
        }
        else {
          map += (key -> p.mapInfo.get(key).get)
        }
      }
    })
    map.toMap
  }

  override def toString: String = {
    name + ":: lines:" + numberOfBatches + " performedBatches: " + childProcesses.foldLeft(0)(_ + _.performedBatches) +
      " totalWaitDuration:" + childProcesses.foldLeft(0.0)(_ + _.totalWaitDuration) +
      " waitingLines:" + childProcesses.foldLeft(0)((waitings:Int,p:SplittingSingleBatchProcess) => waitings + (if (p.isWaiting) 1 else 0))
  }

  override def cloneReset(newModel: Model, storages: SortedMap[Storage, Storage]): ActivableProcess = {
    SplittingBatchProcess(newModel,
                          numberOfBatches,
                          batchDuration,
                          inputs.map({case (fun,fetchable) => (fun,storages(fetchable.asInstanceOf[Storage]))}),
                          outputs.map(_.map({case (fun,putable) => (fun,storages(putable.asInstanceOf[Storage]).asInstanceOf[Putable])})),
                          name,
                          transformFunction,
                          verbosity,
                          id)
  }
}

/**
  *  A rolling (in a conveyor belt) Process means that if the output is blocked, no new batch is started
  * (imagine an industrial rolling band oven where croissants are cooked)
  * and if the input is blocked, the output still proceeds, (as if we were starting empty batches) there is no catch up for the waited time
  * batch only start when they ave their complete inputs.
  * if the output is blocked, the process stops, thus does not perform new inputs either (we cannot model that croissants will eventually burn in the oven)
  *
  * @param m the simulation model
  * @param processDuration the duration between inputting a batch and outputting the batch
  * @param minimalSeparationBetweenBatches the minimal separation between two consecutive batches
  * @param inputs the set of inputs (number of parts to input, storage)
  * @param outputs the set of outputs (number of parts, storage)
  * @param name the name of this process, for pretty printing
  * @param verbosity where verbosities should be sent, can be null
  * @author renaud.delandtsheer@cetic.be
  */
class ConveyorBeltProcess(m:Model,
                          processDuration:() => Double,
                          minimalSeparationBetweenBatches:Double,
                          val inputs:Array[(() => Int, Fetchable)],
                          val outputs:Array[(() => Int, Putable)],
                          transformFunction:ItemClassTransformFunction,
                          name:String,
                          verbosity:(String*)=>Unit = null,
                          override val id:Int = -1) extends ActivableAtomicProcess(name,verbosity, id){

  private val myOutput = new Outputter(outputs)
  override val myInput = new Inputter(inputs)

  //the belt contains the delay for the output since the previous element that was input. delay since input if the belt was empty
  private val belt: DoublyLinkedList[(Double,ItemClass)] = new DoublyLinkedList[(Double,ItemClass)]()

  override def isRunning: Boolean = !blocked
  override def completedBatchCount: Int = totalOutputBatches

  override def startedBatchCount: Int = totalInputBatches

  override def cloneReset(newModel: Model, storages: SortedMap[Storage, Storage]): ActivableProcess = {
    new ConveyorBeltProcess(newModel,
                            processDuration,
                            minimalSeparationBetweenBatches,
                            inputs.map({case (fun,fetchable) => (fun,storages(fetchable.asInstanceOf[Storage]))}),
                            outputs.map({case (fun,putable) => (fun,storages(putable.asInstanceOf[Storage]))}),
                            transformFunction,
                            name,
                            verbosity,
                            id)
  }

  private var timeOfLastInput:Double = 0

  private var blocked:Boolean = false
  private var startBlockingTime:Double = 0
  private var outputMustBeRestarted:Boolean = true
  private var inputMustBeRestarted:Boolean = true

  private var blockedTimeSinceLastInput:Double = 0

  private var totalInputBatches = 0
  private var totalOutputBatches = 0
  private var mTotalBlockedTime:Double = 0.0
  restartInputtingIfNeeded()

  override def totalWaitDuration():Double = if (blocked) mTotalBlockedTime + m.clock() - startBlockingTime else mTotalBlockedTime

  def mapInfo: Map[String, Double] = Map("Content" -> belt.size,
                                         "Total input batches" -> totalInputBatches,
                                         "Total output batches" -> totalOutputBatches,
                                         "Total blocked time" -> totalWaitDuration)

  override def toString: String = {
    name + " " + this.getClass.getSimpleName + ":: content:" + belt.size + " totalInputBatches:" + totalInputBatches + " totalOutputBatches:" + totalOutputBatches + " totalBlockedTime:" + totalWaitDuration + (if (blocked) " blocked" else " running")
  }

  private def restartInputtingIfNeeded(): Unit ={
    if (inputMustBeRestarted) {
      if(verbosity!=null) verbosity("event", name, "Restarting belt")
      inputMustBeRestarted = false
      startPerformInput()
    }
  }

  //on s'assure juste qu'il y aie assez de place depuis le dernier qu'on a mis dedans
  private def startPerformInput() {
    val timeForNextInput = timeOfLastInput + minimalSeparationBetweenBatches + blockedTimeSinceLastInput

    if (blocked) {
      if (verbosity!=null) verbosity("event", name, "Belt blocked at output, next input blocked")
      inputMustBeRestarted = true
    } else if (belt.isEmpty || timeForNextInput >= m.clock()) {
      //we can perform the input
      if (verbosity!=null) verbosity("event", name, "Start input")
      startBlockingTime = m.clock()
      myInput.performInput(finishedInputs)
    } else {
      //we cannot do the input; need to sleep a bit because belt was blocked from output
      val durationToNextInput = timeForNextInput - m.clock()
      m.wait(durationToNextInput){startPerformInput()}
    }
  }

  private def finishedInputs(i:ItemClass): Unit ={
    if (belt.isEmpty) {
      belt.prepend((processDuration(),transformFunction(i)))
    } else {
      belt.prepend((m.clock - timeOfLastInput,transformFunction(i)))
    }
    timeOfLastInput = m.clock()
    blockedTimeSinceLastInput = 0
    restartOutputtingIfNeeded()
    if (verbosity!=null) verbosity("event", name, "Input performed")
    totalInputBatches += 1
    m.wait(minimalSeparationBetweenBatches){startPerformInput()}
  }

  //called at input time, after belt has been fed again
  private def restartOutputtingIfNeeded(){
    if (outputMustBeRestarted) {
      require(belt.nonEmpty)
      outputMustBeRestarted = false
      m.wait(belt.last._1) {
        startPerformOutput(belt.last._2)
      }
    }
  }

  private def startPerformOutput(i:ItemClass) {
    blocked = true
    startBlockingTime = m.clock()
    if (verbosity!=null) verbosity("event", name, "Start outputting")
    myOutput.performOutput(i,finishedOutputs)
  }

  private def finishedOutputs(): Unit = {
    blocked = false
    blockedTimeSinceLastInput = m.clock() - startBlockingTime
    mTotalBlockedTime += blockedTimeSinceLastInput
    belt.deleteLast()
    if (verbosity!=null) verbosity("event", name, "Output performed")
    totalOutputBatches += 1
    restartInputtingIfNeeded()
    //otherwise, the belt is empty and the outputting process will be restarted by the next performed input.
    if (belt.nonEmpty) {
      m.wait(belt.last._1) {
        startPerformOutput(belt.last._2)
      }
    } else {
      outputMustBeRestarted = true
      if(verbosity!=null) verbosity("event", name, "Belt is empty")
    }
  }
}