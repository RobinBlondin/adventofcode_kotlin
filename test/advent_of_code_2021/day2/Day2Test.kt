package advent_of_code_2021.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2Test {

    private val day2 = Day2("./test/advent_of_code_2021/day2/input.txt")
    @Test
    fun solutionA() {
        assertEquals(day2.solutionA(), 150)
    }

    @Test
    fun solutionB() {
        assertEquals(day2.solutionB(), 900)
    }
}