package advent_of_code_2021.day10

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day10Test {
    val day10 = Day10("./test/advent_of_code_2021/day10/input.txt")
    @Test
    fun solutionA() {
        assertEquals(26397, day10.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(288957, day10.solutionB())
    }

    @Test
    fun testHasIncorrectCharacter_shouldReturnTrueIfStringContainsIncorrectClosingBracket() {
        val lineWithIncorrectBracket = "[[{<>}}]"
        val lineWithoutIncorrectBracket = "[[{{<<>>}}]]"

        assertTrue(day10.hasIncorrectCharacter(lineWithIncorrectBracket))
        assertFalse(day10.hasIncorrectCharacter(lineWithoutIncorrectBracket))
    }

    @Test
    fun findMissingBrackets_shouldReturnListOfMissingClosingBrackets() {
        val line1 = "[[{{<<"
        val line2 = "[[{{<<>>}}]]"

        val expected1 = listOf(">", ">", "}", "}", "]", "]")
        val expected2 = listOf<String>()

        assertEquals(expected1, day10.findMissingBrackets(line1))
        assertEquals(expected2, day10.findMissingBrackets(line2))
    }

    @Test
    fun testCalculateScore_shouldReturnResultFromPart2Algoritm() {
        val missingBrackets1 = listOf("}", "}", "]", "]", ")", "}", ")", "]")
        val missingBrackets2 = listOf(")", "}", ">", "]", "}", ")")

        val expectedResult1 = 288957L
        val expectedResult2 = 5566L

        assertEquals(expectedResult1, day10.calculateScore(missingBrackets1))
        assertEquals(expectedResult2, day10.calculateScore(missingBrackets2))
    }

}