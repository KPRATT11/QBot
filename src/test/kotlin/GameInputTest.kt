import org.example.Command
import org.example.GameInput
import org.junit.Test
import kotlin.test.assertEquals

class GameInputTest {
    @Test
    fun `should correctly interpret command for wall`() {
        val input = GameInput("Wa1a4")
        val result = input.interpret()
        val expected = Command(
            wall = true,
            rows = IntRange(1,4),
            cols = IntRange(0,0)
        )
        assertEquals(expected = result.rows, actual = expected.rows)
        assertEquals(expected = result.cols, actual = expected.cols)
        assertEquals(expected = result.wall, actual = expected.wall)
    }

    @Test
    fun `should fail validation for command without correct starting character`() {
        val input = GameInput("asfd")
        val result = input.validateInput()
        val expected = false
        assertEquals(expected, result)
    }

    @Test
    fun `should pass validation for command`() {
        val input = GameInput("Wa1d1")
        val result = input.validateInput()
        val expected = true
        assertEquals(expected, result)
    }
}