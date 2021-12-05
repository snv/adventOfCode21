package day5

fun main() {
    println("""
        Part 1:
            ${countHotspotsForPart1()}
        Part 2:
    """.trimIndent())
}

fun countHotspotsForPart1() = rawInput.parse()
    .filter { (start, end) -> start.first == end.first || start.second == end.second }
    .let(::buildHeatMap)
    .findHotspots(2)
    .count()