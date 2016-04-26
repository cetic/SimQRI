package oscar.des.flow.lib

import oscar.des.engine.Model
import oscar.des.flow.core.ItemClassHelper.ItemClass
import oscar.des.flow.core.{Fetchable, Putable}

/**
 * this is a delay that can be added on a put.
 * so the process takes an extra time putting to the storage, or fetching from it.
 */
class Delay(s:Storage,m:Model,delay:()=>Double) extends Putable with Fetchable{
  /**
   * put the amount of goods into the putable.
   * This is potentially blocking
   * @param amount: the items to be put in the putable
   * @param block the code to be executed after a put
   */
  override def put(amount: Int, i: ItemClass)(block: () => Unit){
    m.wait(delay()){
      s.put(amount,i)(block)
    }
  }

  /**
   * fetch the amount of goods from the putable.
   * This is potentially blocking
   * @param amount the items to be fetched from the putable
   * @param block the block to execute once the items are actually fetched. these items are passed to the block method
   */
  override def fetch(amount: ItemClass)(block: (ItemClass) => Unit): Unit = {
    m.wait(delay()){
      s.fetch(amount)(block)
    }
  }
}
