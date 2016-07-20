package be.cetic.simqri.simulator.mapping

/**
 * @author FK
 * 
 * This class is a kind of intermediate model defined in order to retrieve simulations results of each component
 * and send them back to the Sirius front-end. It has its equivalent in the web client developed by Gustavo Ospina
 */

import oscar.des.flow.lib._

abstract class SimQRiComponent {
  def getName : String
  def getType : String
  def mapInfo : Map[String, Double]
}

case class CBatchProcess(bp : BatchProcess) extends SimQRiComponent {
  def getName = bp.name
  def getType = "Batch Process"
  def mapInfo = bp.mapInfo
  override def toString : String = s"$bp"
}

case class CConveyorBeltProcess(cbp : ConveyorBeltProcess) extends SimQRiComponent {
  def getName = cbp.name
  def getType = "Conveyor BeltProcess"
  def mapInfo = cbp.mapInfo
  override def toString : String = s"$cbp"
}

case class CFailingBatchProcess(fbp : SplittingBatchProcess) extends SimQRiComponent {
  def getName = fbp.name
  def getType = "Failing Batch Process"
  def mapInfo = fbp.mapInfo
  override def toString : String = s"$fbp"
}

case class CFailingSingleBatchProcess(fsbp : SplittingSingleBatchProcess) extends SimQRiComponent {
  def getName = fsbp.name
  def getType = "Failing Single Batch Process"
  def mapInfo = fsbp.mapInfo
  override def toString : String = s"$fsbp"
}

case class COrderOnStockThreshold(oost : OnLowerThreshold) extends SimQRiComponent {
  def getName = oost.name
  def getType = "Order on Stock Threshold"
  def mapInfo = oost.mapInfo
  override def toString : String = s"$oost"
}

case class COrderOnStockThresholdWithTick(oostwt : OnLowerThreshold) extends SimQRiComponent {
  def getName = oostwt.name
  def getType = "Order on Stock Threshold with Tick"
  def mapInfo = oostwt.mapInfo
  override def toString : String = s"$oostwt"
}

case class COverflowStorage(os : Storage) extends SimQRiComponent {
  def getName = os.name
  def getType = "Overflow Storage"
  def mapInfo = os.mapInfo
  override def toString : String = s"$os"
}

case class CPartSupplier(ps : SingleBatchProcess) extends SimQRiComponent {
  def getName = ps.name
  def getType = "Part Supplier"
  def mapInfo = ps.mapInfo
  override def toString : String = s"$ps"
}

case class CSingleBatchProcess(sbp : SingleBatchProcess) extends SimQRiComponent {
  def getName = sbp.name
  def getType = "Single Batch Process"
  def mapInfo = sbp.mapInfo
  override def toString : String = s"$sbp"
}

case class CStorage(s : Storage) extends SimQRiComponent {
  def getName = s.name
  def getType = "Storage"
  def mapInfo = s.mapInfo
  override def toString : String = s"$s"
}