import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DivingKtTest {
    val sampleInput = """
        forward 5
        down 5
        forward 8
        up 3
        down 8
        forward 2
    """.trimIndent()

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

    @Test
    fun complexPositionsTest(){
        //arrange
        val commands = sampleInput
            .lines()
            .map(::parseCommand)

        val (horizontal, depth, _) = commands.fold(ComplexPosition()) { pos, cmd ->
            pos.apply(cmd)
        }
        assertEquals(15, horizontal)
        assertEquals(60, depth)
    }
}