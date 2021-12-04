package day4

fun main() {
    println("""
        Part 1:
            ${pickWinningBoard().finalScore}
        Part 2:
            ${pickLoosingBoard().finalScore}
    """.trimIndent())
}

fun pickWinningBoard() = rawInput
    .parseInput()
    .let { (drawnNumbers, boards) ->
        boards
            .map { PlayedBingoBoard(it, drawnNumbers) }
            .sortedBy { it.winsAfter }
            .first()
    }

fun pickLoosingBoard() = rawInput
    .parseInput()
    .let { (drawnNumbers, boards) ->
        boards
            .map { PlayedBingoBoard(it, drawnNumbers) }
            .sortedByDescending { it.winsAfter }
            .first()
    }
