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
 * This is the main engine of the simulation.
 * Every Process in the simulation should wait, require resource ... on an instance of this class.
 * @author pschaus
 */
class Model {

  private val eventQueue = new PriorityQueue[SimEvent]()
  private var currentTime = 0.0
  private var steps:Int = 0

  def clock() : Double = currentTime

  private def addEvent(e:SimEvent) = eventQueue += e

  /**
   *
   * @param horizon the time limit (at the horizon...)
   * @param verbosity a function that treats a String (for logging purposes)
   * @param abort is called after every progress in time. if returns true, the simulation is aborted.
   *              You can also use it to update some trace analysis functions.
   */
  def simulate(horizon:Float, verbosity:(String*)=>Unit, abort:()=>Boolean = ()=>false) {
    while (eventQueue.nonEmpty) {
      steps +=1
      val e = eventQueue.dequeue()
      require(e.time >= currentTime)
      if(e.time <= horizon){
        if(e.time != currentTime){
          if(abort()) {
            if (verbosity!=null) {
              verbosity("time", e.time.toString)
              verbosity("rawinfo", "ABORTED!")
            }
            return
          }
          if(verbosity!=null) verbosity("time", e.time.toString)
        }
        currentTime = e.time
        e.process()
      }else{
        // we are after the horizon, so event is pushed back into queue, and simulation stops
        eventQueue.enqueue(e)
        if(horizon != currentTime) abort() //we call it, since we re at the end, and it is a new state
        if(verbosity!=null) verbosity("time", horizon.toString)
        currentTime = horizon
        return
      }
    }

    //no more event to process, but time runs to the horizon
    if(horizon != currentTime) {
      abort()
      if (verbosity!=null) verbosity("time", horizon.toString)
    }
    currentTime = horizon
  }

  def wait(duration : Double)(block : => Unit) {
    assert(duration >= 0)
    addEvent(new WaitEvent(clock + duration, block))
  }

  def wait(duration : Int)(block : => Unit) {
    wait(duration.toDouble)(block)
  }

  def request(r : Resource)(block : => Unit) {
    r.request(block)
  }

  def release(r : Resource) {
    r.release()
  }

  def suspend(proc : Process)(block : => Unit) {
    proc.suspend(block)
  }

  def resume(proc : Process){
    proc.resume()
  }

  override def toString = {
    "Model::currentTime:" + currentTime + " " + " step:" + steps +
      " eventQueue is" + (if (this.eventQueue.isEmpty) " " else " not ") + " empty"
  }
}