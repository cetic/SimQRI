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

import scala.collection.mutable._

/**
 * Capacitated resource where waiting customers are served in FIFO order
 * @author pschaus
 */
class Resource(m : Model, capacity: Int) {
	
	private var n = 0
	private var pendings = new MutableList()
	
	def request(block: => Unit) {
		if (n < capacity) {
	         n += 1
	         block
	    } else {
	         pendings :+ block
	    }
	}
	
	def release() {
		n -= 1
		if (pendings.nonEmpty) {
			val block = pendings.head
			pendings = pendings.drop(1)
			block
		}
	}
	
}

class UnaryResource(m : Model) extends Resource(m,1)