package advent_of_code_2020.day4

import java.io.File

fun main() {
    val day4 = Day4()
    val path = "src/advent_of_code_2020/day4/input.txt"
    val inputList = day4.readFileToList(path)
    println("Solution A: ${day4.solutionA(inputList)}")
    println("Solution B: ${day4.solutionB(inputList)}")
}

class Day4 {
    val expectedFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    val ranges = mapOf("byr" to IntRange(1920, 2002), "iyr" to IntRange(2010, 2020), "eyr" to IntRange(2020, 2030), "hgt" to IntRange(150, 193))
    val eyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    fun validColor(color: String): Boolean = "^#\\w{6}\$".toRegex().matches(color)
    fun validPassId(id: String): Boolean = "^\\d{9}\$".toRegex().matches(id)


    fun readFileToList(path: String): List<String> {
        val list: MutableList<String> = ArrayList()
        val sb: StringBuilder = StringBuilder()
        File(path).readLines().forEach {
            if (it.isEmpty()) {
                list.add(sb.toString())
                sb.clear()
            } else sb.append(it).append(" ")
        }
        list.add(sb.toString())
        return list
    }

    fun solutionA(inputList: List<String>): Int {
        var result = 0
        inputList.forEach loop@{
            val arr = it.trim().split(" ")
            val count = arr.count { a -> expectedFields.contains(a.substring(0, 3))}
            if (count == expectedFields.size) result++
        }
        return result
    }

    fun solutionB(inputList: List<String>): Int =
        inputList.stream().map {
            it.trim().split(" ").toList().stream().count { a ->
                val substr = a.substring(0, 3)
                val number = a.split(":")[1]
                if(ranges.keys.contains(substr)) {

                }
            }
        }
    }