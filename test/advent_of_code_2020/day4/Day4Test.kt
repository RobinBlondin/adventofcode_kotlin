package advent_of_code_2020.day4
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day4Test {

    @Test
    fun testSolution(): Unit {
        val first = Day4("test/advent_of_code_2020/day4/inputA.txt")
        val second1 = Day4("test/advent_of_code_2020/day4/validInputs.txt")
        val second2 = Day4("test/advent_of_code_2020/day4/invalidInputs.txt")

        val validInputs = second1.parseList()
        val invalidInputs = second2.parseList()

        assertEquals(2, first.solutionA())
        assertEquals(4, second1.solutionB(validInputs))
        assertEquals(0, second2.solutionB(invalidInputs))
    }
}