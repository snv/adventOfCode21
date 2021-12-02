fun main() {
    val lastPosition = input.lines()
        .map(::parseCommand)
        .fold(Position(0, 0)) { pos, cmd ->
            pos.apply(cmd)
        }
    println("""
        first part:
            Last position is $lastPosition
            Quizanswer is ${lastPosition.horizontal * lastPosition.depth}
        """.trimIndent())
}

data class Position(val horizontal: Int, val depth: Int){
    private fun forward(x:Int) = copy(horizontal = horizontal+x)
    private fun down(x:Int) = copy(depth = depth + x)
    private fun up(x: Int) = copy(depth = depth - x)
    fun apply(command: Command) = when (command.direction) {
        Direction.FORWARD -> forward(command.distance)
        Direction.DOWN -> down(command.distance)
        Direction.UP -> up(command.distance)
    }
}

enum class Direction{
    FORWARD,
    UP,
    DOWN
}

data class Command(val direction: Direction, val distance: Int)

fun parseCommand(s: String) = s.uppercase()
    .split(' ')
    .let { Command(
        Direction.valueOf(it[0]),
        it[1].toInt()
    ) }

