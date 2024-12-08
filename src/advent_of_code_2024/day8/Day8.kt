package advent_of_code_2024.day8


import java.io.File


class Day8(path: String = "./src/advent_of_code_2024/day8/input.txt") {
    val input = File(path).readLines().map { it.toCharArray() }

    fun solutionA(): Int {
        val map = collectAntennaPoints()
        val input = input.map { it.copyOf() }.toMutableList()

        map.values.forEach { value ->
            value.forEach { point ->
                val filtered = value.filter { it != point }
                filtered.forEach { p ->
                    val counterPoint = point.getCounterPoint(p)
                    if(!isOutOfBounds(counterPoint)) {
                        input[counterPoint.first][counterPoint.second] = '#'
                    }
                }
            }
        }
        return input.sumOf { it.count { c -> c == '#' } }
    }

    fun solutionB(): Int {
        val map = collectAntennaPoints()

        map.values.forEach { value ->
            value.forEach { point ->
                val filtered = value.filter { it != point }

                filtered.forEach { p ->
                    val diff = point.getDiffPoint(p)
                    var current = point

                    while(true) {
                        current = Pair(current.first + diff.first, current.second + diff.second)
                        if(isOutOfBounds(current)) {
                            break
                        }
                        input[current.first][current.second] = 'X'
                    }
                }
            }
        }
        return input.sumOf { it.count { c -> c != '.' } }
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
        return Pair((this.first + ( this.first - other.first)), (this.second + (this.second - other.second)))
    }

    private fun Pair<Int, Int>.getDiffPoint(other: Pair<Int, Int>): Pair<Int, Int> {
        return Pair((this.first - other.first), (this.second - other.second))
    }

}

fun main() {
    val day8 = Day8()

    println("SolutionA: ${day8.solutionA()}")
    println("SolutionB: ${day8.solutionB()}")
}
