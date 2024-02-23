package advent_of_code_2020.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day3Test {

    @Test
    fun testSolution(): Unit {
        val day3 = Day3()
        val path = "test/advent_of_code_2020/day3/input.txt"
        val inputList = day3.readFileToList(path)

        assertEquals(7, day3.solutionA(inputList))
        assertEquals(336, day3.solutionB(inputList))
    }
}