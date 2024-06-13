package advent_of_code_2019.day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2Test {
    val day2 = Day2("./test/advent_of_code_2019/day2/input.txt")
    @Test
    fun testAddOperation() {
        val inputCopy = day2.input.toMutableList()
        val expectedList = listOf(1,9,10,70, 2,3,11,0, 99, 30,40,50)

        day2.addOperation(0, inputCopy)
        assertEquals(expectedList, inputCopy)
    }

    @Test
    fun testMultiplyOperation() {
        val inputCopy = day2.input.toMutableList()
        val expectedList = listOf(150 ,9,10,3, 2,3,11,0, 99, 30,40,50)

        day2.multiplyOperation(4, inputCopy)
        assertEquals(expectedList, inputCopy)
    }

    @Test
    fun testSelectedOperation() {
        assertTrue(day2.selectOperation(0, day2.input.toMutableList()))
        assertTrue(day2.selectOperation(4, day2.input.toMutableList()))
        assertFalse(day2.selectOperation(8, day2.input.toMutableList()))
    }

    @Test
    fun testExecute() {
        val inputCopy = day2.input.toMutableList()
        val expectedResult = 3500
        val result = day2.execute(inputCopy, 9, 10)

        assertEquals(expectedResult, result)
    }
}