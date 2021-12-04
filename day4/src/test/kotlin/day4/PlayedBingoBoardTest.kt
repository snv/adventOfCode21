package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PlayedBingoBoardTest {
    val sampleDrawnNumbers: DrawnNumbers = listOf(7,
        4,
        9,
        5,
        11,
        17,
        23,
        2,
        0,
        14,
        21,
        24,
        10,
        16,
        13,
        6,
        15,
        25,
        12,
        22,
        18,
        20,
        8,
        19,
        3,
        26,
        1)
    val winningBoard: BingoBoard = listOf(
        listOf(14, 21, 17, 24, 4),
        listOf(10, 16, 15, 9, 19),
        listOf(18,  8, 23, 26, 20),
        listOf(22, 11, 13,  6,  5),
        listOf(2,  0, 12,  3,  7)
    )
    val loosingBoard: BingoBoard = listOf(
        listOf(22, 13, 17, 11, 0),
        listOf(8, 2, 23, 4, 24),
        listOf(21, 9, 14, 16, 7),
        listOf(6, 10, 3, 18, 5),
        listOf(1, 12, 20, 15, 19)
    )


    @Test
    fun getFinalScore() {
        assertEquals(4512, PlayedBingoBoard(winningBoard, sampleDrawnNumbers))
    }

}