package advent_of_code_2018.day2

import java.io.File

class Day2(path: String = "./src/advent_of_code_2018/day2/inputA.txt") {
    val input = File(path).readLines()

    fun solutionA(): Int {
        val double = input.count { line -> line.groupingBy { it }.eachCount().values.contains(2) }
        val triple = input.count { line -> line.groupingBy { it }.eachCount().values.contains(3) }
        return double * triple
    }

    fun solutionB(): String {
        for (i in 0 ..< input.size - 1) {
            for (j in i + 1..< input.size) {
                val match = input[i].removeMatches(input[j])
                if(match.length == input[i].length - 1) {
                    return match
                }
            }
        }

        return "nothing found"
    }

    private fun String.removeMatches(other: String): String {
        val sb = StringBuilder()
        for((index, ch) in this.withIndex() ) {
            if(ch != other[index]) {
                continue
            } else {
                sb.append(ch)
            }
        }
        return sb.toString()
    }
}

fun main() {
    val day2 = Day2()

    println("SolutionA: ${day2.solutionA()}")
    println("SolutionB: ${day2.solutionB()}")
}
