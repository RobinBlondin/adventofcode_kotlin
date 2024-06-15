package advent_of_code_2019.day3

import java.io.File
import kotlin.math.abs

class Day3(path: String = "./src/advent_of_code_2019/day3/input.txt") {
    val input = File(path).readLines()

    fun solutionA(): Int {
        val lines = drawLines(input)
        lines.forEach { println(it) }
        val crossings = lines[0].intersect(lines[1].toSet()).filter { it != Pair(0, 0) }
        return crossings.minOf { calculateDistance(it) }
    }

    fun solutionB(): Int {
        val lines = drawLines(input)
        val crossings = lines[0].intersect(lines[1].toSet()).filter { it != Pair(0, 0) }
        return crossings.minOf { crossing -> lines.sumOf { it.indexOfFirst { c -> c == crossing } } }
    }

    fun drawLines(input: List<String>): List<List<Pair<Int, Int>>>{
        val pointList = mutableListOf<MutableList<Pair<Int, Int>>>()
        for (line in input) {
            val list = mutableListOf<Pair<Int, Int>>()
            var centralPort = Pair(0, 0)
            for (command in line.split(",")) {
                val target = parseCommandToTargetPoint(centralPort, command)

                val iRange =
                    if (target.first < centralPort.first) centralPort.first  downTo target.first else centralPort.first ..target.first
                val jRange =
                    if (target.second < centralPort.second) centralPort.second  downTo target.second else centralPort.second ..target.second
                for (i in iRange) {
                    for (j in jRange) {
                        list.add(Pair(i, j))
                    }
                }
                centralPort = list.toList().last()
                list.removeLast()
            }
            pointList.add(list)
        }
        return pointList
    }

    fun parseCommandToTargetPoint(start: Pair<Int, Int>, command: String): Pair<Int, Int> {
        val direction = command.substring(0, 1)
        val steps = command.substring(1).toInt()

        return when (direction) {
            "R" -> Pair(start.first, start.second + steps)
            "L" -> Pair(start.first, start.second - steps)
            "U" -> Pair(start.first - steps, start.second)
            "D" -> Pair(start.first + steps, start.second)
            else -> start
        }
    }

    fun calculateDistance(endPoint: Pair<Int, Int>) = abs((minOf(0,endPoint.first) - maxOf(0, endPoint.first)) + minOf(0,endPoint.second) - maxOf(0, endPoint.second))
}

fun main() {
    val day3 = Day3()

    println("SolutionA: ${day3.solutionA()}")
    println("SolutionB: ${day3.solutionB()}")
}
