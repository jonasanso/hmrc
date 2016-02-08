package uk.gov.hmrcpreinterviewassignment

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
