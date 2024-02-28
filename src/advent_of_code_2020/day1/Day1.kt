package advent_of_code_2020.day1
import java.io.File

fun main() {
    val day1 = Day1()
    println("Solution A: ${day1.solutionA()}")
    println("Solution B: ${day1.solutionB()}")
}

class Day1(val path: String = "src/advent_of_code_2020/day1/input.txt") {

    val list = File(path).readLines().map { it.toInt() }
    fun solutionA(): Int {
        list.forEach { i ->
            list.subList(1, list.size).forEach { j ->
                if (i + j == 2020) return i * j
            }
        }
        return 0
    }

    fun solutionB(): Int {
        list.forEach { i ->
            list.subList(1, list.size).forEach { j ->
                list.subList(2, list.size).forEach { k ->
                    if (i + j + k == 2020) return i * j * k
                }
            }
        }
        return 0
    }
}
