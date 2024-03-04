package advent_of_code_2020.day2

import java.io.File

/**
 *  Inspired by user Cortinico @ Github. https://github.com/cortinico/adventofcode-2020
 *
 *  Same as mine, but uses the xor operator that is true when the compared booleans differs from each other. This one I will
 *  definitely remember to use from now on.
 *
 *  true xor false = true
 *  false xor true = true
 *  true xor true = false
 *  false xor false = false
 */
class OtherSolution(path: String = "src/advent_of_code_2020/day2/input.txt") {
    val list = File(path).readLines()

    fun solutionB(): Int = list.count {
        val (first, last, letter, password) = it.split(": ", " ", "-")
        (password[first.toInt() - 1].toString() == letter) xor (password[last.toInt() - 1].toString() == letter)
    }
}

fun main() {
    val other = OtherSolution()
    println(other.solutionB())
}