package advent_of_code_2020.day9

import java.io.File
import java.math.BigInteger

class Day9(path: String = "src/advent_of_code_2020/day9/input.txt", isTest: Boolean) {
    private val numbers = File(path).readLines().map { it.toBigInteger() }
    private val windowSize = if (isTest) 6 else 26

    fun solutionA() = numbers.windowed(windowSize, 1)
        .find { sublist ->
            sublist.flatMap { first ->
                sublist.mapNotNull { second ->
                    if (first != second) Pair(first, second) else null
                }
            }
                .none { it.first + it.second == sublist.last() }
        }?.last()


    fun solutionB(): BigInteger {
        val number = solutionA()
        val acc = mutableListOf<BigInteger>()
        val windowed = numbers.windowed(numbers.size, 1, true)

        outer@
        for (sublist in windowed) {
            for (j in sublist) {
                if (j == number) continue

                acc.add(j)
                val foundNumbers = acc.sumOf { it } == number
                if (foundNumbers) break@outer else if (acc.sumOf { it } > number) break
            }
            acc.clear()
        }
        acc.sort()
        return acc.first() + acc.last()
    }
}

fun main() {
    val day9 = Day9(isTest = false)

    println("solutionA: ${day9.solutionA()}")
    println("SolutionB: ${day9.solutionB()}")
}
