package advent_of_code_2020.day9

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day9Test {
    private val day9 = Day9("test/advent_of_code_2020/day9/input.txt", true)
    @Test
    fun solutionA() {
        assertEquals(127.toBigInteger(), day9.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(62.toBigInteger(), day9.solutionB())
    }
}
