package advent_of_code_2020.day8

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day8Test {
    private val day8 = Day8("test/advent_of_code_2020/day8/input.txt")
    @Test
    fun solutionA() {
        assertEquals(5, day8.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(8, day8.solutionB())
    }
}