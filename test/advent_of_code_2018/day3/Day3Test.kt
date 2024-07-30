package advent_of_code_2018.day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3Test {
    private val day3 = Day3("./test/advent_of_code_2018/day3/input.txt")
    @Test
    fun solutionA() {
        assertEquals(4, day3.solutionA())
    }

    @Test
    fun solutionB() {
        day3.solutionA()
        assertEquals("3", day3.solutionB())
    }
}