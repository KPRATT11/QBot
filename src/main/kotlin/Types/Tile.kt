package org.example.Types

data class Tile (
    var filled: Boolean = false,
    var wall: Boolean,
    val pos: Pair<Int, Int>
)