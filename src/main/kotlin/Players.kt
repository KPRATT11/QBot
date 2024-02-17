package org.example

data class Players(
    val player1: Player,
    val player2: Player,
    val player1Turn: Boolean
)

data class Player(
    var pos: Pair<Int, Int>,
    val walls: Int
)
