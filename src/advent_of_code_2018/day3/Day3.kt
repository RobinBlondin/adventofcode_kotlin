package advent_of_code_2018.day3

import java.io.File

class Day3(path: String = "./src/advent_of_code_2018/day3/input.txt") {
    val input = File(path).readLines().map { it
        .split("[@#,:x ]+".toRegex())
        .filter { element -> element.isNotEmpty() }
        .map { element -> element.toInt() }
    }

    val matrix = Array(1000) { Array(1000) { "" } }

    fun solutionA(): Int {
        for(list in input) {
            val num = list[0].toString()
            val fromLeft = list[1]
            val fromTop = list[2]
            val width = list[3]
            val height = list[4]

            for(i in fromTop ..< fromTop + height) {
                for(j in fromLeft ..< fromLeft + width) {
                    val current = matrix[i][j]
                    if(current.isEmpty()) {
                        matrix[i][j] = num
                    } else {
                        matrix[i][j] = "X"
                    }
                }
            }
        }
        return matrix.sumOf { it.count { element -> element == "X" } }
    }

    fun solutionB(): String {
        for(list in input) {
            val id = list[0].toString()

            val sum = list[3] * list[4]
            println(sum)
            val count = matrix.sumOf { it.count{ element -> element == id} }
            println(count)
            if (count == sum) {

                return id
            }
        }
        return "nothing found"
    }
}

fun main() {
    val day3 = Day3()

    println("SolutionA: ${day3.solutionA()}")
    println("SolutionB: ${day3.solutionB()}")
}
