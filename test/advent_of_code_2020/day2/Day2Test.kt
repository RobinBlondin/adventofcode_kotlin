package advent_of_code_2020.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day2Test {

    @Test
    fun testSolution(): Unit {
        val day2 = Day2()
        val path = "test/advent_of_code_2020/day2/input.txt"
        val inputList = day2.readFileToList(path)

        assertEquals(2, day2.solutionA(inputList))
        assertEquals(1, day2.solutionB(inputList))
    }
}