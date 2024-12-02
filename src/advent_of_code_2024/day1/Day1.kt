package advent_of_code_2024.day1

import java.io.File
import kotlin.math.absoluteValue

class Day1(path: String = "./src/advent_of_code_2024/day1/input.txt") {
    private val input = File(path)
        .readLines()
        .map {
            val (first, second) = it.split("\\s+".toRegex()).map { num -> num.toInt() }
            Pair(first, second)
        }

    private val left = input.map { it.first }.sorted()
    private val right = input.map { it.second }.sorted()

    fun solutionA(): Int = left.zip(right)
        .sumOf { (it.first - it.second).absoluteValue }

    fun solutionB(): Int = left.sumOf { num ->
            val countInRightList = right.count { num2 -> num == num2 }
            num * countInRightList
        }
}

fun main() {
    val day1 = Day1()

    println("SolutionA: ${day1.solutionA()}")
    println("SolutionB: ${day1.solutionB()}")
}
