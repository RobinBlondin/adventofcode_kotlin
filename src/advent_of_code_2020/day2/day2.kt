package advent_of_code_2020.day2

import java.io.File

fun main() {
    val day2 = Day2()
    val path = "src/advent_of_code_2020/day2/input.txt"
    val inputList = day2.readFileToList(path)

    println("Solution A: ${day2.solutionA(inputList)}")
    println("Solution B: ${day2.solutionB(inputList)}")
}

class Day2 {
    fun readFileToList(path: String): List<String> = File(path).readLines()
    fun solutionA(inputList: List<String>): Int = inputList.count {
        val arr = it.split(": ", " ", "-")
        (arr[3].count { a -> a.toString() == arr[2] } in IntRange(arr[0].toInt(), arr[1].toInt()))
    }

    fun solutionB(inputList: List<String>): Int = inputList.count {
        val arr = it.split(": ", " ", "-")
        (arr[3][arr[0].toInt() - 1].toString() == arr[2] && arr[3][arr[1].toInt() - 1].toString() != arr[2]) ||
                (arr[3][arr[1].toInt() - 1].toString() == arr[2] && arr[3][arr[0].toInt() - 1].toString() != arr[2])
    }
}