package advent_of_code_2020.day1

import java.io.File

/**
 * Inspired from all other solutions.
 *
 * I didnt check a solution for this one, but came back after learning some new tricks during the later days.
 */

class OtherSolution(path: String = "src/advent_of_code_2020/day1/input.txt") {
    val list = File(path).readLines().map { it.toInt() }

    fun solutionA() = list.flatMap { a ->
        list.filter { b -> a + b == 2020 } }.reduce {acc, i -> acc * i }

    fun solutionB() = list.flatMapIndexed { i, a ->
        list.drop(i).flatMap { b ->
            list.filter { c -> a + b + c == 2020 } } }.reduce { acc, i -> acc * i }
}

fun main() {
    val other = OtherSolution()
    println(other.solutionA())
    println(other.solutionB())
}