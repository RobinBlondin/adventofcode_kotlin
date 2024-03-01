package advent_of_code_2020.day7

import java.io.File

/**
 *  Inspired by Todd Ginsburg
 *
 *  I chose this solution because of the use of a data class that represent a relationship between one parent bag to
 *  one child bag. All bags are added to a set using a parsing function with some clever regex to remove unnecessary data
 *  from the file. The solution for part 1 is filtering out every bag that directly contain a gold bag and then recursively climb
 *  up the tree adding every parent to the set, because they indirectly also contain a gold bag. It's much more concise than my
 *  method.
 *
 *  The second part solution is basically identical to mine, but Todd's is much cleaner. It filters out the bags where the gold
 *  bag is the parent and then recursively climb down the tree and sum up the total amount of bags that is contained under the gold bag.
 *  Doing this version has taught me more about flatMap, drop and windowed functions. And made recursive functions a little bit more clear.
 */

class OtherSolution(path: String = "src/advent_of_code_2020/day7/input.txt") {
    val list = File(path).readLines()
    private val unnecessaryWords = "bags|bag|contain|\\.|,".toRegex()


    private val setOfBags: Set<Bag> = list.filterNot { it.contains("no other") }.flatMap { line ->
        val parts = line.replace(unnecessaryWords, "").split("\\s+".toRegex())
        val parent = parts.take(2).joinToString(" ")

        parts.drop(2).windowed(3, 3, false).map { child ->
            Bag(parent,
                child.first().toInt(),
                child.drop(1).joinToString(" "))

        }
    }.toSet()

    private fun canContainGold(bag: String = "shiny gold"): Set<String> =
        setOfBags.filter { it.child == bag }
            .flatMap { canContainGold(it.parent) }
            .toSet() + bag

    private fun countBagsInShinyGoldBag(bag: String = "shiny gold"): Int =
        setOfBags.filter { it.parent == bag }
            .sumOf { it.amount * countBagsInShinyGoldBag(it.child) } + 1



    fun solutionA(): Int = canContainGold().size - 1
    fun solutionB(): Int = countBagsInShinyGoldBag() - 1

    data class Bag(val parent: String, val amount: Int, val child: String)


}

fun main() {
    val other = OtherSolution()
    //other.setOfBags.forEach { println(it) }
    println(other.solutionA())
    println(other.solutionB())
}