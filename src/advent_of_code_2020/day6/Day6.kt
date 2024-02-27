package advent_of_code_2020.day6

import java.io.File

class Day6(val path: String = "src/advent_of_code_2020/day6/input.txt") {

    val listOfUniqueYeses = File(path).readText()
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

    val listOfStrings = File(path).readText()
        .trim()
        .split("\n\n")
        .map { it.split(" ", "\n") }
        .toList()


    fun solutionA(): Int = listOfUniqueYeses.sumOf { it.size }
    fun solutionB(): Int {
        var count = 0
        listOfStrings.forEach { list ->
            list.forEach { element ->
               element.toCharArray().forEach { a ->
                   if (element.contains(a)) count++
               }
            }
        }
    }
}

fun main() {
    val day6 = Day6()

    println(day6.listOfStrings.forEach{ println(it)})
    println(day6.solutionB())
}