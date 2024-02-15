package org.example

import org.example.Exceptions.InvalidWallSpotException
import org.example.Types.Board

class Command(
    val wall: Boolean,
    val rows: IntRange,
    val cols: IntRange
) {
    fun handle(board: Board){
        if (wall){
            handleWall(board)
        }
    }

    private fun handleWall(board: Board){
        for (row in rows){
            for (tile in cols){
                if (!board[row][tile].wall) {throw InvalidWallSpotException()
                }
                if (board[row][tile].filled) {throw InvalidWallSpotException()
                }
                board[row][tile].filled = true
            }
        }
    }
}