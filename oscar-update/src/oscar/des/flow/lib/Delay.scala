package oscar.des.flow.lib

import oscar.des.engine.Model
import oscar.des.flow.core.ItemClassHelper.ItemClass
import oscar.des.flow.core.{Fetchable, Putable}

/**
 * this is a delay that can be added on a put.
 * so the proces takes an extra time putting to the sorage, or fetching from it.
 */
class Delay(s:Storage, m:Model, delay:Double, val id:Int) extends Putable with Fetchable{
  /**
   * put the amount of goods into the putable.
   * This is potentially blocking
   * @param amount the items to be put in the puteable
   * @param block the block to execute after the items are put
   */
  override def put(amount: Int, i: ItemClass)(block: () => Unit){
    m.wait(delay){
      s.put(amount,i)(block)
    }
  }

  /**
   * fetch the amount of goods from the putable.
   * This is potentially blocking
   * @param amount the amount of goods to be fetched
   * @param block the block to execute once the items are actually fetched. these are bound to the block method
   */
  override def fetch(amount: ItemClass)(block: (ItemClass) => Unit): Unit = {
    m.wait(delay){
      s.fetch(amount)(block)
    }
  }

  def cloneReset(m:Migrator):Delay = {
    new Delay(m(s),m.newModel,delay,id)
  }

  override def toString : String = "DelayToStorage(" + s + " delay:" + delay + ")"
}
