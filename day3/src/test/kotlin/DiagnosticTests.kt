import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
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

    @Nested
    inner class LifeSupport{

        @Test
        fun `binary oxygen generation rating`(){
            assertEquals("10111", binaryOxygenRating(sampleData))
        }

        @Test
        fun `oxygen generation rating`(){
            assertEquals(23, oxygenRating(sampleData))
        }

        @Test
        fun `binary CO2 scrubber rating`(){
            assertEquals("01010", binaryCo2Rating(sampleData))
        }

        @Test
        fun `CO2 scrubber rating`(){
            assertEquals(10, co2ScrubberRating(sampleData))
        }

        @Test
        fun `life support rating`(){
            assertEquals(230, lifeSupportRating(sampleData))
        }
    }

    @Nested
    inner class PowerConsumption{
        @Test
        fun `binary gamma`(){
            assertEquals("10110", binaryGamma(sampleData))
        }

        @Test
        fun gamma(){
            assertEquals(22, gamma(sampleData))
        }

        @Test
        fun `binary epsilon`(){
            assertEquals("01001", binaryEpsilon(sampleData))
        }

        @Test
        fun epsilon(){
            assertEquals(9, epsilon(sampleData))
        }

        @Test
        fun `power consumption`(){
            assertEquals(198, powerConsumption(sampleData))
        }
    }
}