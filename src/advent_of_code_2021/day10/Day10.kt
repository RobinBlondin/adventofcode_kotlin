package advent_of_code_2021.day10

import java.io.File
import kotlin.math.ceil

class Day10(path: String = "./src/advent_of_code_2021/day10/input.txt") {
    val input = File(path).readLines()
    private val bracketPoints = mapOf(")" to 3, "]" to 57, "}" to 1197, ">" to 25137)
    private val opposingBracket = mapOf("(" to ")", "[" to "]", "{" to "}", "<" to ">")
    private val openingBrackets = "([{<"
    private val closingBrackets = ")]}>"

    fun solutionA(): Int {
        var sum = 0

        for(line in input) {
            val openingBracketHistory = mutableListOf<String>()
            println(findMissingBrackets(line))
            inner@
            for(bracket in line.split("").filter { it.isNotEmpty() }) {
                if (openingBrackets.contains(bracket)) {
                    openingBracketHistory.add(bracket)
                    continue
                } else if (closingBrackets.contains(bracket)) {
                    if (bracket == opposingBracket[openingBracketHistory.last()]) {
                        openingBracketHistory.removeLast()
                        continue
                    } else {
                        sum += bracketPoints[bracket]!!
                        break@inner
                    }
                }
            }
        }
        return sum
    }

    fun solutionB(): Long {
        val incompleteLines = input.filter { !hasIncorrectCharacter(it) }
        val scores = mutableListOf<Long>()
        for(line in incompleteLines) {
            scores.add(calculateScore(findMissingBrackets(line)))
        }
        return scores.sorted()[ceil(scores.size.toDouble() / 2).toInt() - 1]
    }

    fun hasIncorrectCharacter(line: String): Boolean {
        val bracketHistory = mutableListOf<String>()
        for(bracket in line.split("").filter { it.isNotEmpty() }) {
            if (openingBrackets.contains(bracket)) {
                bracketHistory.add(bracket)
            } else {
                if(bracket != opposingBracket[bracketHistory.last()]) {
                    return true
                } else {
                    bracketHistory.removeLast()
                }
            }
        }
        return false
    }

    fun findMissingBrackets(line: String):List<String> {
        val bracketHistory = mutableListOf<String>()
        for (bracket in line.split("").filter { it.isNotEmpty() }) {
            if(openingBrackets.contains(bracket)) {
                bracketHistory.add(bracket)
            } else if (closingBrackets.contains(bracket)) {
                if(bracket == opposingBracket[bracketHistory.last()]) {
                    bracketHistory.removeLast()
                }
            }
        }
        return bracketHistory.map { opposingBracket[it].toString() }.reversed()
    }

    fun calculateScore(missingBrackets: List<String>): Long {
        val points = mapOf(")" to 1, "]" to 2, "}" to 3, ">" to 4)
        var sum = 0L
        for (bracket in missingBrackets) {
            val value = points[bracket]
            sum = sum * 5 + value!!
        }
        return sum
    }
}

fun main() {
    val day10 = Day10()

    println("SolutionA: ${day10.solutionA()}")
    println("SolutionB: ${day10.solutionB()}")
}
