package advent_of_code_2016.day3

import java.io.File

class Day3(path: String = "./src/advent_of_code_2016/day3/input.txt") {
    val input = File(path).readLines().map { it.trim().split(Regex(" +")).map(String::toInt) }

    fun solutionA(): Int {
        return input.count { isTriangle(it) }
    }

    fun solutionB(): Int {
        val rotatedList = input[0].indices
            .flatMap { i ->
                input.map { it[i] }
            }.windowed(3, 3)

        return rotatedList.count { isTriangle(it) }
    }


    private fun isTriangle(sides: List<Int>): Boolean {
        return (sides[0] + sides[1] > sides[2]) && (sides[0] + sides[2] > sides[1]) && (sides[1] + sides[2] > sides[0])
    }
}

fun main() {
    val day3 = Day3()

    println("SolutionA: ${day3.solutionA()}")
    println("SolutionB: ${day3.solutionB()}")
}
