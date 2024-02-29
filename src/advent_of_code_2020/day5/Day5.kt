package advent_of_code_2020.day5


import java.io.File
import kotlin.math.ceil
import kotlin.math.floor

fun main() {
    val day5 = Day5()

    val inputList = day5.readFileToList()

    println("Solution A: ${day5.solutionA(inputList)}")
    println("Solution B: ${day5.solutionB(inputList)}")
}


class Day5(private val path: String = "src/advent_of_code_2020/day5/input.txt") {
    fun readFileToList(): List<Int> = File(path).readLines()
        .map { getSeatId(it) }
        .sorted()
    private fun getSeatId(code: String): Int {
        var rowStart = 0.0
        var rowEnd = 127.0
        var colStart = 0.0
        var colEnd = 7.0

        code.forEach {
            when (it) {
                'F' -> rowEnd -= floor((((rowEnd - rowStart) / 2)))
                'B' -> rowStart += ceil(((rowEnd - rowStart) / 2))
                'L' -> colEnd -= floor((((colEnd - colStart) / 2)))
                'R' -> colStart += ceil(((colEnd - colStart) / 2))
            }
        }
        return (rowStart * 8 + colStart).toInt()
    }
    fun solutionA(list: List<Int>): Int = list.max()
    fun solutionB(list: List<Int>): Int {
        return list.stream().filter { it + 1 !in list }.toList().first() + 1
    }
}