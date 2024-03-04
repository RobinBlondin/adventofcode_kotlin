package advent_of_code_2020.day1

import java.io.File

/**
 * Inspired by user Cortinico @ GitHub. https://github.com/cortinico/adventofcode-2020
 *
 *  Both parts use a clever way of checking if the difference is in the input, then using the difference to find the
 *  remaining subtrahend
 */

class OtherSolution(path: String = "src/advent_of_code_2020/day1/input.txt") {
    private val numbers = File(path).readLines().map { it.toInt() }.toSet()

    fun solutionA() = numbers.first { 2020 - it in numbers }.let { it * (2020 - it) }

    fun solutionB() = numbers.forEachIndexed  { index1, a ->
        numbers.forEachIndexed { index2, b ->
            if (index1 != index2 && 2020 - a - b in numbers) {
                println( a * b * (2020 - a - b))
                return
            }
        }
    }


}

fun main() {
    val other = OtherSolution()
    println(other.solutionA())
    other.solutionB()
}