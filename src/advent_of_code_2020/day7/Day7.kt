package advent_of_code_2020.day7

import java.io.File

class Day7(private val path: String = "src/advent_of_code_2020/day7/input.txt") {

    val map: Map<String, List<Pair<String, String>>> = File(path).readLines()
        .associate {
            val (key, value) = it.split(" bags contain ")
            val list = value.split(", ").map { element ->
                val arr = element.split(" ")
                Pair(arr[0], "${arr[1]} ${arr[2]}")
            }
            key to list
        }

    fun solutionA(): Int =
        map.entries.sumOf { entry ->
            entry.value.count { it.second.contains("gold") } +
            if (entry.value.count { map[entry.key]?.any { it.second.contains("gold") }!! } > 0) 1 else 0
        }

}

fun main() {
    val day7 = Day7()
    println(day7.solutionA())
}