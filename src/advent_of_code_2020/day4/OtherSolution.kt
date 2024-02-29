package advent_of_code_2020.day4

import java.io.File
/*
    Inspired by KotlinByJetBrains @ YouTube

    The use of a custom Passport class and then using associate to split the strings into a map was way more clever than
    my way. Also, I learned about the use of companion objects, to basically create a static method in an OOP environment.
    And the use of WHEN was much more fitting than the regex battle in my solution. The use of toIntOrNull() would
    have been really helpful in my solution as well. takeLast() and removeSuffix() was two functions I didn't know about
    either. Very helpful.
 */

val readFileToList = File("src/advent_of_code_2020/day4/input.txt")
    .readText()
    .trim()
    .split("\n\n")
    .map { Passport.fromStringToMap(it) }

class Passport(private val map: Map<String, String>) {
    private val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    private val eyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    companion object {
        fun fromStringToMap(str: String): Passport {
            val fieldsWithValues = str.split(" ", "\n")
            val map = fieldsWithValues.associate {
                val (key, value) = it.split(":")
                key to value
            }
            return Passport(map)
        }
    }

    fun hasAllRequiredFields(): Boolean = map.keys.containsAll(requiredFields)
    fun hasValidValues(): Boolean = map.all { (key, value) ->
        when (key) {
            "byr" -> value.length == 4 && value.toIntOrNull() in 1920..2002
            "iyr" -> value.length == 4 && value.toIntOrNull() in 2010..2020
            "eyr" -> value.length == 4 && value.toIntOrNull() in 2020..2030
            "hgt" -> when(value.takeLast(2)) {
                "cm" -> value.removeSuffix("cm").toIntOrNull() in 150..193
                "in" -> value.removeSuffix("in").toIntOrNull() in 59..76
                else -> false
            }
            "hcl" -> value matches """#[0-9a-f]{6}""".toRegex()
            "ecl" -> value in eyeColors
            "pid" -> value.length == 9 && value.all(Char::isDigit)
            else -> true
        }
    }
}

fun main() {
    println(readFileToList.count { it.hasAllRequiredFields() })
    println(readFileToList.count { it.hasValidValues() && it.hasAllRequiredFields() })
}