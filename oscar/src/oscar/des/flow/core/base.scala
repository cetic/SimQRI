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

package oscar.des.flow.core

import scala.collection.mutable.ListBuffer

import ItemClassHelper._

/** represents a process fragment where one can put a part
  * @author renaud.delandtsheer@cetic.be
  */
trait Putable {
  /**
    * put the amount of goods into the putable.
    * This is potentially blocking
    * @param amount: the items to be put in the puteable
    * @param block the block to execute after the put
    */
  def put(amount:Int,i:ItemClass)(block : () => Unit)
}

/** represents a process fragment from which one can fetch a part
  * @author renaud.delandtsheer@cetic.be
  * */
trait Fetchable {
  /**
    * fetch the amount of goods from the putable.
    * This is potentially blocking
    * @param amount the items to be fetched from the fetchable
    * @param block the block to execute once the items are actually fetched. these are bigen to the block method
    */
  def fetch(amount:Int)(block : ItemClass => Unit)
}

/** This proposes a standard FIFO model behind the fetch operation,
  * in case the fetch operation is not possible
  * and must wait eg. for some refurbishment to proceed
  * @author renaud.delandtsheer@cetic.be
  */
trait RichFetchable extends Fetchable {
  private val waitingFetches:ListBuffer[(Int, ItemClass, ItemClass => Unit)] = ListBuffer.empty
  var mTotalFetch = 0
  protected def pTotalFetch:Int = mTotalFetch

  def isThereAnyWaitingFetch:Boolean = waitingFetches.nonEmpty

  protected def resetRichFetchable(){
    waitingFetches.remove(waitingFetches.size)
    mTotalFetch = 0
  }

  /**
    * @param amount the items to be internally fetched from the fetchable
    * @return what remains to be fetched, whas has been fetched
    */
  protected def internalFetch(amount:Int,hasBeenFetch:ItemClass = ItemClassHelper.zeroItemClass):(Int,ItemClass)

  def appendFetch(amount:Int)(block : ItemClass => Unit) {
    waitingFetches.append((amount, ItemClassHelper.zeroItemClass, block))
  }

  /**
    * @return true if something could be done, false otherwise.
    */
  protected def processBlockedFetches():Boolean = {
    var somethingDone = false
    var finished = false
    while (! finished) {
      finished = true
      if (waitingFetches.nonEmpty) {
        val (toFetch, alreadyFetched, block) = waitingFetches.remove(0)
        val (remainingToFetch,fetched) = internalFetch(toFetch,alreadyFetched)
        val nbFetched = toFetch - remainingToFetch
        mTotalFetch += nbFetched
        if (remainingToFetch == 0) {
          block(fetched)
          finished = false
          somethingDone = true
        } else {
          if (remainingToFetch != toFetch) somethingDone = true
          waitingFetches.prepend((remainingToFetch, fetched, block))
          finished = true
        }
      } else {
        finished = true
      }
    }
    somethingDone
  }
}

/** This proposes a standard FIFO model behind the put operation,
  * in case the put operation is not possible
  * and must wait eg. for some space to be freed
  * @author renaud.delandtsheer@cetic.be
  */
trait RichPutable extends Putable {

  protected val waitingPuts:ListBuffer[(List[(Int,ItemClass)], () => Unit)] = ListBuffer.empty
  var mTotalPut = 0
  def pTotalPut:Int = mTotalPut

  protected def resetRichPutable(){
    waitingPuts.remove(waitingPuts.size)
    mTotalPut = 0
  }

  def isThereAnyWaitingPut:Boolean = waitingPuts.nonEmpty

  /**
    * @param l the items to be internally put
    * @return what remains to be pt after this put, and what has been put
    */
  protected def internalPut(l:List[(Int,ItemClass)], hasBeenPut:Int = 0):(List[(Int,ItemClass)],Int)

  /**
    * put the amount of goods into the putable.
    * This is potentially blocking
    * @param l the items to be put
    * @param block the block to execute after the put
    */
  protected def appendPut(l:List[(Int,ItemClass)])(block : () => Unit): Unit = {
    waitingPuts.append((l, block))
  }

  /**
    * @return true if something could be done, false otherwise.
    */
  protected def processBlockedPuts(): Boolean = {
    var somethingDone = false
    var finished = false
    while (! finished) {
      finished = true
      if (waitingPuts.nonEmpty) {
        val (toPut, block) = waitingPuts.remove(0)
        val (remainingToPut,put) = internalPut(toPut)
        mTotalPut += put
        if (remainingToPut.isEmpty) {
          block()
          finished = false
          somethingDone = true
        } else {
          if (remainingToPut != toPut) somethingDone = true
          waitingPuts.prepend((remainingToPut, block))
          finished = true
        }
      } else {
        finished = true
      }
    }
    somethingDone
  }

  /** flushes the blocked puts
    * the blocked method is called for each flushed put
    * @return the number of units that were flushed, zero if nothing was flushed
    */
  protected def flushBlockedPuts(): Int = {
    var flushedUnits = 0
    while (waitingPuts.nonEmpty) {
      val (toPut, block) = waitingPuts.remove(0)
      block()
      val nbToPut = toPut.length
      flushedUnits += nbToPut
      mTotalPut += nbToPut
    }
    flushedUnits
  }
}

/** This class counts a set of event,and calls a callback method
  * once a defined number of such events have happened.
  * @author renaud.delandtsheer@cetic.be
  *
  * @param waitedNotification the number of waited notifications
  * @param gate the method to call once the method notifyOne has been called waitedNotification times
  */
case class CounterGate(var waitedNotification:Int, gate: ItemClass => Unit, var itemClass:ItemClass = zeroItemClass) {
  def notifyOne(mItemClass:ItemClass = zeroItemClass): Unit = {
    itemClass = union(itemClass,mItemClass)
    waitedNotification -=1
    if(waitedNotification == 0) gate(itemClass)
  }
}

/** This trait proposes a standard method to perform an output
  * an output consists is outputting a set of parts to a set of Putables
  * @author renaud.delandtsheer@cetic.be
  */
class Outputter(outputs:Array[(() => Int, Putable)]) {
  val outputCount = outputs.length
  /**returns the number of output items*/
  def performOutput(i:ItemClass, block: () => Unit){
    val gate = CounterGate(outputCount +1, _ => block())
    var i = 0
    while(i<outputCount){
      val (nr,putable) = outputs(i)
      putable.put(nr(),i)(() => gate.notifyOne())
      i+=1
    }
    gate.notifyOne()
  }
}

/** This trait proposes a standard method to perform an input
  * an input consists in fetching a set of parts from a set of Fetchables
  * @author renaud.delandtsheer@cetic.be
  */
class Inputter(inputs:Array[(() => Int, Fetchable)]) {
  val inputCount = inputs.length
  def addPreliminaryInput(preliminaryInput:Fetchable){
    require(this.preliminaryInput == null)
    this.preliminaryInput = preliminaryInput
  }
  var preliminaryInput:Fetchable = null

  def performInput(block : ItemClass => Unit): Unit = {

    def doPerformInput() {
      val gate = CounterGate(inputCount + 1, block)

      var i = 0
      while(i < inputCount){
        val (amount, fetchable) =inputs(i)
        fetchable.fetch(amount())(gate.notifyOne)
        i += 1
      }
      gate.notifyOne()
    }

    if (preliminaryInput == null){
      doPerformInput()
    }else{
      preliminaryInput.fetch(1)(_ => doPerformInput())
    }
  }
}

trait StockNotificationTarget{
  def notifyStockLevel(level:Int)
}