package oscar.des.flow.lib

import oscar.des.engine.Model
import oscar.des.flow.DoublyLinkedList
import oscar.des.flow.core.ItemClassHelper._
import oscar.des.flow.core._

import scala.language.implicitConversions

object Storage{
  implicit def orderingById[A <: Storage]: Ordering[A] =
    Ordering.by(e => e.id)
}
/**
  * represents a storage point, or a stock as you name it
  * @param maxCapacity the maximal content of the stock. attempting to put more items will block the putting operations
  * @param name the name of the stock
  * @param verbosity where verbosities should be sent, can be null
  * @author renaud.delandtsheer@cetic.be
  * */
abstract class Storage(val maxCapacity: Int,
                       val name:String,
                       val verbosity:(String*)=>Unit,
                       overflowOnInput:Boolean,
                       val id:Int)
  extends RichPutable with RichFetchable {

  var cost : DoubleExpr = null

  def cloneReset(newModel : Model) : Storage

  class BufferCompositeItem(var n : Int, val itemClass : ItemClass)

  implicit def coupleToComposite(c : (Int, ItemClass)) : BufferCompositeItem = new BufferCompositeItem(c._1, c._2)

  def totalFetch : Int = pTotalFetch

  def totalPut : Int = pTotalPut

  var totalLostByOverflow = 0

  def contentSize : Int

  private var notificationTo : List[StockNotificationTarget] = List.empty

  protected def resetStorage() : Unit = {
    resetRichFetchable()
    resetRichPutable()
    totalLostByOverflow = 0
  }

  override def toString : String = {
    name + " " + this.getClass.getSimpleName + ":: content:" + contentSize + " max:" + maxCapacity + " totalPut:" + totalPut + " totalFetch:" + totalFetch + (if (overflowOnInput) " totalOverflow:" + totalLostByOverflow else "")
  }

  protected def flow() : Boolean = {
    var somethingCouldBeDone = false
    var finished = false
    while (!finished) {
      finished = true
      if (processBlockedFetches()) {
        somethingCouldBeDone = true
        finished = false
      }
      if (processBlockedPuts()) {
        somethingCouldBeDone = true
        finished = false
      }
    }

    if (somethingCouldBeDone) {
      //dirty but faster
      var tmp = notificationTo
      while (tmp.nonEmpty) {
        tmp.head.notifyStockLevel(contentSize)
        tmp = tmp.tail
      }
    }

    if (overflowOnInput) {
      val lostByOverflow = flushBlockedPuts()
      totalLostByOverflow += lostByOverflow
      if (lostByOverflow != 0 && verbosity != null) verbosity("event", name, "Overflow, " + lostByOverflow + " pieces lost")
      somethingCouldBeDone || (lostByOverflow != 0)
    } else {
      somethingCouldBeDone
    }
  }

  def registerNotificationTarget(t : StockNotificationTarget) : Unit = {
    notificationTo = t :: notificationTo
  }

  def fetch(amount : Int)(block : ItemClass => Unit) {
    appendFetch(amount)(block)
    flow()
    if (isThereAnyWaitingFetch && verbosity != null) verbosity("event", name, "Empty storage")
  }

  def put(amount : Int, i : ItemClass)(block : () => Unit) : Unit = {
    appendPut(List((amount, i)))(block)
    flow()
    if (isThereAnyWaitingPut && verbosity != null)
      verbosity("event", name, "Full storage")
  }

  protected def initialContent : List[(Int, ItemClass)]

  var attributeCounters : List[AttributeConditionCounter] = List.empty

  def measureCondition(a : AttributeCondition) : AttributeConditionCounter = {
    val newCounter = new AttributeConditionCounter(a, initialContent)
    attributeCounters = newCounter :: attributeCounters
    newCounter
  }

  override def recordFetch(nbFetched : ItemClass, itemClass : ItemClass) {
    for (a <- attributeCounters) {
      a.notifyGet(nbFetched, itemClass)
    }
  }

  override def recordPut(put : List[(Int, ItemClass)]) {
    for (a <- attributeCounters) {
      for ((n, c) <- put) {
        a.notifyPut(n, c)
      }
    }
  }

  def mapInfo: Map[String, Double] = {
    var map = Map("Content" -> contentSize.toDouble,
      "Max" -> maxCapacity.toDouble,
      "Total put" -> totalPut.toDouble,
      "Total fetch" -> totalFetch.toDouble)
    if (overflowOnInput) {
      map += ("Total overflow" -> totalLostByOverflow)
    }
    map
  }
}

class AttributeConditionCounter(a:AttributeCondition, initContent:Iterable[(Int,ItemClass)]){
  val initContentCount = initContent.foldLeft(0)({case (acc,(n,itemClass)) => if(a.evaluate(itemClass)) acc + n else acc})

  var puts:Int = 0
  var gets:Int = 0
  def content:Int = initContentCount + puts - gets - overflow
  var overflow:Int = 0

  def notifyPut(n:Int,itemClass:ItemClass){
    if(a.evaluate(itemClass)){
      puts += n
    }
  }
  def notifyGet(n:Int,itemClass:Int){
    if(a.evaluate(itemClass)){
      gets += n
    }
  }
  def notifyOverflow(n:Int,itemClass:Int){
    if(a.evaluate(itemClass)){
      overflow += n
    }
  }
}

/**
  *this type of storage acts in a FIFO-way.
  * it does matter to know this if you distinguish between different items.
  * @param maxSize the maximal content of the stock. attempting to put more items will block the putting operations
  * @param initialContent the initial content of the stock
  * @param name the name of the stock
  * @param verbosity where verbosities should be sent, can be null
  * @param overflowOnInput true if the stock overflows when there are excessing input, false to have it blocking the puts when it is full
  */
class FIFOStorage(maxSize:Int,
                  protected val initialContent:List[(Int,ItemClass)],
                  name:String,
                  verbosity:(String*)=>Unit,
                  overflowOnInput:Boolean,id:Int) extends Storage(maxSize,name,verbosity,overflowOnInput,id){

  val content:DoublyLinkedList[BufferCompositeItem] = new DoublyLinkedList[BufferCompositeItem]
  for(i <- initialContent){
    content.append(coupleToComposite(i))
  }

  override def contentSize: Int = internalSize

  private[this] var internalSize = content.foldLeft(0)({case (acc,bufferItem) => acc + bufferItem.n})

  override def cloneReset(newModel:Model):Storage =
    new FIFOStorage(maxSize, initialContent, name, verbosity, overflowOnInput,id)

  /**
    * @param l the list of items to be put
    * @return what remains to be put after this put, and what has been actually put
    */
  override protected def internalPut(l: List[(Int,ItemClass)], hasBeenPut:Int = 0): (List[(Int,ItemClass)], Int) = {
    l match {
      case h :: t =>
        val n = h._1
        if(n + internalSize <= maxSize) {
          //we can put the header composite fully
          if (content.nonEmpty && content.last.itemClass == h._2){
            //we can aggregate wit hthe previously put item because tehy have the same ItemClass :-)
            content.last.n += n
          }else {
            content.prepend(h)
          }
          internalSize += n
          internalPut(t, hasBeenPut + n) //tail

        }else if (internalSize < maxSize){
          //only partial put, and end of recursion
          val toPut = maxSize - internalSize
          val remain = n - toPut
          if (content.nonEmpty && content.last.itemClass == h._2){
            //we can aggregate wit hthe previously put item because they have the same ItemClass :-)
            content.last.n += toPut
          }else {
            content.prepend((toPut,h._2))
          }
          internalSize += toPut
          ((remain,h._2) :: t,hasBeenPut + toPut)
        }else {
          (l, hasBeenPut)
        }
      case Nil => (l, hasBeenPut)
    }
  }

  override protected def internalFetch(remainsToFetch: Int, hasBeenFetch:ItemClass = ItemClassHelper.zeroItemClass): (Int,ItemClass) = {
    if(remainsToFetch == 0){
      (0,hasBeenFetch)
    }else if (content.nonEmpty){
      val head = content.head
      if(head.n <= remainsToFetch){
        content.deleteFirst()
        internalSize -= head.n
        internalFetch(remainsToFetch-head.n, ItemClassHelper.union(head.itemClass,hasBeenFetch))
      }else{
        //we do not take everything, we have to put a part back
        head.n -= remainsToFetch
        internalSize -= remainsToFetch
        (0,ItemClassHelper.union(head.itemClass,hasBeenFetch))
      }
    }else{
      (remainsToFetch,hasBeenFetch)
    }
  }
}

/**
  *this type of storage acts in a LIFO-way.
  * it does matter to know this if you distinguish between different items.
  * @param maxSize the maximal content of the stock. attempting to put more items will block the putting operations
  * @param initialContent the initial content of the stock
  * @param name the name of the stock
  * @param verbosity where verbosities should be sent, can be null
  * @param overflowOnInput true if the stock overflows when there are excessing input, false to have it blocking the puts when it is full
  */
class LIFOStorage(maxSize:Int,
                  protected val initialContent:List[(Int,ItemClass)] = List.empty,
                  name:String,
                  verbosity:(String*)=>Unit,
                  overflowOnInput:Boolean,id:Int) extends Storage(maxSize,name,verbosity,overflowOnInput,id){

  var content:List[BufferCompositeItem] = initialContent.map(coupleToComposite)

  override def contentSize: Int = internalSize
  private[this] var internalSize: Int = content.foldLeft(0)({case (acc,bufferItem) => acc + bufferItem.n})

  override def cloneReset(newModel:Model): Storage = new LIFOStorage(maxSize, initialContent,name,verbosity,overflowOnInput,id)

  /**
    * @param l the list of items to be put
    * @return what remains to be put after this put, and what has been actually put
    */
  override protected def internalPut(l: List[(Int,ItemClass)], hasBeenPut:Int = 0): (List[(Int,ItemClass)], Int) = {
    l match {
      case h :: t =>
        val n = h._1
        if(n + internalSize <= maxSize) {
          //we can put the header composite fully (so far, we do not aggregate composite items)
          if(content.nonEmpty && content.head.itemClass == h._2){
            content.head.n += n
          }else{
            content = h :: content
          }
          internalSize += n
          internalPut(t, hasBeenPut + n) //tail
        }else if (internalSize < maxSize){
          //only partial put, and end of recursion
          val toPut = maxSize - internalSize
          val remain = n - toPut
          if(content.nonEmpty && content.head.itemClass == h._2){
            content.head.n += toPut
          }else{
            content = (toPut,h._2) :: content
          }
          internalSize += toPut
          ((remain,h._2) :: t,hasBeenPut + toPut)
        }else {
          (l, hasBeenPut)
        }
      case Nil => (l, hasBeenPut)
    }
  }

  override protected def internalFetch(remainsToFetch: Int, hasBeenFetch:ItemClass = ItemClassHelper.zeroItemClass): (Int,ItemClass) = {
    if(remainsToFetch == 0){
      (0,hasBeenFetch)
    }else content match{
      case head :: t =>
        if(head.n <= remainsToFetch){
          //we take this composite fully
          content = t
          internalSize -= head.n
          internalFetch(remainsToFetch-head.n, ItemClassHelper.union(head.itemClass,hasBeenFetch))
        }else{
          //we do not take everything, we have to put a part back
          head.n -= remainsToFetch
          internalSize -= remainsToFetch
          (0,ItemClassHelper.union(head.itemClass,hasBeenFetch))
        }
      case Nil =>
        (remainsToFetch,hasBeenFetch)
    }
  }
}