package advent_of_code_2019.day2

import java.io.File

class Day2(path: String = "./src/advent_of_code_2019/day2/input.txt") {
    private val input = File(path).readLines()[0].split(",").map { it.toInt() }.toMutableList()

    fun solutionA(): Int {
        input[1] = 12
        input[2] = 2
        loop@
        for(i in 0 until input.size step 4) {
            when(input[i]) {
                1 -> addOperation(i)
                2 -> multiplyOperation(i)
                99 -> break@loop
            }
        }
        return input[0]
    }

    fun solutionB(): Int {
        var input = input.toMutableList()
        program@
        for (j in 12 until input.size) {
            input[1] = j
            for(k in 2 until input.size) {
                input[2] = k
                loop@
                for (i in 0 until input.size step 4) {
                    when (input[i]) {
                        1 -> addOperation(i)
                        2 -> multiplyOperation(i)
                        99 -> break@loop
                    }
                }
                if (input[1] == 12)
                    input[2]++
                else {
                    input[1]++
                }
                if(input[0] == 19690720) break@program
            }

        }
        return 100 * input[1] + input[2]
    }

    fun addOperation(index: Int) {
        println(index)
        input[input[index + 3]] = input[input[index + 1]] + input[input[index + 2]]
    }

    fun multiplyOperation(index: Int) {
        input[input[index + 3]] = input[input[index + 1]] * input[input[index + 2]]
    }
}

fun main() {
    val day2 = Day2()

    //println("SolutionA: ${day2.solutionA()}")
    println("SolutionB: ${day2.solutionB()}")
}
