package advent_of_code_2024.day2

import java.io.File

class Day2(path: String = "./src/advent_of_code_2024/day2/input.txt") {
    val input = File(path).readLines()
        .map { it.split("\\s+".toRegex()).map(String::toInt) }

    fun solutionA(): Int = input.count { isSafeReport(it, false) }

    fun solutionB(): Int = input.count { isSafeReport(it, true) }

    private fun isSafeReport(list: List<Int>, dampenerActive: Boolean): Boolean {
        val ascending = list.first() < list.last()
        val range = 1..3

        for (i in 0 until list.size - 1) {
            val result = if (ascending) list[i + 1] - list[i] else list[i] - list[i + 1]

            if (result !in range) {
                return if(dampenerActive) isSafeAfterDampened(list, i) else false
            }
        }
        return true
    }

    private fun List<Int>.removeElementByIndex(index: Int): List<Int> = filterIndexed { i, _ -> i != index }

    private fun isSafeAfterDampened(list: List<Int>, index: Int): Boolean {
        val currentIndexRemoved = list.removeElementByIndex(index)
        val nextIndexRemoved = list.removeElementByIndex(index + 1)

        return isSafeReport(currentIndexRemoved, false) || isSafeReport(nextIndexRemoved, false)
    }

}

fun main() {
    val day2 = Day2()

    println("SolutionA: ${day2.solutionA()}")
    println("SolutionB: ${day2.solutionB()}")
}
