package day5

typealias Coordinate = Pair<Int,Int>
typealias Vents = Pair<Coordinate, Coordinate>
typealias HeatMap = Map<Coordinate, Int>

@JvmName("plusCoords")
operator fun HeatMap.plus(coordinate: Coordinate) : HeatMap = plus(
    coordinate to getOrDefault(coordinate, 0) + 1
)

fun Vents.expand() : List<Coordinate> = let { (start, end) ->
    (if (start.first <= end.first) (start.first..end.first) else (end.first..start.first))
        .flatMap { first ->
            (if (start.second <= end.second) (start.second..end.second) else (end.second..start.second))
                .map { second -> Coordinate(first,second) }
        }
}


@JvmName("plusVents")
operator fun HeatMap.plus(vents: Vents) :HeatMap = vents.expand()
    .fold(this) { heatmap, vent ->  heatmap + vent }

fun buildHeatMap(lines : Collection<Vents>): HeatMap = lines
    .fold(emptyMap()) {
        heatMap: HeatMap, vents ->
        heatMap + vents
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