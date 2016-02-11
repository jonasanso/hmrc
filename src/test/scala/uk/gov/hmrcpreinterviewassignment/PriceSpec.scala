package uk.gov.hmrcpreinterviewassignment

import org.specs2.mutable.Specification
import org.specs2.ScalaCheck
import org.scalacheck.{Prop, Gen}

class PriceSpec extends Specification with ScalaCheck {
  val itemsGenerator = Gen.sized { size => Gen.listOfN(size, Gen.oneOf(APPLE, ORANGE)) }

  "Price calculate totalPrice" should {
    "is the sum of the price for the apples and the price for the oranges" in {
      Prop.forAll(itemsGenerator) { items: List[Item] =>
        Price.totalPrice(items) mustEqual Price.totalPrice(items.filter(_ == APPLE)) + Price.totalPrice(items.filter(_ == ORANGE))
      }
    }

    "of a basket of apples is the number of apples by 60p" in {
      val applesGenerator = Gen.sized { size => List.fill(size)(APPLE) }
      Prop.forAll(applesGenerator) { apples: List[Item] =>
        Price.totalPrice(apples) mustEqual apples.size * 60
      }
    }

    "of a basket of oranges is the number of oranges by 25p" in {
      val orangesGenerator = Gen.sized { size => List.fill(size)(ORANGE) }
      Prop.forAll(orangesGenerator) { apples: List[Item] =>
        Price.totalPrice(apples) mustEqual apples.size * 25
      }
    }

    "is independent of the order of the items" in {
      Prop.forAll(itemsGenerator) { items: List[Item] =>
        Price.totalPrice(items) mustEqual Price.totalPrice(items.reverse)
      }
    }

    "and associative" in {
      val genTuples: Gen[(List[Item], List[Item])] = for {
        a <- itemsGenerator
        b <- itemsGenerator
      } yield (a, b)

      Prop.forAll(genTuples) {
        case (items: List[Item], items2: List[Item])  =>
          Price.totalPrice(items) + Price.totalPrice(items2) mustEqual Price.totalPrice(items ++ items2)
      }
    }

  }

}
