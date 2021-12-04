package day3

import kotlin.math.roundToInt

fun lifeSupportRating(diagnosticReport : List<List<Int>>) :Int = oxygenRating(diagnosticReport) * co2ScrubberRating(diagnosticReport)

fun co2ScrubberRating(diagnosticReport: List<List<Int>>): Int = binaryCo2Rating(diagnosticReport).toInt(2)

fun binaryCo2Rating(diagnosticReport: List<List<Int>>): String = findBestMatch(
    diagnosticReport
        .map{ it.joinToString("") }
        .map { Candidate(it, it) },
    BitCriteria.CO2
)


fun oxygenRating(diagnosticReport: List<List<Int>>): Int = binaryOxygenRating(diagnosticReport).toInt(2)

fun binaryOxygenRating(diagnosticReport: List<List<Int>>): String = findBestMatch(
    diagnosticReport
        .map{ it.joinToString("") }
        .map { Candidate(it, it) },
    BitCriteria.OXYGEN
)

data class Candidate(val suffix: String, val originalLine: String)

enum class BitCriteria(val flipped: Boolean) {
    OXYGEN(false),
    CO2( true)
}

fun findBestMatch(
    remainingCandidates: List<Candidate>,
    mode: BitCriteria,
): String =
    if (remainingCandidates.size == 1) remainingCandidates.first().originalLine else {
        val winningBit = remainingCandidates
            .sumOf { it.suffix.first().digitToInt() }
            .toDouble()
            .let { it / remainingCandidates.size }
            .roundToInt()
            .let { if (mode.flipped) flipBit(it) else it }
            .toString()

        findBestMatch(
            remainingCandidates
                .filter { it.suffix.startsWith(winningBit) }
                .map { it.copy(suffix = it.suffix.removePrefix(winningBit)) },
            mode
        )
    }