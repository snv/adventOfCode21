typealias DrawnNumbers = List<Int>
typealias BingoBoard = List<List<Int>>
private const val BOARD_SIZE = 5

data class Input(val drawnNumbers: DrawnNumbers, val boards : List<BingoBoard>)

fun String.parseInput() = Input(
    lines()
        .take(1)
        .single()
        .split(',')
        .map(String::toInt),
    lines()
        .drop(1)
        .chunked(BOARD_SIZE + 1) {
            it.drop(1) //strip the leading empty line
                .let(::parseBoard)
        }
)

private fun parseBoard(rawBoard: List<String>) : BingoBoard{
    require(rawBoard.size == BOARD_SIZE) {"Expected rawBoard to have the size $BOARD_SIZE, but got the board $rawBoard"}
    return rawBoard
        .map { it.split(Regex("\\s")) }
        .map { it.map(String::toInt) }
}

private val rawInput = """
    
""".trimIndent()

val input = rawInput.parseInput()
