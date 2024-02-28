package advent_of_code_2020.day6

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6Test {

    @Test
    fun solutionA() {
        val day6 = Day6("test/advent_of_code_2020/day6/input.txt")

        assertEquals(11, day6.solutionA())
        assertEquals(6, day6.solutionB())
    }
}