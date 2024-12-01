package advent_of_code_2024.day1

import java.io.File
import kotlin.math.absoluteValue

class Day1(path: String = "./src/advent_of_code_2024/day1/input.txt") {
    private val pairOfLists: Pair<List<Long>, List<Long>> = File(path)
        .readLines()
        .map { it.split("\\s+".toRegex()).map { num -> num.toLong() } }
        .flatten()
        .splitAndSort()

    fun solutionA(): Long = pairOfLists.first
        .withIndex()
        .sumOf { (index, num) ->
            val num2 = pairOfLists.second[index]
            (num - num2).absoluteValue
        }

    fun solutionB(): Long = pairOfLists.first
        .sumOf { num ->
            val countInRightList = pairOfLists.second.count { num2 -> num == num2 }
            num * countInRightList
        }

    private fun List<Long>.splitAndSort(): Pair<List<Long>, List<Long>> {
        val first = this.filterIndexed { index, _ -> index % 2 == 0 }.sorted()
        val second = this.filterIndexed { index, _ -> index % 2 != 0 }.sorted()

        return Pair(first, second)
    }
}

fun main() {
    val day1 = Day1()

    println("SolutionA: ${day1.solutionA()}")
    println("SolutionB: ${day1.solutionB()}")
}
