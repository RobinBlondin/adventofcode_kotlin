package advent_of_code_2021.day9

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day9Test {

    private val day9 = Day9("./test/advent_of_code_2021/day9/input.txt")

    @Test
    fun solutionA() {
        assertEquals(15, day9.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(1134, day9.solutionB())
    }

    @Test
    fun testFindLowPoints_shouldReturnListOfAllLowPointsOfMatrix() {
        val expectedResult = listOf(
            Pair(0,1), Pair(0, 9),
            Pair(2, 2), Pair(4, 6))

        assertEquals(expectedResult, day9.findLowPoints(day9.input))
    }

    @Test
    fun testCheckLowPoint_shouldReturnTrueIfPointIsLowerThanSurroundingNumbers() {
        val expectedValidLowPoint = Pair(0, 1)
        val expectedInvalidLowPoint = Pair(0,2)

        assertTrue(day9.checkLowPoint(expectedValidLowPoint.first, expectedValidLowPoint.second, day9.input))
        assertFalse(day9.checkLowPoint(expectedInvalidLowPoint.first, expectedInvalidLowPoint.second, day9.input))
    }

    @Test
    fun testCheckNeighbors_shouldReturnListOfAllNeighborsOfPointThatAreHigherAndNot9() {
        val expectedResult1 = listOf(Pair(1, 0))
        val expectedResult2 = listOf(Pair(1, 2), Pair(3, 2), Pair(2, 1), Pair(2, 3))
        val expectedResult3 = listOf(Pair(3, 6), Pair(4, 5), Pair(4,7))

        assertEquals(expectedResult1, day9.checkNeighbors(0,0, day9.input))
        assertEquals(expectedResult2, day9.checkNeighbors(2,2, day9.input))
        assertEquals(expectedResult3, day9.checkNeighbors(4, 6, day9.input))
        assertEquals(emptyList<Int>(), day9.checkNeighbors(4, 1, day9.input))
    }

    @Test
    fun testMapOutBasinsRecursive_shouldReturnSetOfVisitedPointsAfterMappingOutBasinFromEnteredStartingPoint() {
        val expectedSet1 = setOf(Pair(0,0), Pair(1,0))
        val expectedSet2 = setOf(Pair(0,8), Pair(0,7),Pair(0,6), Pair(0,5), Pair(1,6), Pair(1,8), Pair(1,9), Pair(2,9))

        assertEquals(expectedSet1, day9.mapOutBasinsRecursive(0, 1, mutableSetOf(), day9.checkNeighbors(0, 1, day9.input)))
        assertEquals(expectedSet2, day9.mapOutBasinsRecursive(0, 9, mutableSetOf(), day9.checkNeighbors(0, 9, day9.input)))
    }
}