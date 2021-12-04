package day4

@JvmInline
value class MarkedNumbers(val positions : Set<Coordinate>){
    private enum class Perspective(val selector: Coordinate.() -> Int){
        ROWS(Coordinate::first),
        COLUMNS(Coordinate::second)
    }
    fun hasWon() = findWinningCoords().isNotEmpty()
    fun findWinningCoords() = findWinningCoordsForDirection(Perspective.ROWS) + findWinningCoordsForDirection(Perspective.COLUMNS)
    private fun findWinningCoordsForDirection(perspective: Perspective) =
        positions.groupBy(perspective.selector)
            .filter { it.value.size == BOARD_SIZE }
            .map { it.value }
}