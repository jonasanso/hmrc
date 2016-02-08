package uk.gov.hmrcpreinterviewassignment

object Checkout {

  def totalCost(cart: List[String]) : Int = {
    val items = Item(cart)
    Price.totalPrice(items) - Discount.totalDiscount(items)
  }

}








