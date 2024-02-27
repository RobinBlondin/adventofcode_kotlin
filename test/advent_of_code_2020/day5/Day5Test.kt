package advent_of_code_2020.day5

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class Day5Test {
    private val day5 = Day5()
    private val list = day5.readFileToList("test/advent_of_code_2020/day5/input.txt")
    @Test
    fun solutionA() {
        assertEquals(820, day5.solutionA(list))
    }
}