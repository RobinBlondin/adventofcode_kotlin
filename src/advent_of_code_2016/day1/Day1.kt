package advent_of_code_2016.day1

import java.io.File
import java.util.Queue
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt

class Day1(path: String = "./src/advent_of_code_2016/day1/input.txt") {
    val input = File(path).readLines()[0].split(", ").map { Pair(it.substring(0, 1), it.substring(1).toInt()) }

    fun solutionA(): Int {
        var x = 0
        var y = 0
        val direction = Direction()

        input.forEach { (way, steps) ->
            direction.turn(way)

            when(direction.current) {
                Way.NORTH -> y += steps
                Way.EAST -> x += steps
                Way.SOUTH -> y -= steps
                Way.WEST -> x -= steps
            }
        }
        return calculateDistanceBetweenPoints(Pair(x, y))
    }

    fun solutionB(): Int {
        val points = mutableListOf<Pair<Int, Int>>()
        var x = 0
        var y = 0
        val direction = Direction()

        for((way, steps) in input) {
            direction.turn(way)

            when(direction.current) {
                Way.NORTH -> {
                    (y + 1..y + steps).forEach { points.add(Pair(x, it)) }
                    y += steps
                }
                Way.EAST -> {
                    (x + 1..x + steps).forEach { points.add(Pair(it, y)) }
                    x += steps
                }
                Way.SOUTH -> {
                    (y - 1 downTo  y - steps).forEach { points.add(Pair(x, it)) }
                    y -= steps
                }
                Way.WEST -> {
                    (x - 1 downTo x - steps).forEach { points.add(Pair(it, y)) }
                    x -= steps
                }
            }
        }
        val seenPairs = mutableSetOf<Pair<Int, Int>>()
        val firstDuplicate = points.firstOrNull { !seenPairs.add(it) }
        return calculateDistanceBetweenPoints(firstDuplicate!!)
    }

    private fun calculateDistanceBetweenPoints(endPoint: Pair<Int, Int>): Int {
        return (endPoint.first.absoluteValue + endPoint.second.absoluteValue)
    }
}

fun main() {
    val day1 = Day1()

    println("SolutionA: ${day1.solutionA()}")
    println("SolutionB: ${day1.solutionB()}")
}
