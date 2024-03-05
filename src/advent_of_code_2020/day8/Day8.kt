package advent_of_code_2020.day8

import java.io.File

typealias Pairs = Pair<String, Int>
typealias Sum = Int
typealias BootSuccessful = Boolean

class Day8(path: String = "src/advent_of_code_2020/day8/input.txt") {
    private val instructions: List<Pairs> = File(path).readLines()
        .map { line ->
            val (operation, value) = line.split(" ")
            Pair(operation, value.toInt())
        }

    private val executedInstructions = mutableSetOf<Int>()

    private fun countAccumulator(index: Int = 0, sum: Int = 0, list: List<Pairs> = instructions): Pair<Sum, BootSuccessful> {
        if (index + 1 > list.size) return Pair(sum, true)
        val currentOperation = list[index].first
        val value = list[index].second

        if (executedInstructions.contains(index))
            return Pair(sum, false)
        else
            executedInstructions.add(index)

        return when (currentOperation) {
            "acc" -> countAccumulator(index + 1, sum + value, list)
            "jmp" -> countAccumulator(index + value, sum, list)
            else -> countAccumulator(index + 1, sum, list)
        }
    }

    fun solutionA(): Int = countAccumulator().first
    fun solutionB(): Int {
        val mutatedList = instructions.toMutableList()

        for (i in mutatedList.indices) {
            val currentInstruction = mutatedList[i]
            when (currentInstruction.first) {
                "jmp" -> mutatedList[i] = Pair("nop", currentInstruction.second)
                "nop" -> if (currentInstruction.second != 0) mutatedList[i] = Pair("jmp", currentInstruction.second)
                else -> continue
            }
            executedInstructions.clear()
            val temp = countAccumulator(list = mutatedList)
            if (temp.second) return temp.first else mutatedList[i] = currentInstruction
        }
        return -1
    }
}

fun main() {
    val day8 = Day8()
    println("SolutionA: ${day8.solutionA()}")
    println("SolutionB: ${day8.solutionB()}")
}
