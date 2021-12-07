package day7

import kotlin.math.absoluteValue

fun main() {
//    val input = rawInput.parse()
    println("""
        Part 1: ${CrabSwarm(rawInput().parse()).idealConstantFuelCost}
        Part 2: ${CrabSwarm(rawInput().parse()).idealIncreasingConstantFuelCost}
    """.trimIndent())
}

class CrabSwarm(private val initalPositions: List<Int>){
    private val sortedPositions = initalPositions.sorted()
    val medianPosition = sortedPositions.elementAt(initalPositions.count().div(2))
    val idealConstantFuelCost = constantFuelCost(medianPosition)

    private val smallesPosition = sortedPositions.first()
    private val largestPosition = sortedPositions.last()
    private val fuelCostsPlot = (smallesPosition..largestPosition)
        .associateBy { increasingFuelCost(it) }
        .toSortedMap()

    val weighedPosition: Int = fuelCostsPlot[fuelCostsPlot.firstKey()]!!
    val idealIncreasingConstantFuelCost: Int = increasingFuelCost(weighedPosition)

    fun constantFuelCost(targetPosition: Int): Int = initalPositions.sumOf { (targetPosition - it).absoluteValue }
    fun increasingFuelCost(targetPosition: Int): Int = initalPositions.sumOf { smallGauss((targetPosition - it).absoluteValue) }

    private fun smallGauss(n: Int) = n * ( n + 1) / 2
}