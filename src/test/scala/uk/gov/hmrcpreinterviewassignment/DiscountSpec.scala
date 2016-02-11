package uk.gov.hmrcpreinterviewassignment

import org.scalacheck.{Gen, Prop}
import org.specs2.ScalaCheck
import org.specs2.mutable.Specification

class DiscountSpec extends Specification with ScalaCheck {
  val itemsGenerator = Gen.sized { size => Gen.listOfN(size, Gen.oneOf(APPLE, ORANGE)) }

  "Discount calculate totalDiscount" should {
    "is the sum of the discount for the apples and the discount for the oranges" in {
      Prop.forAll(itemsGenerator) { items: List[Item] =>
        Discount.totalDiscount(items) mustEqual Discount.totalDiscount(items.filter(_ == APPLE)) + Discount.totalDiscount(items.filter(_ == ORANGE))
      }
    }

    "of a basket of apples is the number of apples pairs by the price of an apple (buy one, get one free) " in {
      val applesGenerator = Gen.sized { size => List.fill(size)(APPLE) }
      Prop.forAll(applesGenerator) { apples: List[Item] =>
        Discount.totalDiscount(apples) mustEqual apples.size / 2 * APPLE.price
      }
    }

    "of a basket of oranges is the number of oranges trios by the price of an orange (3 for the price of 2)" in {
      val orangesGenerator = Gen.sized { size => List.fill(size)(ORANGE) }
      Prop.forAll(orangesGenerator) { apples: List[Item] =>
        Discount.totalDiscount(apples) mustEqual apples.size / 3 * 25
      }
    }

    "is independent of the order of the items" in {
      Prop.forAll(itemsGenerator) { items: List[Item] =>
        Discount.totalDiscount(items) mustEqual Discount.totalDiscount(items.reverse)
      }
    }
  }

}
