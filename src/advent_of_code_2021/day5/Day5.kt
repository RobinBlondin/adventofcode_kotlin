package advent_of_code_2021.day5

import java.io.File

class Day5(path: String = "./src/advent_of_code_2021/day5/input.txt") {
    val input = File(path).readLines().map { it.replace(" -> ", ",").split(",").map(String::toInt) }
    private val points = input.map {
        Pair(Pair(it[0], it[1]), Pair(it[2], it[3]))
    }
    private var matrix = List(1000) {MutableList(1000) {0} }


    fun solutionA(): Int {
        val points = points.filter { it.first.first == it.second.first || it.first.second == it.second.second }

        for (point in points) {
            val x1 = minOf(point.first.first, point.second.first)
            val x2 = maxOf(point.first.first, point.second.first)
            val y1 = minOf(point.first.second, point.second.second)
            val y2 = maxOf(point.first.second, point.second.second)

            for(i in y1.. y2)  {
                for (j in x1 ..x2) {
                    matrix[i][j] += 1
                }
            }
        }
        return matrix.sumOf { it.count { number -> number >= 2 } }
    }

    fun solutionB(): Int {
        matrix = List(1000) { MutableList(1000) {0} }
        for (point in points) {
            val startPoint = point.first
            val endPoint = point.second

            var (x, y) = startPoint
            while (x != endPoint.first || y != endPoint.second) {
                matrix[x][y]++
                if (x < endPoint.first) x++
                else if (x > endPoint.first) x--
                if (y < endPoint.second) y++
                else if (y > endPoint.second) y--
            }
            matrix[x][y]++
        }
        return matrix.sumOf { it.count { number -> number > 1 } }
    }
}

fun main() {
    val day5 = Day5()
    println("Solution A: ${day5.solutionA()}")
    println("Solution B: ${day5.solutionB()}")
}