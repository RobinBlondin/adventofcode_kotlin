package advent_of_code_2019.day4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day4Test {
    private val day4 = Day4("./test/advent_of_code_2019/day4/input.txt")

    @Test
    fun solutionA() {
    }

    @Test
    fun solutionB() {
    }

    @Test
    fun hasDuplicateDigitsA() {
        val numberTrue1 = 1123456
        val numberTrue2 = 1111111
        val numberFalse = 123456

        assertTrue(day4.hasDuplicateDigitsA(numberTrue1))
        assertTrue(day4.hasDuplicateDigitsA(numberTrue2))
        assertFalse(day4.hasDuplicateDigitsA(numberFalse))
    }

    @Test
    fun hasDuplicateDigitsB() {
        val numberTrue1 = 1123456
        val numberTrue2 = 1122222
        val numberFalse1 = 1111111
        val numberFalse2 = 123456

        assertTrue(day4.hasDuplicateDigitsB(numberTrue1))
        assertTrue(day4.hasDuplicateDigitsB(numberTrue2))
        assertFalse(day4.hasDuplicateDigitsB(numberFalse1))
        assertFalse(day4.hasDuplicateDigitsB(numberFalse2))
    }


    @Test
    fun hasIncreasingDigits() {
        val numberTrue = 1123456
        val numberFalse = 1234560

        assertTrue(day4.hasIncreasingDigits(numberTrue))
        assertFalse(day4.hasIncreasingDigits(numberFalse))
    }
}