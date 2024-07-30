package advent_of_code_2018.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2Test {
    private val day2a = Day2("./test/advent_of_code_2018/day2/inputA.txt")
    private val day2b = Day2("./test/advent_of_code_2018/day2/inputB.txt")

    @Test
    fun solutionA() {
        assertEquals(12, day2a.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals("fgij", day2b.solutionB())
    }
}