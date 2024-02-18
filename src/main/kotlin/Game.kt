package org.example

import org.example.Exceptions.InvalidWallSpotException
import org.example.Types.Board
import org.example.Types.Tile

class Game(
    private val boardSize: Int = 9
) {
    private val letters = Letters.substring(0, boardSize * 2) //might need to make this importable
    val board = generateBoard()
    val printer = Printer(this, letters)

    val players: HashMap<Byte, Player> = hashMapOf(
        0.toByte() to Player(Pair(boardSize, 1), 9),
        1.toByte() to Player(Pair(boardSize, boardSize * 2 - 1), 9),
    )
    val playerTurn: Byte = 0.toByte()

    fun handleCommand(command: Command): Boolean {
        return if (command.wall) {
            handleWallPlacement(command)
        } else {
            handlePlayerMovement(command)
        }
    }

    private fun generateBoard(): Board {
        return List(boardSize * 2) { upperIt ->
            if (upperIt % 2 != 0) {
                List(boardSize * 2) {
                    if (it % 2 != 0) {
                        Tile(wall = false, pos = Pair(it, upperIt))
                    } else {
                        Tile(wall = true, pos = Pair(it, upperIt))
                    }
                }
            } else {
                List(boardSize * 2) { Tile(wall = true, pos = Pair(it - 1, upperIt - 1)) }
            }
        }
    }

    private fun handleWallPlacement(command: Command): Boolean {
        for (row in command.rows) {
            for (tile in command.cols) {
                if (!board[row][tile].wall) {
                    throw InvalidWallSpotException()
                }
                if (board[row][tile].filled) {
                    throw InvalidWallSpotException()
                }
                board[row][tile].filled = true }
        }
        return true
    }
    private fun handlePlayerMovement(command: Command): Boolean {
        val endingPos = Pair(command.cols.first, command.rows.first)
        if (!validatePlayerMove(players[command.player]!!.pos, endingPos)) return false
        players[command.player]!!.pos = endingPos
        return true
    }

    private fun validatePlayerMove(startingPos: Pair<Int, Int>, endingPos: Pair<Int, Int>): Boolean{
        return (endingPos.first % 2 != 0 && endingPos.second % 2 != 0)
    }
}


