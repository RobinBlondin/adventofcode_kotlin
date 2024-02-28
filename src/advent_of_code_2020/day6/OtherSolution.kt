package advent_of_code_2020.day6

import java.io.File

class OtherSolution(path: String = "src/advent_of_code_2020/day6/input.txt") {
    val list = File(path).readText().trim().split("\n\n")

    val first = list.sumOf { it.replace("\n", "").toSet().count() }

    val second = list.map { a ->
        a.split("\n").map { it.toSet() } }.sumOf { a ->
            a.reduce {x, y -> x intersect y}.count()
    }
}

fun main() {
    val sol = OtherSolution()
    println(sol.second)
}