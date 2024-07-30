package advent_of_code_2018.day1

import java.io.File

class Day1(path: String = "./src/advent_of_code_2018/day1/input.txt") {
    val input = File(path).readLines().map { it.toInt() }

    fun solutionA(): Int {
       return input.sum()
    }

    fun solutionB(): Int {
        val set = mutableSetOf<Int>()

        var sum = 0

        loop@
        while(true) {
            for (num in input) {
                sum += num

                if (set.contains(sum)) {
                    break@loop
                } else {
                    set.add(sum)
                }
            }
        }
        return sum
    }
}

fun main() {
    val day1 = Day1()

    println("SolutionA: ${day1.solutionA()}")
    println("SolutionB: ${day1.solutionB()}")
}
