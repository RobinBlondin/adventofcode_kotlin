package advent_of_code_2020.day10

import java.io.File

class Day10(path: String = "src/advent_of_code_2020/day10/input.txt") {
    private val adapterJolts = File(path).readLines().map { it.toInt() }.sorted().reversed()

    private fun countDiffs(): Int {
        var one = 1
        var three = 1
        adapterJolts.forEachIndexed { index, _ ->
            if (index + 1 >= adapterJolts.size ) return@forEachIndexed
            val difference = adapterJolts[index] - adapterJolts[index + 1]
            if( difference == 1) one++ else if (difference == 3)three++
        }
        return one * three
    }

    fun solutionA() = countDiffs()
    fun solutionB() = 0
}

fun main() {
    val day10 = Day10()
    println(day10.solutionA())
}