package oscar.des.flow.modeling

import oscar.des.flow.core._
import scala.collection.immutable.SortedSet

sealed abstract class ParsingResultItemClassTransformFunction()
case class ParsedTransformFuntion(f:ItemClassTransformFunction) extends ParsingResultItemClassTransformFunction
case class ParseErrorTransformFunction(s:String) extends ParsingResultItemClassTransformFunction

sealed abstract class ParsingResultItemClassTransformWitAdditionalOutput()
case class ParsedItemClassTransformWitAdditionalOutput(f:ItemClassTransformWitAdditionalOutput) extends ParsingResultItemClassTransformWitAdditionalOutput
case class ParseErrorItemClassTransformWitAdditionalOutput(s:String) extends ParsingResultItemClassTransformWitAdditionalOutput

class AttributeFunctionParser(attributes:AttributeDefinitions)
  extends ParserWithSymbolTable with AttributeHelper {
  override def skipWhitespace: Boolean = true
  protected override val whiteSpace = """(\s|//.*|(?m)/\*(\*(?!/)|[^*])*\*/)+""".r

  def parseTransformFunction(input: String): ParsingResultItemClassTransformFunction = {
    parseAll(attributeTransformFunctionParser, input) match {
      case Success(result: ItemClassTransformFunction, _) => ParsedTransformFuntion(result)
      case n: NoSuccess => ParseErrorTransformFunction(n.toString)
    }
  }

  def parseTransformFunctionWithAdditionalOutput(input:String):ParsingResultItemClassTransformWitAdditionalOutput = {
    parseAll(transformFunctionWithOutputParser, input) match {
      case Success(result: ItemClassTransformWitAdditionalOutput, _) => ParsedItemClassTransformWitAdditionalOutput(result)
      case n: NoSuccess => ParseErrorItemClassTransformWitAdditionalOutput(n.toString)
    }
  }

  private def transformFunctionWithOutputParser:Parser[ItemClassTransformWitAdditionalOutput] = (
    "if"~>attributeConditionParser~("then"~>(transformFunctionWithOutputParser~("else"~>transformFunctionWithOutputParser))) ^^ {
      case ((attr:AttributeCondition)~((thenF:ItemClassTransformWitAdditionalOutput)~(elseF:ItemClassTransformWitAdditionalOutput))) => iTE(attr,thenF,elseF)}
      | outputPortParser ~attributeTransformFunctionParser^^{case i~f => outputValue(i,f)}
    )

  private def outputPortParser:Parser[PortChoice] =
    rep1("outputPort"~>integer~opt("weight"~>doubleParser)^^{
      case i~None => (i,1)
      case i~Some(j) => (i,j)}) ^^
      { case List(a) => constantPort(a._1)
      case l:List[(Int,Double)] => discreteChoice(l)
      }

  def doubleParser:Parser[Double] = """[0-9]+(\.[0-9]+)?""".r ^^ {case s:String => s.toDouble}

  private def attributeTransformFunctionParser: Parser[ItemClassTransformFunction] =
    rep(atomicAttributeTransformFunctionParser) ^^ {
      case Nil => identity
      case h :: Nil => h
      case l: List[ItemClassTransformFunction] => composedItemClassTransformFunction(l: _*)
    }

  private def atomicAttributeTransformFunctionParser: Parser[ItemClassTransformFunction] = (
    "+" ~> attribute ^^ { a: Attribute => addAttribute(a) }
      | "-" ~> attribute ^^ { a: Attribute => removeAttribute(a) }
      | ":=" ~ "{" ~> (rep(attribute) <~ "}") ^^ { c: List[Attribute] => constantAttributes(attributeSet(SortedSet.empty[Attribute] ++ c, attributes)) }
      | failure("expected +, -,or :={...}")
    )

  def attributeConditionParser:Parser[AttributeCondition] = disjunctionParser
  def disjunctionParser:Parser[AttributeCondition] =
    conjunctionParser ~ opt("|"~>disjunctionParser) ^^ {
      case a~None => a
      case a~Some(b) => or(a,b)}

  def conjunctionParser:Parser[AttributeCondition]  =
    atomicBoolExprParser ~ opt("&"~>conjunctionParser) ^^ {
      case a~None => a
      case a~Some(b) => and(a,b)}

  def atomicBoolExprParser:Parser[AttributeCondition] = (
    "!"~>disjunctionParser^^{case (b:AttributeCondition) => not(b)}
      | "("~>disjunctionParser<~")"
      |attribute^^{attributeTerminal(_)}
    )

  private def attribute: Parser[Attribute] =
    identifier convertStringUsingSymbolTable(attributes.attributeMap, "attribute")

  private def identifier: Parser[String] = """[a-zA-Z0-9]+""".r ^^ {_.toString}

  private def integer:Parser[Int] = """[0-9]+""".r ^^ {_.toInt}
}