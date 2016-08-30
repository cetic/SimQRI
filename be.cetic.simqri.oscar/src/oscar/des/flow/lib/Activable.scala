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

package oscar.des.flow.lib

import oscar.des.flow.core.Inputter
import oscar.des.flow.core.ItemClassHelper._

/**
 * Represents activable processes
 * @author renaud.delandtsheer@cetic.be
 */

abstract class ActivableProcess(val name:String, verbosity:(String*)=>Unit, val id:Int) {
  def isRunning:Boolean
  def completedBatchCount(outputPort:Int = -1):Int
  def startedBatchCount:Int
  def totalWaitDuration:Double

  var cost:DoubleExpr = null

  var productionBatch:LIFOStorage = null

  def setUnderControl(){
    productionBatch = new LIFOStorage(Int.MaxValue,List.empty,"productionWindow_" + this.name, verbosity, false,-1)
    addPreliminaryInput(productionBatch)
  }

  def activate(intensity: Int): Unit ={
    productionBatch.put(intensity,zeroItemClass)({()=>})
  }

  def addPreliminaryInput(preliminary:Storage)

  def cloneReset(m:Migrator):ActivableProcess

  def mapInfo: Map[String, Double]
}

abstract class ActivableAtomicProcess(name:String, verbosity:(String*)=>Unit, id:Int) extends ActivableProcess(name,verbosity,id){

  def myInput:Inputter

  override def addPreliminaryInput(preliminary: Storage) {
    myInput.addPreliminaryInput(preliminary)
  }
}

abstract class ActivableMultipleProcess(name:String, verbosity:(String*)=>Unit, id:Int) extends ActivableProcess(name,verbosity,id){
  def childProcesses:Iterable[ActivableAtomicProcess]

  override def addPreliminaryInput(preliminary: Storage) {
    for(s <- childProcesses) s.myInput.addPreliminaryInput(preliminary)
  }

  override def isRunning: Boolean = childProcesses.exists(_.isRunning)
  override def completedBatchCount(outputPort:Int = -1): Int = sumIntOnChildren(_.completedBatchCount(outputPort))
  override def startedBatchCount: Int = sumIntOnChildren(_.startedBatchCount)
  override def totalWaitDuration:Double = sumDoubleOnChildren(_.totalWaitDuration)

  private def sumIntOnChildren(f:(ActivableAtomicProcess => Int)) = childProcesses.foldLeft(0)({case (i:Int,a:ActivableAtomicProcess) => i+f(a)})
  private def sumDoubleOnChildren(f:(ActivableAtomicProcess => Double)) = childProcesses.foldLeft(0.0)({case (i:Double,a:ActivableAtomicProcess) => i+f(a)})

}

