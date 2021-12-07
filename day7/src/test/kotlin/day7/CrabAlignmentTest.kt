package day7

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CrabAlignmentTest(){
    val sampleInput = """
        16,1,2,0,4,2,7,1,2,14
    """.trimIndent()

    @Test
    fun parseInput(){
        assertEquals(
            listOf(16,1,2,0,4,2,7,1,2,14),
            sampleInput.parse()
        )
    }

    @Test
    fun `find the optimal position`() {
        assertEquals(
            2,
            CrabSwarm(sampleInput.parse())
                .medianPosition
        )
    }

    @Suppress("ClassName")
    @Nested
    inner class `calculating the fuel costs`{
        @ParameterizedTest
        @CsvSource(value = [
            "1, 41",
            "2, 37",
            "3, 39",
            "10, 71"
        ])
        fun `for Position`(position: Int, expectedFuelCost: Int) {
            assertEquals(
                expectedFuelCost,
                CrabSwarm(sampleInput.parse())
                    .fuelcost(position)
            )
        }

        @Test
        fun `find ideal fuel cost`() {
            assertEquals(
                37,
                CrabSwarm(sampleInput.parse())
                    .idealFuelCost
            )
        }
    }

}