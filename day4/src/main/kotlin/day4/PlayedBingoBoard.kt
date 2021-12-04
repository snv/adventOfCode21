package day4

typealias Coordinate = Pair<Int, Int>

class PlayedBingoBoard(private val board: BingoBoard, private val drawnNumbers: DrawnNumbers){
    val winsAfter: Int
    private val lastCalledNumber: Int
    val finalScore: Int

    init {
        val (winsAfter, withMarkedNumbers) = play()
        this.winsAfter = winsAfter

        lastCalledNumber = if (winsAfter < drawnNumbers.size) drawnNumbers[winsAfter] else drawnNumbers.last()

        finalScore = lastCalledNumber *
            board
                .foldIndexed(0) { rowNr, totalScore, row ->
                    totalScore +
                        row.filterIndexed { colNr, _ ->
                            !withMarkedNumbers.positions.contains(Pair(rowNr, colNr))
                        }
                            .sum()
                }
    }

    private fun play() = drawnNumbers.foldIndexed(
        Pair(Int.MAX_VALUE, MarkedNumbers(setOf()))
    ) { turn, (earleastWin, markedNumbers), currentDrawnNr ->
        if (earleastWin < turn) Pair(earleastWin, markedNumbers)
        else {
            val currentMarking = MarkedNumbers(markedNumbers.positions + board.find(currentDrawnNr))
            if (currentMarking.hasWon()) Pair(turn, currentMarking)
            else Pair(earleastWin, currentMarking)
        }
    }
}

private fun BingoBoard.find(number: Int) = foldIndexed(setOf<Coordinate>()){
    rowNr, foundCoords, currentRow ->
    foundCoords
        .plus(
            currentRow
                .findPositionsInRow(number)
                .map { Coordinate(rowNr, it) }
        )
}

private fun List<Int>.findPositionsInRow(nr : Int) = foldIndexed(setOf<Int>()){
    colNr, foundPositions, currentNr -> if (currentNr == nr) foundPositions + colNr else foundPositions
}

