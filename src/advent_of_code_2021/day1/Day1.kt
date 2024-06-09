package advent_of_code_2021.day1

import java.io.File

class Day1(path: String = "./src/advent_of_code_2021/day1/input.txt")  {
    val list = File(path).readLines().map { it.toInt() }

    fun solutionA(input: List<Int>): Int {
        val sublist = input.subList(1, input.size)
        return sublist.filterIndexed { index, i ->
            i > input[index]
         }.toList().size
    }

    fun solutionB(input: List<Int>): Int {
        val list = input.windowed(3, 1).map {it.sum()}
        return solutionA(list)
    }
}

fun main() {
    val day1 = Day1()

    println("SolutionA: ${day1.solutionA(day1.list)}")
    println("SolutionB: ${day1.solutionB(day1.list)}")
}