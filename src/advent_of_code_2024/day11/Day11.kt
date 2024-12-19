package advent_of_code_2024.day11

import java.io.File

class Day11(path: String = "./src/advent_of_code_2024/day11/input.txt") {
    private val input = File(path).readLines().map { it.split(" ").map { str -> str.toLong() } }.flatten()

    fun solutionA(): Int {
        val stones = input.toMutableList()

        for(index in 1 .. 25) {
            var i = 0
            while (i < stones.size) {
                val num = stones[i]
                val initialSize = stones.size
                handleStone(num, i, stones)

                if (stones.size > initialSize) {
                    i += 2
                } else {
                    i++
                }
            }
        }


        return stones.size
    }

    fun solutionB(): Int {
        return 0
    }

    fun handleStone(num: Long,  index: Int, stones: MutableList<Long>) {
        when {
            num == 0L -> stones[index]++
            num.toString().length % 2 == 0 -> {
                val (left, right) = num.toString().chunked(num.toString().length / 2).map { it.toLong() }
                stones[index] = left
                stones.add(index + 1, right)
            }
            else -> stones[index] = num * 2024
        }
    }
}

fun main() {
    val day11 = Day11()

    println("SolutionA: ${day11.solutionA()}")
    println("SolutionB: ${day11.solutionB()}")
}
