package advent_of_code_2021.day9

import java.io.File

class Day9(path: String = "./src/advent_of_code_2021/day9/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { digit -> digit.toString().toInt() } }
    val points = mutableListOf<Pair<Int, Int>>()

    fun solutionA(): Int {
        var sum = 0
        for((i, row) in input.withIndex()) {
            for((j, col) in input[i].withIndex()) {
                if (checkLowPoint(i, j)) {
                    points.add(Pair(i, j))
                    sum += input[i][j] + 1
                }
            }
        }
        return sum
    }

    fun solutionB(): Int {
        return 0
    }

    fun recursive(acc: Int, i: Int, j: Int, lastElement: Int): Int {
        if(i == 0)
        val currentElement = input[i]
        if(lastElement == 9 or lastElement <)
    }

    fun checkLowPoint(indexA: Int, indexB: Int): Boolean {
        val current = input[indexA][indexB]
        val around = listOf(
            if(indexA > 0) input[indexA - 1][indexB] else current + 1,
            if(indexA < input.size - 1) input[indexA + 1][indexB] else current + 1,
            if(indexB > 0 ) input[indexA][indexB - 1] else current + 1,
            if(indexB < input[0].size - 1) input[indexA][indexB + 1] else current + 1)

        return around.all { it > input[indexA][indexB] }
    }
}

fun main() {
    val day9 = Day9()

    println("SolutionA: ${day9.solutionA()}")
    println("SolutionB: ${day9.solutionB()}")
}
