package advent_of_code_2019.day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3Test {
    private val day3 = Day3("./test/advent_of_code_2019/day3/input.txt")
    @Test
    fun solutionA() {
        assertEquals(6, day3.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(30, day3.solutionB())
    }

    @Test
    fun testDrawLines_shouldReturnListOfListContainingOnePairPerPoint() {
        val expectedResult = listOf(
            listOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(0, 3), Pair(0, 4), Pair(0, 5), Pair(0, 6), Pair(0, 7), Pair(0, 8), Pair(-1, 8), Pair(-2, 8), Pair(-3, 8), Pair(-4, 8), Pair(-5, 8), Pair(-5, 7), Pair(-5, 6), Pair(-5, 5), Pair(-5, 4), Pair(-5, 3), Pair(-4, 3), Pair(-3, 3)),
            listOf(Pair(0, 0), Pair(-1, 0), Pair(-2, 0), Pair(-3, 0), Pair(-4, 0), Pair(-5, 0), Pair(-6, 0), Pair(-7, 0), Pair(-7, 1), Pair(-7, 2), Pair(-7, 3), Pair(-7, 4), Pair(-7, 5), Pair(-7, 6), Pair(-6, 6), Pair(-5, 6), Pair(-4, 6), Pair(-3, 6), Pair(-3, 5), Pair(-3, 4), Pair(-3, 3)))

        assertEquals(expectedResult, day3.drawLines(day3.input))
    }

    @Test
    fun testParseCommandToTargetPoint() {
        val startPoint = Pair(0,0)

        val expectedResult1 = Pair(0, -3)
        val expectedResult2 = Pair(0, 3)
        val expectedResult3 = Pair(-3, 0)
        val expectedResult4 = Pair(3, 0)

        assertEquals(expectedResult1, day3.parseCommandToTargetPoint(startPoint, "L3"))
        assertEquals(expectedResult2, day3.parseCommandToTargetPoint(startPoint, "R3"))
        assertEquals(expectedResult3, day3.parseCommandToTargetPoint(startPoint, "U3"))
        assertEquals(expectedResult4, day3.parseCommandToTargetPoint(startPoint, "D3"))
    }

    @Test
    fun testCalculateDistance() {
        val endPoint1 = Pair(-5, -5)
        val endPoint2 = Pair(-5, 5)
        val endPoint3 = Pair(5, -5)

        val expectedResult1 = 10

        assertEquals(expectedResult1, day3.calculateDistance(endPoint1))
        assertEquals(expectedResult1, day3.calculateDistance(endPoint2))
        assertEquals(expectedResult1, day3.calculateDistance(endPoint3))
    }
}