package advent_of_code_2020.day3

import java.io.File

/**
 *  Inspired by Todd Ginsburg @ GitHub. https://github.com/tginsberg/advent-2020-kotlin/tree/main
 *
 *  This solution is interesting because it uses operator overloads. Contains that uses the pair arguments values,
 *  and return true if a tree is on those coordinates in the list. Then Plus that makes it possible to add two
 *  pairs together.
 *
 *  The path function generates a sequence of pairs from the input pair and keep adding it to itself to create the
 *  next pair in the sequence until the second part of the pair will be out of bounds from the input list.
 *
 *  On the first part, treesOnSlope will use the input pair to generate a sequence using path and count every tree on
 *  the way using the overloaded contains function.
 *
 *  On the second part a list of pairs will be created and for each pair in the list we generate a sequence that counts
 *  how many trees that is encountered and put those values in a list, which all gets multiplied together using the
 *  reduce function.
 *
 *  This solution has definitely opened my eyes towards sequences and my goal is to learn to identify good cases where
 *  to use them.
 */

class OtherSolution(path: String = "src/advent_of_code_2020/day3/input.txt") {
    val list = File(path).readLines()

    private val forestWidth = list.first().length
    private val forestHeight = list.size

    fun solutionA() = treesOnSlope(3 to 1)

    fun solutionB(): Long = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        .map { treesOnSlope(it).toLong() }
        .reduce(Long::times)

    private fun treesOnSlope(slope: Pair<Int, Int>) = path(slope).count { it in list }

    private fun path(slope: Pair<Int, Int>): Sequence<Pair<Int, Int>> =
        generateSequence(Pair(0, 0)) { prev -> (prev + slope).takeIf { next -> next.second < forestHeight } }


    private operator fun List<String>.contains(location: Pair<Int, Int>): Boolean =
        this[location.second][location.first % forestWidth] == '#'

    private operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> =
        Pair(this.first + other.first, this.second + other.second)
}

fun main() {
    val other = OtherSolution()
    println(other.solutionA())
    println(other.solutionB())
}