package advent_of_code_2024.day1

import java.io.File
import kotlin.math.absoluteValue

class Day1(path: String = "./src/advent_of_code_2024/day1/input.txt") {
    val input = File(path).readLines().map {
        it.replace("\\s+".toRegex(), "-")
          .split("-")
          .map { num -> num.toInt() }
    }

    private val rotatedAndSorted = rotateMatrix(input).sortEach()

    fun solutionA(): Long {
        var sum = 0L
        rotatedAndSorted.first().forEachIndexed { index, num ->
            val num2 = rotatedAndSorted.last()[index]
            sum += (num - num2).absoluteValue
        }
        return sum
    }

    fun solutionB(): Long {
        var sum = 0L
        rotatedAndSorted.first().forEach { num ->
            val amountOfTimesInRightList = rotatedAndSorted.last().count {
                num2 -> num == num2
            }

            sum += num * amountOfTimesInRightList
        }
        return sum
    }

    private fun rotateMatrix(list: List<List<Int>>): List<List<Int>> {
        val first = list.flatten().filterIndexed { index, _ -> index % 2 == 0 }
        val second = list.flatten().filterIndexed { index, _ -> index % 2 != 0 }

        return listOf(first, second)
    }

    private fun List<List<Int>>.sortEach(): List<List<Int>> {
        return this.map { it.sorted() }.toList()
    }
}

fun main() {
    val day1 = Day1()

    println("SolutionA: ${day1.solutionA()}")
    println("SolutionB: ${day1.solutionB()}")
}
