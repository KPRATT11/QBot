package org.example

import org.example.Types.Board
import org.example.Types.Tile

class Game (
    private val boardSize: Int = 9
) {
    val board = generateBoard()

    private val letters = "acbdefghijklmnopqrstuvwxyz".substring(0, boardSize * 2)

    private fun generateBoard(): Board { return List(boardSize * 2) { upperIt ->
        if (upperIt % 2 != 0){
            List(boardSize * 2) {
                if (it % 2 != 0){
                    Tile(wall = false)
                } else {
                    Tile(wall = true)
                }
            }
        } else {
            List(boardSize * 2) { Tile(wall = true) }
        }
    } }

    private fun formatRow(row: List<Tile>): String{
        return row.map {
            if (it.wall){
                if (it.filled){
                    "#"
                } else {
                    "."
                }
            } else {
                if (!it.filled){
                    "■"
                } else {
                    "x"
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
        for ((index, value) in board.withIndex()) {
            println("${formatIndex(index)} ${formatRow(value)}")
        }
    }
}