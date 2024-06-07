package advent_of_code_2021.day6

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6Test {
    val day6 = Day6("./test/advent_of_code_2021/day6/input.txt")
    @Test
    fun solutionA_shouldReturnTestInputAnswer() {
        assertEquals(5934, day6.solutionA())
    }

    @Test
    fun solutionB_shouldReturnTestInputAnswer() {
        assertEquals(0, day6.solutionB())
    }
}