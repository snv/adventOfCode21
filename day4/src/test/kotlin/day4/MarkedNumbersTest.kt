package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource


internal class MarkedNumbersTest {

    @Suppress("unused") //the jUnit runner will use them
    enum class Winning(val data: Set<Coordinate>){
        ROW(setOf(Coordinate(0, 0), Coordinate(0, 1), Coordinate(0, 2), Coordinate(0, 3), Coordinate(0, 4))),
        COLUMN(setOf(Coordinate(0, 0), Coordinate(1, 0), Coordinate(2, 0), Coordinate(3, 0), Coordinate(4, 0)))
    }

    @ParameterizedTest
    @EnumSource(Winning::class)
    fun hasWon(winning: Winning) {
        assertTrue(MarkedNumbers(winning.data).hasWon())
    }


    @ParameterizedTest
    @EnumSource(Winning::class)
    fun findWinningCoords(winning: Winning) {
        assertTrue(
            MarkedNumbers(winning.data)
                .findWinningCoords()
                .single()
                .containsAll(winning.data)
        )
    }
}