package uk.gov.hmrcpreinterviewassignment

import org.scalacheck.{Gen, Prop}
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class CheckoutSpec extends Specification with ScalaCheck {
  val cart = Gen.sized { size => Gen.listOfN(size, Gen.oneOf("apple", "orange")) }

  "Checkout calculate totalCost" should {
    "be the totalPrice minus the totalDiscount" in {
      Prop.forAll(cart) { cart: List[String] =>
        Checkout.totalCost(cart) mustEqual Price.totalPrice(Item(cart)) - Discount.totalDiscount(Item(cart))
      }
    }
  }

}
