package functionalities
import utility.Item
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import org.apache.log4j.Logger
class Operations extends ItemOperations {

  override def updateCount(item: Item,inventory: Map[Item,Int],updateBy: Int): Future[Map[Item,Int]] = Future {
    if (inventory.contains(item) && (inventory(item) + updateBy)> 0) {
      val count: Int = inventory(item) + updateBy
      inventory + (item -> count)
    }
    else {
      if (!inventory.contains(item)){
        inventory + (item -> updateBy)
      }
      else{
        val log = Logger.getLogger(this.getClass)
        log.info(s"Not enough items to sell")
        inventory
      }
    }
  }

  override def searchItem(category: String, inventory: Map[Item,Int]): Future[Map[Item,Int]] = Future {
    inventory.filterKeys(_.category == category)
  }
  def sortItems()
}
