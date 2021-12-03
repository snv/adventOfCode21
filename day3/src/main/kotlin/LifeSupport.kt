fun lifeSupportRating(diagnosticReport : List<List<Int>>) :Int = oxygenRating(diagnosticReport) * co2ScrubberRating(diagnosticReport)

fun co2ScrubberRating(diagnosticReport: List<List<Int>>): Int = binaryCo2Rating(diagnosticReport).toInt(2)

fun binaryCo2Rating(diagnosticReport: List<List<Int>>): String {
    TODO("Not yet implemented")
}

fun oxygenRating(diagnosticReport: List<List<Int>>): Int = binaryOxygenRating(diagnosticReport).toInt(2)

fun binaryOxygenRating(diagnosticReport: List<List<Int>>): String {
    TODO("Not yet implemented")
}
