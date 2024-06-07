package advent_of_code_2021.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {

    private val day4 = Day4("test/advent_of_code_2021/day4/input.txt")

    @Test
    fun solutionA_shouldReturnTestInputAnswer() {
        assertEquals(4512, day4.solutionA())
    }

    @Test
    fun solutionB_shouldReturnTestInputAnswer() {
        assertEquals(1924, day4.solutionB())
    }

    @Test
    fun testRotateBoard_shouldRotate2dListMakingColumnsIntoRows() {
        val board = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )

        val expectedResult = listOf(
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(3, 6, 9)
        )

        assertEquals(expectedResult, day4.rotateBoard(board))
    }

    @Test
    fun testCheckRow_shouldReturnTrueIfAllNumbersInAnyRowOrColumnExistsInListOfNumbers() {
        val numbers = listOf(1, 3, 12, 15, 28, 39, 40)
        val boardWithBingoOnRow = listOf(
            listOf(2, 4, 7),
            listOf(3, 28, 40),
            listOf(23, 25, 37))

        val boardWithBingoOnColumn = listOf(
            listOf(2, 12, 18),
            listOf(5, 28, 44),
            listOf(9, 39, 48))

        val boardWithNoBingo = listOf(
            listOf(2, 5, 8),
            listOf(3, 12, 38),
            listOf(9, 13, 40))

        assertTrue(day4.checkRows(boardWithBingoOnRow, numbers))
        assertTrue(day4.checkRows(boardWithBingoOnColumn, numbers))
        assertFalse(day4.checkRows(boardWithNoBingo, numbers))
    }

    @Test
    fun testBingoScoreCalculation_whenBingoSumOfUncrossedNumbersMultipliedByLastDrawnNumber_elseZero() {
        val numbers = listOf(39, 3, 12, 15, 28, 2, 40)
        val boardWithBingo = listOf(listOf(
            listOf(1, 1, 1),
            listOf(2, 15, 39),
            listOf(1, 1, 1)))

        val boardWithNoBingo = listOf(listOf(
            listOf(1, 1, 1),
            listOf(1, 1, 1),
            listOf(1, 1, 1)))

        /*
        Sum of all uncrossed numbers on boardWithBingo is 6, multiplied by the last drawn number when bingo
        is hit, which is 2.
        */
        val expectedResultOnBingo = 6 * 2

        assertEquals(expectedResultOnBingo, day4.bingoScoreCalculation(boardWithBingo, numbers))
        assertEquals(0, day4.bingoScoreCalculation(boardWithNoBingo, numbers))
    }
}