package advent_of_code_2020.day8

import java.io.File

typealias Pairs = Pair<String, Int>

class Day8(path: String = "src/advent_of_code_2020/day8/input.txt") {
    val list: List<Pairs> = File(path).readLines()
        .map { line ->
            val arr = line.split(" ")
            Pair(arr[0], arr[1].toInt())
        }

    private val usedOperations = mutableSetOf<Pair<Pairs, Int>>()

    private fun countAccumulator(index: Int = 0, sum: Int = 0, list: List<Pairs> = this.list): Pair<Int, Boolean> {
        if (index + 1 > list.size) return Pair(sum, true)
        val currentPair = list[index]
        val currentCommand = list[index].first
        val value = list[index].second

        if (usedOperations.contains(Pair(currentPair, index))) return Pair(sum, false)

        usedOperations.add(Pair(currentPair, index))

        return when (currentCommand) {
            "acc" -> countAccumulator(index + 1, sum + value, list)
            "jmp" -> countAccumulator(index + value, sum, list)
            else -> countAccumulator(index + 1, sum, list)
        }
    }

    private fun testMutatedList(list: MutableList<Pairs>): Int {
        usedOperations.clear()
        try {
            val temp = countAccumulator(list = list)
            return if (temp.second) temp.first else -1
        } catch (e: Exception) {
            return -1
        }
    }

    fun solutionA(): Int = countAccumulator().first
    fun solutionB(): Int {
        val mutatedList = list.toMutableList()

        for (i in mutatedList.indices) {
            val before = mutatedList[i]
            when (before.first) {
                "jmp" -> mutatedList[i] = Pair("nop", before.second)
                "nop" -> if (before.second != 0) mutatedList[i] = Pair("jmp", before.second)
            }
            val temp = testMutatedList(mutatedList)
            if (temp > 0) return temp else mutatedList[i] = before
        }
        return -1
    }
}

fun main() {
    val day8 = Day8()
    println("SolutionA: ${day8.solutionA()}")
    println("SolutionB: ${day8.solutionB()}")
}
