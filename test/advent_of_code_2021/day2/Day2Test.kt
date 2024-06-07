package advent_of_code_2021.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2Test {

    private val day2 = Day2("./test/advent_of_code_2021/day2/input.txt")
    @Test
    fun solutionA() {
        assertEquals(150, day2.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(900, day2.solutionB())
    }
}