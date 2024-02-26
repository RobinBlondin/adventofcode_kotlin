package advent_of_code_2020.day4

import java.io.File

fun main() {
    val day4 = Day4()
    val path = "src/advent_of_code_2020/day4/input.txt"
    val inputList = day4.readFileToList(path)
    println("Solution A: ${day4.solutionA(inputList)}")
    println("Solution B: ${day4.solutionB(inputList)}")
    println(inputList)
}

class Day4 {
    val expectedFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    val ranges = mapOf("byr" to IntRange(1920, 2002), "iyr" to IntRange(2010, 2020), "eyr" to IntRange(2020, 2030), "hgt" to IntRange(150, 193))
    val eyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    fun validColor(color: String?): Boolean = "^#\\w{6}\$".toRegex().matches(color.toString())
    fun validPassId(id: String?): Boolean = "^\\d{9}\$".toRegex().matches(id.toString())


    fun readFileToList(path: String): List<String> {
        val list: MutableList<String> = ArrayList()
        val sb: StringBuilder = StringBuilder()
        File(path).readLines().forEach {
            println(it)
            if (it.isEmpty()) {
                sb.clear()




            } else sb.append(it).append(" ")
        }
        val arr = sb.trim().split(" ")
        println(arr.size)
        if ((sb.contains("cid") && arr.size >= 8) || (!sb.contains("cid") && arr.size >= 7)) {
            val color = "hcl:(\\S+)".toRegex().find(sb)?.groups?.get(1)?.value
            val eyeColor = "ecl:(\\S+)".toRegex().find(sb)?.groups?.get(1)?.value
            val passId = "pid:(\\S+)".toRegex().find(sb)?.groups?.get(1)?.value
            val eyr = "eyr:\\S+".toRegex().find(sb)?.value?.split(":")
            val iyr = "iyr:\\S+".toRegex().find(sb)?.value?.split(":")
            val byr = "byr:\\S+".toRegex().find(sb)?.value?.split(":")
            var height = "(hgt:)(\\d+)(\\D+)".toRegex().find(sb)?.groups?.get(2)?.value?.toDouble()
            val unit = "(hgt:)(\\d+)(\\w+)".toRegex().find(sb)?.groups?.get(3)?.value

            if (height != null) {
                if (unit != null) {
                    if (unit.contains("in")) height *= 2.54
                }
            }

            if (height != null) {
                if(validColor(color) && validPassId(passId) &&
                    (eyr?.get(1)?.let { ranges[eyr[1]]?.contains(it.toInt()) } == true) &&
                    (iyr?.get(1)?.let { ranges[iyr[1]]?.contains(it.toInt()) } == true) &&
                    (byr?.get(1)?.let { ranges[byr[1]]?.contains(it.toInt()) } == true) &&
                    (ranges["hgt"]?.contains(height.toInt()) == true) &&
                    (eyeColors.contains(eyeColor))) list.add(sb.toString())
            }
        }
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

    fun solutionB(inputList: List<String>): Int = inputList.size
}