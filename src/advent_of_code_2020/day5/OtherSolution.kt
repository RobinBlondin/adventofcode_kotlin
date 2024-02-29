package advent_of_code_2020.day5

import java.io.File

/*
    Inspired by KotlinByJetBrains @ YouTube

    I did not notice the similarity to binary code before I saw this video. That's all I needed to hear to create a more
    concise version than mine.
 */

val seatIds = File("src/advent_of_code_2020/day5/input.txt").readLines()
    .stream()
    .map{
        it.replace("B", "1")
            .replace("R", "1")
            .replace("F", "0")
            .replace("L", "0")
            .toInt(2)
    }.toList().sorted()

val maxSeatId: Int = seatIds.max()

val findYourSeat = seatIds.stream().filter { it + 1 !in seatIds }.findFirst().get() + 1

fun main() {
    println("SolutionA: $maxSeatId")
    println("SolutionB: $findYourSeat")
}
