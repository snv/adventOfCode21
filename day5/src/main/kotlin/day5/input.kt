package day5

val rawInput = """
    
""".trimIndent()

fun String.parse() : List<Vents> = lines()
    .map { it.parseLine() }


private fun String.parseLine(): Vents = split(Regex("\\s+->\\s+"))
    .map { it.parseCoordinate() }
    .let { Vents(it.first(), it.last()) }

private fun String.parseCoordinate(): Coordinate = split(',')
    .map { it.toInt() }
    .let { Coordinate(it.first(), it.last())}


