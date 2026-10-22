enum CardType:
  case Main, Plus, Minus
import CardType.*
case class Card(value:Int, cardType:CardType) {
  def isHandCard: Boolean = cardType != Main
  override def toString: String = cardType match {
    case Plus => s"+$value"
    case Minus => s"-$value"
    case Main => s"$value"
  }
}
val PlusZwei=Card(2,Plus)
PlusZwei.isHandCard
val Zwei=Card(2,Main)
Zwei.isHandCard

case class Hand(cards: List[Card] = List.empty) {
  def size: Int = cards.length
  def addCard(card: Card): Hand = Hand(cards :+ card)
  def isEmpty: Boolean = cards.isEmpty
}

case class Player(
                 name: String,
                 setsWon: Int = 0,
                 score: Int = 0,
                 playedCards: List[Card] = List.empty,
                 hand: Hand = Hand()
                 )

val TestHand=Hand(List())
TestHand.size
TestHand.addCard(PlusZwei)
TestHand.size //immutable
val hand1 = TestHand.addCard(PlusZwei)
hand1.size

case class Field(player1: Player, player2: Player) {
  def render: String =
    s"${player1.name} ($p1SetsWon/3, Score: ${player1.score}) VS ${player2.name} ($p2SetsWon/3, Score: ${player2.score})"

  private def p1SetsWon: Int = player1.setsWon

  private def p2SetsWon: Int = player2.setsWon
}
val p1=Player(name = "Gary")
val p2=Player(name = "Fred")
p1.hand.addCard(PlusZwei) //immutable
p1 //immutable
val testField=Field(p1,p2)
testField.render

// Examples for completion/end-of-round tests in the worksheet:
assert(p1.hand.isEmpty)
assert(PlusZwei.isHandCard)
assert(!Zwei.isHandCard)