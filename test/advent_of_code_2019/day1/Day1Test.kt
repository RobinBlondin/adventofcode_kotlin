package advent_of_code_2019.day1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1Test {
    private val day1 = Day1("./test/advent_of_code_2019/day1/input.txt")
    @Test
    fun solutionA() {
        assertEquals(34241, day1.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(51316, day1.solutionB())
    }

    @Test
    fun testCalculateFuel() {
        val input1 = 12L
        val input2 = 100756L

        val expectedResult1 = 2L
        val expectedResult2 = 33583L

        assertEquals(expectedResult1, day1.calculateFuel(input1))
        assertEquals(expectedResult2, day1.calculateFuel(input2))
    }

    @Test
    fun testCalculateFuelRecursive() {
        val input1 = 1969L
        val input2 = 100756L

        val expectedResult1 = 966L
        val expectedResult2 = 50346L

        assertEquals(expectedResult1, day1.calculateFuelRecursive(input1, 0))
        assertEquals(expectedResult2, day1.calculateFuelRecursive(input2, 0))
    }
}