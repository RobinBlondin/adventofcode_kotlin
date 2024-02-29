package advent_of_code_2020.day7

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day7Test {

    private val a = Day7("test/advent_of_code_2020/day7/input.txt")
    private val b = Day7("test/advent_of_code_2020/day7/inputForB.txt")


    @Test
    fun solutionA() {
        assertEquals(4, a.solutionA())
    }

    @Test
    fun solutionB() {
        assertEquals(126, b.solutionB())
    }
}