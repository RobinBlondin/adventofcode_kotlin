package advent_of_code_2020.day10

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day10Test {

    private val day10 = Day10("test/advent_of_code_2020/day10/input.txt")
    @Test
    fun solutionA() {
        assertEquals(220, day10.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(0, day10.solutionB())
    }
}