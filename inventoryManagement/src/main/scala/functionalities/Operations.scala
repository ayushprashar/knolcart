package functionalities
import utility.Item

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import org.apache.log4j.Logger

import scala.collection.immutable.ListMap
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

  def sortItems(inventory: Map[Item,Int],sortBy: String = "default"): Future[Map[Item,Int]] =Future {
    sortBy.toLowerCase match {
      case "price ascending" => ListMap(inventory.toSeq.sortBy(_._1.price): _*)
      case "price descending" => ListMap(inventory.toSeq.sortWith(_._1.price > _._1.price): _*)
      case "rating ascending" => ListMap(inventory.toSeq.sortBy(_._1.rating): _*)
      case "rating descending" => ListMap(inventory.toSeq.sortWith(_._1.rating > _._1.rating): _*)
      case _ => ListMap(inventory.toSeq.sortWith(_._1.rating > _._1.rating): _*)
    }
  }

}
