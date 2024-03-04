package advent_of_code_2020.day2

import java.io.File

class Day2(path: String = "src/advent_of_code_2020/day2/input.txt") {
    val list = File(path).readLines()
    fun solutionA(): Int = list.count {
        val (first, last, letter, password) = it.split(": ", " ", "-")
        password.count { char -> char.toString() == letter } in first.toInt()..last.toInt()
    }

    fun solutionB(): Int = list.count {
        val (first, last, letter, password) = it.split(": ", " ", "-")
        (password[first.toInt() - 1].toString() == letter && password[last.toInt() - 1].toString() != letter) ||
                (password[last.toInt() - 1].toString() == letter && password[first.toInt() - 1].toString() != letter)
    }
}

fun main() {
    val day2 = Day2()

    println("Solution A: ${day2.solutionA()}")
    println("Solution B: ${day2.solutionB()}")
}