package advent_of_code_2020.day9

import java.io.File
import java.math.BigInteger

class Day9(path: String = "src/advent_of_code_2020/day9/input.txt") {
    private val numbers = File(path).readLines().map { it.toBigInteger() }

    fun solutionA() = numbers.windowed(26, 1)
        .find { sublist -> sublist.flatMap { first ->
        sublist.mapNotNull { second ->
            if (first != second) Pair(first, second) else null } }
            .none { it.first + it.second == sublist.takeLast(1)[0] } }
        ?.takeLast(1)
        ?.get(0)


    fun solutionB(): BigInteger {
        val number = solutionA()

        val acc = mutableListOf<BigInteger>()

        for (i in numbers) {
            acc.add(i)
            val currentSumInList = acc.sumOf { it }
            if(currentSumInList > number) acc.clear() else if (currentSumInList == number) break
        }
        return acc.first() + acc.last()
    }

}

fun main() {
    val day9 = Day9()

    println(day9.solutionA())
    println(day9.solutionB())
}