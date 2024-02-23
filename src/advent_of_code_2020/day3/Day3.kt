package advent_of_code_2020.day3

import java.io.File

fun main() {
    val day3 = Day3()
    val path = "src/advent_of_code_2020/day3/input.txt"
    val inputList = day3.readFileToList(path)
    println("Solution A: ${day3.solutionA(inputList)}")
    println("Solution B: ${day3.solutionB(inputList)}")
}

class Day3 {
    fun readFileToList(path: String): List<String> = File(path).readLines()


    fun solutionA(inputList: List<String>): Int {
        var count = 0
        var incr = 0
        for (i in inputList.indices) {
            if (inputList[i][incr] == '#') count++
            incr = (incr + 3) % (inputList[i].length)
        }
        return count
    }

    fun solutionB(inputList: List<String>): Long {
        val arr = listOf(1, 3, 5, 7, 1)
        var result: Long = 1
        var steps = 1

        for (j in 0..4) {
            var count = 0
            var incr = 0
            for (i in inputList.indices step steps) {
                if (inputList[i][incr] == '#') count++
                incr = (incr + arr[j]) % (inputList[i].length)
            }
            result *= count
            if (j == 3) steps++
        }
        return result
    }
}