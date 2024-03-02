package advent_of_code_2020.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day2Test {

    @Test
    fun testSolution() {
        val day2 = Day2("test/advent_of_code_2020/day2/input.txt")

        assertEquals(2, day2.solutionA())
        assertEquals(1, day2.solutionB())
    }
}