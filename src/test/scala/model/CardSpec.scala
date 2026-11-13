package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*
import model.CardType.*

class CardSpec extends AnyWordSpec {
  "A Card" when {
    "created as a Plus card with value 3" should {
      val card = Card(3, Plus)

      "have value 3" in {
        card.value shouldEqual 3
      }

      "be a hand card" in {
        card.isHandCard shouldEqual true
      }

      "have a formatted string representation with a plus sign" in {
        card.toString shouldEqual "+3"
      }
    }

    "created as a Minus card with value 2" should {
      val card = Card(2, Minus)

      "have value 2" in {
        card.value shouldEqual 2
      }

      "be a hand card" in {
        card.isHandCard shouldEqual true
      }

      "have a formatted string representation with a minus sign" in {
        card.toString shouldEqual "-2"
      }
    }

    "created as a Main card with value 5" should {
      val card = Card(5, Main)

      "have value 5" in {
        card.value shouldEqual 5
      }

      "not be a hand card" in {
        card.isHandCard shouldEqual false
      }

      "have a formatted string representation with just the number" in {
        card.toString shouldEqual "5"
      }
    }
  }
}