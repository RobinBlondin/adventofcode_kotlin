package advent_of_code_2024.day6

import enums.Direction
import java.io.File

class Day6(path: String = "./src/advent_of_code_2024/day6/input.txt") {
    val input = File(path).readLines().map { it.toCharArray() }
    private val startingPoint = setStartingPoint()

    fun solutionA(): Int = mapPatrolPath()
    
    fun solutionB(): Int {
        return 0
    }

    private fun mapPatrolPath(): Int {

        val visited = mutableSetOf(startingPoint)
        var currentPoint = startingPoint
        var direction = Direction.NORTH

        while(!isNextMoveOutOfBounds(currentPoint,direction)) {

            direction = if(isNextMoveObstruction(currentPoint, direction)) nextDirection(direction) else direction

            currentPoint = when(direction) {
                Direction.NORTH -> Pair(currentPoint.first - 1, currentPoint.second)
                Direction.SOUTH -> Pair(currentPoint.first + 1, currentPoint.second)
                Direction.EAST -> Pair(currentPoint.first, currentPoint.second + 1)
                else -> Pair(currentPoint.first, currentPoint.second - 1)
            }
            visited.add(currentPoint)
        }

        return visited.size
    }

    private fun isOutOfBounds(point: Pair<Int, Int>): Boolean {
        return point.first < 0 || point.first > input.size - 1 || point.second < 0 || point.second > input.first().size - 1
    }

    private fun isNextMoveOutOfBounds(point: Pair<Int, Int>, direction: Direction): Boolean {
        return when (direction) {
            Direction.NORTH -> isOutOfBounds(Pair(point.first - 1, point.second))
            Direction.SOUTH -> isOutOfBounds(Pair(point.first + 1, point.second))
            Direction.EAST -> isOutOfBounds(Pair(point.first, point.second + 1))
            else -> isOutOfBounds(Pair(point.first, point.second - 1))
        }
    }

    private fun isNextMoveObstruction(point: Pair<Int, Int>, direction: Direction): Boolean {
        val y = point.first
        val x = point.second

        val nextMove = when (direction) {
            Direction.NORTH -> input[y - 1][x]
            Direction.SOUTH -> input[y + 1][x]
            Direction.EAST -> input[y][x + 1]
            Direction.WEST -> input[y][x - 1]
            else -> input[y][x]
        }

        return nextMove == '#'
    }

    private fun nextDirection(direction: Direction): Direction {
        return when (direction) {
            Direction.NORTH -> Direction.EAST
            Direction.EAST -> Direction.SOUTH
            Direction.SOUTH -> Direction.WEST
            Direction.WEST -> Direction.NORTH
            else -> direction
        }
    }

    private fun setStartingPoint(): Pair<Int, Int> {
        for (i in input.indices) {
            for (j in input[i].indices) {
                if (input[i][j] == '^') {
                    return Pair(i, j)
                }
            }
        }
        return Pair(0, 0)
    }
}

fun main() {
    val day6 = Day6()

    println("SolutionA: ${day6.solutionA()}")
    println("SolutionB: ${day6.solutionB()}")
}
