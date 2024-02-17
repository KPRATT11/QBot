import org.example.Command
import org.example.Game
import org.example.GameInput
import org.junit.Test
import kotlin.test.assertEquals

class GameTest{
    @Test
    fun `should correctly move player when given correct command`(){
        val game = Game()
        val command: Command = GameInput("1b1").interpret()
        val result = game.handleCommmand(command)
        assertEquals(result, true)
        assertEquals(Pair(1,1), game.players.player1.pos)
    }

    @Test
    fun `should not process this command`(){
        val game = Game()
        val command: Command = GameInput("1a1").interpret()
        val result = game.handleCommmand(command)
        assertEquals(result, false)
        assertEquals(Pair(8,0), game.players.player1.pos)
    }
}