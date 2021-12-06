import day6.parse
import day6.rawInput

fun main() {
//    val input = rawInput.parse()
    println("""
        Part 1:
            ${swarmSizeForPart1()}
        Part 2:
            
    """.trimIndent())
}

typealias Swarm = MutableList<Int>

fun swarmSizeForPart1() = rawInput
    .parse()
    .toMutableList()
    .age(80)
    .count()

fun Swarm.age(days: Int = 1): Swarm {
    for (i in 1..days) {
        val spawn = mutableListOf<Int>()

        forEachIndexed { index, age ->
            this[index] = if (age > 0) age-1 else {
                spawn.add(8)
                6
            }
        }

        this.addAll(spawn)
    }
    return this
}
