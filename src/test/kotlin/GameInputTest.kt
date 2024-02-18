import org.example.Command
import org.example.GameInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameInputTest {
    @Test
    fun `should correctly interpret command for wall`() {
        val input = GameInput("W,a,1,a,4")
        val result = input.interpret()
        val expected = Command(
            wall = true,
            rows = IntRange(1,4),
            cols = IntRange(0,0)
        )
        assertEquals(result.rows,expected.rows)
        assertEquals(result.cols,expected.cols)
        assertEquals(result.wall,expected.wall)
    }

    @Test
    fun `should fail validation for command without correct starting character`() {
        val input = GameInput("asfd")
        val result = input.validateInput()
        val expected = false
        assertEquals(expected, result)
    }

    @Test
    fun `should fail validation for command with incorrect length for wall`() {
        val input = GameInput("W1")
        val result = input.validateInput()
        val expected = false
        assertEquals(expected, result)
    }
    @Test
    fun `should fail validation for command with incorrect pattern for wall`() {
        val input = GameInput("W,1,a,1,d")
        val result = input.validateInput()
        val expected = false
        assertEquals(expected, result)
    }
    @Test
    fun `should pass validation for command to place wall`() {
        val input = GameInput("W,a,1,d,1")
        val result = input.validateInput()
        val expected = true
        assertEquals(expected, result)
    }

    @Test
    fun `should pass validation for command to move player`() {
        val input = GameInput("1,a,1")
        val result = input.validateInput()
        val expected = true
        assertEquals(expected, result)
    }


    @Test
    fun `should pass validation for command to move player 1`() {
        val input = GameInput("0,a,1")
        val result = input.validateInput()
        val expected = true
        assertEquals(expected, result)
    }

    @Test
    fun `should interpret player movement command for player 1`() {
        val input = GameInput("0,a,1")
        val result = input.interpret()
        val expected = Command(
           false,
            IntRange(1,1),
            IntRange(0,0),
            '0'
        )
        assertEquals(expected.rows,result.rows)
        assertEquals(expected.cols,result.cols)
        assertEquals(expected.wall,result.wall)
        assertEquals(expected.player,result.player)
    }

    @Test
    fun `should interpret player movement command for player 2`() {
        val input = GameInput("1,a,1")
        val result = input.interpret()
        val expected = Command(
            false,
            IntRange(1,1),
            IntRange(0,0),
            '1'
        )
        assertEquals(expected.rows,result.rows)
        assertEquals(expected.cols,result.cols)
        assertEquals(expected.wall,result.wall)
        assertEquals(expected.player,result.player)
    }

    @Test
    fun `should pass validation for command to move player with double digit number`() {
        val input = GameInput("1,a,17")
        val result = input.validateInput()
        val expected = true
        assertEquals(expected, result)
    }
}