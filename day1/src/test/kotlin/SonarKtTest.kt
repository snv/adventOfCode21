import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SonarKtTest {

    @Test
    fun window_increments() {
        assertEquals(2,
            listOf(1,2,3)
                .windowIncrements(1)
        )

        assertEquals(1,
            listOf(1,2,3)
                .windowIncrements(2)
        )

        assertEquals(2,
            listOf(1,2,3,4)
                .windowIncrements(2)
        )

        assertEquals(1,
            listOf(1,2,2,1)
                .windowIncrements(2)
        )

        listOf(1,2,3,0,0,6,7,8,9)
            .windowed(3)
            .also(::println)
            .map { it.sum() }
            .also(::println)
            .increments()
            .also(::println)



    }
}