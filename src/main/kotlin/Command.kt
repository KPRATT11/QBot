package org.example

class Command(
    var wall: Boolean = false,
    var rows: IntRange = IntRange(0,0),
    var cols: IntRange = IntRange(0,0),
    val player: Byte = 0.toByte()
)