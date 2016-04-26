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
package oscar.des.engine

/**
 * Objects stored in the main queue of the simulation. The modeler should not have knowledge of it.
 * @author pschaus
 */
abstract class SimEvent(val time: Double) extends Ordered[SimEvent] {
	def process() = {}
	
	def compare(that : SimEvent) = that.time.compare(this.time)
}

class WaitEvent(time: Double, block: => Unit ) extends SimEvent(time) {
	override def process() = block
}



