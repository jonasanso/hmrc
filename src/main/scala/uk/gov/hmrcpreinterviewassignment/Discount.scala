package uk.gov.hmrcpreinterviewassignment

sealed abstract class Discount {
  def calculate(items: List[Item]): Int
}

object ApplesDiscount extends Discount {
  override def calculate(items: List[Item]): Int = items.count(_ == APPLE) / 2 * APPLE.price
}

object OrangesDiscount extends Discount {
  override def calculate(items: List[Item]): Int = items.count(_ == ORANGE) / 3 * ORANGE.price
}

object Discount {
  val discounts = List(ApplesDiscount, OrangesDiscount)

  def totalDiscount(items: List[Item]): Int = discounts.map(_.calculate(items)).sum
}