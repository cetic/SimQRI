package oscar.des.flow.modeling

import oscar.des.engine.Model
import oscar.des.flow.lib._

/**
  * Created by rdl on 31/08/2015.
  */
trait PolicyHelper {

  /**
    * activates "a" with intensity "intensity" every "delay". the initial activation is performed after "offset"
    * @param m the model of the simulation
    * @param intensity the intensity if the activation
    * @param delay the delay between consecutive activations
    * @param initialDelay the initial delay before the first activation
    * @param a the activeable that is activated by this activation
    */
  def regularActivation(m:Model, intensity:Int, delay:Float, initialDelay:Float, a:ActivableProcess, verbosity:(String*)=>Unit = null, name:String)
  = new RegularActivation(m, intensity, delay, initialDelay, a,verbosity, name)

  /**
    * This rule activates the activeable "a" by intensity activationSize(s.content)
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
    * @param verbosity true to have verbosities on the standard output
    * @param period the period of activation, set to zero for immediate activation
    * @param name the name of this rule, for debugging purposes
    */
  def onLowerThreshold(s:Storage,
                       m:Model,
                       a:ActivableProcess,
                       threshold:Int,
                       activationSize:Int=>Int,
                       verbosity:(String*)=>Unit = null,
                       period:Float,
                       name:String)
  = new OnLowerThreshold(s,m,a,threshold,activationSize,verbosity,period,name)

}