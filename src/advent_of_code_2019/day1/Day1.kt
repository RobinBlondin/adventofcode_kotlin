package advent_of_code_2019.day1

import java.io.File
import kotlin.math.floor

class Day1(path: String = "./src/advent_of_code_2019/day1/input.txt") {
    private val input = File(path).readLines().map { it.toLong() }

    fun solutionA(): Long = input.sumOf {calculateFuel(it)}

    fun solutionB(): Long = input.sumOf { calculateFuelRecursive(it, 0) }

    fun calculateFuel(mass: Long): Long {
        return floor(mass.toDouble() / 3).toLong() - 2
    }

    fun calculateFuelRecursive(mass: Long, acc:Long): Long {
        val updatedMass = calculateFuel(mass)
        if (updatedMass <= 0) return acc
        return calculateFuelRecursive(updatedMass, acc + updatedMass)
    }
}

fun main() {
    val day1 = Day1()

    println("SolutionA: ${day1.solutionA()}")
    println("SolutionB: ${day1.solutionB()}")
}
