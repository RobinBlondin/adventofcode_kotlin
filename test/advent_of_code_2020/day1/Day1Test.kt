package advent_of_code_2020.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day1Test {

    @Test
    fun testSolution(): Unit {
        val day1 = Day1()
        val path = "test/advent_of_code_2020/day1/inputA.txt"
        val inputList = day1.readFileToList(path)


        assertEquals(514579, day1.solutionA(inputList))
        assertEquals(241861950, day1.solutionB(inputList))
    }
}