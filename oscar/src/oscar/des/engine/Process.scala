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
 * Every simulated object taking part in the simulation should extend this class.
 * @author pschaus
 */
class Process (m: Model, name : String = "Process"){

	private var suspending = false
	private var suspended = {}
	
	def suspend(block : => Unit) {
		if (suspending) {
			//throw new RuntimeException("The process " + name + " is already suspending");
		}
		suspending = true
		suspended = block
	}
	
	def resume(){
		if (!suspending){
			//throw new RuntimeException("The process " + name + " is not suspending");
		}
		suspending = false
		suspended
	}
}
