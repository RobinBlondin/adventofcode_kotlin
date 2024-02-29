package advent_of_code_2020.day6

import java.io.File

/*
    Inspired by KotlinByJetBrains @ YouTube

    The reason why I chose this solution was because of the use of intersect which will return all elements that exist
    in both specified collections. With the use of reduce this will accumulate all the matching elements from every. Then use count
    to return the amount of individual. Very clever

    Also, the solution for the first part was way more concise than mine
*/
class OtherSolution(path: String = "src/advent_of_code_2020/day6/input.txt") {
    val list = File(path).readText().trim().split("\n\n")

    val first = list.sumOf { it.replace("\n", "").toSet().count() }


    val second = list.map { line ->
        line.split("\n").map { it.toSet() } }.sumOf { listOfSets ->
            listOfSets.reduce {set1, set2 -> set1 intersect set2}.count()
    }
}

fun main() {
    val sol = OtherSolution()
    println(sol.second)
}