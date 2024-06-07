package advent_of_code_2021.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1Test {

    private val day1 = Day1("./test/advent_of_code_2021/day1/input.txt")

    @Test
    fun solutionA() {
        assertEquals(7, day1.solutionA(day1.list))
    }

    @Test
    fun solutionB() {
        assertEquals(5, day1.solutionB(day1.list))
    }
}