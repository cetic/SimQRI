package oscar.des.flow.modeling

import oscar.des.engine.Model
import oscar.des.flow.core.ItemClassHelper._
import oscar.des.flow.core._
import oscar.des.flow.lib._
import scala.language.implicitConversions

/** since many of the classes proposed by this lib support random variables, represented using functions to Floats or Ints,
  * and ou might not need this dimension in your model,
  * this trait provides implicit translation eg. from Float to function to Float
  */
trait FactoryHelper extends AttributeHelper{

  implicit def doubleToConstantDoubleFunction(f: Double): (() => Double) = () => f
  implicit def intToConstantDoubleFunction(f: Int): (() => Double) = () => f
  implicit def doubleToConstantIntFunction(f: Double): (() => Int) = () => f.toInt
  implicit def intToConstantIntFunction(f: Int): (() => Int) = () => f
  implicit def constantFetchableToFunctionFetchable(l: Array[(Int,Fetchable)]): Array[(()=>Int,Fetchable)] = l.map(v => (()=>v._1,v._2))
  implicit def constantPutableToFunctionPutable(l: Array[(Int,Putable)]): Array[(()=>Int,Putable)] = l.map(v => (()=>v._1,v._2))

  /**
    * a process inputs some inputs, and produces its outputs at a given rate.
    * notice that inputs and outputs are performed in parallel (thus might cause some deadlocks)
    *
    * @param m the simulation model
    * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
    * @param inputs the set of inputs (number of parts to input, storage)
    * @param outputs the set of outputs (number of parts, storage)
    * @param name the name of this process, for pretty printing
    * @param verbosity true if you want to see the start input, start batch, end batch start output, end output events on the console
    * @author renaud.delandtsheer@cetic.be
    * */
  def singleBatchProcess(m:Model,
                         batchDuration:() => Double,
                         inputs:Array[(() => Int, Fetchable)],
                         outputs:Array[(()=>Int,Putable)],
                         transformFunction:ItemClassTransformFunction,
                         name:String,
                         verbosity:(String*)=>Unit = null,
                         costFunction:String = "0") = {
    val toReturn = SingleBatchProcess(m:Model,batchDuration,inputs,outputs,transformFunction,name,verbosity)
    toReturn.cost = ListenerParser.processCostParser(toReturn,attributeDefinitions()).applyAndExpectDouble(costFunction)
    toReturn
  }

  /**
    * This represents a batch process (see [[SingleBatchProcess]]) with multiple batch running in parallel.
    * @param numberOfBatches the number of batches running in parallel.
    * @param m the simulation model
    * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
    * @param inputs the set of inputs (number of parts to input, storage)
    * @param outputs the set of outputs (number of parts, storage)
    * @param name the name of this process, for pretty printing, bath are named "name chain i" where i is the identifier of the batch process
    * @param verbosity true if you want to see the start input, start batch, end batch start output, end output events on the console
    * @author renaud.delandtsheer@cetic.be
    * */
  def batchProcess(m:Model,
                   numberOfBatches:Int,
                   batchDuration:() => Double,
                   inputs:Array[(() => Int, Fetchable)],
                   outputs:Array[(() => Int,Putable)],
                   name:String,
                   transformFunction:ItemClassTransformFunction,
                   verbosity:(String*)=>Unit = null,
                   costFunction:String = "0") ={
    val toReturn = new BatchProcess(m,numberOfBatches,batchDuration,inputs,outputs,name,transformFunction,verbosity)
    toReturn.cost = ListenerParser.processCostParser(toReturn,attributeDefinitions()).applyAndExpectDouble(costFunction)
    toReturn
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
    * @param verbosity true if you want to see the start input, start batch, end batch start output, end output events on the console
    * @author renaud.delandtsheer@cetic.be
    */
  def conveyorBeltProcess(m:Model,
                          processDuration:() => Double,
                          minimalSeparationBetweenBatches:Double,
                          inputs:Array[(() => Int, Fetchable)],
                          outputs:Array[(() => Int, Putable)],
                          transformFunction:ItemClassTransformFunction,
                          name:String,
                          verbosity:(String*)=>Unit = null,
                          costFunction:String  = "0") = {
    val toReturn = new ConveyorBeltProcess(m:Model,processDuration,minimalSeparationBetweenBatches,inputs,outputs,transformFunction,name,verbosity)
    toReturn.cost = ListenerParser.processCostParser(toReturn,attributeDefinitions()).applyAndExpectDouble(costFunction)
    toReturn
  }

  /**
    * This represents a failing batch process (see [[oscar.des.flow.lib.SplittingBatchProcess]]) with multiple batch running in parallel.
    * @param m the simulation model
    * @param numberOfBatches the number of batches running in parallel.
    * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
    * @param inputs the set of inputs (number of parts to input, storage)
    * @param outputs the set of outputs (number of parts, storage)
    * @param name the name of this process, for pretty printing
    * @param verbosity true if you want to see the start input, start batch, end batch start output, end output events on the console
    * @author renaud.delandtsheer@cetic.be
    * */
  def splittingBatchProcess(m:Model,
                            numberOfBatches:Int,
                            batchDuration:() => Double,
                            inputs:Array[(() => Int, Fetchable)],
                            outputs:Array[Array[(()=>Int,Putable)]],
                            name:String,
                            transformFunction:ItemClassTransformWitAdditionalOutput,
                            verbosity:(String*)=>Unit = null,
                            costFunction:String) = {
    val toReturn = SplittingBatchProcess(m, numberOfBatches, batchDuration, inputs, outputs, name, transformFunction, verbosity)
    toReturn.cost = ListenerParser.processCostParser(toReturn,attributeDefinitions()).applyAndExpectDouble(costFunction)
    toReturn
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
    * @param verbosity true if you want to see the start input, start batch, end batch start output, end output events on the console
    * @author renaud.delandtsheer@cetic.be
    * */
  def splittingSingleBatchProcess(m:Model,
                                  batchDuration:() => Double,
                                  inputs:Array[(() => Int, Fetchable)],
                                  outputs:Array[Array[(() => Int,Putable)]],
                                  transformFunction:ItemClassTransformWitAdditionalOutput,
                                  name:String,
                                  verbosity:(String*)=>Unit = null,
                                  costFunction:String = "0") = {
    val toReturn = SplittingSingleBatchProcess(m, batchDuration, inputs, outputs, transformFunction, name, verbosity)
    toReturn.cost = ListenerParser.processCostParser(toReturn,attributeDefinitions()).applyAndExpectDouble(costFunction)
    toReturn
  }

  /**
    *this type of storage acts in a LIFO-way.
    * it does matter to know this if you distinguish between different items.
    * @param maxSize the maximal content of the stock. attempting to put more items will block the putting operations
    * @param initialContent the initial content of the stock
    * @param name the name of the stock
    * @param verbosity true to print when stock is empty or overfull
    * @param overflowOnInput true if the stock overflows when there are excessing input, false to have it blocking the puts when it is full
    */
  def lIFOStorage(maxSize:Int,
                  initialContent:List[(Int,ItemClass)] = List.empty,
                  name:String,
                  verbosity:(String*)=>Unit,
                  overflowOnInput:Boolean,
                  costFunction:String = "0",
                  attributes:AttributeDefinitions) = {
    val toReturn = new LIFOStorage(maxSize, initialContent, name, verbosity, overflowOnInput,0)
    toReturn.cost = ListenerParser.storageCostParser(toReturn,attributes).applyAndExpectDouble(costFunction)
    toReturn
  }

  /**
    *this type of storage acts in a FIFO-way.
    * it does matter to know this if you distinguish between different items.
    * @param maxSize the maximal content of the stock. attempting to put more items will block the putting operations
    * @param initialContent the initial content of the stock
    * @param name the name of the stock
    * @param verbosity true to print when stock is empty or overfull
    * @param overflowOnInput true if the stock overflows when there are excessing input, false to have it blocking the puts when it is full
    */
  def fIFOStorage(maxSize:Int,
                  initialContent:List[(Int,ItemClass)],
                  name:String,
                  verbosity:(String*)=>Unit,
                  overflowOnInput:Boolean,
                  costFunction:String = "0",
                  attributes:AttributeDefinitions) = {
    val toReturn = new FIFOStorage(maxSize, initialContent, name, verbosity, overflowOnInput,0)
    toReturn.cost = ListenerParser.storageCostParser(toReturn,attributes).applyAndExpectDouble(costFunction)
    toReturn
  }
}