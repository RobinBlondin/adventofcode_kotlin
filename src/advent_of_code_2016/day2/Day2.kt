package advent_of_code_2016.day2

import java.io.File

class Day2(path: String = "./src/advent_of_code_2016/day2/input.txt") {
    val input = File(path).readLines().map { it.toCharArray() }
    private val numpadA = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).windowed(3, 3)
    private val numpadB = listOf('X', 'X', '1', 'X','X','X', '2', '3', '4', 'X', '5', '6', '7', '8', '9', 'X', 'A', 'B', 'C', 'X', 'X', 'X', 'D', 'X', 'X').windowed(5, 5)
    fun solutionA(): String {
        var x = 1
        var y = 1
        val code = StringBuilder()
        for(line in input) {
            for(char in line) {
                when(char) {
                    'D' -> {
                        if(y + 1 <= numpadA.size - 1) {
                            y++
                        }
                    }
                    'U' -> {
                        if (y - 1 >= 0) {
                            y--
                        }
                    }
                    'R' -> {
                        if(x + 1 <= numpadA.first().size - 1) {
                            x++
                        }
                    }
                    else -> {
                        if(x - 1 >= 0) {
                            x--
                        }
                    }
                }
            }
            val currentNumber = numpadA[y][x]
            code.append(currentNumber)

        }
        return code.toString()
    }

    fun solutionB(): String {
        var x = 1
        var y = 1
        val code = StringBuilder()
        for(line in input) {
            for(char in line) {
                when(char) {
                    'D' -> {
                        if(y + 1 <= numpadB.size - 1 && numpadB[y + 1][x] != 'X') {
                            y++
                        }
                    }
                    'U' -> {
                        if (y - 1 >= 0 && numpadB[y - 1][x] != 'X') {
                            y--
                        }
                    }
                    'R' -> {
                        if(x + 1 <= numpadB.first().size - 1 && numpadB[y][x + 1] != 'X') {
                            x++
                        }
                    }
                    else -> {
                        if(x - 1 >= 0 && numpadB[y][x - 1] != 'X') {
                            x--
                        }
                    }
                }
            }
            val currentNumber = numpadB[y][x]
            code.append(currentNumber)

        }
        return code.toString()
    }

}

fun main() {
    val day2 = Day2()

    println("SolutionA: ${day2.solutionA()}")
    println("SolutionB: ${day2.solutionB()}")
}
