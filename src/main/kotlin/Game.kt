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
    val players = Players(
        player1 = Player(Pair(boardSize - 1, 0), 9),
        player2 = Player(Pair(boardSize - 1, boardSize), 9),
        player1Turn = true
    )


    fun handleCommmand(command: Command): Boolean {
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
                        Tile(wall = false, pos = Pair(it - 1, upperIt - 1))
                    } else {
                        Tile(wall = true, pos = Pair(it - 1, upperIt - 1))
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
        if (command.player == '0'){
            players.player1.pos = Pair(command.cols.first, command.rows.first)
        } else {
            players.player2.pos = Pair(command.cols.first, command.rows.first)
        }
        return true
    }
}


