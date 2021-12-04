package day3

import kotlin.math.roundToInt

fun powerConsumption(data: List<List<Int>>) = epsilon(data) * gamma(data)

fun epsilon(data: List<List<Int>>): Int = binaryEpsilon(data)
    .toInt(2)

fun binaryEpsilon(data: List<List<Int>>): String  = averageColumns(data)
    .map(Double::roundToInt)
    .map(::flipBit)
    .joinToString(separator = "")

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