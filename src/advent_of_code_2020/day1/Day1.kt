package advent_of_code_2020.day1

import java.io.File

class Day1(path: String = "src/advent_of_code_2020/day1/input.txt") {

    val list = File(path).readLines().map { it.toInt() }
    fun solutionA() = list.flatMap { first ->
        list.filter { second -> first + second == 2020 } }.reduce(Int::times)

    fun solutionB() = list.flatMapIndexed { index, first ->
        list.drop(index).flatMap { second ->
            list.filter { third -> first + second + third == 2020 } } }.reduce(Int::times)
}

fun main() {
    val day1 = Day1()
    println("Solution A: ${day1.solutionA()}")
    println("Solution B: ${day1.solutionB()}")
}
