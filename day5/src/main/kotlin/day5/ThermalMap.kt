package day5

typealias Coordinate = Pair<Int,Int>
typealias Vents = Pair<Coordinate, Coordinate>
typealias HeatMap = MutableMap<Coordinate, Int>

@JvmName("plusAssignCoords")
operator fun HeatMap.plusAssign(coordinate: Coordinate) = plusAssign(
    coordinate to getOrDefault(coordinate, 0) + 1
)

fun Vents.expand() : List<Coordinate> = let { (start, end) ->
    when {
        start.first == end.first -> verticalLine(start.second, end.second, start.first)
        start.second == end.second -> horizontalLine(start.first, end.first, start.second)
        else -> diagonalLine(start.first, start.second, end.first, end.second)
    }
}

private fun rangeOf(a: Int, b: Int) = if (a <= b) (a..b) else (a downTo b)

private fun horizontalLine(startX: Int, endX: Int, y : Int) =
    rangeOf(startX, endX)
        .map { Coordinate(it, y) }

private fun verticalLine(startY: Int, endY: Int, x: Int) =
    rangeOf(startY, endY)
        .map { Coordinate(x, it) }

private fun diagonalLine(startX: Int, startY: Int, endX: Int, endY: Int) : List<Coordinate> =
    rangeOf(startX, endX)
        .zip(rangeOf(startY, endY))

@JvmName("plusVents")
operator fun HeatMap.plusAssign(vents: Vents) = vents.expand()
    .forEach{ this += it }

fun buildHeatMap(lines : Collection<Vents>): HeatMap = lines
    .fold(mutableMapOf()) {
        heatMap: HeatMap, vents ->
        heatMap += vents
        heatMap
    }

@Suppress("unused") //for debugging
fun HeatMap.draw(minX: Int = 0, maxX: Int = 9, minY: Int = 0, maxY: Int = 9) =
    (minY..maxY).joinToString(separator = "", prefix = "${this}\n") { second ->
        (minX..maxX)
            .map { this[it to second] }
            .map { it?.digitToChar() ?: '.' }
            .joinToString(separator = "", postfix = "\n", prefix = "\t")
    }

fun HeatMap.findHotspots(threshold: Int) =
    filter { (_, value) -> value >= threshold }