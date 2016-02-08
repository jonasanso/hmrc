package uk.gov.hmrcpreinterviewassignment

import org.specs2.mutable._


class CheckoutSpec extends Specification {

  "Checkout calculate totalCost" should {
    "be 0 for an empty shopping cart" in {
      Checkout.totalCost(List()) must beEqualTo(0)
    }

    "be 60p for one apple" in {
      Checkout.totalCost(List("apple")) must beEqualTo(60)
    }

    "be 25p for one orange" in {
      Checkout.totalCost(List("orange")) must beEqualTo(25)
    }

    "be 180p minus 60p of discount = 120p for 3 apples" in {
      Checkout.totalCost(List("apple", "apple", "apple")) must beEqualTo(120)
    }

    "be 205p - 60p of discount = 145p for 3 apples and one orange" in {
      Checkout.totalCost(List("apple", "apple", "orange", "apple")) must beEqualTo(145)
    }

  }
}
