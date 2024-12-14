package advent_of_code_2024.day9

import java.io.File

class Day9(path: String = "./src/advent_of_code_2024/day9/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { ch -> ch.digitToInt() } }.flatten()

    fun solutionA(): Long {
        var count = 0L
        val list = organizeA()
        list.forEachIndexed { index, s -> count += index * decodeChar(s) }
        return count
    }

    fun solutionB(): Long {
        var count = 0L
        val list = organizeB()
        println(list)
        list.forEachIndexed { index, s ->
            if (s != '.') {
                count += index.toLong() * decodeChar(s).toLong()
            }
        }
        return count
    }

    private fun processInput(): Array<Char> {
        val input = this.input.toList()
        val list = mutableListOf<Char>()
        var count = 0

        for (i in input.indices) {
            for (j in 1..input[i]) {
                if (i % 2 == 0) {
                    list.add(encodeNumber(count))
                } else {
                    list.add('.')
                }
            }

            if (i % 2 == 0) count++

            if (i >= input.size) break
        }

        return list.toTypedArray()
    }

    private fun organizeA(): List<Char> {
        val processedInput = processInput()

        for (i in processedInput.size - 1 downTo 0) {
            if (processedInput[i] != '.') {
                val spaceIndex = processedInput.indexOfFirst { it == '.' }

                if (spaceIndex > i) {
                    break
                }
                processedInput[spaceIndex] = processedInput[i]
                processedInput[i] = '.'
            }

        }
        return processedInput.filter { it != '.' }
    }

    fun groupCharacters(input: String): List<CharArray> {
        if (input.isEmpty()) return emptyList()

        val result = mutableListOf<String>()
        var currentGroup = StringBuilder(input[0].toString())

        for (i in 1 until input.length) {
            if (input[i] == input[i - 1]) {
                currentGroup.append(input[i])
            } else {
                result.add(currentGroup.toString())
                currentGroup = StringBuilder(input[i].toString())
            }
        }
        result.add(currentGroup.toString())

        return result.map { it.toCharArray() }
    }


    private fun organizeB(): List<Char> {
        val input = processInput().joinToString("")
        var groups = groupCharacters(input)

        var index = groups.size - 1
        while (index >= 0) {
            if (groups.subList(0, index).none { it.contains('.') }) break
            val spaces = groups.indexOfFirst { it.contains('.') && it.size >= groups[index].size }

            if (spaces == -1 || spaces >= index || groups[index].all { it == '.' }) {
                index--
                continue
            }
            val before = groups.size
            switchCharacters(groups[spaces], groups[index])
            groups = groupCharacters(groups.joinToString("") { it.joinToString("") })
            val diff = before - groups.size
            if(diff == 2) index--
        }
        return groups.flatMap { arr -> arr.map { ch -> ch } }
    }

    private fun switchCharacters(spaces: CharArray, group: CharArray) {
        for (i in group.indices) {
            spaces[i] = group[i]
            group[i] = '.'
        }
    }

    fun encodeNumber(number: Int): Char {
        val baseOffset = 0x4E00
        val maxOffset = 0x9FFF
        val charCode = baseOffset + number
        return if (charCode in baseOffset..maxOffset) charCode.toChar() else ' '
    }

    fun decodeChar(encoded: Char): Int {
        val baseOffset = 0x4E00
        return encoded.code - baseOffset
    }

}

fun main() {
    val day9 = Day9()

    println("SolutionA: ${day9.solutionA()}")
    println("SolutionB: ${day9.solutionB()}")
}
