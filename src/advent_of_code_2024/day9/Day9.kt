package advent_of_code_2024.day9

import advent_of_code_2024.day8.Day8.Companion.MARKED
import java.io.File

class Day9(path: String = "./src/advent_of_code_2024/day9/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { ch -> ch.digitToInt() } }.flatten()

    fun solutionA(): Long {
        var count = 0L
        val list = organizeA()
        list.forEachIndexed { index, s -> count += index * s.toInt() }
        return count
    }

    fun solutionB(): Long {
        var count = 0L
        val list = organizeB()
        list.forEachIndexed() { index, s ->
            if (s != ".") {
                count += index * s.toInt()
            }
        }
        return count
    }

    private fun processInput(): Array<String> {
        val list = mutableListOf<String>()
        var count = 0

        for (i in input.indices) {
            for (j in 1..input[i]) {
                if (i % 2 == 0) {
                    list.add(count.toString())
                } else {
                    list.add(".")
                }
            }

            if (i % 2 == 0) count++

            if (i >= input.size) break
        }

        return list.toTypedArray()
    }

    private fun organizeA(): List<String> {
        val processedInput = processInput()

        for (i in processedInput.size - 1 downTo 0) {
            if (processedInput[i] != ".") {
                val spaceIndex = processedInput.indexOfFirst { it == "." }

                if (spaceIndex > i) {
                    break
                }
                processedInput[spaceIndex] = processedInput[i]
                processedInput[i] = "."
            }

        }
        return processedInput.filter { it != "." }
    }

    private fun groupCharacters(input: String): MutableList<CharArray> {
        val regex = "(.)\\1*".toRegex()
        return regex.findAll(input)
            .map { match -> match.value.toCharArray() }
            .toMutableList()
    }

    fun organizeB(): List<String> {
        val input = processInput().joinToString("").trim()
        var groups = groupCharacters(input)

        for(i in  groups.indices.reversed()) {
            if(groups.subList(0, i + 1).none { it.contains('.') }) break
            val spaces = groups.indexOfFirst { it.contains('.') && it.size >= groups[i].size }

            if(spaces == -1) continue

            if(spaces > i) {
                continue
            }

            if(groups[i].contains('.')) {
                continue;
            }

            switchCharacters(groups[spaces], groups[i])

            groups = groupCharacters(groups.joinToString("") { it.joinToString("") })

        }
        return groups.flatMap { arr -> arr.map { ch -> ch.toString() } }

    }

    private fun switchCharacters(spaces: CharArray, group: CharArray) {
        for(i in group.indices) {
            spaces[i] = group[i]
            group[i] = '.'
        }
    }

}

    fun main() {
        val day9 = Day9()

        println("SolutionA: ${day9.solutionA()}")
        println("SolutionB: ${day9.solutionB()}")
    }
