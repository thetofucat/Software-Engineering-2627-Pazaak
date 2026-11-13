package model

case class Field(player1: Player, player2: Player) {
  def render: String =
    s"${player1.name} ($p1SetsWon/3, Score: ${player1.score}) VS ${player2.name} ($p2SetsWon/3, Score: ${player2.score})"

  private def p1SetsWon: Int = player1.setsWon

  private def p2SetsWon: Int = player2.setsWon
}