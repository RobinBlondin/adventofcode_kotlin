package advent_of_code_2020.day3

import java.io.File

fun main() {
    val day3 = Day3()

    println("Solution A: ${day3.solutionA()}")
    println("Solution B: ${day3.solutionB()}")
}

class Day3(val path: String = "src/advent_of_code_2020/day3/input.txt") {

    val list = File(path).readLines()

    fun solutionA(): Int {
        var count = 0
        var incr = 0
        for (i in list.indices) {
            if (list[i][incr] == '#') count++
            incr = (incr + 3) % (list[i].length)
        }
        return count
    }

    fun solutionB(): Long {
        val arr = listOf(1, 3, 5, 7, 1)
        var result: Long = 1
        var steps = 1

        for (j in 0..4) {
            var count = 0
            var incr = 0
            for (i in list.indices step steps) {
                if (list[i][incr] == '#') count++
                incr = (incr + arr[j]) % (list[i].length)
            }
            result *= count
            if (j == 3) steps++
        }
        return result
    }
}