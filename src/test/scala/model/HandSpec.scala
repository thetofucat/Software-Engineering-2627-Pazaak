package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*
import model.CardType.*

class HandSpec extends AnyWordSpec {
  "A Hand" when {
    "empty" should {
      val hand = Hand()

      "have size 0" in {
        hand.size shouldEqual 0
      }

      "have an empty string representation" in {
        hand.toString shouldEqual ""
      }

      "allow adding a card" in {
        val card = Card(3, Plus)
        val newHand = hand.addCard(card)
        newHand.size shouldEqual 1
        newHand.cards shouldEqual Vector(card)
      }
    }

    "containing cards" should {
      val c1 = Card(3, Plus)
      val c2 = Card(1, Minus)
      val hand = Hand(Vector(c1, c2))

      "return correct size" in {
        hand.size shouldEqual 2
      }

      "format cards as a space-separated string" in {
        hand.toString shouldEqual "+3 -1"
      }

      "allow removing a card by index" in {
        val (removed, remainingHand) = hand.remove(0)
        removed shouldEqual c1
        remainingHand.size shouldEqual 1
        remainingHand.cards shouldEqual Vector(c2)
      }
    }
  }
}