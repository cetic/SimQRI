package oscar.des.flow.lib

import oscar.des.engine.Model
import oscar.des.flow.core.ItemClassHelper._
import oscar.des.flow.core.{ItemClassTransformWitAdditionalOutput, ItemClassTransformFunction, Putable, Fetchable}
import oscar.des.flow.modeling.{MultipleParsingError, MultipleParsingSuccess, ListenerParser}
import scala.collection.immutable.SortedMap
import scala.language.implicitConversions

trait implicitConvertors {
  implicit def doubleToConstantDoubleFunction(f: Double): (() => Double) = () => f
  implicit def intToConstantDoubleFunction(f: Int): (() => Double) = () => f
  implicit def doubleToConstantIntFunction(f: Double): (() => Int) = () => f.toInt
  implicit def intToConstantIntFunction(f: Int): (() => Int) = () => f
  implicit def constantFetchableToFunctionFetchable(l: Array[(Int, Fetchable)]): Array[(() => Int, Fetchable)] = l.map(v => (() => v._1, v._2))
  implicit def constantPutableToFunctionPutable(l: Array[(Int, Putable)]): Array[(() => Int, Putable)] = l.map(v => (() => v._1, v._2))
}

class OrderingOnStorage() extends Ordering[Storage]{
  override def compare(x: Storage, y: Storage): ItemClass = x.id.compare(y.id)
}

class OrderingOnActivableProcesses() extends Ordering[ActivableProcess]{
  override def compare(x: ActivableProcess, y: ActivableProcess): ItemClass = x.id.compare(y.id)
}

class FactoryModel(verbosity:(String*)=>Unit,
                   private val m:Model = new Model,
                   var ms:MetricsStore = null,
                   private var storages:List[Storage] = List.empty,
                   private var processes:List[ActivableProcess] = List.empty,
                   private var activationRules:List[ActivationRule] = List.empty){

  private var nextStorageID = 0
  private var nextProcessID = 0
  private var nextActivationRuleID = 0

  def getStorages:List[Storage] = storages
  def getProcesses:List[ActivableProcess] = processes

  def simulate(horizon:Float, abort:()=>Boolean = ()=>false){
    m.simulate(horizon,verbosity,()=>{ms.updateMetricsIfNeeded(m.clock());abort()})

    ms.finish(m.clock())
    //if(verbosity != null) println(this)
  }

  def queries:SortedMap[String,Expression] = {
    SortedMap.empty[String,Expression] ++ ms.rootExpressions
  }

  /**
   * creates a clone of this factory model where everything has been reset
   * so that you can simulate the clone as well
   * @return
   */
  def cloneReset:FactoryModel = {
    val newModel:Model = new Model
    val newStorages = SortedMap.empty[Storage,Storage](new OrderingOnStorage()) ++ storages.map((s:Storage) => (s,s.cloneReset(newModel)))
    val newProcesses = SortedMap.empty[ActivableProcess,ActivableProcess](new OrderingOnActivableProcesses()) ++ processes.map((p:ActivableProcess) => (p,p.cloneReset(newModel,newStorages)))

    //activation rules:
    val newActiationRules = activationRules.map(_.cloneReset(newModel,newProcesses, newStorages))

    //cloner les expressions
    val (newMetricStore,doubleExprTranslation) = ms.cloneReset(newStorages,newProcesses)

    //mettre les expressions clonées dans newProcesses et newStorages
    for((oldS,newS) <- newStorages){
      newS.cost = doubleExprTranslation.getOrElse(oldS.cost,null)
    }

    for((oldP,newP) <- newProcesses){
      newP.cost = doubleExprTranslation.getOrElse(oldP.cost,null)
    }

    //retourner le tout
    new FactoryModel(verbosity,
      newModel,
      newMetricStore,
      newStorages.values.toList,
      newProcesses.values.toList,
      newActiationRules)
  }

  def setQueriesToParse(queriesNameAndExpression:List[(String,String)]){
    require(ms == null)
    val parser = ListenerParser(storages,processes)
    parser.parseAllListeners(queriesNameAndExpression) match{
      case  MultipleParsingSuccess(expressions:List[(String,Expression)]) =>
        setQueries(expressions)
      case  MultipleParsingError(s:String) =>
        throw new Error(s)
    }
  }

  def setQueries(expressions:List[(String, Expression)]){
    ms = new MetricsStore(expressions,verbosity)
  }

  /**
   * a process inputs some inputs, and produces its outputs at a given rate.
   * notice that inputs and outputs are performed in parallel (thus might cause some deadlocks)
   *
   * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
   * @param inputs the set of inputs (number of parts to input, storage)
   * @param outputs the set of outputs (number of parts, storage)
   * @param name the name of this process, for pretty printing
   * @author renaud.delandtsheer@cetic.be
   * */
  def singleBatchProcess(batchDuration:() => Double,
                         inputs:Array[(() => Int, Fetchable)],
                         outputs:Array[(()=>Int,Putable)],
                         transformFunction:ItemClassTransformFunction,
                         name:String,
                         costFunction:String = "0") = {
    val toReturn = SingleBatchProcess(m,batchDuration,inputs,outputs,transformFunction,name,verbosity, nextProcessID)
    nextProcessID += 1
    toReturn.cost = ListenerParser.processCostParser(toReturn).applyAndExpectDouble(costFunction)
    processes = toReturn :: processes
    toReturn
  }

  /**
   * This represents a batch process (see [[SingleBatchProcess]]) with multiple batch running in parallel.
   * @param numberOfBatches the number of batches running in parallel.
   * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
   * @param inputs the set of inputs (number of parts to input, storage)
   * @param outputs the set of outputs (number of parts, storage)
   * @param name the name of this process, for pretty printing, bath are named "name chain i" where i is the identifier of the batch process
   * @author renaud.delandtsheer@cetic.be
   * */
  def batchProcess(numberOfBatches:Int,
                   batchDuration:() => Double,
                   inputs:Array[(() => Int, Fetchable)],
                   outputs:Array[(() => Int,Putable)],
                   name:String,
                   transformFunction:ItemClassTransformFunction,
                   costFunction:String = "0") ={
    val toReturn = new BatchProcess(m,numberOfBatches,batchDuration,inputs,outputs,name,transformFunction,verbosity, nextProcessID)
    nextProcessID += 1
    toReturn.cost = ListenerParser.processCostParser(toReturn).applyAndExpectDouble(costFunction)
    processes = toReturn :: processes
    toReturn
  }

  /**
   *  A rolling (in a conveyor belt) Process means that if the output is blocked, no new batch is started
   * (imagine an industrial rolling band oven where croissants are cooked)
   * and if the input is blocked, the output still proceeds, (as if we were starting empty batches) there is no catch up for the waited time
   * batch only start when they ave their complete inputs.
   * if the output is blocked, the process stops, thus does not perform new inputs either (we cannot model that croissants will eventually burn in the oven)
   *
   * @param processDuration the duration between inputting a batch and outputting the batch
   * @param minimalSeparationBetweenBatches the minimal separation between two consecutive batches
   * @param inputs the set of inputs (number of parts to input, storage)
   * @param outputs the set of outputs (number of parts, storage)
   * @param name the name of this process, for pretty printing
   * @author renaud.delandtsheer@cetic.be
   */
  def conveyorBeltProcess(processDuration:() => Double,
                          minimalSeparationBetweenBatches:Double,
                          inputs:Array[(() => Int, Fetchable)],
                          outputs:Array[(() => Int, Putable)],
                          transformFunction:ItemClassTransformFunction,
                          name:String,
                          costFunction:String  = "0") = {
    val toReturn = new ConveyorBeltProcess(m:Model,processDuration,minimalSeparationBetweenBatches,inputs,outputs,transformFunction,name,verbosity, nextProcessID)
    nextProcessID += 1
    toReturn.cost = ListenerParser.processCostParser(toReturn).applyAndExpectDouble(costFunction)
    processes = toReturn :: processes
    toReturn
  }

  /**
   * This represents a failing batch process (see [[oscar.des.flow.lib.SplittingBatchProcess]]) with multiple batch running in parallel.
   * @param numberOfBatches the number of batches running in parallel.
   * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
   * @param inputs the set of inputs (number of parts to input, storage)
   * @param outputs the set of outputs (number of parts, storage)
   * @param name the name of this process, for pretty printing
   * @author renaud.delandtsheer@cetic.be
   * */
  def splittingBatchProcess(numberOfBatches:Int,
                            batchDuration:() => Double,
                            inputs:Array[(() => Int, Fetchable)],
                            outputs:Array[Array[(()=>Int,Putable)]],
                            name:String,
                            transformFunction:ItemClassTransformWitAdditionalOutput,
                            costFunction:String = "0") = {
    val toReturn = SplittingBatchProcess(m, numberOfBatches, batchDuration, inputs, outputs, name, transformFunction, verbosity, nextProcessID)
    nextProcessID += 1
    toReturn.cost = ListenerParser.processCostParser(toReturn).applyAndExpectDouble(costFunction)
    processes = toReturn :: processes
    toReturn
  }

  /**
   * A process inputs some inputs, and produces its outputs at a given rate.
   * notice that inputs and outputs are performed in parallel (thus might cause some deadlocks)
   * this process might fail. In this case, failure is assessed at the end of the batch duration,
   * and produces the failureOutputs
   *
   * @param batchDuration the duration of a batch starting from all inputs being inputted, and ending with the beginning of the outputting
   * @param inputs the set of inputs (number of parts to input, storage)
   * @param outputs the set of outputs (number of parts, storage)
   * @param name the name of this process, for pretty printing
   * @author renaud.delandtsheer@cetic.be
   * */
  def splittingSingleBatchProcess(batchDuration:() => Double,
                                  inputs:Array[(() => Int, Fetchable)],
                                  outputs:Array[Array[(() => Int,Putable)]],
                                  transformFunction:ItemClassTransformWitAdditionalOutput,
                                  name:String,
                                  costFunction:String = "0") = {
    val toReturn = SplittingSingleBatchProcess(m, batchDuration, inputs, outputs, transformFunction, name, verbosity, nextProcessID)
    nextProcessID += 1
    toReturn.cost = ListenerParser.processCostParser(toReturn).applyAndExpectDouble(costFunction)
    processes = toReturn :: processes
    toReturn
  }

  /**
   *this type of storage acts in a LIFO-way.
   * it does matter to know this if you distinguish between different items.
   * @param maxSize the maximal content of the stock. attempting to put more items will block the putting operations
   * @param initialContent the initial content of the stock
   * @param name the name of the stock
   * @param overflowOnInput true if the stock overflows when there are excessing input, false to have it blocking the puts when it is full
   */
  def lIFOStorage(maxSize:Int,
                  initialContent:List[(Int,ItemClass)] = List.empty,
                  name:String,
                  overflowOnInput:Boolean,
                  costFunction:String = "0") = {

    val toReturn = new LIFOStorage(maxSize, initialContent, name, verbosity, overflowOnInput,nextStorageID)
    nextStorageID += 1
    toReturn.cost = ListenerParser.storageCostParser(toReturn).applyAndExpectDouble(costFunction)
    storages = toReturn :: storages
    toReturn
  }

  /**
   *this type of storage acts in a FIFO-way.
   * it does matter to know this if you distinguish between different items.
   * @param maxSize the maximal content of the stock. attempting to put more items will block the putting operations
   * @param initialContent the initial content of the stock
   * @param name the name of the stock
   * @param overflowOnInput true if the stock overflows when there are excessing input, false to have it blocking the puts when it is full
   */
  def fIFOStorage(maxSize:Int,
                  initialContent:List[(Int,ItemClass)],
                  name:String,
                  overflowOnInput:Boolean,
                  costFunction:String = "0") = {
    val toReturn = new FIFOStorage(maxSize, initialContent, name, verbosity, overflowOnInput,nextStorageID)
    nextStorageID += 1
    toReturn.cost = ListenerParser.storageCostParser(toReturn).applyAndExpectDouble(costFunction)
    storages = toReturn :: storages
    toReturn
  }

  /**
   * This rule activates the activable "a" by intensity activationSize(s.content)
   * whenever s.content goes below "threshold"
   *
   * if period is specified, it only perform the activation when time is a multiple of period.
   * the intensity is computed at the time of activation of "a"
   *
   * @param s the stock that is monitored by this rule
   * @param a the activeable that is activated by this activation
   * @param threshold the threshold for activation
   * @param activationSize a function that computes the level of activation, given the s.content
   * @param period the period of activation, set to zero for immediate activation
   * @param name the name of this rule, for debugging purposes
   */
  def onLowerThreshold(s:Storage,
                       a:ActivableProcess,
                       threshold:Int,
                       activationSize:Int=>Int,
                       period:Float,
                       name:String) = {
    val toReturn = new OnLowerThreshold(s,m, a, threshold, activationSize, verbosity, period, name)
    activationRules = toReturn :: activationRules
    toReturn
  }

  /**
   * activates "a" with intensity "intensity" every "delay". the initial activation is performed after "offset"
   * @param intensity the intensity if the activation
   * @param delay the delay between consecutive activations
   * @param initialDelay the initial delay before the first activation
   * @param a the activeable that is activated by this activation
   */
  def regularActivation(intensity:Int, delay:Float, initialDelay:Float, a:ActivableProcess, name:String) = {
    val toReturn = new RegularActivation(m, intensity, delay, initialDelay, a, verbosity, name)
    activationRules = toReturn :: activationRules
    toReturn
  }

  def logMetrics() = if (ms != null) {
    ms.logMetrics()
  }

  override def toString: String = {
    ("FactoryModel \n" +
      m.toString() + "\nProcesses:\n"
    + processes.mkString("\n") + "\nstorages:\n"
    + storages.mkString("\n") + "\nqueries:\n"
    + ms.toString)
  }
}
