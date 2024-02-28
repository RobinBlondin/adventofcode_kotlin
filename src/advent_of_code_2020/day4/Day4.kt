package advent_of_code_2020.day4

import java.io.File

fun main() {
    val day4 = Day4()
    val parsedList = day4.parseList()

    println("Solution A: ${day4.solutionA()}")
    println("Solution B: ${day4.solutionB(parsedList)}")
}

class Day4(private val path: String = "src/advent_of_code_2020/day4/input.txt" ) {
    private val expectedFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    private val ranges = mapOf(
        "byr" to IntRange(1920, 2002),
        "iyr" to IntRange(2010, 2020),
        "eyr" to IntRange(2020, 2030),
        "hgt" to IntRange(150, 193)
    )

    private val eyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    private fun validColor(color: String?): Boolean = "^#\\w{6}\$".toRegex().matches(color.toString())
    private fun validPassId(id: String?): Boolean = "^\\d{9}\$".toRegex().matches(id.toString())

    private val inputList = File(path).readText()
        .trim()
        .split("\n\n")
        .map {it.split(" ", "\n")
            .joinToString(" ") }


    fun parseList(): List<String> {
        val mList: MutableList<String> = ArrayList()
        inputList.forEach { sb ->
            val arr = sb.trim().split(" ")
            val count = arr.count { expectedFields.contains(it.substring(0, 3)) }
            if (count != expectedFields.size) return@forEach

            val color = "hcl:(#[0-9a-f]+)".toRegex().find(sb)?.groups?.get(1)?.value ?: "defaultColor"
            val eyeColor = "ecl:(\\S+)".toRegex().find(sb)?.groups?.get(1)?.value ?: "defaultEyeColor"
            val passId = "pid:(\\S+)".toRegex().find(sb)?.groups?.get(1)?.value ?: "defaultPassId"
            val eyr = "eyr:\\S+".toRegex().find(sb)?.value?.split(":") ?: emptyList()
            val iyr = "iyr:\\S+".toRegex().find(sb)?.value?.split(":") ?: emptyList()
            val byr = "byr:\\S+".toRegex().find(sb)?.value?.split(":") ?: emptyList()
            var height = "(hgt:)(\\d+)(\\D+)".toRegex().find(sb)?.groups?.get(2)?.value?.toDoubleOrNull() ?: 0.0
            val unit = "(hgt:)(\\d+)(\\w+)".toRegex().find(sb)?.groups?.get(3)?.value ?: "defaultUnit"

            if (unit.contains("in")) {
                height *= 2.55
            }

            if (validColor(color) && validPassId(passId) &&
                (ranges[eyr[0]]?.contains(eyr[1].toInt()) == true) &&
                (ranges[iyr[0]]?.contains(iyr[1].toInt()) == true) &&
                (ranges[byr[0]]?.contains(byr[1].toInt()) == true) &&
                (ranges["hgt"]?.contains(height.toInt()) == true) &&
                (eyeColors.contains(eyeColor))
            ) {
                mList.add(sb)
            }
        }
        return mList
    }

    fun solutionA(): Int {
        var result = 0
        inputList.forEach loop@{
            val arr = it.trim().split(" ")
            val count = arr.count { a -> expectedFields.contains(a.substring(0, 3)) }
            if (count == expectedFields.size) result++
        }
        return result
    }

    fun solutionB(inputList: List<String>): Int = inputList.size
}