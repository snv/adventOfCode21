package day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InputKtTest {
    private val rawSampleInput = """
        0,9 -> 5,9
        8,0 -> 0,8
        9,4 -> 3,4
        2,2 -> 2,1
        7,0 -> 7,4
        6,4 -> 2,0
        0,9 -> 2,9
        3,4 -> 1,4
        0,0 -> 8,8
        5,5 -> 8,2
    """.trimIndent()

    private val expectedLinesSample = listOf(
        Coordinate(0,9) to Coordinate(5,9),
        Coordinate(0,9) to Coordinate(2,9),
        Coordinate(2,2) to Coordinate(2,1),
        Coordinate(0,0) to Coordinate(8,8)
    )

    @Test
    fun parse() {
        //act
        val parsedLines = rawSampleInput.parse()

        //assert
        assertTrue(parsedLines.containsAll(
            expectedLinesSample
        ))
    }
}