package oscar.des.flow.core

import JSci.maths.statistics.UniformDistribution
import oscar.des.flow.core.ItemClassHelper.ItemClass
import oscar.des.montecarlo.DoubleRandomVar

import scala.collection.SortedSet
import scala.collection.immutable.SortedMap
import scala.language.implicitConversions


/**
 * defines an attribute symbol table.
 * this serves to attribute an integer value to each attribute
 * @param l the sequence of attribute names
 */
class AttributeDefinitions(l:String*){
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

class Attribute(val name:String, val id:Int,val convention:AttributeDefinitions) extends Ordered[Attribute]{
  def mask:Int = 1 << id
  override def compare(that: Attribute): Int = this.id.compare(that.id)

  override def toString: String = "Attribute(" + name + " id:" + id + ")"
}

object AttributeSet{
  def apply(convention:AttributeDefinitions, attributesString:String*) =
    new AttributeSet(SortedSet.empty[Attribute].++(attributesString.map((s: String) => convention.get(s))), convention)
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
 * @param outputValue the output value
 * @param attr the function that transforms the attributes
 */
case class OutputValue(outputValue:PortChoice, attr:ItemClassTransformFunction = Identity()) extends ItemClassTransformWitAdditionalOutput{
  override def slowApply(l: AttributeSet): (Int, AttributeSet) =
    (outputValue(),attr.slowApply(l))

  override def apply(i: Int): (Int, Int) = {
    (outputValue(),attr(i))
  }
}
abstract class PortChoice{
  protected val rdVar = new DoubleRandomVar("rdV", new UniformDistribution(0, 1))

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

  def apply():Int = getValue(choices,rdVar.getValue*totalWeights)

  private def getValue(ls:List[(Int,Double)],offset:Double):Int = {
    ls match{
      case List(l) => l._1
      case (value,weight)::t =>
        if (weight < offset) getValue(t,offset - weight)
        else value
      case Nil => throw new Error("unexpected end of list")
    }
  }
}
