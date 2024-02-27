package advent_of_code_2020.day5


import java.io.File

fun main() {
    val day5 = Day5()

    val inputList = day5.readFileToList()
    println("Solution A: ${day5.solutionA(inputList)}")
    println("Solution B: ${day5.solutionB(inputList)}")
}

class Day5 {
    fun readFileToList(path: String = "src/advent_of_code_2020/day5/input.txt"): List<String> = File(path).readLines()
    fun solutionA(list: List<String>): Int {
        val rowRange = Pair(0, 127)
        val colRange = Pair(0, 7)
        list.all loop@{ line ->
            line.all {
                when(it) {
                    'F' -> rowRange.second -= Math.floor((rowRange.second - rowRange.first) / 2).toInt()
                    'B' -> rowRange.first += Math.ceil((rowRange.second - rowRange.first) / 2).toInt()
                    'L' -> colRange.second -= Math.floor((colRange.second - colRange.first) / 2).toInt()
                    else -> colRange.first += Math.ceil((colRange.second - colRange.first) / 2).toInt()
                }
            }
        }
    }

    fun solutionB(list: List<String>): Int {
        return 0;
    }
 }