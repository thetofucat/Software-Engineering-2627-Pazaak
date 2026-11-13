package model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*

class PlayerSpec extends AnyWordSpec {
  "A Player" when {
    "created with a name" should {
      val player = Player("Alice")

      "have that name" in {
        player.name shouldEqual "Alice"
      }

      "have an empty default hand" in {
        player.hand.size shouldEqual 0
      }

      "have a default score of 0" in {
        player.score shouldEqual 0
      }

      "have 0 sets won by default" in {
        player.setsWon shouldEqual 0
      }

      "have a correct string representation" in {
        player.toString shouldEqual "Spieler: Alice | Gewonnene Sätze: 0 | Punkte: 0\n Handkarten: "
      }
    }
  }
}