@file:Suppress("ClassName")

package day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ThermalMapKtTest {
    enum class ExpandedSampleVents(val coordinates: List<Coordinate>){
        LONG_HORIZONTAL(listOf(
            0 to 9,
            1 to 9,
            2 to 9,
            3 to 9,
            4 to 9,
            5 to 9
        )),
        SHORT_HORIZONTAL(listOf(
            0 to 9,
            1 to 9,
            2 to 9
        )),
        VERTICAL(listOf(
            7 to 0,
            7 to 1,
            7 to 2,
            7 to 3,
            7 to 4
        )),
        DIAGONAL_A(listOf(
            1 to 1,
            2 to 2,
            3 to 3
        )),
        DIAGONAL_B(listOf(
            9 to 7,
            8 to 8,
            7 to 9
        ))
    }
    enum class SampleVents(val vents: Vents){
        LONG_HORIZONTAL((0 to 9) to (5 to 9)),
        SHORT_HORIZONTAL((0 to 9) to (2 to 9)),
        VERTICAL((7 to 0) to (7 to 4)),
        DIAGONAL_A((1 to 1) to (3 to 3)),
        DIAGONAL_B((9 to 7) to (7 to 9)),
    }

    val sampleInput = listOf(
        ((0 to 9) to (5 to 9)),
        ((8 to 0) to (0 to 8)),
        ((9 to 4) to (3 to 4)),
        ((2 to 2) to (2 to 1)),
        ((7 to 0) to (7 to 4)),
        ((6 to 4) to (2 to 0)),
        ((0 to 9) to (2 to 9)),
        ((3 to 4) to (1 to 4)),
        ((0 to 0) to (8 to 8)),
        ((5 to 5) to (8 to 2))
    )

    @Test
    fun `add coordinates to heatmap`() {
        val heatmap : HeatMap = mutableMapOf()

        ExpandedSampleVents.SHORT_HORIZONTAL.coordinates
            .forEach { heatmap += it }
        println(heatmap.draw())

        ExpandedSampleVents.LONG_HORIZONTAL.coordinates
            .forEach { heatmap += it }
        println(heatmap.draw())

        ExpandedSampleVents.VERTICAL.coordinates
            .forEach { heatmap += it }
        println(heatmap.draw())

        assertNull(heatmap[9 to 9])
        assertEquals(2, heatmap[0 to 9])
        assertEquals(2, heatmap[2 to 9])
        assertEquals(1, heatmap[3 to 9])
        assertEquals(1, heatmap[7 to 2])
        assertEquals(1, heatmap[7 to 4])
    }

    @Nested
    inner class `expand vents` {
        @Test
        fun horzontaly() {
            //act
            val expandedVents = SampleVents.LONG_HORIZONTAL.vents.expand()

            //assert
            assertEquals(
                ExpandedSampleVents.LONG_HORIZONTAL.coordinates,
                expandedVents
            )
        }

        @Test
        fun vertically() {
            //arrange
            val sampleVents : Vents = SampleVents.VERTICAL.vents

            //act
            val expandedVents = sampleVents.expand()

            //assert
            assertEquals(
                ExpandedSampleVents.VERTICAL.coordinates,
                expandedVents
            )
        }
    }

    @Test
    fun `add lines of vents to heatmap`() {
        val heatmap :HeatMap = mutableMapOf()

        heatmap += SampleVents.LONG_HORIZONTAL.vents
        heatmap += SampleVents.SHORT_HORIZONTAL.vents
        heatmap += SampleVents.VERTICAL.vents

        //println(heatmap.draw())

        assertNull(heatmap[9 to 9])
        assertEquals(2, heatmap[0 to 9])
        assertEquals(2, heatmap[2 to 9])
        assertEquals(1, heatmap[3 to 9])
        assertEquals(1, heatmap[7 to 2])
        assertEquals(1, heatmap[7 to 4])
    }

    @Test
    fun `adding diagonal lines`(){
        val heatMap :HeatMap = mutableMapOf()

        heatMap += SampleVents.DIAGONAL_A.vents
        heatMap += SampleVents.DIAGONAL_B.vents

        assertTrue {
            ExpandedSampleVents.DIAGONAL_A.coordinates
                .all { heatMap.containsKey(it) } and
            ExpandedSampleVents.DIAGONAL_B.coordinates
                .all { heatMap.containsKey(it) }
        }
    }

    @Test
    fun drawHeatMap() {
        val filtered = sampleInput
            .also(::println)

        println(buildHeatMap(filtered).draw())
    }

    @Test
    fun findHotspots(){
        val filtered = sampleInput
            .filter { (start, end) -> start.first == end.first || start.second == end.second }

        val hotspots = buildHeatMap(filtered).findHotspots(2)

        assertEquals(5, hotspots.size)
    }

    @Test
    fun findHotspotsWithDiagonals(){
        val filtered = sampleInput

        val hotspots = buildHeatMap(filtered).findHotspots(2)

        assertEquals(12, hotspots.size)
    }


}