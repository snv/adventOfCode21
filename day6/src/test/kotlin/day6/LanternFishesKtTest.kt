package day6

import Swarm
import age
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LanternFishesKtTest {
    private val sampleInput = """
        3,4,3,1,2
    """.trimIndent()

    @Test
    fun parse() {
        assertEquals(
            listOf(3,4,3,1,2),
            sampleInput.parse()
        )
    }

    @Test
    fun `age 18 days`() {
        val swarm: Swarm = sampleInput.parse().toMutableList()

        for (i in 1..18) {
            swarm.age()
        }

        assertEquals(
            26,
            swarm.count()
        )
    }

    @Test
    fun `age 80 days`() {
        val swarm: Swarm = sampleInput.parse().toMutableList()

        swarm.age(80)

        assertEquals(
            5934,
            swarm.count()
        )
    }
}