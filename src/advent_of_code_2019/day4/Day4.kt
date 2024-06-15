package advent_of_code_2019.day4

import java.io.File

class Day4(path: String = "./src/advent_of_code_2019/day4/input.txt") {
    val range = File(path).readLines().map { line ->
        val (start, end) = line.split("-").map { it.toInt() }
        IntRange(start, end)
    }[0]

    fun solutionA(): Int = range.count { hasDuplicateDigitsA(it) && hasIncreasingDigits(it) }

    fun solutionB(): Int = range.count { hasDuplicateDigitsB(it) && hasIncreasingDigits(it) }

    fun hasDuplicateDigitsA(number: Int): Boolean = number.toString().toList().size != number.toString().toSet().size

    fun hasDuplicateDigitsB(number: Int): Boolean {
        val digitArray = number.toString().toCharArray().toList()
        val duplicateCount = digitArray.groupingBy { it }.eachCount()
        return duplicateCount.containsValue(2)
    }

    fun hasIncreasingDigits(number: Int): Boolean {
        val digitArray = number.toString().toCharArray()
        for (i in digitArray.indices) {
            for (j in i+1 until digitArray.size) {
                if(digitArray[j] < digitArray[i]) return false
            }
        }
        return true
    }
}

fun main() {
    val day4 = Day4()

    println("SolutionA: ${day4.solutionA()}")
    println("SolutionB: ${day4.solutionB()}")
}
