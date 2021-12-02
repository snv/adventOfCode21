import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DivingKtTest {

    @Test
    fun parseCommand() {
        val f5 = parseCommand("forward 5")
        val d8 = parseCommand("down 8")
        val u3 = parseCommand("up 3")

        assertEquals(Direction.FORWARD, f5.direction)
        assertEquals(5, f5.distance)

        assertEquals(Direction.DOWN, d8.direction)
        assertEquals(8, d8.distance)

        assertEquals(Direction.UP, u3.direction)
        assertEquals(3, u3.distance)
    }
}