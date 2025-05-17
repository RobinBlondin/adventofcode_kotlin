import java.io.File

class Day11(path: String = "./src/advent_of_code_2024/day11/input.txt") {
    private val input = File(path).readLines().map { it.split(" ").map(String::toLong) }.flatten()
    private val memo = mutableMapOf<Pair<Long, Int>, Long>() // Store the count of stones

    fun solutionA(): Long = input.sumOf { countStones(it, 25) }
    fun solutionB(): Long = input.sumOf { countStones(it, 75) }

    private fun countStones(num: Long, iterations: Int): Long {
        val key = Pair(num, iterations)
        if (key in memo) return memo[key]!!

        val result = when {
            iterations == 0 -> 1L
            num == 0L -> countStones(1L, iterations - 1)
            num.toString().length % 2 == 0 -> {
                val halfLength = num.toString().length / 2
                val left = num.toString().substring(0, halfLength).toLong()
                val right = num.toString().substring(halfLength).toLong()
                countStones(left, iterations - 1) + countStones(right, iterations - 1)
            }
            else -> countStones(num * 2024, iterations - 1)
        }

        memo[key] = result
        return result
    }
}

fun main() {
    val day11 = Day11()
    println("Solution A: ${day11.solutionA()}")
    println("Solution B: ${day11.solutionB()}")
}
