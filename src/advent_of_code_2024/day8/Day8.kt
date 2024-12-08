package advent_of_code_2024.day8


import java.io.File


class Day8(path: String = "./src/advent_of_code_2024/day8/input.txt") {
    val input = File(path).readLines().map { it.toCharArray() }

    fun solutionA(): Int {
        val workingInput = input.map { it.copyOf() }.toMutableList()

        processAntennaPoints { point, otherPoint, _ ->
            val counterPoint = point.getCounterPoint(otherPoint)
            if (!isOutOfBounds(counterPoint)) {
                workingInput[counterPoint.first][counterPoint.second] = MARKED
            }
        }

        return workingInput.sumOf { it.count { c -> c == MARKED } }
    }

    fun solutionB(): Int {
        val workingInput = input.map { it.copyOf() }.toMutableList()

        processAntennaPoints { point, _, diff ->
                var current = point
                while (!isOutOfBounds(current)) {
                    workingInput[current.first][current.second] = MARKED
                    current = Pair(current.first + diff.first, current.second + diff.second)
            }
        }

        return workingInput.sumOf { it.count { c -> c != EMPTY } }
    }

    private fun processAntennaPoints(
        action: (point: Pair<Int, Int>, otherPoint: Pair<Int, Int>, diff: Pair<Int, Int>) -> Unit
    ) {
        findAntennaPoints().values.forEach { antennaGroup ->
            antennaGroup.forEach { point ->
                antennaGroup.filter { it != point }.forEach { otherPoint ->
                    val diff = point.getDiffPoint(otherPoint)
                    action(point, otherPoint, diff,)
                }
            }
        }
    }

    private fun findAntennaPoints(): Map<Char, Set<Pair<Int, Int>>> {
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
        return Pair(this.first * 2 - other.first, this.second * 2 - other.second)
    }

    private fun Pair<Int, Int>.getDiffPoint(other: Pair<Int, Int>): Pair<Int, Int> {
        return Pair((this.first - other.first), (this.second - other.second))
    }

    companion object {
        const val EMPTY = '.'
        const val MARKED = '#'
    }
}

fun main() {
    val day8 = Day8()

    println("SolutionA: ${day8.solutionA()}")
    println("SolutionB: ${day8.solutionB()}")
}
