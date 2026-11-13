package model

case class Player(
                   name: String,
                   setsWon: Int = 0,
                   score: Int = 0,
                   playedCards: List[Card] = List.empty,
                   hand: Hand = Hand()
                 ) {
  override def toString: String = {
    s"Spieler: $name | Gewonnene Sätze: $setsWon | Punkte: $score\n Handkarten: ${hand.toString}"
  }
}