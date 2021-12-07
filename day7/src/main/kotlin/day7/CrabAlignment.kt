package day7

import kotlin.math.absoluteValue

fun main() {
//    val input = rawInput.parse()
    println("""
        Part 1: ${CrabSwarm(rawInput().parse()).idealFuelCost}
        Part 2:
    """.trimIndent())
}

class CrabSwarm(private val initalPositions: List<Int>){
    val medianPosition = initalPositions.sorted().elementAt(initalPositions.count().div(2))
    val idealFuelCost = fuelcost(medianPosition)

    fun fuelcost(targetPosition: Int): Int = initalPositions.sumOf { (targetPosition - it).absoluteValue }
}