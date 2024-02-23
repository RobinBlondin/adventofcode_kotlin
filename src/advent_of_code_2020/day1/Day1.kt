package advent_of_code_2020.day1
import java.io.File

fun main() {
    val path = "src/advent_of_code_2020/day1/input.txt"
    val day1 = Day1()
    val inputList = day1.readFileToList(path)

    println("Solution A: ${day1.solutionA(inputList)}")
    println("Solution B: ${day1.solutionB(inputList)}")
}

class Day1 {
    fun readFileToList(path: String): List<Int> = File(path).readLines().map { it.toInt() }
    fun solutionA(inputList: List<Int>): Int {
        inputList.forEach { i ->
            inputList.subList(1, inputList.size).forEach { j ->
                if (i + j == 2020) return i * j
            }
        }
        return 0
    }

    fun solutionB(inputList: List<Int>): Int {
        inputList.forEach { i ->
            inputList.subList(1, inputList.size).forEach { j ->
                inputList.subList(2, inputList.size).forEach { k ->
                    if (i + j + k == 2020) return i * j * k
                }
            }
        }
        return 0
    }
}
