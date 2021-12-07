import day6.parse
import day6.rawInput
import java.math.BigInteger

fun main() {
//    val input = rawInput.parse()
    println("""
        Part 1:
            ${swarmSizeAfter(80)}
        Part 2:
            ${swarmSizeAfter(256)}
    """.trimIndent())
}

typealias Swarm = MutableMap<Int,Long>

fun swarmSizeAfter(days: Int) = rawInput
    .parse()
    .age(days)
    .values
    .reduce(Long::plus)

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
                merge(6, spawningAmount, Long::plus)
            }
    }
    return this
}
