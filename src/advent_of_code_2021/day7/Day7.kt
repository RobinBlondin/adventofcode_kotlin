package advent_of_code_2021.day7

import java.io.File

class Day7(path: String = "./src/advent_of_code_2021/day7/input.txt") {
    val input = File(path).readLines()[0].split(",").map { it.toInt() }

    fun solutionA(): Int {
        return findAlignWithLowestFuelCost(input,"first")
    }

    fun solutionB(): Int {
        return findAlignWithLowestFuelCost(input,"second")
    }

    fun alignCrabs(input:List<Int>, position: Int, part: String): Int {
        return if(part == "first")
            input.sumOf { maxOf(it, position) - minOf(it, position) }
        else
            input.sumOf { returnSumOfSteps(it, position) }
    }

    fun returnSumOfSteps(a: Int, b:Int): Int {
        val difference = maxOf(a, b) - minOf(a, b)
        var sum = 0
        for(i in 1 .. difference) {
            sum += i
        }
        return sum
    }

    fun findAlignWithLowestFuelCost(input:List<Int>, part:String): Int {
        val list = mutableListOf<Int>()
        val max = input.max()
        for (i in 1 .. max) {
            list.add(alignCrabs(input, i, part))
        }
        return list.min()
    }
}

fun main() {
    val day7 = Day7()

    println("SolutionA: ${day7.solutionA()}")
    println("SolutionB: ${day7.solutionB()}")
}
