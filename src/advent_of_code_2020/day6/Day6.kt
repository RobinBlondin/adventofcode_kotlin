package advent_of_code_2020.day6

import java.io.File

class Day6(val path: String = "src/advent_of_code_2020/day6/input.txt") {

    private val listOfUniqueYeses = File(path).readText()
        .trim()
        .split("\n\n")
        .map {
            it.split(" ", "\n")
                .joinToString { a -> a }
                .replace(", ", "")
                .toCharArray().map { b -> b.toString() }
                .toSet().toList()
        }
        .toList()


    private val listOfGroups = File(path).readText()
        .trim()
        .split("\n\n")
        .map { it.split(" ", "\n") }
        .toList()

    fun solutionA(): Int = listOfUniqueYeses.sumOf { it.size }

    fun solutionB(): Int {
        return listOfUniqueYeses.zip(listOfGroups).sumOf { pair ->
            pair.first.count { value ->
                pair.second.all { it.contains(value) }
            }
        }
    }
}

fun main() {
    val day6 = Day6()
    println("SolutionA: ${day6.solutionA()}")
    println("SolutionB: ${day6.solutionB()}")
}