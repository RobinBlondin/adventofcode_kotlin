package advent_of_code_2024.day4

import java.io.File

class Day4(path: String = "./src/advent_of_code_2024/day4/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { c -> c.toString() } }

    fun solutionA(): Int {
        var sum = 0
        for(y in input.indices) {
            for(x in input[y].indices) {
                sum += xmasFinder(x, y, 0, 0)
            }
        }
        return sum
    }

    fun solutionB(): Int {
        var sum = 0
        for(y in input.indices) {
            for(x in input[y].indices) {
                val current = input[y][x]
                if(current == "A") {
                    sum += xmasChecker(x, y)
                }
            }
        }
        return sum
    }

    private fun xmasFinder(x: Int, y: Int, letterIndex: Int, direction: Int): Int {
        val letters = listOf("X", "M", "A", "S")

        if (isOutOfBounds(y, x))
            return 0

        if (input[y][x] != letters[letterIndex])
            return 0

        if (letterIndex == letters.size - 1)
            return 1

        return when (direction) {
            1 -> xmasFinder(x - 1, y, letterIndex + 1, 1)
            2 -> xmasFinder(x + 1, y, letterIndex + 1, 2)
            3 -> xmasFinder(x, y - 1, letterIndex + 1, 3)
            4 -> xmasFinder(x, y + 1, letterIndex + 1, 4)
            5 -> xmasFinder(x - 1, y - 1, letterIndex + 1, 5)
            6 -> xmasFinder(x - 1, y + 1, letterIndex + 1, 6)
            7 -> xmasFinder(x + 1, y - 1, letterIndex + 1, 7)
            8 -> xmasFinder(x + 1, y + 1, letterIndex + 1, 8)
            else -> {
                xmasFinder(x - 1, y, letterIndex + 1, 1) +
                xmasFinder(x + 1, y, letterIndex + 1, 2) +
                xmasFinder(x, y - 1, letterIndex + 1, 3) +
                xmasFinder(x, y + 1, letterIndex + 1, 4) +
                xmasFinder(x - 1, y - 1, letterIndex + 1, 5) +
                xmasFinder(x - 1, y + 1, letterIndex + 1, 6) +
                xmasFinder(x + 1, y - 1, letterIndex + 1, 7) +
                xmasFinder(x + 1, y + 1, letterIndex + 1, 8)
            }
        }
    }

    private fun isOutOfBounds(x: Int, y: Int): Boolean {
        return (y < 0 || y >= input.size) || (x < 0 || x >= input.first().size)
    }

    private fun xmasChecker(x: Int, y: Int): Int {
        if(isOutOfBounds(x - 1, y -1) || isOutOfBounds(x + 1, y + 1) || isOutOfBounds(x - 1, y + 1) || isOutOfBounds(x - 1, y + 1))
            return 0

        val str1 = (input[y][x] + input[y - 1][x - 1] + input[y + 1][x + 1]).toSortedSet().joinToString("")
        val str2 = (input[y][x] + input[y - 1][x + 1] + input[y + 1][x - 1]).toSortedSet().joinToString("")

        return if(str1 == str2 && str1 == "AMS") 1 else 0
    }
}

fun main() {
    val day4 = Day4()

    println("SolutionA: ${day4.solutionA()}")
    println("SolutionB: ${day4.solutionB()}")
}
