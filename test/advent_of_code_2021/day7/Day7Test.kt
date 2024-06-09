package advent_of_code_2021.day7

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day7Test {
    private val day7 = Day7("./test/advent_of_code_2021/day7/input.txt")
    @Test
    fun solutionA() {
        assertEquals(37, day7.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(168, day7.solutionB())
    }

    @Test
    fun alignCrabs_shouldReturnFuelCostPerMoveBasedOnPart() {
        val first = day7.alignCrabs(day7.input, 2, "first")
        val second = day7.alignCrabs(day7.input, 2, "second")
        val second2 = day7.alignCrabs(day7.input, 5, "second")


        val expectedResultFirst = 37
        val expectedResultSecond = 206
        val expectedResultSecond2 = 168

        assertEquals(expectedResultFirst, first)
        assertEquals(expectedResultSecond, second)
        assertEquals(expectedResultSecond2, second2)



    }

    @Test
    fun returnSumOfSteps_shouldReturnSumOf_1_to_n() {
        val from = 16
        val to = 5
        val expectedResult = 66

        assertEquals(expectedResult, day7.returnSumOfSteps(from, to))
    }

    @Test
    fun findAlignWithLowestFuelCost_shouldReturnLowestFuelCostBasedOnPart() {
        val lowestFuelCostFirstPart = day7.findAlignWithLowestFuelCost(day7.input, "first")
        val lowestFuelCostSecondPart = day7.findAlignWithLowestFuelCost(day7.input, "second")
        val expectedResultFirst = 37
        val expectedResultSecond = 168

        assertEquals(expectedResultFirst, lowestFuelCostFirstPart)
        assertEquals(expectedResultSecond, lowestFuelCostSecondPart)


    }
}