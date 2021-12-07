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

typealias Swarm = MutableMap<Int,Int>

fun swarmSizeForPart1() = rawInput
    .parse()
    .age(80)
    .values
    .sum()

fun Swarm.age(days: Int = 1): Swarm {
    for (i in 1..days) {
        val aged = this.keys
            .toList()
            .sorted()
            .map { it - 1 to this.getOrDefault(it, 0) }
        this.clear()
        this.putAll(aged)

        this.remove(-1)
            ?.let { spawningAmount ->
                this[8] = spawningAmount
                merge(6, spawningAmount, Int::plus)
            }
    }
    return this
}
