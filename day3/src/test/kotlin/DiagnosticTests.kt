import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DiagnosticTests {
    private val sampleData = """
        00100
        11110
        10110
        10111
        10101
        01111
        00111
        11100
        10000
        11001
        00010
        01010
    """.trimIndent()
        .parse()

    @Test
    fun calculateBinaryGamma(){
        assertEquals("10110", binaryGamma(sampleData))
    }

    @Test
    fun calculateGamma(){
        assertEquals(22, gamma(sampleData))
    }

    @Test
    fun calculateBinaryEpsilon(){
        assertEquals("01001", binaryEpsilon(sampleData))
    }

    @Test
    fun calculateEpsilon(){
        assertEquals(9, epsilon(sampleData))
    }

    @Test
    fun calculatePowerConsumption(){
        assertEquals(198, powerConsumption(sampleData))
    }
}