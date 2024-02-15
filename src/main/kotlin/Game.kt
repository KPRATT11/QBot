package org.example

import org.example.Types.Board
import org.example.Types.Tile

class Game () {
    val board = generateBoard()

    private fun generateBoard(): Board { return List(18) { upperIt ->
        if (upperIt % 2 != 0){
            List(18) {
                if (it % 2 != 0){
                    Tile(wall = false)
                } else {
                    Tile(wall = true)
                }
            }
        } else {
            List(18) { Tile(wall = true) }
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
            .replace("[", "|")
            .replace("]", "|")
            .trim()
    }

    private fun formatIndex(value: Int): String {
        val formatted = value.toString()
        return if (formatted.length == 2) formatted
        else "$formatted "
    }

    fun fullGame(){
        println("\n\n\n\n")
        println("    a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q")
        println("    _  _  _  _  _  _  _  _  _  _  _  _  _  _  _  _  _")
        for ((index, value) in board.withIndex()) {
            println("${formatIndex(index)} ${formatRow(value)}")
        }
        println("    ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯  ¯")
    }
}