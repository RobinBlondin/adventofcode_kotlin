package advent_of_code_2024.day9

import advent_of_code_2024.day8.Day8.Companion.MARKED
import java.io.File

class Day9(path: String = "./src/advent_of_code_2024/day9/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { ch -> ch.digitToInt() } }.flatten()

    fun solutionA(): Long {
        var count = 0L
        val list = organizeInput()
        list.forEachIndexed { index, s -> count += index * s.toInt() }
        return count
    }

    fun solutionB(): Int {
        println(countSpaceLength())
        return 0
    }

    private fun processInput(): Array<String> {
        val list = mutableListOf<String>()
        var count = 0

        for (i in input.indices) {
            for (j in 1..input[i]) {
                if (i % 2 == 0) {
                    list.add(count.toString())
                } else {
                    list.add(".")
                }
            }

            if (i % 2 == 0) count++

            if (i >= input.size) break
        }

        return list.toTypedArray()
    }

    private fun organizeInput(): List<String> {
        val processedInput = processInput()

        for (i in processedInput.size - 1 downTo 0) {
            if (processedInput[i] != ".") {
                val spaceIndex = processedInput.indexOfFirst { it == "." }

                if (spaceIndex > i) {
                    break
                }
                processedInput[spaceIndex] = processedInput[i]
                processedInput[i] = "."
            }

        }
        return processedInput.filter { it != "." }
    }

    fun countFileLengths(): List<Int> {
        val files = processInput()
        val result = mutableListOf<Int>()

        var count = 0
        var current = files[0]
        for (i in files.indices) {
            if (files[i] != current && files[i] != ".") {
                result.add(count)
                count = 0
                current = files[i]
                count++
            } else if (i == files.size - 1) {
                count++
                result.add(count)
            } else if (files[i] != ".") {
                count++
            }
        }
        println(result)
        return result.reversed()
    }

    fun countSpaceLength(): List<Int> {
        return processInput().joinToString("").split("\\w+".toRegex()).map { it.length }.filter { it > 0 }
    }

    fun processInputB(): Array<String> {
        val files = processInput()
        val fileLengths = countFileLengths()
        val spaceLengths = countSpaceLength()

        fileLengths.forEachIndexed { index, s ->
            if(s <= spaceLengths[index]) {
                files.
            }
        }
    }


}

fun main() {
    val day9 = Day9()

    println("SolutionA: ${day9.solutionA()}")
    println("SolutionB: ${day9.solutionB()}")
}
