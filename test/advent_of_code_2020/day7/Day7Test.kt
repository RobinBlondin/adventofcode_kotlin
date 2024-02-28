package advent_of_code_2020.day7

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day7Test {

    private val day7 = Day7("test/advent_of_code_2020/day7/input.txt")
    @Test
    fun solutionA() {
        assertEquals(4, day7.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(0, day7.solutionB())
    }
}