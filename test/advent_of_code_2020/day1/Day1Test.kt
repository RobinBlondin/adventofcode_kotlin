package advent_of_code_2020.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day1Test {

    @Test
    fun testSolution(){
        val day1 = Day1("test/advent_of_code_2020/day1/input.txt")

        assertEquals(514579, day1.solutionA())
        assertEquals(241861950, day1.solutionB())
    }
}