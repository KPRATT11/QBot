import org.example.Command
import org.example.Game
import org.example.GameInput
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class GameTest{
    @Test
    fun `should correctly move player when given correct command`(){
        val game = Game()
        val command: Command = GameInput("1,b,1").interpret()
        val result = game.handleCommand(command)
        assertEquals(result, true)
        assertEquals(Pair(1,1), game.players[1.toByte()]!!.pos)
    }

    @Test
    fun `should not process this command`(){
        val game = Game()
        val command: Command = GameInput("1,a,1").interpret()
        val result = game.handleCommand(command)
        assertEquals(result, false)
    }
}