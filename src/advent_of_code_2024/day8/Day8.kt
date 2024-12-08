package advent_of_code_2024.day8

import enums.Direction
import java.io.File

class Day8(path: String = "./src/advent_of_code_2024/day8/input.txt") {
    val input = File(path).readLines().map { it.toCharArray() }

    fun solutionA(): Int {
        val map = collectAntennaPoints()

        return map.values.sumOf { value ->

            value.sumOf { point ->
                val filtered = value.filter { it != point }
                filtered.count { p ->
                    isOutOfBounds(point.getCounterPoint(p))}
            }
        }
    }

    fun solutionB(): Int {
        return 0
    }

    private fun collectAntennaPoints(): Map<Char, Set<Pair<Int, Int>>> {
        val map = mutableMapOf<Char, MutableSet<Pair<Int, Int>>>()
        for(i in input.indices) {
            for (j in input[i].indices) {
                val currentChar = input[i][j]
                if(currentChar != '.') {
                    map.getOrPut(currentChar) { mutableSetOf(i to j) }.add(i to j)
                }
            }
        }
        return map
    }

    private fun isOutOfBounds(point: Pair<Int, Int>): Boolean {
        return (point.first < 0 || point.first >= input.size || point.second < 0 || point.second >= input.first().size)
    }

    private fun Pair<Int, Int>.getCounterPoint(other: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(this.first + -other.first, this.second + -other.second)
    }

}

fun main() {
    val day8 = Day8()

    println("SolutionA: ${day8.solutionA()}")
    println("SolutionB: ${day8.solutionB()}")
}
