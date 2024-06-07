package advent_of_code_2021.day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day4Test {

        private val day4 = Day4("test/advent_of_code_2021/day4/input.txt")

        @Test
        fun solutionA() {
            assertEquals(4512, day4.solutionA())
        }

        @Test
        fun solutionB() {
            assertEquals(1924, day4.solutionB())
        }

        @Test
        fun testRotateBoard_shouldRotateMakingColumnsIntoRows() {
            val board = listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6),
                listOf(7, 8, 9))

            val expectedResult = listOf(
                listOf(1, 4, 7),
                listOf(2, 5, 8),
                listOf(3, 6, 9)
            )

            assertEquals(expectedResult, day4.rotateBoard(board))
        }
}