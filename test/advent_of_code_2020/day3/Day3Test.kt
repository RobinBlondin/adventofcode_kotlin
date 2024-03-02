package advent_of_code_2020.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day3Test {

    @Test
    fun testSolution() {
        val day3 = Day3("test/advent_of_code_2020/day3/input.txt")

        assertEquals(7, day3.solutionA())
        assertEquals(336, day3.solutionB())
    }
}