package advent_of_code_2024.day9

import java.io.File

class Day9(path: String = "./src/advent_of_code_2024/day9/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { ch -> ch.digitToInt() } }.flatten()

    fun solutionA(): Long {
        var count = 0L
        val list = realignCharacters()
        list.forEachIndexed { index, s -> count += index * decodeChar(s) }
        return count
    }

    fun solutionB(): Long {
        var count = 0L
        val list = realignFiles()
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

    private fun realignCharacters(): List<Char> {
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

    private fun realignFiles(): List<Char> {
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
            val initialSize = groups.size
            switchCharacters(groups[spaces], groups[index])
            groups = groupCharacters(groups.joinToString("") { it.joinToString("") })

            val sizeDifference = initialSize - groups.size
            index -= sizeDifference
        }
        return groups.flatMap { arr -> arr.map { ch -> ch } }
    }

    private fun groupCharacters(input: String): List<CharArray> =
        "(.)\\1*".toRegex().findAll(input).map { it.value.toCharArray() }.toList()


    private fun switchCharacters(spaces: CharArray, group: CharArray) {
        for (i in group.indices) {
            spaces[i] = group[i]
            group[i] = '.'
        }
    }

    private fun encodeNumber(number: Int): Char {
        val baseOffset = 0x4E00
        val maxOffset = 0x9FFF
        val charCode = baseOffset + number
        return if (charCode in baseOffset..maxOffset) charCode.toChar() else ' '
    }

    private fun decodeChar(encoded: Char): Int {
        val baseOffset = 0x4E00
        return encoded.code - baseOffset
    }

}

fun main() {
    val day9 = Day9()

    println("SolutionA: ${day9.solutionA()}")
    println("SolutionB: ${day9.solutionB()}")
}
