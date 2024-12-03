package advent_of_code_2024.day3

import java.io.File

class Day3(path: String = "./src/advent_of_code_2024/day3/input.txt") {
    val input = File(path).readText()
    private val pattern = "mul\\(\\w+,\\w+\\)".toRegex()

    fun solutionA(): Int =
        matchAllInstructions(input).sumOf { it.first * it.second }

    fun solutionB(): Int =
        filterDisabledInstructions(input).sumOf {
            matchAllInstructions(it).sumOf { pair ->
                pair.first * pair.second
            }
        }

    private fun matchAllInstructions(input: String): List<Pair<Int, Int>> =
        pattern.findAll(input).map { matchResult ->
            matchResult.value
                .replace("mul(", "")
                .replace(")", "")
                .split(",")
                .map { it.toInt() }
                .toList()
        }.map { list -> Pair(list[0], list[1]) }.toList()

    private fun filterDisabledInstructions(input: String): List<String> {
        val disableInstruction = "don't\\(\\)".toRegex()
        val enableInstruction = "do\\(\\)".toRegex()

        return input.split(disableInstruction)
            .mapIndexed { index, line ->
                val containsEnableInstruction = enableInstruction.containsMatchIn(line)

                if(index == 0) {
                    return@mapIndexed line
                } else if (containsEnableInstruction) {
                    line.split(enableInstruction)
                        .drop(1)
                        .joinToString("")
                } else
                    return@mapIndexed ""
            }
    }
}

fun main() {
    val day3 = Day3()

    println("SolutionA: ${day3.solutionA()}")
    println("SolutionB: ${day3.solutionB()}")
}
