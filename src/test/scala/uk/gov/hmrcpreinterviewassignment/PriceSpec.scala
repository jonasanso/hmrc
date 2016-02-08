package uk.gov.hmrcpreinterviewassignment

import org.specs2.mutable._


class PriceSpec extends Specification {

  "Price calculate totalPrice" should {
    "be 0 for an empty shopping cart" in {
      Price.totalPrice(List()) must beEqualTo(0)
    }

    "be 60p for one apple" in {
      Price.totalPrice(List(APPLE)) must beEqualTo(60)
    }

    "be 25p for one orange" in {
      Price.totalPrice(List(ORANGE)) must beEqualTo(25)
    }

    "be 180p for 3 apples" in {
      Price.totalPrice(List(APPLE, APPLE, APPLE)) must beEqualTo(180)
    }

    "be 205p for 3 aples and one orange" in {
      Price.totalPrice(List(APPLE, APPLE, ORANGE, APPLE)) must beEqualTo(205)
    }
  }

}
