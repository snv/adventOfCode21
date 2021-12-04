package day3

fun main() {
    println("""
        Part 1:
            PowerConsumption is ${powerConsumption(input)}
        Part 2:
            Life Suppurt Rating is ${lifeSupportRating(input)}
    """.trimIndent())
}

fun flipBit(it: Int) = (it - 1) * -1