package day1

fun List<Int>.increments() = zipWithNext { a, b -> a < b }
    .count { it }

fun List<Int>.windowIncrements(size: Int) = windowed(size)
    .map { it.sum() }
    .increments()

fun main() {
    println("Simple Increments ${input.increments()}")
    println("Sliding Window Increments ${input.windowIncrements(3)}")
}