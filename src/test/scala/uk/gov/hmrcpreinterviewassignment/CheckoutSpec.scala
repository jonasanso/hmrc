package uk.gov.hmrcpreinterviewassignment

import org.specs2.mutable._


class CheckoutSpec extends Specification {

  "Checkout calculate totalCost" should {
    "be 0 for an empty basket" in {
      Checkout.totalCost(List()) must beEqualTo(0)
    }

  }
}
