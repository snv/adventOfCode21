fun main() {
    val commands = input.lines()
        .map(::parseCommand)
    val lastPosition1 = commands
        .fold(Position()) { pos, cmd ->
            pos.apply(cmd)
        }
    println("""
        first part:
            Last position is $lastPosition1
            Quizanswer is ${lastPosition1.horizontal * lastPosition1.depth}
        """.trimIndent())

    val lastPosition2 = commands.fold(ComplexPosition()) { pos, cmd ->
        pos.apply(cmd)
    }
    println("""
        second part:
            Last position is $lastPosition2
            Quizanswer is ${lastPosition2.horizontal * lastPosition2.depth}
        """.trimIndent())

}

data class Position(val horizontal: Int = 0, val depth: Int = 0){
    private fun forward(x:Int) = copy(horizontal = horizontal+x)
    private fun down(x:Int) = copy(depth = depth + x)
    private fun up(x: Int) = copy(depth = depth - x)
    fun apply(command: Command) = when (command.direction) {
        Direction.FORWARD -> forward(command.distance)
        Direction.DOWN -> down(command.distance)
        Direction.UP -> up(command.distance)
    }
}

data class ComplexPosition(val horizontal: Int = 0, val depth: Int = 0, val aim: Int = 0){
    private fun forward(x:Int) = copy(horizontal = horizontal + x, depth = depth + aim*x)
    private fun down(x:Int) = copy(aim = aim + x)
    private fun up(x: Int) = copy(aim = aim - x)
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

