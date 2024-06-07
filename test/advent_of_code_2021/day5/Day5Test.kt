package advent_of_code_2021.day5

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Day5Test {
    private val day5 = Day5("./test/advent_of_code_2021/day5/input.txt")

    @Test
    fun testSolutionA_shouldReturnTestInputAnswer() {
        assertEquals(5, day5.solutionA())
    }

    @Test
    fun testSolutionB_shouldReturnTestInputAnswer() {
        assertEquals(12, day5.solutionB())
    }
}