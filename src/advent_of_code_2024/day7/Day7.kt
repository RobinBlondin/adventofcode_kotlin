package advent_of_code_2024.day7

import java.io.File

class Day7(path: String = "./src/advent_of_code_2024/day7/input.txt") {
    val input = File(path).readLines()
        .map { it.split(": ")[0].toLong() to
                it.split(": ")[1]
                    .split(" ")
                    .map { num -> num.toLong() } }

    fun solutionA(): Long = solve(charArrayOf('+', '*'))

    fun solutionB(): Long = solve(charArrayOf('+', '*', '|'))

    private fun solve(operators: CharArray): Long = input.sumOf {
        val calculations = generateCalculationsAndOperators(it.second, operators)

        val match = calculations.any { pair ->
            val sum = calculate(pair.first, 0, pair.second)
            sum == it.first
        }

        if(match) it.first else 0
    }

    private fun calculate(calc: List<Long>, index: Int, operators: List<Char>): Long {
        if (index >= operators.size) {
            return calc.first()
        }

        val result = mutableListOf<Long>()

        when (operators[index]) {
            '*' -> result.add(calc[0] * calc[1])
            '+' -> result.add(calc[0] + calc[1])
            else -> result.add((calc[0].toString() + calc[1].toString()).toLong())
        }

        result.addAll(calc.drop(2))
        return calculate(result, index + 1, operators)
    }

    private fun generateCalculationsAndOperators(numbers: List<Long>, operators: CharArray): List<Pair<List<Long>, List<Char>>> {
        val combinations = generateOperators(numbers.size - 1, operators)
        val result = mutableListOf<Pair<List<Long>, List<Char>>>()
        val stringNums = mutableListOf<Long>()
        val newOperators = mutableListOf<Char>()

        for (combo in combinations) {
            for ((index, number) in numbers.withIndex()) {
                stringNums.add(number)
                if (index == numbers.size - 1) {
                    continue
                }
                newOperators.add(combo[index])
            }
            result.add(Pair(stringNums.toList(), newOperators.toList()))
            stringNums.clear()
            newOperators.clear()
        }
        return result
    }

    private fun generateOperators(length: Int, chars: CharArray = charArrayOf('+', '*')): List<String> {
        if (length == 0) {
            return mutableListOf("")
        }

        val smallerCombinations = generateOperators(length - 1, chars)
        val result = mutableListOf<String>()

        for (combination in smallerCombinations) {
            for (char in chars) {
                result.add(combination + char)
            }
        }
        return result
    }
}

fun main() {
    val day7 = Day7()

    println("SolutionA: ${day7.solutionA()}")
    println("SolutionB: ${day7.solutionB()}")
}
