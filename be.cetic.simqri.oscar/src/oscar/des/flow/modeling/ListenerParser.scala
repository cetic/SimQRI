package oscar.des.flow.modeling

import oscar.des.flow.core.{AttributeDefinitions, Attribute, AttributeCondition}

import oscar.des.flow.lib._

import scala.collection.immutable.SortedMap
import scala.util.parsing.combinator._

import scala.language.implicitConversions

sealed abstract class ListenerParsingResult
sealed abstract class ParsingSuccess extends ListenerParsingResult

case class DoubleExpressionResult(d:DoubleExpr) extends ParsingSuccess
case class BooleanExpressionResult(b:BoolExpr) extends ParsingSuccess
case class DoubleHistoryExpressionResult(dh:DoubleHistoryExpr) extends ParsingSuccess
case class BoolHistoryExpressionResult(bh:BoolHistoryExpr) extends ParsingSuccess

case class ParsingError(s:String) extends ListenerParsingResult {
  override def toString: String = "Parse Error:\n" + s + "\n"
}

sealed abstract class MultipleParsingResult
case class MultipleParsingSuccess(expressions:List[(String,Expression)]) extends MultipleParsingResult{
  override def toString: String = " MultipleParsingSuccess(\n\t" + expressions.mkString("\n\t") + ")"
}
case class MultipleParsingError(s:String) extends MultipleParsingResult

object ListenerParser{

  def apply(storages:Iterable[Storage],processes:Iterable[ActivableProcess],a:AttributeDefinitions):ListenerParser = {
    val storagesMap = storages.foldLeft[SortedMap[String,Storage]](SortedMap.empty)(
      (theMap,storage) => theMap + ((storage.name,storage)))
    val processMap = processes.foldLeft[SortedMap[String,ActivableProcess]](SortedMap.empty)(
      (theMap,process) => theMap + ((process.name,process)))
    new ListenerParser(storagesMap, processMap,a)
  }

  def apply(storages:Iterable[Storage],processes:Iterable[ActivableProcess], expressions:List[(String,String)],a:AttributeDefinitions): MultipleParsingResult ={
    val myParser = ListenerParser(storages, processes,a)
    myParser.parseAllListeners(expressions)
  }

  def processCostParser(process:ActivableProcess,a:AttributeDefinitions):ListenerParser = {
    new ListenerParser(SortedMap.empty, SortedMap.empty[String,ActivableProcess]+(("this",process)),a)
  }

  def storageCostParser(storage:Storage,a:AttributeDefinitions):ListenerParser = {
    new ListenerParser(SortedMap.empty[String,Storage]+(("this",storage)), SortedMap.empty,a)
  }
}

class ListenerParser(storages:Map[String,Storage],
                     processes:Map[String,ActivableProcess],
                     attributes:AttributeDefinitions)
  extends ParserWithSymbolTable with ListenersHelper with AttributeHelper{

  protected override val whiteSpace = """(\s|//.*|(?m)/\*(\*(?!/)|[^*])*\*/)+""".r

  override def skipWhitespace: Boolean = true

  def parseAllListeners(expressions:List[(String,String)]):MultipleParsingResult = {
    MultipleParsingSuccess(expressions.map({
      case (name,expr) =>
        this.apply(expr) match{
          case BooleanExpressionResult(result) =>
            declaredBoolExpr += ((name,result))
            (name,result)
          case DoubleExpressionResult(result) =>
            declaredDoubleExpr += ((name,result))
            (name,result)
          case DoubleHistoryExpressionResult(result) =>
            (name,result)
          case BoolHistoryExpressionResult(result) =>
            (name,result)
          case ParsingError(p) => return MultipleParsingError("Error while parsing " + name + "\n" + p)
        }
    }))
  }

  var declaredBoolExpr:SortedMap[String,BoolExpr] = SortedMap.empty[String,BoolExpr]
  var declaredDoubleExpr:SortedMap[String,DoubleExpr] = (SortedMap.empty[String,DoubleExpr]
    ++ storages.map(nameAndStorage => ("cost of " + nameAndStorage._1, nameAndStorage._2.cost))
    ++ processes.map(nameAndProcess => ("cost of " + nameAndProcess._1, nameAndProcess._2.cost)))

  def apply(input:String):ListenerParsingResult = {
    parseAll(expressionParser, input) match {
      case Success(result:BoolExpr, _) => BooleanExpressionResult(result)
      case Success(result:DoubleExpr, _) => DoubleExpressionResult(result)
      case Success(result:DoubleHistoryExpr, _) => DoubleHistoryExpressionResult(result)
      case Success(result:BoolHistoryExpr, _) => BoolHistoryExpressionResult(result)
      case n:NoSuccess => ParsingError(n.toString)
    }
  }

  def applyAndExpectDouble(input:String):DoubleExpr = {
    apply(input) match{
      case DoubleExpressionResult(r) => r
      case e:ListenerParsingResult =>
        throw new Exception("expected double expression, got " + e.toString)
        null
    }
  }

  def expressionParser:Parser[Expression] = (
    doubleExprParser
      | boolExprParser
      | "record(" ~> boolExprParser <~ ")" ^^ {boolHistoryExpr(_)}
      | "record(" ~> doubleExprParser <~ ")" ^^ {doubleHistoryExpr(_)}
      |failure("expected boolean or arithmetic expression"))

  def boolExprParser:Parser[BoolExpr] = (
    "[*]" ~> boolExprParser ^^ {case b => hasAlwaysBeen(b)}
      | "<*>" ~> boolExprParser ^^ {case b => hasBeen(b)}
      | "@" ~> boolExprParser ^^ {case b => becomesTrue(b)}
      | doubleExprParser~(">="|">"|"<="|"<"|"!="|"=")~doubleExprParser ^^ {
      case (a~op~b) => op match{
        case ">" => g(a,b)
        case ">=" => ge(a,b)
        case "<" => l(a,b)
        case "<=" => le(a,b)
        case "=" => eq(a,b)
        case "!=" => neq(a,b)
      }}
      | disjunctionParser)

  def disjunctionParser:Parser[BoolExpr] =
    conjunctionParser ~ opt("|"~>disjunctionParser) ^^ {
      case a~None => a
      case a~Some(b) => or(a,b)}

  def conjunctionParser:Parser[BoolExpr]  =
    atomicBoolExprParser ~ opt("&"~>conjunctionParser) ^^ {
      case a~None => a
      case a~Some(b) => and(a,b)}

  def atomicBoolExprParser:Parser[BoolExpr] = (
    "empty(" ~> storageParser <~")" ^^ {empty(_)}
      | processBoolProbe("running",running)
      | processBoolProbe("anyBatchStarted",anyBatchStarted)
      | "true" ^^^ boolConst(true)
      | "false" ^^^ boolConst(false)
      | boolListener
      | binaryOperatorBB2BParser("and",and)
      | binaryOperatorBB2BParser("or",or)
      | binaryOperatorBB2BParser("since",since)
      | unaryOperatorB2BParser("not",not)
      | "!"~>boolExprParser^^{case (b:BoolExpr) => not(b)}
      | unaryOperatorB2BParser("hasAlwaysBeen",hasAlwaysBeen)
      | unaryOperatorB2BParser("hasBeen",hasBeen)
      | unaryOperatorB2BParser("becomesTrue",becomesTrue)
      | unaryOperatorB2BParser("becomesFalse",becomesFalse)
      | binaryOperatorDD2BParser("g",g)
      | binaryOperatorDD2BParser("ge",ge)
      | binaryOperatorDD2BParser("l",l)
      | binaryOperatorDD2BParser("le",le)
      | binaryOperatorDD2BParser("eq",eq)
      | binaryOperatorDD2BParser("ne",neq)
      | "changed(" ~> (boolExprParser | doubleExprParser) <~")" ^^ {
      case b:BoolExpr => boolChanged(b)
      case d:DoubleExpr => doubleChanged(d)
      case _ => {throw new Exception("internal parser error"); null}}
      | "ite(" ~> boolExprParser~(","~>boolExprParser)~(","~>boolExprParser <~ ")") ^^{ case i~t~e => booleanITE(i,t,e)}
      | "("~>boolExprParser<~")"
      | failure("expected boolean expression"))

  def binaryTerm:Parser[BoolExpr] = unaryOperatorB2BParser("not",not)

  def doubleExprParser:Parser[DoubleExpr] =
    term ~ opt(("+"|"-")~doubleExprParser) ^^ {
      case a~None => a
      case a~Some("+"~b) => plus(a,b)
      case a~Some("-"~b) => minus(a,b)}

  def term: Parser[DoubleExpr] =
    atomicDoubleExprParser ~ opt(("*"|"/")~term) ^^ {
      case a~None => a
      case a~Some("*"~b) => mult(a,b)
      case a~Some("/"~b) => div(a,b)}

  def atomicDoubleExprParser:Parser[DoubleExpr] = (
    "content"~>"("~>storageParser ~opt(","~>attributeConditionParser) <~")" ^^ {case storage~cond => stockLevel(storage,cond)}
      | storageDoubleProbe("capacity",stockCapacity)
      | storageDoubleProbe("relativeStockLevel",relativeStockLevel)
      | "totalPut"~>"("~>storageParser ~opt(","~>attributeConditionParser) <~")" ^^ {case storage~cond => totalPut(storage,cond)}
      | "totalFetch"~>"("~>storageParser ~opt(","~>attributeConditionParser) <~")" ^^ {case storage~cond => totalFetch(storage,cond)}
      | "totalLostByOverflow"~>"("~>storageParser ~opt(","~>attributeConditionParser) <~")" ^^ {case storage~cond => totalLostByOverflow(storage,cond)}
      | storageDoubleProbe("cost",(s:Storage) => s.cost)
      | processDoubleProbe("cost",(p:ActivableProcess) => p.cost)
      | "completedBatchCount"~>"("~>processParser ~opt(","~>naturalParser)<~")" ^^ {
      case process~None => completedBatchCount(process,-1)
      case process~Some(portNumber) => completedBatchCount(process,portNumber)}
      | processDoubleProbe("startedBatchCount",startedBatchCount)
      | processDoubleProbe("totalWaitDuration",totalWaitDuration)
      | doubleParser ^^ {d:Double => doubleConst(d)}
      | doubleListener
      | binaryOperatorDD2DParser("plus",plus)
      | binaryOperatorDD2DParser("minus",minus)
      | binaryOperatorDD2DParser("mult",mult)
      | binaryOperatorDD2DParser("div",(a,b) => div(a,b))
      | unaryOperatorD2DParser("opposite",opposite)
      | unaryOperatorD2DParser("delta",delta)
      | unaryOperatorB2DParser("cumulatedDuration",cumulatedDuration)
      | unaryOperatorB2DParser("cumulatedDurationNotStart",cumulatedDurationNotStart)
      | "time"^^^ currentTime
      | "tic" ^^^ delta(currentTime)
      | unaryOperatorD2DParser("integral",ponderateWithDuration)
      | ("maxOnHistory("|"max(") ~> doubleExprParser~opt("," ~> boolExprParser)<~")" ^^ {
      case (d~None) => maxOnHistory(d)
      case (d~Some(cond:BoolExpr)) => maxOnHistory(d,cond)}
      | ("minOnHistory("|"min(") ~> doubleExprParser~opt("," ~> boolExprParser)<~")"^^ {
      case (d~None) => minOnHistory(d)
      case (d~Some(cond:BoolExpr)) => minOnHistory(d,cond)}
      | unaryOperatorD2DParser("avg",avgOnHistory)
      | unaryOperatorD2DParser("avgOnHistory",avgOnHistory)
      | "ite(" ~> boolExprParser~(","~>doubleExprParser)~(","~>doubleExprParser<~ ")") ^^{ case i~t~e => doubleITE(i,t,e)}
      |"duration(" ~> boolExprParser <~")" ^^ {case e => duration(e)}
      | "-"~> doubleExprParser ^^ {opposite(_)}
      | "("~>doubleExprParser<~")"
      | "totalCost" ^^^ {
      val costList = storages.toList.map(_._2.cost) ::: processes.toList.map(_._2.cost)
      costList.foldLeft[DoubleExpr](0.0)(plus(_,_))}
      | failure("expected arithmetic expression"))

  //generic code
  def boolListener:Parser[BoolExpr] = {
    identifier convertStringUsingSymbolTable(declaredBoolExpr, "delcared boolean expression") //^^ {boolSubExpression(_)}
  }
  def doubleListener:Parser[DoubleExpr] =
    identifier convertStringUsingSymbolTable(declaredDoubleExpr, "declared double expression") //^^{doubleSubExpression(_)}

  //probes on storages
  def storageDoubleProbe(probeName:String,constructor:Storage=>DoubleExpr):Parser[DoubleExpr] =
    probeName~>"("~>storageParser <~")" ^^ {constructor(_)}

  def storageParser:Parser[Storage] = identifier convertStringUsingSymbolTable(storages, "storage")

  //probes on processes
  def processDoubleProbe(probeName:String,constructor:ActivableProcess=>DoubleExpr):Parser[DoubleExpr] =
    probeName~>"("~>processParser <~")" ^^ {constructor(_)}
  def processBoolProbe(probeName:String,constructor:ActivableProcess=>BoolExpr):Parser[BoolExpr] =
    probeName~>"("~>processParser <~")" ^^ {constructor(_)}
  def processParser:Parser[ActivableProcess] = identifier convertStringUsingSymbolTable(processes, "process")

  // some generic parsing methods
  def unaryOperatorD2DParser(operatorString:String,constructor:DoubleExpr=>DoubleExpr):Parser[DoubleExpr] =
    operatorString~>"("~>doubleExprParser<~")" ^^ {
      case param => constructor(param)
    }

  def unaryOperatorB2BParser(operatorString:String,constructor:BoolExpr=>BoolExpr):Parser[BoolExpr] =
    operatorString~>"("~>boolExprParser<~")" ^^ {
      case param => constructor(param)
    }

  def unaryOperatorB2DParser(operatorString:String,constructor:BoolExpr=>DoubleExpr):Parser[DoubleExpr] =
    operatorString~>"("~>boolExprParser<~")" ^^ {
      case param => constructor(param)
    }

  def binaryOperatorDD2DParser(operatorString:String,constructor:(DoubleExpr,DoubleExpr)=>DoubleExpr):Parser[DoubleExpr] =
    operatorString~"("~>doubleExprParser~(","~>doubleExprParser<~")") ^^ {
      case param1~param2 => constructor(param1,param2)
    }

  def binaryOperatorDD2BParser(operatorString:String,constructor:(DoubleExpr,DoubleExpr)=>BoolExpr):Parser[BoolExpr] =
    operatorString~>"("~>doubleExprParser~(","~>doubleExprParser<~")") ^^ {
      case param1~param2 => constructor(param1,param2)
    }

  def binaryOperatorBB2BParser(operatorString:String,constructor:(BoolExpr,BoolExpr)=>BoolExpr):Parser[BoolExpr] =
    operatorString~>"("~>boolExprParser~(","~>boolExprParser<~")") ^^ {
      case param1~param2 => constructor(param1,param2)
    }

  def identifierNoSpaceAllowed:Parser[String] = """[a-zA-Z0-9_\-]+""".r ^^ {_.toString}
  def identifierSpaceAllowed:Parser[String] = """\"[a-zA-Z0-9 _\-]+\"""".r ^^ {_.toString.drop(1).dropRight(1)}
  def identifier:Parser[String] = identifierSpaceAllowed | identifierNoSpaceAllowed

  def doubleParser:Parser[Double] = """[0-9]+(\.[0-9]+)?""".r ^^ {case s:String => s.toDouble}
  def naturalParser:Parser[Int] = """[0-9]+""".r ^^ {case s:String => s.toInt}

  def attributeConditionParser:Parser[AttributeCondition] = disjunctionAttributeParser
  def disjunctionAttributeParser:Parser[AttributeCondition] =
    conjunctionAttributeParser ~ opt("|"~>disjunctionAttributeParser) ^^ {
      case a~None => a
      case a~Some(b) => or(a,b)}

  def conjunctionAttributeParser:Parser[AttributeCondition]  =
    atomicBoolExprAttributeParser ~ opt("&"~>conjunctionAttributeParser) ^^ {
      case a~None => a
      case a~Some(b) => and(a,b)}

  def atomicBoolExprAttributeParser:Parser[AttributeCondition] = (
    "!"~>disjunctionAttributeParser^^{case (b:AttributeCondition) => not(b)}
      | "("~>disjunctionAttributeParser<~")"
      |attribute^^{attributeTerminal(_)}
    )

  private def attribute: Parser[Attribute] =
    identifier convertStringUsingSymbolTable(attributes.attributeMap, "attribute")
}

trait ParserWithSymbolTable extends RegexParsers{
  class parserWithSymbolTable(identifierParser: Parser[String]) {
    def convertStringUsingSymbolTable[U](symbolTable: Map[String,U], symbolType: String): Parser[U] = new Parser[U] {
      def apply(in: Input) = identifierParser(in) match {
        case Success(x, in1) => symbolTable.get(x) match {
          case Some(u: U) => Success(u, in1)
          case None => Failure("" + x + " is not a known " + symbolType + ": (" + symbolTable.keys.mkString(",") + ") (add quotes around identifiers with white spaces)", in)
        }
        case f: Failure => f
        case e: Error => e
      }
    }
  }

  implicit def addSymbolTableFeature(identifierParser:Parser[String]):parserWithSymbolTable = new parserWithSymbolTable(identifierParser)
}
