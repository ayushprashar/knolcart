package functionalities

import utility.Item
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
trait ItemOperations {
  def searchItem(category: String,inventory: Map[Item,Int]): Future[Map[Item,Int]]
  def updateCount(item: Item,inventory: Map[Item,Int],updateBy: Int): Future[Map[Item,Int]]
  def
}
