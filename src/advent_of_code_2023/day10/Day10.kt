package advent_of_code_2023.day10

import java.io.File
import kotlin.streams.toList

fun main() {
    val day10 = Day10()
    val path = "src/advent_of_code_2023/day10/input.txt"
    val inputList = day10.readFileToList(path)
    val start = day10.findStart(inputList)
    day10.findMatchingPipe(start, inputList, start, day10.findFirst(start, inputList), 0 )
}

class Pipe(val type: Char, val dir: Pair<Direction, Direction>)
enum class Direction(val value: Int) {
    NORTH(-1), SOUTH(1), WEST(-1), EAST(1)
}
class Day10 {
    private fun Pipe.isMatch(other: Pipe): Boolean {
        return this.dir.first.value - other.dir.second.value == 0 || this.dir.second.value - other.dir.first.value == 0
    }

    private val pipes = mapOf(
        ('|' to Pipe('|', Pair(Direction.NORTH, Direction.SOUTH))),
        ('-' to Pipe('-', Pair(Direction.EAST, Direction.WEST))),
        ('L' to Pipe('L', Pair(Direction.NORTH, Direction.EAST))),
        ('J' to Pipe('J', Pair(Direction.NORTH, Direction.WEST))),
        ('7' to Pipe('7', Pair(Direction.SOUTH, Direction.WEST))),
        ('F' to Pipe('F', Pair(Direction.EAST, Direction.SOUTH))),
        ('S' to Pipe('S', Pair(Direction.EAST, Direction.SOUTH))))

    fun readFileToList(path: String): List<List<Char>> = File(path).readLines().stream().map { it.toCharArray().toList() }.toList()

    fun findStart(list: List<List<Char>>): Pair<Int, Int> {
        for (i in list.indices) {
            if (list[i].contains('S')) {
                return Pair(i, list[i].indexOf('S'))
            }
        }
        return Pair(0, 0)
    }

    fun findFirst(start: Pair<Int, Int>, list: List<List<Char>>): Pair<Int, Int> {
        val startPipe = pipes[list[start.first][start.second]]
        println("startPipe: $startPipe")
        val north: Pipe? = pipes[list.getOrNull(start.first-1)?.getOrNull(start.second)]
        val south: Pipe? = pipes[list.getOrNull(start.first+1)?.getOrNull(start.second)]
        val west: Pipe? = pipes[list.getOrNull(start.first)?.getOrNull(start.second - 1)]
        val east: Pipe? = pipes[list.getOrNull(start.first)?.getOrNull(start.second + 1)]


        if (startPipe != null) {
            println("in null check")
            return if (north != null && startPipe.isMatch(north)) Pair(start.first - 1, start.second)
            else if (south != null && startPipe.isMatch(south)) Pair(start.first + 1, start.second)
            else if (west != null && startPipe.isMatch(west)) Pair(start.first, start.second - 1)
            else Pair(start.first, start.second + 1)
        }
        return Pair(0, 0)
    }

    private fun findNext(last: Pair<Int, Int>, current: Pair<Int, Int>, list: List<List<Char>>): Pair<Int, Int> {
        val lastPipe = pipes[list[last.first][last.second]]
        val currentPipe = pipes[list[current.first][current.second]]
        val lastDir = if ((lastPipe?.dir?.first?.value ?: 0) - (currentPipe?.dir?.second?.value ?: 0) == 0) currentPipe?.dir?.second else currentPipe?.dir?.first
        println(lastDir)
        return when (lastDir) {
            Direction.NORTH -> Pair(current.first - 1, current.second)
            Direction.SOUTH -> Pair(current.first + 1, current.second)
            Direction.WEST -> Pair(current.first, current.second - 1)
            Direction.EAST -> Pair(current.first, current.second + 1)
            null -> Pair(0, 0)
        }
    }
    fun findMatchingPipe(start: Pair<Int, Int>, list: List<List<Char>>, last: Pair<Int, Int>, current: Pair<Int, Int>, count: Int) {
        println(list[current.first][current.second])
        if (current == start) println(count / 2)
        val next = findNext(last, current, list)
        findMatchingPipe(start, list, current, next, count + 1)
    }
}