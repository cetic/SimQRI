package oscar.des.flow.modeling

import oscar.des.flow.lib._
import scala.language.implicitConversions

/** this trait is a factory for all the elements of the listener tooling
  */
trait ListenersHelper{

  def boolHistoryExpr(b:BoolExpr) = new BoolHistoryExpr(b)

  def doubleHistoryExpr(d:DoubleExpr) = new DoubleHistoryExpr(d)

  /**
    * true if the storage is empty, false otherwise
    * @param s a storage
    */
  def empty(s:Storage) = Empty(s)

  /**
    * the level of the storage s in number of units
    * @param s a storage
    */
  def stockLevel(s:Storage) = StockLevel(s:Storage)

  /**
    * the maximal number of item that can be put in the storage s
    * @param s a storage
    */
  def stockCapacity(s:Storage) = StockCapacity(s:Storage)

  /**
    * the relative level of the storage s (number of item / maximal capacity)
    * @param s a storage
    */
  def relativeStockLevel(s:Storage) = RelativeStockLevel(s:Storage)

  /**
    * the number of items that have been put in the storage since the beginning of the simulation, not counting the initial ones
    * @param s a storage
    */
  def totalPut(s:Storage) = TotalPut(s:Storage)

  /**
    * the number of items that have been taken out of the storage since the beginning of the trace
    * @param s a storage
    */
  def totalFetch(s:Storage) = TotalFetch(s:Storage)

  /**
    * the number of items that have been lost by the storage through overflow. obviously zero if the storage does not overflow.
    * @param s a storage
    */
  def totalLostByOverflow(s:Storage) = TotalLostByOverflow(s:Storage)

  /**
    * true if the process is running, false otherwise. a process might not be running if it is blocked by lack of input material or output storage blocking the outputting of items at the output of the process.
    * notice that [[ConveyorBeltProcess]] do not block by lack of input items
    * for a process with multiple lines, this returns true iff if at least one line is running
    * @param p a process
    */
  def running(p:ActivableProcess)= Running(p:ActivableProcess)

  /**
    * the total number of batches performed by the process since the beginning of the trace
    * a splitting process sums up the batches delivered to each of its outputs
    * for a process with multiple lines, it sums up the completed batches of each line.
    * @param p a process
    */
  def completedBatchCount(p:ActivableProcess) = CompletedBatchCount(p:ActivableProcess)

  /**
    * the number of batches started by the process since the beginning of the trace
    *  * for a process with multiple lines, it sums up the started batches of each line.
    * @param p a process
    */
  def startedBatchCount(p:ActivableProcess) = StartedBatchCount(p:ActivableProcess)

  /**
    * the total time where the process was not running since the beginning of the trace.
    * for a process with multiple lines, it sums up the waiting time of each line.
    * @param p a process
    */
  def totalWaitDuration(p:ActivableProcess) = TotalWaitDuration(p:ActivableProcess)

  //////////////////////////////////////////////////////////////////////////////

  /** shorthand for Changed(StartedBatchCount(p))
    * @param p a process
    */
  def anyBatchStarted(p:ActivableProcess):BoolExpr = doubleChanged(StartedBatchCount(p))

  /**
    * a boolean constant
    * @param b the value of the constant
    */
  implicit def boolConst(b:Boolean) = BoolConst(b)

  /**
    * a Double constant
    * @param d the value of the constant
    */
  implicit def doubleConst(d:Double) = DoubleConst(d:Double)

  /**
    * the negation of expression f
    * @param f a boolean expression
    */
  def not(f:BoolExpr) = {
    f match{
      case Not(g) => g
      case _ => Not(f)
    }
  }

  /**
    * the conjunction of two boolean expressions
    * @param f a boolean expression
    * @param g a boolean expression
    */
  def and(f:BoolExpr, g:BoolExpr) = And(f:BoolExpr, g:BoolExpr)

  /**
    * the disjunction between two boolean expressions
    * @param f a boolean expression
    * @param g a boolean expression
    */
  def or(f:BoolExpr, g:BoolExpr) = Or(f:BoolExpr, g:BoolExpr)

  /**
    * true iff f has always been true since the start of the trace
    * also known as "historically" or as [*]
    * @param f a boolean expression
    */
  def hasAlwaysBeen(f:BoolExpr) = HasAlwaysBeen(f:BoolExpr)

  /**
    * true if there is a post position (now is included) such that f is true at this position
    * @param f a boolean expression
    */
  def hasBeen(f:BoolExpr) = HasBeen(f:BoolExpr)

  /**
    * true if there is a past position in time (now is included)
    * such that b is true and for each position between this position and now (both being included) a holds
    * @param a a boolean expression
    * @param b a boolean expression
    */
  def since(a:BoolExpr,b:BoolExpr) = Since(a:BoolExpr,b:BoolExpr)


  /** if i then t else e*/
  def booleanITE(i:BoolExpr, t:BoolExpr, e:BoolExpr) = ITE(i,t,e)

  /** if i then t else e*/
  def doubleITE(i:BoolExpr, t:DoubleExpr, e:DoubleExpr) = new DoubleITE(i, t, e)

  /**the duration for which b has been true since it was last false*/
  def duration(b:BoolExpr) = new Duration(b)

  /**
    * true iff p is true now, and was false at the previous step in the trace
    * BEWARE that this is a dangerous epxressio, since time is event-based,
    * so that an additional artifact in the model might introduce additional intermediary steps)
    * @param p a boolean expression
    */
  def becomesTrue(p:BoolExpr) = BecomesTrue(p:BoolExpr)

  /**
    * true iff p is false now, and was true at the previous step in the trace
    * BEWARE that this is a dangerous expression, since time is event-based,
    * so that an additional artifact in the model might introduce additional intermediary steps)
    *
    * this is a shorthand for becomesTrue(not(p))
    * @param p a boolean expression
    */
  def becomesFalse(p:BoolExpr) = BecomesTrue(not(p))

  /**
    * true whenever the value of p changes, that is, whenever it is different from its value at the previous itration step
    * BEWARE that this is a dangerous expression, since time is event-based,
    * so that an additional artifact in the model might introduce additional intermediary steps)
    * @param b an expression; it might be a boolean or a double expression
    */
  def boolChanged(b:BoolExpr) = BoolChanged(b:BoolExpr)

  /**
    * true whenever the value of p changes, that is, whenever it is different from its value at the previous itration step
    * BEWARE that this is a dangerous expression, since time is event-based,
    * so that an additional artifact in the model might introduce additional intermediary steps)
    * @param p an expression; it might be a boolean or a double expression
    */
  def doubleChanged(p:DoubleExpr) = DoubleChanged(p:DoubleExpr)

  /**
    * the value of d now minus the value of p at the previous position in the trace.
    * BEWARE that this is a dangerous expression, since time is event-based,
    * so that an additional artifact in the model might introduce additional intermediary steps)
    * @param p a double expression
    */
  def delta(p:DoubleExpr) = Delta(p:DoubleExpr)

  /**
    * the sum of the time lapse between consecutive positions in the trace where b is true at both positions
    * @param b a boolean expression
    */
  def cumulatedDuration(b:BoolExpr) = CumulatedDuration(b:BoolExpr)

  /** shortHand for Minus(CumulatedDuration(b), CumulatedDuration(HasAlwaysBeen(b)))
    * @param b a boolean expression
    */
  def cumulatedDurationNotStart(b: BoolExpr) = Minus(CumulatedDuration(b), CumulatedDuration(HasAlwaysBeen(b)))

  /**
    * the duration between the start of history (time zero) and the curret position in time
    */
  def currentTime = CurrentTime()

  /**
    * a * b
    * @param a a double expression
    * @param b a double expression
    */
  def mult(a:DoubleExpr,b:DoubleExpr) = Mult(a:DoubleExpr,b:DoubleExpr)

  /**
    * a + b
    * @param a a double expression
    * @param b a double expression
    */
  def plus(a:DoubleExpr,b:DoubleExpr) = Plus(a:DoubleExpr,b:DoubleExpr)

  /**
    * a - b
    * @param a a double expression
    * @param b a double expression
    */
  def minus(a:DoubleExpr,b:DoubleExpr) = Minus(a:DoubleExpr,b:DoubleExpr)

  /**
    * shorthand for 0-d
    * @param d
    */
  def opposite(d:DoubleExpr) = minus(0.0,d)

  /**
    * if (b == 0) defaultValueIfDividerIsZero else a / b
    * if defaultValueIfDividerIsZero is Nan, throws an exception in case of divide by zero
    * @param a a double expression
    * @param b a double expression
    * @param defaultValueIfDividerIsZero the default value for this if b is zero
    */
  def div(a:DoubleExpr,b:DoubleExpr,defaultValueIfDividerIsZero:Double = Double.NaN) =
    Div(a:DoubleExpr,b:DoubleExpr,defaultValueIfDividerIsZero)

  /**
    * a > b
    * @param a a double expression
    * @param b a double expression
    */
  def g(a:DoubleExpr,b:DoubleExpr) = G(a,b)

  /**
    * a >= b
    * @param a a double expression
    * @param b a double expression
    */
  def ge(a:DoubleExpr,b:DoubleExpr) = GE(a,b)

  /**
    * a < b
    * @param a a double expression
    * @param b a double expression
    */
  def l(a:DoubleExpr,b:DoubleExpr) = G(b,a)

  /**
    * a <= b
    * @param a a double expression
    * @param b a double expression
    */
  def le(a:DoubleExpr,b:DoubleExpr) = GE(b,a)

  /**
    * a == b
    * @param a a double expression
    * @param b a double expression
    */
  def eq(a:DoubleExpr,b:DoubleExpr) = EQ(a,b)

  /**
    * a != b
    * @param a a double expression
    * @param b a double expression
    */
  def neq(a:DoubleExpr,b:DoubleExpr) = not(EQ(a,b))

  /**
    * computes the integral of s over time through the trapezoidal rule
    * taking the events as discretizations base
    * https://en.wikipedia.org/wiki/Numerical_integration
    * @param s a double expression
    */
  def ponderateWithDuration(s:DoubleExpr) = PonderateWithDuration(s:DoubleExpr)

  /**
    * the max value of s over all position of time since the start where "when" is true
    * @param s the measured expression
    * @param when a boolean expression telling the relevant point of time to consider
    */
  def maxOnHistory(s:DoubleExpr, when:BoolExpr = null) = MaxOnHistory(s:DoubleExpr, when)

  /**
    * the min value of s over all position of time since the start where "when" is true
    * @param s the measured expression
    * @param when a boolean expression telling the relevant point of time to consider
    */
  def minOnHistory(s:DoubleExpr, when:BoolExpr = null) = opposite(MaxOnHistory(opposite(s),when))

  /**
    * the average value of s in history, ponderated with the duration
    * this is a shorthand for Div(PonderateWithDuration(s),CurrentTime())
    * @param s a double expression
    */
  def avgOnHistory(s:DoubleExpr):DoubleExpr = Div(PonderateWithDuration(s),CurrentTime())

  def boolSubExpression(name:String,expr:BoolExpr) = BoolSubExpression(name:String,expr:BoolExpr)

  def doubleSubExpression(name:String,expr:DoubleExpr) = DoubleSubExpression(name:String,expr:DoubleExpr)
}