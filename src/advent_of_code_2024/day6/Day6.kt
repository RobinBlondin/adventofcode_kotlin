package advent_of_code_2024.day6

import enums.Direction
import java.io.File

class Day6(path: String = "./src/advent_of_code_2024/day6/input.txt") {
    val input = File(path).readLines().map { it.toCharArray() }
    private val startingPoint = setStartingPoint()

    fun solutionA(): Int = mapPatrolPath(input).size

    fun solutionB(): Int =
            mapPatrolPath(input).count {
                val copy = input.map { list -> list.copyOf() }
                copy[it.first][it.second] = '#'
                mapPatrolPath(copy).isEmpty()
            }

    private fun mapPatrolPath(matrix: List<CharArray>): Set<Pair<Int, Int>> {
        var currentPoint = startingPoint
        var direction = Direction.NORTH
        val visited = mutableSetOf(startingPoint)
        var count = 0

        while (!isNextMoveOutOfBounds(currentPoint, direction, matrix)) {
            if(count == 1000) {
                return setOf()
            }

            while (isNextMoveObstruction(currentPoint, direction, matrix)) {
                direction = nextDirection(direction)
            }

            currentPoint = when (direction) {
                Direction.NORTH -> Pair(currentPoint.first - 1, currentPoint.second)
                Direction.SOUTH -> Pair(currentPoint.first + 1, currentPoint.second)
                Direction.EAST -> Pair(currentPoint.first, currentPoint.second + 1)
                else -> Pair(currentPoint.first, currentPoint.second - 1)
            }

            if(visited.contains(currentPoint)) {
                count++
            } else {
                count = 0
                visited.add(currentPoint)
            }
        }
        return visited
    }

    private fun isOutOfBounds(point: Pair<Int, Int>, matrix: List<CharArray>): Boolean {
        return point.first < 0 || point.first > matrix.size - 1 || point.second < 0 || point.second > matrix.first().size - 1
    }

    private fun isNextMoveOutOfBounds(point: Pair<Int, Int>, direction: Direction, matrix: List<CharArray>): Boolean {
        return when (direction) {
            Direction.NORTH -> isOutOfBounds(Pair(point.first - 1, point.second), matrix)
            Direction.SOUTH -> isOutOfBounds(Pair(point.first + 1, point.second), matrix)
            Direction.EAST -> isOutOfBounds(Pair(point.first, point.second + 1), matrix)
            else -> isOutOfBounds(Pair(point.first, point.second - 1), matrix)
        }
    }

    private fun isNextMoveObstruction(point: Pair<Int, Int>, direction: Direction, matrix: List<CharArray>): Boolean {
        val y = point.first
        val x = point.second

        val nextMove = when (direction) {
            Direction.NORTH -> matrix[y - 1][x]
            Direction.SOUTH -> matrix[y + 1][x]
            Direction.EAST -> matrix[y][x + 1]
            Direction.WEST -> matrix[y][x - 1]
            else -> matrix[y][x]
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
