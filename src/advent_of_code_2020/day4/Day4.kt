package advent_of_code_2020.day4

import java.io.File

fun main() {
    val day4 = Day4()
    val path = "src/advent_of_code_2020/day4/input.txt"
    val inputList = day4.readFileToList(path)
    println("Solution A: ${day4.solutionA(inputList)}")
    println("Solution B: ${day4.solutionB(inputList)}")
}

class Day4 {
    fun readFileToList(path: String): List<String> = File(path).readLines()

    fun solutionA(inputList: List<String>): Int {
        return 0
    }

    fun solutionB(inputList: List<String>): Int {
        return 0
    }
}