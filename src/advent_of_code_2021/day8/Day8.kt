package advent_of_code_2021.day8

import java.io.File

class Day8(path: String = "./src/advent_of_code_2021/day8/input.txt") {
    private val input = File(path).readLines()
    private val numberCodes = input.map { it.split(" | ")[0].split(" ") }
    private val numbers = input.map { it.split(" | ")[1].split(" ") }.map { it.map { value -> value.toList().sorted().joinToString("") } }


    fun solutionA(): Int {
        return numbers.sumOf { it.count { code -> code.length in 2..4 || code.length == 7 } }
    }

    fun solutionB(): Int {
        var sum = 0

        for((index, listOfCodes) in numberCodes.withIndex()) {
            val result = StringBuilder()
            val arrayOfCodes = populateArrayWithCodes(listOfCodes)
            for(number in numbers[index]) {
                result.append(arrayOfCodes.indexOf(number).toString())
            }
            sum += result.toString().toInt()
        }
        return sum
    }

    /**
     * Populates an array with the codes for the digits with unique amount of segments(1, 4, 7 and 8)
     */
    private fun populateArrayWithUniqueCodes(listOfCodes: List<String>): Array<String> {
        val array = Array(10) { "" }
        for (numberCode in listOfCodes) {
            when(numberCode.length) {
                2 -> array[1] = numberCode
                3 -> array[7] = numberCode
                4 -> array[4] = numberCode
                7 -> array[8] = numberCode
            }
        }
        return array
    }

    /**
     * Populates an array with the codes for the digits that not have unique amount of segments. Compares the non-unique
     * with the unique using the method of exclusion.
     */
    private fun populateArrayWithCodes(listOfCodes: List<String>): Array<String> {
        val array = populateArrayWithUniqueCodes(listOfCodes)

        while(!sumIsEqual(array, listOfCodes)) {
            for (numberCode in listOfCodes) {
                when(numberCode.length) {
                    5 -> {
                        if(array[1].toList().count { numberCode.contains(it)  } == 2) {
                            array[3] = numberCode
                        } else if(array[4].toList().count { numberCode.contains(it) } == 3) {
                            array[5] = numberCode
                        } else {
                            array[2] = numberCode
                        }
                    }
                    6 -> {
                        if(array[4].toList().count { numberCode.contains(it) } == 4) {
                            array[9] = numberCode
                        } else if (array[4].toList().count { numberCode.contains(it) } == 3 && array[7].toList().count { numberCode.contains(it)} == 3) {
                            array[0] = numberCode
                        } else {
                            array[6] = numberCode
                        }
                    }
                }
            }
        }
       array.forEachIndexed { index, value ->
           array[index] = value.toList().sorted().joinToString("") }

        return array
    }

    /**
     * returns true if the array is fully populated
     */
    private fun sumIsEqual(array: Array<String>, listOfCodes: List<String>): Boolean =
        array.sumOf { it.length } == listOfCodes.sumOf { it.length }
}

fun main() {
    val day8 = Day8()

    println("SolutionA: ${day8.solutionA()}")
    println("SolutionB: ${day8.solutionB()}")
}
