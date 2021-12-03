import kotlin.math.roundToInt

fun main() {
    val data = """
        010
        100
        111
        """.trimIndent()
        .parse()
    println(data)

    println(binaryGamma(data))
    println(gamma(data))
}

fun powerConsumption(data: List<List<Int>>) = epsilon(data) * gamma(data)

fun epsilon(data: List<List<Int>>): Int = binaryEpsilon(data)
    .toInt(2)

fun binaryEpsilon(data: List<List<Int>>): String  = averageColumns(data)
    .map(Double::roundToInt)
    .map(::flipBit)
    .joinToString(separator = "")

private fun flipBit(it: Int) = (it - 1) * -1

fun gamma(data: List<List<Int>>) = binaryGamma(data)
    .toInt(2)

fun binaryGamma(data: List<List<Int>>) = averageColumns(data)
    .map(Double::roundToInt)
    .joinToString(separator = "")

private fun averageColumns(
    data: List<List<Int>>
) = addColumns(data)
        .map(Int::toDouble)
        .map { it / data.size }

private fun addColumns(data: List<List<Int>>) = data.reduce { total, line ->
    total
        .zip(line)
        .map { (avg, i) ->
            avg + i
        }
}

fun String.parse() = lines()
    .map(String::toList)
    .map { it.map(Char::digitToInt) }
