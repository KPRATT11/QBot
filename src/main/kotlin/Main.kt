package org.example

fun main() {
    val newGame = Game(boardSize = 7)
    gameLoop(newGame)
}
fun gameLoop(game: Game) {
    while(true){
        game.printer.fullGame()
        turnLoop(game)
    }
}

fun turnLoop(game: Game) {
    var moveMade: Boolean
    do {
        val command = getInput()
        moveMade = game.handleCommmand(command)
    } while (!moveMade)
}


fun getInput(): Command {
    val inputPrefix = "Input: "
    lateinit var gameInput: GameInput

    do {
       print(inputPrefix)
       gameInput = GameInput(readln())
       if (!gameInput.validated) println("Failed to validate command")
    } while (!gameInput.validated)

    return gameInput.interpret()
}
