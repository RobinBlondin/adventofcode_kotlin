package advent_of_code_2020.day7

import java.io.File

class Day7(path: String = "src/advent_of_code_2020/day7/input.txt") {

    private val bagsThatCanHoldGold = mutableSetOf<String>()

    val map: Map<String, List<Pair<Int, String>>> = File(path).readLines()
        .associate {
            val (key, value) = it.split(" bags contain ")
            val list = value.split(", ").map { element ->
                val arr = element.split(" ")
                Pair(arr[0].toIntOrZero(), "${arr[1]} ${arr[2]}")
            }
            key to list
        }

    private fun String.toIntOrZero(): Int =
        if ("[0-9]+".toRegex().matches(this)) this.toInt() else 0


    private fun checkBag(bag: String): Boolean {
        if (bag in bagsThatCanHoldGold) return true

        val tempBag = map[bag] ?: return false

        if(tempBag.any { it.second.contains("shiny gold") }) {
            bagsThatCanHoldGold.add(bag)
            return true
        } else if (tempBag.any { checkBag(it.second) }) {
            bagsThatCanHoldGold.add(bag)
            return true
        }
        return false
    }

    private fun countBags(bag: String): Int {
        val tempBag = map[bag] ?: return 0
        val sum = tempBag.sumOf { it.first }

        return sum + tempBag.sumOf { it.first * countBags(it.second) }
    }

    fun solutionA(): Int = map.keys.count {checkBag(it)}

    fun solutionB(): Int = countBags("shiny gold")

}

fun main() {
    val day7 = Day7()
    println("SolutionA: ${day7.solutionA()}")
    println("SolutionB: ${day7.solutionB()}")
}