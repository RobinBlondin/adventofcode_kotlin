package advent_of_code_2020.day6

import java.io.File

class Day6(val path: String = "src/advent_of_code_2020/day6/input.txt") {

    val listOfYes = File(path).readText()
        .trim()
        .split("\n\n")
        .map {
            it.split(" ", "\n")
                .joinToString { a -> a }
                .replace(", ", "")
                .toCharArray()
                .toSet().toList()
        }
        .toList()

    val list = File(path).readText()
        .trim()
        .split("\n\n")
        .map { it.split(" ", "\n") }
        .toList()


    fun solutionA(): Int = listOfYes.sumOf { it.size }
    fun solutionB(): Int {
        var count = 0
        for (i in list.indices) {
            for (j in list[i].indices) {
                var count2 = 0
                for (k in listOfYes.indices) {
                    for (l in listOfYes[k].indices) {
                        if (list[i][j].contains(listOfYes[k][l])) count2++
                    }
                }
                println(count2)
                if (count2 == list[i].size) count++
            }
        }
        return count
    }
}

fun main() {
    val day6 = Day6()


    println(day6.solutionB())
}