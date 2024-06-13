package advent_of_code_2019.day2

import java.io.File

class Day2(path: String = "./src/advent_of_code_2019/day2/input.txt") {
    val input = File(path).readLines()[0].split(",").map { it.toInt() }

    fun solutionA(): Int {
        val inputCopy = input.toMutableList()
        return execute(inputCopy, 12, 2)
    }

    fun solutionB(): Int {
        for(i in 0 .. 99) {
            for (j in 0 .. 99) {
                val inputCopy = input.toMutableList()
                val result = execute(inputCopy, i, j)
                if (result == 19690720) {
                    return 100 * i + j
                }
            }
        }
        return 0
    }

    fun addOperation(index: Int, list: MutableList<Int>) {
        list[list[index + 3]] = list[list[index + 1]] + list[list[index + 2]]
    }

    fun multiplyOperation(index: Int, list: MutableList<Int>) {
        list[list[index + 3]] = list[list[index + 1]] * list[list[index + 2]]
    }

    fun selectOperation(index: Int, list: MutableList<Int>): Boolean {
        when (list[index]) {
            1 -> addOperation(index, list)
            2 -> multiplyOperation(index, list)
            99 -> return false
        }
        return true
    }

    fun execute(list: MutableList<Int>, noun: Int, verb: Int): Int {
        list[1] = noun
        list[2] = verb
        for(i in 0 until list.size step 4) {
            if(selectOperation(i, list)) continue else break
        }
        return list[0]
    }
}

fun main() {
    val day2 = Day2()

    println("SolutionA: ${day2.solutionA()}")
    println("SolutionB: ${day2.solutionB()}")
}
