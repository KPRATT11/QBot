package org.example

import org.example.Types.Tile

class Printer(private val game: Game, private val letters: String) {
    private fun formatRow(row: List<Tile>): String{
        return row.map {
            if (it.wall){
                if (it.filled){
                    "#"
                } else {
                    "."
                }
            } else {
                if (it.pos == game.players.player1.pos){
                    "o"
                } else if (it.pos == game.players.player2.pos) {
                    "●"
                }
                else {
                    "■"
                }
            }
        }.toString()
            .replace(",", " ")
            .replace("[", "")
            .replace("]", "")
            .trim()
    }

    private fun formatIndex(value: Int): String {
        val formatted = value.toString()
        return if (formatted.length == 2) formatted
        else "$formatted "
    }

    private fun printLetterRow(){
        print("   ")
        letters.forEach {
            print("$it  ")
        }
        print("\n")
    }

    fun fullGame(){
        println("\n\n\n\n")
        printLetterRow()
        for ((index, value) in game.board.withIndex()) {
            println("${formatIndex(index)} ${formatRow(value)}")
        }
    }
}