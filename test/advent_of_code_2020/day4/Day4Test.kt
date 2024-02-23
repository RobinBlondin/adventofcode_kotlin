package advent_of_code_2020.day4
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day4Test {

    @Test
    fun testSolution(): Unit {
        val day4 = Day4()
        val path = "test/advent_of_code_2020/day4/input.txt"
        val inputList = day4.readFileToList(path)

        assertEquals(2, day4.solutionA(inputList))
        //assertEquals(336, day4.solutionB(inputList))
    }
}