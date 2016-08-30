package oscar.des.flow.lib

import oscar.des.engine.Model
import oscar.des.flow.core.StockNotificationTarget

import scala.collection.immutable.SortedMap

/**
  * a rule that activates a, based on its specific activation scheme
  *
  * @param a the activeable that is activated by this activation
  */
abstract class ActivationRule(a: ActivableProcess) {
  a.setUnderControl()
  def activate(intensity:Int) {a.activate(intensity)}

  def cloneReset(newModel:Model,activableMapping:SortedMap[ActivableProcess,ActivableProcess], storageMapping:SortedMap[Storage,Storage]):ActivationRule
}

/**
  * activates "a" with intensity "intensity" every "delay". the initial activation is performed after "offset"
  *
  * @param m the model of the simulation
  * @param intensity the intensity if the activation
  * @param delay the delay between consecutive activations
  * @param initialDelay the initial delay before the first activation
  * @param a the activeable that is activated by this activation
  */
class RegularActivation(m: Model, intensity: Int, delay: Float, initialDelay: Float, a: ActivableProcess, verbosity: (String*) => Unit, name: String) extends ActivationRule(a){
  def doActivate(){
    if(verbosity != null){verbosity("event", name, "Regular activation")}
    activate(intensity)
    m.wait(delay){doActivate()}
  }
  m.wait(initialDelay){doActivate()}

  override def cloneReset(newModel: Model, activableMapping: SortedMap[ActivableProcess, ActivableProcess], storageMapping:SortedMap[Storage,Storage]): ActivationRule = {
    new RegularActivation(newModel, intensity, delay, initialDelay, activableMapping(a), verbosity, name)
  }
}

/**
  * This rule activates the activable "a" by intensity activationSize(s.content)
  * whenever s.content goes below "threshold"
  *
  * if period is specified, it only perform the activation when time is a multiple of period.
  * the intensity is computed at the time of activation of "a"
  *
  * @param s the stock that is monitored by this rule
  * @param m tye model of the simulation
  * @param a the activeable that is activated by this activation
  * @param threshold the threshold for activation
  * @param activationSize a function that computes the level of activation, given the s.content
  * @param verbosity where verbosities should be sent, can be null
  * @param period the period of activation, set to zero for immediate activation
  * @param name the name of this rule, for debugging purposes
  */
class OnLowerThreshold(s:Storage,
                       m:Model,
                       a:ActivableProcess,
                       threshold:Int,
                       activationSize:Int=>Int,
                       verbosity:(String*)=>Unit = null,
                       period:Float,
                       val name:String)
  extends ActivationRule(a) with StockNotificationTarget{
  s.registerNotificationTarget(this)

  private var placedOrders = 0

  private var lastNotifiedlevel:Int = s.contentSize

  override def notifyStockLevel(level: Int): Unit = {
    if(level <= threshold && lastNotifiedlevel > threshold){
      activation()
    }
    lastNotifiedlevel = level
  }

  private def doActivate(): Unit ={
    val activation = activationSize(s.contentSize)
    if (verbosity != null) verbosity("event", s.name, "Threshold (" + threshold + ") reached (now:" + s.contentSize + "), activation " + activation)
    activate(activation)
    placedOrders += 1
  }

  protected def activation(): Unit ={
    if(period == 0){
      doActivate()
    }else{
      m.wait(period - (m.clock() % period)) {if (s.contentSize < threshold) doActivate()}
    }
  }

  def mapInfo: Map[String, Double] = Map("Placed Orders" -> placedOrders)

  override def toString: String = name + " " + this.getClass.getSimpleName + ":: placedOrders:" + placedOrders

  override def cloneReset(newModel: Model, activableMapping: SortedMap[ActivableProcess, ActivableProcess], storageMapping:SortedMap[Storage,Storage]): ActivationRule = {
    new OnLowerThreshold(storageMapping(s),
                         newModel,
                         activableMapping(a),
                         threshold,
                         activationSize,
                         verbosity,
                         period,
                         name)
  }
}