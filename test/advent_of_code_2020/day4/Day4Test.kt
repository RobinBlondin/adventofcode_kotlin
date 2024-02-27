package advent_of_code_2020.day4
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day4Test {

    @Test
    fun testSolution(): Unit {
        val day4 = Day4()
        val pathA = "test/advent_of_code_2020/day4/inputA.txt"
        val pathB = "test/advent_of_code_2020/day4/validInputs.txt"
        val pathB2 = "test/advent_of_code_2020/day4/invalidInputs.txt"

        val inputListA = day4.readFileToList(pathA)
        val validInputs = day4.parseList(day4.readFileToList(pathB))
        val invalidInputs = day4.parseList(day4.readFileToList(pathB2))

        assertEquals(2, day4.solutionA(inputListA))
        assertEquals(4, day4.solutionB(validInputs))
        assertEquals(0, day4.solutionB(invalidInputs))
    }
}