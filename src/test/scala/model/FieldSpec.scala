package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*
import model.CardType.*

class FieldSpec extends AnyWordSpec {
  "A Field" when {
    "empty" should {
      val field = Field()

      "have a sum of 0" in {
        field.sum shouldEqual 0
      }

      "have a formatted string representation with sum 0" in {
        field.toString shouldEqual "Spielfeld (Summe: 0): "
      }

      "allow adding a card" in {
        val card = Card(5, Main)
        val newField = field.addCard(card)
        newField.sum shouldEqual 5
        newField.cards shouldEqual Vector(card)
      }
    }

    "containing multiple cards" should {
      val c1 = Card(6, Main)
      val c2 = Card(3, Plus)
      val c3 = Card(2, Minus)
      val field = Field(Vector(c1, c2, c3))

      "calculate the sum correctly" in {
        field.sum shouldEqual 7
      }

      "format the output with sum and cards" in {
        field.toString shouldEqual "Spielfeld (Summe: 7): 6 +3 -2"
      }
    }
  }
}