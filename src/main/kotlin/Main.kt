package org.example

import org.example.Exceptions.InvalidCommandTypeException
import org.example.Types.Board

fun main() {
    val newGame = Game(boardSize = 7)
    gameLoop(newGame)
}
fun gameLoop(game: Game) {
    while(true){
        game.fullGame()
        getAndExecuteInput(game.board)
    }
}

fun getAndExecuteInput(board: Board){
    while (true){
        print("Input : ")
        val input = readln().split("-")

        val letters = "abcdefghijklmnopqrstuvwxyz".split("").drop(1).dropLast(1)
        try {
            if (input.first() !in listOf("W", "0", "1")){
                throw InvalidCommandTypeException(input.first())
            }

            val command = Command(
                wall = input[0] == "W",
                rows = IntRange(input[2].toInt(),  if (input.size > 4) {input[4].toInt()} else { input[2].toInt()} ),
                cols = IntRange(letters.indexOf(input[1]), if (input.size > 3) {letters.indexOf(input[3])} else {letters.indexOf(input[1])})
            )
            command.handle(board)
        } catch (exception: Exception){
            println(exception.message)
            continue
        }
    }
}

