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

import oscar.des.flow.core.ItemClassHelper.ItemClass

import scala.collection.SortedSet
import scala.collection.immutable.SortedMap
import scala.language.implicitConversions
import scala.util.Random

/**
  * Defines an attribute symbol table.
  * this serves to attribute an integer value to each attribute
  * @param l the sequence of attribute names
  */
class AttributeDefinitions(l:String*){
  require(l.length <= 31, "maximum 31 attributes can be declared in a simulation model")
  def size:Int = l.length
  val attributeArray:Array[Attribute] = {
    val numbering = l.toArray
    for(i <- numbering.indices) yield
      new Attribute(numbering(i),i,this)
  }.toArray

  val attributeDico:SortedMap[String,Attribute] =
    SortedMap.empty[String,Attribute].++(for (a <- attributeArray) yield (a.name,a))

  override def toString: String = {
    "AttributeDefinitions(" + l.mkString(",") + ")"
  }

  def get(s:String):Attribute = attributeDico.get(s) match{
    case Some(a) => a
    case None => throw new Error("unknown attribute:"+ s)
  }

  def attributeMap:Map[String,Attribute] = attributeDico

  def getN(i:Int) = attributeArray(i)
}

object Attribute{
  implicit def toSet(a:Attribute):AttributeSet = AttributeSet(SortedSet(a), a.convention)
  implicit def toItemClass(a:Attribute):ItemClass = a.mask
}

class Attribute(val name:String, val id:Int,val convention:AttributeDefinitions) extends Ordered[Attribute]{
  def mask:Int = 1 << id
  override def compare(that: Attribute): Int = this.id.compare(that.id)

  override def toString: String = "Attribute(" + name + " id:" + id + ")"

  def toSet:AttributeSet = AttributeSet(SortedSet(this), convention)
  def toItemClass:ItemClass = mask
}

object AttributeSet{
  def apply(convention:AttributeDefinitions, attributesString:String*) =
    new AttributeSet(SortedSet.empty[Attribute].++(attributesString.map((s: String) => { convention.get(s) })), convention)
}

/**
  * this represents a set of attributes, or an ItemClass
  * @param attributes a sorted set of attributes
  * @param convention the convention that defines the attributes
  */
case class AttributeSet(attributes:SortedSet[Attribute], convention:AttributeDefinitions){
  def mask:Int = attributes.foldLeft(0)((acc,l) => acc | l.mask)
  implicit def itemClass:ItemClass = mask
  override def toString: String = {
    "AttributeSet(" + attributes.map(_.name).mkString(",") + " " + convention + ")"
  }
}

object AttributeHelper{
  def unionAll(l:Set[AttributeSet]):AttributeSet =
    AttributeSet(l.foldLeft(SortedSet.empty[Attribute])((acc,l) => acc union l.attributes), l.head.convention)

  def fullSet(a:AttributeDefinitions):AttributeSet = null
  def emptySet(a:AttributeDefinitions):AttributeSet = null
  def attributeList(d:AttributeDefinitions):List[Attribute] = null
}

object ItemClassHelper{
  type ItemClass = Int
  val zeroItemClass = 0

  def unionAll(l:List[ItemClass]):ItemClass = l.foldLeft(0:ItemClass)((acc,l) => l & acc)
  def union(i:ItemClass,j:ItemClass):ItemClass = i | j
  implicit def storage(i:(Int,ItemClass)):List[ItemClass] = (1 to i._1).map(_=>i._2).toList
}

// //////////////////////////////////////////////////////////////
// A2A
sealed abstract class ItemClassTransformFunction{
  def slowApply(l:AttributeSet):AttributeSet

  //1: conjunction 2:disjunction
  def conjunctionMask:Int = -1
  def disjunctionMask:Int = 0

  def apply(i:Int):Int = (i & conjunctionMask) | disjunctionMask
}


/**
  * a function that removes an atribute from an attribute set
  * @param a the attribute to remove
  */
case class RemoveAttribute(a:Attribute) extends ItemClassTransformFunction{
  override def slowApply(l:AttributeSet):AttributeSet = AttributeSet(l.attributes.-(a),l.convention)
  override val conjunctionMask:Int = -1 ^ (1 << a.id)
}

/**
  * a function that adds an atribute from an attribute set
  * @param a the attribute to add
  */
case class AddAttribute(a:Attribute) extends ItemClassTransformFunction{
  override def slowApply(l:AttributeSet):AttributeSet = AttributeSet(l.attributes.+(a),l.convention)
  override val disjunctionMask:Int = 1 << a.id
}

/**
  * a function that returns a pre-defined attribute set; ignoring the attributes passed to it
  * @param s the attributes to return
  */
case class ConstantAttributes(s:AttributeSet) extends ItemClassTransformFunction{
  override def slowApply(l:AttributeSet):AttributeSet = s
  val mask:Int = s.mask
  override def conjunctionMask:Int = mask
  override def disjunctionMask:Int = mask
}

/**
  * a composite function of attribute transforms.
  * the functions are called one after the other to gradually transform attributeSet into their output value
  * @param ops the sequence of transforms to apply, in this order
  */
case class ComposedItemClassTransformFunction(ops:ItemClassTransformFunction*) extends ItemClassTransformFunction{
  def slowApply(l:AttributeSet):AttributeSet = ops.foldLeft(l)((acc,op) => op.slowApply(acc))
  def quickApplyNoCache(i:Int):Int = ops.foldLeft(i)((acc,op) => op.apply(acc))
  override val conjunctionMask:Int = quickApplyNoCache(-1)
  override val disjunctionMask:Int = quickApplyNoCache(0)
}

/**
  * ths identify tranform fucntion for attribute sets
  */
case class Identity() extends ItemClassTransformFunction{
  def slowApply(l:AttributeSet):AttributeSet = l
}

object Test extends App{
  val a = new AttributeDefinitions("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t")

  val transform = ComposedItemClassTransformFunction(RemoveAttribute(a.get("i")),
    AddAttribute(a.get("i")),
    AddAttribute(a.get("d")),
    RemoveAttribute(a.get("i")),
    AddAttribute(a.get("o")),
    RemoveAttribute(a.get("t")))

  val s = AttributeSet(a,"c","o","n")

  assert(transform.slowApply(s).mask == transform.quickApplyNoCache(s.mask))
  assert(transform.quickApplyNoCache(s.mask) == transform.apply(s.mask))
}

sealed abstract class ItemClassTransformWitAdditionalOutput{
  def slowApply(l:AttributeSet):(Int,AttributeSet)
  def apply(i:Int):(Int,Int)
}

/**
  * this is an if-then-else construct
  * @param a the attribute on which the if-then else is targeted
  * @param thenBranch the then branch, taken if a is in the submitted attribute  set
  * @param elseBranch the else branch, taken if a is not in the submitted attribute set
  */
case class ITE(a:AttributeCondition,thenBranch:ItemClassTransformWitAdditionalOutput,elseBranch:ItemClassTransformWitAdditionalOutput) extends ItemClassTransformWitAdditionalOutput{

  override def slowApply(l: AttributeSet): (Int, AttributeSet) = {
    if (a.slowEvaluate(l)){
      thenBranch.slowApply(l)
    }else{
      elseBranch.slowApply(l)
    }
  }

  override def apply(i: Int): (Int, Int) = {
    if(a.evaluate(i)){
      thenBranch.apply(i)
    }else{
      elseBranch.apply(i)
    }
  }
}

sealed abstract class AttributeCondition{
  def slowEvaluate(l: AttributeSet):Boolean
  def evaluate(i:Int):Boolean
}

case class AttributeAnd(a:AttributeCondition,b:AttributeCondition) extends AttributeCondition{
  override def slowEvaluate(l: AttributeSet): Boolean = a.slowEvaluate(l) && b.slowEvaluate(l)
  override def evaluate(i: ItemClass): Boolean = a.evaluate(i) && b.evaluate(i)
}

case class AttributeOr(a:AttributeCondition,b:AttributeCondition) extends AttributeCondition{
  override def slowEvaluate(l: AttributeSet): Boolean = a.slowEvaluate(l) || b.slowEvaluate(l)
  override def evaluate(i: ItemClass): Boolean = a.evaluate(i) || b.evaluate(i)
}

case class AttributeNot(a:AttributeCondition) extends AttributeCondition {
  override def slowEvaluate(l: AttributeSet): Boolean = !a.slowEvaluate(l)
  override def evaluate(i: ItemClass): Boolean = !a.evaluate(i)
}

case class AttributeTerminal(a:Attribute) extends AttributeCondition{
  override def slowEvaluate(l: AttributeSet): Boolean =  l.attributes.contains(a)
  override def evaluate(i: ItemClass): Boolean = (i & a.mask) != 0
}

/**
  * a function that defines the output integer sent back
  * @param outputValue the function that chooses the output port
  * @param attr the transformation function for item classes
  */
case class OutputValue(outputValue:PortChoice, attr:ItemClassTransformFunction = Identity()) extends ItemClassTransformWitAdditionalOutput{
  override def slowApply(l: AttributeSet): (Int, AttributeSet) =
    (outputValue(),attr.slowApply(l))

  override def apply(i: Int): (Int, Int) = {
    (outputValue(),attr(i))
  }
}
abstract class PortChoice{
  def apply():Int
}
case class ConstantPort(port:Int) extends PortChoice{
  override def apply():Int = port
}
case class DiscreteChoice(choices:List[(Int,Double)]) extends PortChoice{
  val totalWeights = choices.foldLeft(0.0)((acc,newVal) => {
    require(newVal._2 >= 0.0)
    acc + newVal._2
  })

  def apply():Int = getValue(choices,Random.nextDouble()*totalWeights)

  private def getValue(lvalues:List[(Int,Double)],offset:Double):Int = {
    lvalues match{
      case List(l) => l._1
      case (value,weight)::t =>
        if (weight < offset) getValue(t,offset - weight)
        else value
      case Nil => throw new Error("unexpected end of list")
    }
  }

}