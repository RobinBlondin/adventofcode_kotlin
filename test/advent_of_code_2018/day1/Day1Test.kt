package advent_of_code_2018.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1Test {
    private val day1 = Day1("./test/advent_of_code_2018/day1/input.txt")

    @Test
    fun solutionA() {
        assertEquals(3, day1.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(2, day1.solutionB())
    }
}