package uk.gov.hmrcpreinterviewassignment

object Price {
  def totalPrice(items: List[Item]): Int = {
    items.map(_.price).sum
  }
}
