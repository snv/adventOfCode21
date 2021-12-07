package day6

import Swarm
import age
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test

internal class LanternFishesKtTest {
    private val sampleInput = """
        3,4,3,1,2
    """.trimIndent()

    @Test
    fun parse() {
        assertIterableEquals(
            mapOf<Int,Long>(
                1 to 1,
                2 to 1,
                3 to 2,
                4 to 1,
            )
                .toSortedMap()
                .entries,
            sampleInput.parse()
                .toSortedMap()
                .entries
        )
    }

    @Test
    fun `age 18 days`() {
        val swarm: Swarm = sampleInput.parse()

        for (i in 1..18) {
            swarm.age()
        }

        assertEquals(
            26,
            swarm.values.sum()
        )
    }

    @Test
    fun `age 80 days`() {
        val swarm: Swarm = sampleInput.parse()

        swarm.age(80)

        assertEquals(
            5934,
            swarm.values.sum()
        )
    }
}