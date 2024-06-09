package advent_of_code_2021.day6

import java.io.File
import java.util.*

class Day6(path: String = "./src/advent_of_code_2021/day6/input.txt") {
    private var initialSchoolOfFish: MutableList<Int> = File(path).readLines()[0].split(",").map(String::toInt).toMutableList()

    fun solutionA(): Long {
        val list = initialSchoolOfFish
        println(countArrayOfFish(80))
        return decrementAllByOne(list, 80)
    }

    fun solutionB(): Long {
        return countArrayOfFish(256)
    }

    private fun countArrayOfFish(days: Int):Long {
        val amountOfFish = LongArray(9)
        initialSchoolOfFish.forEach { amountOfFish[it]++ }

        for(day in 1 .. days) {
            val newFish = amountOfFish[0]

            for (i in 1..8) {
                amountOfFish[i - 1] = amountOfFish[i]
            }
            amountOfFish[6] += newFish
            amountOfFish[8] = newFish
        }
        return amountOfFish.sum()
    }

    private fun decrementAllByOne(list: MutableList<Int>, times:Int): Long {
        if (times == 0) return list.size.toLong()
        val numberOfZeros = list.filter { it == 0 }.size
        var newList = list
        newList = newList.map {
            if (it == 0) 6 else it - 1
        }.toMutableList()

        newList.addAll(Collections.nCopies(numberOfZeros, 8))

        return decrementAllByOne(newList, times - 1)
    }
}

fun main() {
    val day6 = Day6()
    println("solution A: ${day6.solutionA()}")
    println("solution B: ${day6.solutionB()}")
}