package advent_of_code_2021.day3

import java.io.File

class Day3(path: String = "./src/advent_of_code_2021/day3/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { char -> char.toString() } }

    fun solutionA(): Int {
        val list = MutableList(input[0].size) { mutableListOf<String>() }
        input.forEach {
            it.forEachIndexed { index, value ->
                list[index].add(value)
            }
        }
        val gammaRate = StringBuilder()
        val epsilon = StringBuilder()
        list.forEach {
            val ones = it.filter { letter -> letter == "1" }.size
            val zeros = it.filter { letter -> letter == "0" }.size
            if (ones > zeros) {
                gammaRate.append("1")
                epsilon.append("0")
            } else {
                gammaRate.append("0")
                epsilon.append("1")
            }
        }
        return gammaRate.toString().toInt(2) * epsilon.toString().toInt(2)
    }

    private fun recursiveB(mostCommon: Boolean, index: Int, input: List<List<String>>): Int {
        if (input.size <= 1) return input[0].joinToString("").toInt(2)

        val ones = input.count { binaryNumber -> binaryNumber[index] == "1" }
        val zeros = input.count { binaryNumber -> binaryNumber[index] == "0" }

        val result: List<List<String>> = if (ones >= zeros) {
            if (mostCommon) input.filter { it[index] == "1" } else input.filter { it[index] == "0" }
        } else {
            if (mostCommon) input.filter { it[index] == "0" } else input.filter { it[index] == "1" }
        }

        return recursiveB(mostCommon,index + 1, result)
    }

    fun solutionB(): Int {
        return recursiveB(true, 0, input) * recursiveB(false, 0, input)
    }
}


fun main() {
    val day3 = Day3()

    println("SolutionA: ${day3.solutionA()}")
    println("SolutionB: ${day3.solutionB()}")
}