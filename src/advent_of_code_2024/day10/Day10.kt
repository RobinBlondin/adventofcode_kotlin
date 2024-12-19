package advent_of_code_2024.day10

import java.io.File

class Day10(path: String = "./src/advent_of_code_2024/day10/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { ch -> ch.digitToInt() }.toList() }
    val set = mutableSetOf<Pair<Int, Int>>()
    var sum = 0

    fun solutionA(): Int = countTrails(set)

    fun solutionB(): Int = sum

    private fun <T> countTrails(set: MutableSet<T>): Int {
        var sum = 0
        input.forEachIndexed { y, row ->
            row.forEachIndexed { x, ch ->
                if (ch == 0) {
                    findAllTrails(Pair(y, x))
                    sum += set.size
                    set.clear()
                }
            }
        }
        return sum
    }

    private fun findAllTrails(current: Pair<Int, Int>) {
        if (input[current.first][current.second] == 9) {
            set.add(current)
            sum++
            return
        }

        val trails = getDirections(current)

        if (trails.isEmpty()) {
            return
        }

        trails.forEach { trail -> findAllTrails(trail) }
    }

    private fun getDirections(pair: Pair<Int, Int>): Set<Pair<Int, Int>> {
        val list = listOf(
            Pair(pair.first - 1, pair.second),
            Pair(pair.first + 1, pair.second),
            Pair(pair.first, pair.second + 1),
            Pair(pair.first, pair.second - 1)
        ).filter {
            !isPointOutOfBounds(it) &&
                    (input[it.first][it.second] == input[pair.first][pair.second] + 1)
        }

        return list.toSet()
    }


    private fun isPointOutOfBounds(pair: Pair<Int, Int>): Boolean {
        return pair.first < 0 || pair.second < 0 || pair.first >= input.size || pair.second >= input.first().size
    }
}

fun main() {
    val day10 = Day10()

    println("SolutionA: ${day10.solutionA()}")
    println("SolutionB: ${day10.solutionB()}")
}
