package advent_of_code_2024.day5

import java.io.File

class Day5(path: String = "./src/advent_of_code_2024/day5/input.txt") {
    private val orderingRules = File(path).readText()
        .split("\n\n")[0]
        .split("\n")
        .map {
            val (first, second) = it.split("|").map { num -> num.toInt() }
            first to second
        }

    private val updates = File(path).readText()
        .split("\n\n")[1]
        .split("\n")
        .map { it.split(',').map { num -> num.toInt() } }

    fun solutionA(): Int {
        return updates.sumOf { update ->
            if( orderingRules.all { rule -> isInOrder(rule, update) } ) {
                update[update.size / 2]
            } else 0
        }
    }

    fun solutionB(): Int {
        val unorderedUpdates = updates.filter { update -> !orderingRules.all { rule -> isInOrder(rule, update) } }.map { it.toMutableList() }

        unorderedUpdates.forEach { update ->
            loop@
            while (!orderingRules.all { r -> isInOrder(r, update) }) {
                for(rule in orderingRules) {
                    if (!isInOrder(rule, update)) {
                        val firstIndex = update.indexOf(rule.first)
                        val secondIndex = update.indexOf(rule.second)

                        val temp = update[firstIndex]
                        update[firstIndex] = update[secondIndex]
                        update[secondIndex] = temp

                        continue@loop
                    }
                }
            }
        }

        return unorderedUpdates.sumOf { it[it.size / 2] }
    }

    private fun isInOrder(rule: Pair<Int, Int>, update: List<Int>): Boolean {
        if(update.contains(rule.first) && update.contains(rule.second)) {
            return update.subList(update.indexOf(rule.first), update.size).contains(rule.second)
        }
        return true
    }
}

fun main() {
    val day5 = Day5()

    println("SolutionA: ${day5.solutionA()}")
    println("SolutionB: ${day5.solutionB()}")
}
