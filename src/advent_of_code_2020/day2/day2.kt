package advent_of_code_2020.day2

import java.io.File

fun main() {
    val day2 = Day2()

    println("Solution A: ${day2.solutionA()}")
    println("Solution B: ${day2.solutionB()}")
}

class Day2(val path: String = "src/advent_of_code_2020/day2/input.txt") {
    val list = File(path).readLines()
    fun solutionA(): Int = list.count {
        val arr = it.split(": ", " ", "-")
        (arr[3].count { a -> a.toString() == arr[2] } in IntRange(arr[0].toInt(), arr[1].toInt()))
    }

    fun solutionB(): Int = list.count {
        val arr = it.split(": ", " ", "-")
        (arr[3][arr[0].toInt() - 1].toString() == arr[2] && arr[3][arr[1].toInt() - 1].toString() != arr[2]) ||
                (arr[3][arr[1].toInt() - 1].toString() == arr[2] && arr[3][arr[0].toInt() - 1].toString() != arr[2])
    }
}