package advent_of_code_2021.day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3Test {

    val day3 = Day3("./test/advent_of_code_2021/day3/input.txt")
    @Test
    fun solutionA() {
        assertEquals(198, day3.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(230, day3.solutionB())
    }
}