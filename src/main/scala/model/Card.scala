package model

import model.CardType.{Main, Minus, Plus}

enum CardType:
  case Main, Plus, Minus

case class Card(value:Int, cardType:CardType) {
  def isHandCard: Boolean = cardType != Main
  override def toString: String = cardType match {
    case Plus => s"+$value"
    case Minus => s"-$value"
    case Main => s"$value"
  }
}
