package advent_of_code_2021.day2

import java.io.File
import kotlin.math.abs

class Day2(path: String = "./src/advent_of_code_2021/day2/input.txt") {
    val input = File(path).readLines().map { it.split(" ") }

    fun solutionA(): Int {
        val horizontal = input.filter { it[0] == "forward" }.sumOf { instruction ->
            instruction[1].toInt()
        }
        val vertical = input.filter { it[0] != "forward" }.sumOf { instruction ->
            if (instruction[0] == "up") {
                -abs(instruction[1].toInt())
            }
            else instruction[1].toInt()
        }
        return vertical * horizontal
    }

    fun solutionB(): Int {
        var aim = 0
        var horizontal = 0
        var vertical = 0

        for (list in input) {
            val instruction = list[0]
            val value = if(instruction == "up") -abs(list[1].toInt()) else list[1].toInt()

            if(instruction == "up" || instruction == "down") {
                aim += value
            } else if (instruction == "forward") {
                horizontal += value
                vertical += value * aim
            }
        }
        return vertical * horizontal
    }
}

fun main() {
    val day2 = Day2()

    println("SolutionA: ${day2.solutionA()}")
    println("SolutionB: ${day2.solutionB()}")
}