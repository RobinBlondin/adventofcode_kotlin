package advent_of_code_2021.day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3Test {

    val day3 = Day3("./test/advent_of_code_2021/day3/input.txt")
    @Test
    fun solutionA() {
        assertEquals(day3.solutionA(), 198)
    }

    @Test
    fun solutionB() {
        assertEquals(day3.solutionB(), 230)
    }
}