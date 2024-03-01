package advent_of_code_2020.day8

import java.io.File

typealias Pairs = Pair<String, Int>
class Day8(path: String = "src/advent_of_code_2020/day8/input.txt") {
    val list: List<Pairs> = File(path).readLines()
        .map { line ->
            val arr = line.split(" ")
            Pair(arr[0], arr[1].toInt())
        }.toMutableList()

    private val loopedOverPairs = mutableSetOf<Pair<Pairs, Int>>()
    private fun recursive(index: Int = 0, sum: Int = 0, list: List<Pairs>): Pair<Int, Boolean> {
        if(index+1 > list.size) return Pair(sum, true)
        val currentPair = list[index]
        val currentCommand = list[index].first
        val value = list[index].second

        if (loopedOverPairs.contains(Pair(currentPair, index))) return Pair(sum, false)

        loopedOverPairs.add(Pair(currentPair, index))

        return when (currentCommand) {
            "acc" -> recursive(index + 1, sum + value, list)
            "jmp" -> recursive(index + value, sum, list)
            else -> recursive(index + 1, sum, list)
        }
    }

        private fun testRecursive(list :MutableList<Pairs>): Int {
            loopedOverPairs.clear()
            try {
                val temp = recursive(list = list)
                return if(temp.second) temp.first else -1
            } catch (e: Exception) {
                return -1
            }
        }


    fun solutionA():Int = recursive(list = list).first
    fun solutionB():Int {
        val mList = list.toMutableList()

        for (i in mList.indices) {
            val before = list[i]
            when(before.first) {
                "jmp" -> mList[i] = Pair("nop", before.second)
                "nop" -> if(before.second != 0) mList[i] = Pair("jmp", before.second)
            }
            val temp = testRecursive(mList)
            if (temp > 0) return temp else mList[i] = before
        }
        return -1
    }



}

fun main() {
    val day8 = Day8()
    println("SolutionA: ${day8.solutionA()}")
    println("SolutionB: ${day8.solutionB()}")
}
