package advent_of_code_2023.day10

import enums.Direction
import java.io.File

class Day10(path: String = "./src/advent_of_code_2023/day10/input.txt") {
    private val input = File(path).readLines().map { it.toCharArray() }

    private val startingPoint = input.mapIndexed { i, row ->
        row.mapIndexed { j, c -> if (c == 'S') i to j else null }
    }.flatten().filterNotNull().first()

    private val pipeMap = mapOf(
        '|' to listOf(Direction.NORTH, Direction.SOUTH),
        '-' to listOf(Direction.WEST, Direction.EAST),
        'L' to listOf(Direction.NORTH, Direction.EAST),
        'J' to listOf(Direction.NORTH, Direction.WEST),
        '7' to listOf(Direction.SOUTH, Direction.WEST),
        'F' to listOf(Direction.SOUTH, Direction.EAST),
        'S' to listOf(Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST)
    )

    private val matchingPipes = mapOf(
        Direction.NORTH to Direction.SOUTH,
        Direction.SOUTH to Direction.NORTH,
        Direction.WEST to Direction.EAST,
        Direction.EAST to Direction.WEST
    )

    fun solutionA(): Int {
        println(startingPoint)
        return 0
    }

    fun solutionB(): Int {
        return 0
    }

    fun containsMatch(current: Char, next: Char): Boolean {
        if (!pipeMap.keys.contains(current) && !pipeMap.keys.contains(next)) {
            return false
        }

        val currentDirections = pipeMap[current] ?: emptyList()
        val nextDirections = pipeMap[next] ?: emptyList()

        for (direction in currentDirections) {
            if (nextDirections.contains(matchingPipes[direction])) {
                return true
            }
        }
        return false
    }

    fun traverseMap(startingPoint: Pair<Int, Int>, direction: Direction) {
        val inputCopy = input.map { it.copyOf() }
        var currentPoint = startingPoint
        var currentDirection = direction
        var nextPoint = currentPoint
        var nextDirection = currentDirection

        while (true) {

        }
    }

}


fun main() {
    val day10 = Day10()

    println("SolutionA: ${day10.solutionA()}")
    println("SolutionB: ${day10.solutionB()}")
}
