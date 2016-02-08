package uk.gov.hmrcpreinterviewassignment

import org.specs2.mutable._


class DiscountSpec extends Specification {

  "ApplesDiscount" should {
    "be 0 for an empty shopping cart" in {
      ApplesDiscount.calculate(List()) must beEqualTo(0)
    }

    "be 0 for one apple" in {
      ApplesDiscount.calculate(List(APPLE)) must beEqualTo(0)
    }

    "be 60p for 2 or 3 apples" in {
      ApplesDiscount.calculate(List(APPLE, APPLE)) must beEqualTo(60)
      ApplesDiscount.calculate(List(APPLE, APPLE, APPLE)) must beEqualTo(60)
    }

    "be 120p for 4 apples" in {
      ApplesDiscount.calculate(List(APPLE, APPLE, APPLE, APPLE)) must beEqualTo(120)
    }
  }

  "OrangesDiscount" should {
    "be 0 for an empty shopping cart" in {
      OrangesDiscount.calculate(List()) must beEqualTo(0)
    }

    "be 0p for one or two orange" in {
      OrangesDiscount.calculate(List(ORANGE)) must beEqualTo(0)
      OrangesDiscount.calculate(List(ORANGE, ORANGE)) must beEqualTo(0)
    }


    "be 25p for 3 or 4 or 5 oranges" in {
      OrangesDiscount.calculate(List(ORANGE, ORANGE, ORANGE)) must beEqualTo(25)
      OrangesDiscount.calculate(List(ORANGE, ORANGE, ORANGE, ORANGE)) must beEqualTo(25)
      OrangesDiscount.calculate(List(ORANGE, ORANGE, ORANGE, ORANGE, ORANGE)) must beEqualTo(25)
    }
  }


  "Discount calculate totalDiscount" should {
    "be 0 for an empty shopping cart" in {
      Discount.totalDiscount(List()) must beEqualTo(0)
    }

    "be 85p for 2 apples and 3 oranges" in {
      Discount.totalDiscount(List(APPLE, APPLE, ORANGE, ORANGE, ORANGE)) must beEqualTo(85)
    }
  }

}
