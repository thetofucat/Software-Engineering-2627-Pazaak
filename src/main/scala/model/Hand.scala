package model

case class Hand(cards: List[Card] = List.empty) {
  def size: Int = cards.length

  def add(card: Card): Hand = Hand(cards :+ card)
  def addCard(card: Card): Hand = add(card) // supporting both method names

  def remove(index: Int): (Card, Hand) = {
    val card = cards(index)
    val newCards = cards.patch(index, Nil, 1)
    (card, Hand(newCards))
  }

  def isEmpty: Boolean = cards.isEmpty

  override def toString: String = cards.map(_.toString).mkString(" ")
}