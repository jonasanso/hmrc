package uk.gov.hmrcpreinterviewassignment

object Checkout {

  def totalCost(cart: List[String]) : Int = {
    Item(cart).map(_.price).sum
  }

}



sealed abstract class Item(val price: Int)

case object APPLE extends Item(60)
case object ORANGE extends Item(25)

object Item {
  def apply(item: String) : Item = item match {
    case "apple" => APPLE
    case "orange" => ORANGE
  }

  def apply(items: List[String]): List[Item] = items.map(apply)
}



