package advent_of_code_2021.day5

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Day5Test {
    val day5 = Day5("./test/advent_of_code_2021/day5/input.txt")

    @Test
    fun testSolutionA_shouldReturnTestInputAnswer() {
        assertEquals(5, day5.solutionA())
    }
}