package day5

fun main() {
    val input = rawInput.parse()
    println("""
        Part 1:
            ${countHotspotsForPart1(input)}
        Part 2:
            ${countHotspotsForPart2(input)}
    """.trimIndent())
}

fun countHotspotsForPart1(input: List<Vents>) = input
    .filter { (start, end) -> start.first == end.first || start.second == end.second }
    .let(::buildHeatMap)
    .findHotspots(2)
    .count()

fun countHotspotsForPart2(input: List<Vents>) = input
    .let(::buildHeatMap)
    .findHotspots(2)
    .count()