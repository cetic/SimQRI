package oscar.des.flow.modeling

import oscar.des.flow.core.ItemClassHelper.ItemClass
import oscar.des.flow.core._

import scala.collection.SortedSet
import scala.language.implicitConversions

object AttributeHelper extends AttributeHelper

/**
  * Created by rdl on 31/08/2015.
  */
trait AttributeHelper {
  /**
    * defines an attribute symbol table.
    * this serves to attribute an intr value to each attribute
    * @param l the list of attribute's symbols
    */
  def attributeDefinitions(l: String*) = new AttributeDefinitions(l: _*)

  /**
    * this represents a set of attributes, or an ItemClass
    * @param attributes a sorted set of attributes
    * @param convention the attribute definitions
    */
  def attributeSet(attributes: SortedSet[Attribute], convention: AttributeDefinitions)
  = new AttributeSet(attributes, convention)

  /**
    * a function that removes an atribute from an attribute set
    * @param a the attribute to remove
    */
  def removeAttribute(a: Attribute) = RemoveAttribute(a)

  /**
    * a function that adds an attribute from an attribute set
    * @param a the attribute to add
    */
  def addAttribute(a: Attribute) = AddAttribute(a: Attribute)

  /**
    * a function that returns a pre-defined attribute set; ignoring the attributes passed to it
    * @param s the attributes to return
    */
  def constantAttributes(s: AttributeSet) = ConstantAttributes(s: AttributeSet)

  /**
    * a composite function of attribute transforms.
    * the functions are called one after the other to gradually transform attributeSet into their output value
    * @param ops the sequence of transforms to apply, in this order
    */
  def composedItemClassTransformFunction(ops: ItemClassTransformFunction*) = ComposedItemClassTransformFunction(ops: _*)

  /**
    * ths identify tranform fucntion for attribute sets
    */
  val identity = new Identity()

  /**
    * this is an if-then-else construct
    * @param a the attribute on which the if-then else is targeted
    * @param thenBranch the then branch, taken if a is in the submitted attribute  set
    * @param elseBranch the else branch, taken if a is not in the submitted attribute set
    */
  def iTE(a: AttributeCondition, thenBranch: ItemClassTransformWitAdditionalOutput, elseBranch: ItemClassTransformWitAdditionalOutput)
  = new ITE(a, thenBranch, elseBranch)

  /**
    * a function that defines the output integer sent back
    * @param port the choice of port
    * @param attr the attribute function
    */
  def outputValue(port:PortChoice, attr: ItemClassTransformFunction = Identity())
  = OutputValue(port, attr)

  def discreteChoice(choices:List[(Int,Double)]):PortChoice = new DiscreteChoice(choices)

  def constantPort(port:Int):PortChoice = ConstantPort(port)


  def and(a:AttributeCondition,b:AttributeCondition) = AttributeAnd(a,b)
  def or(a:AttributeCondition,b:AttributeCondition) = AttributeOr(a,b)
  def not(a:AttributeCondition) = AttributeNot(a)
  def attributeTerminal(a:Attribute) = AttributeTerminal(a)

  val zeroItemClass = 0

  implicit def storage(i:(Int,ItemClass)):List[ItemClass] = (1 to i._1).map(_=>i._2).toList
}