package oscar.des.flow

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
/*******************************************************************************
  * Contributors:
  *     This code has been initially developed by CETIC www.cetic.be
  *         by Renaud De Landtsheer
  ******************************************************************************/

/** This is a mutable data structure allowing insert,
  * and delete in O(1) based on a key mechanism
  * @author renaud.delandtsheer@cetic.be
  * @tparam T contents type
  */
class DoublyLinkedList[T<:AnyRef] extends Iterable[T]{

  val headFantom:DLLStorageElement[T] = new DLLStorageElement[T](null.asInstanceOf[T])
  val endFantom:DLLStorageElement[T] = new DLLStorageElement[T](null.asInstanceOf[T])

  headFantom.setNext(endFantom)

  override def size = msize
  var msize:Int = 0
  def prepend(elem:T):DLLStorageElement[T] = {
    val d = new DLLStorageElement[T](elem)
    d.setNext(headFantom.next)
    headFantom.setNext(d)
    msize +=1
    d
  }

  def append(elem:T):DLLStorageElement[T] = {
    val d = new DLLStorageElement[T](elem)
    endFantom.prev.setNext(d)
    d.setNext(endFantom)
    msize +=1
    d
  }

  def +(elem:T){prepend(elem)}
  def ++(elems:Iterable[T]) {for(elem <- elems) prepend(elem)}

  def deleteElem(elemkey:DLLStorageElement[T]):T = {
    elemkey.prev.setNext(elemkey.next)
    msize -=1
    elemkey.elem
  }

  def first = headFantom.next.elem

  override def last = endFantom.prev.elem

  def deleteFirst(): T = {
    val firstStorageElement = headFantom.next
    if(firstStorageElement != endFantom){
      deleteElem(firstStorageElement)
    }else{
     null.asInstanceOf[T]
    }
  }

  def deleteLast(): T = {
    val lastStorageElement = endFantom.prev
    if(lastStorageElement != headFantom){
      deleteElem(lastStorageElement)
    }else{
      null.asInstanceOf[T]
    }
  }

  def dropAll(){
    headFantom.setNext(endFantom)
    msize = 0
  }

  override def isEmpty:Boolean = size == 0

  override def iterator = new DLLIterator[T](headFantom,endFantom)
}

/**
 * @author renaud.delandtsheer@cetic.be
 * @param elem the actual element
 * @tparam T the element type
 */
class DLLStorageElement[T](val elem:T){
  var next:DLLStorageElement[T] = null
  var prev:DLLStorageElement[T] = null

  def setNext(d:DLLStorageElement[T]){
    this.next = d
    d.prev = this
  }
}

/**
 * @author renaud.delandtsheer@cetic.be
 * @param CurrentKey the reference of the "current" element in the iterator
 * @param endfantom a reference to the "last" element in the iterator
 * @tparam T the element type
 */
class DLLIterator[T](var CurrentKey:DLLStorageElement[T], val endfantom:DLLStorageElement[T]) extends Iterator[T]{
  def next():T = {
    CurrentKey = CurrentKey.next
    CurrentKey.elem
  }

  def hasNext:Boolean = {CurrentKey.next != endfantom}
}
