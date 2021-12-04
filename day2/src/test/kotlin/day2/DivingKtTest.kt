package day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DivingKtTest {
    private val sampleInput = """
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

        Assertions.assertEquals(Direction.FORWARD, f5.direction)
        Assertions.assertEquals(5, f5.distance)

        Assertions.assertEquals(Direction.DOWN, d8.direction)
        Assertions.assertEquals(8, d8.distance)

        Assertions.assertEquals(Direction.UP, u3.direction)
        Assertions.assertEquals(3, u3.distance)
    }

    @Test
    fun complexPositionsTest(){
        //arrange
        val commands = sampleInput
            .lines()
            .map(::parseCommand)

        //act
        val (horizontal, depth, _) = commands.fold(ComplexPosition(), ComplexPosition::execute)

        //assert
        Assertions.assertEquals(15, horizontal)
        Assertions.assertEquals(60, depth)
    }
}