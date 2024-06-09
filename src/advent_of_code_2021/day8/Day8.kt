package advent_of_code_2021.day8

import java.io.File

class Day8(path: String = "./src/advent_of_code_2021/day8/input.txt") {
    val input = File(path).readLines()
    val numberCodes = input.map { it.split(" | ")[0].split(" ") }
    val numbers = input.map { it.split(" | ")[1].split(" ") }
    private val codeMap = mapOf(
        "abcdeg" to "0",
        "acdfg" to "2",
        "abcdf" to "3",
        "bcdef" to "5",
        "bcdefg" to "6",
        "abcdef" to "9"
    )

    private val uniqueCodes = mapOf(
        2 to "1",
        3 to "7",
        4 to "4",
        7 to 8)

    fun solutionA(): Int {
        return numbers.sumOf { it.count { code -> code.length in 2..4 || code.length == 7 } }
    }

    fun solutionB(): Int {
        val arrayOfCodes = Array(10) {""}
        var sum = 0
        for((index, listOfCodes) in numberCodes.withIndex()) {
            var result = ""
            populateArrayWithCodes(arrayOfCodes, listOfCodes)
            for(number in numbers) {
                result += arrayOfCodes.indexOf(number[index]).toString()
            }
            sum += result.toInt()
        }
        return sum
    }

    fun populateArrayWithUniqueCodes(array: Array<String>, listOfCodes: List<String>) {
        for (numberCode in listOfCodes) {
            when(numberCode.length) {
                2 or 3 or 4 or 7 -> array[1] = numberCode
            }
        }
    }

    fun populateArrayWithCodes(array: Array<String>, listOfCodes: List<String>) {
        populateArrayWithUniqueCodes(array, listOfCodes)
        while(!sumIsEqual(array, listOfCodes)) {
            for (numberCode in listOfCodes) {
                when(numberCode.length) {
                    5 -> {
                        if(array[1].toList().count { numberCode.contains(it)  } == 2) {
                            array[3] = numberCode
                        } else if(array[4].toList().count { numberCode.contains(it) } == 3 ) {
                            array[5] = numberCode
                        } else {
                            array[2] = numberCode
                        }
                    }
                    6 -> {
                        if(array[8].toList().count { numberCode.contains(it) } == 6) {
                            array[0] = numberCode
                        } else if (array[4].toList().count { numberCode.contains(it) } == 4) {
                            array[9] = numberCode
                        } else {
                            array[6] = numberCode
                        }
                    }
                }
            }
        }
    }

    fun sumIsEqual(array: Array<String>, listOfCodes: List<String>): Boolean =
        array.sumOf { it.length } == listOfCodes.sumOf { it.length }
}

fun main() {
    val day8 = Day8()

    println("SolutionA: ${day8.solutionA()}")
    println("SolutionB: ${day8.solutionB()}}")
}
