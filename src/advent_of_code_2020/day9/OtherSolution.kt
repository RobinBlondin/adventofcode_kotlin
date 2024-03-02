package advent_of_code_2020.day9

import java.io.File

/**
 * Inspired by user mo_66 @ Reddit https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/
 *
 * I chose this solution because of the use of indexed lambda functions, which I didn't know about up until this point.
 * This makes it possible to create indexed loops in your lambdas which I have felt the need for several times.
 *
 * The first part is solved by using an extension function which with a clever nested loop style lambda will return true
 * if the sum of any pair combination in a list is equal to the given argument. Then using a filterIndexed to create
 * sublist of the preamble size and call the extension function to look for a number with no addends in the sublist.
 *
 * The second part is solved basically the same way as my solution, but with the use of the indexed lambda functions.
 * It creates from each index a growing sublist for every new element compare the sum of the list with number from the
 * first part
 */
class OtherSolution(path: String = "src/advent_of_code_2020/day9/input.txt") {
    private val inputList = File(path).readLines().map { it.toLong() }
    private val numberWithoutAddends = inputList.filterIndexed { index, l -> index > 25 && !inputList.subList(index - 25, index).containSum(l) }.first()

    private fun List<Long>.containSum(num: Long): Boolean = this.any { i -> this.any { j -> i + j == num } }

    fun solutionA(): Long = numberWithoutAddends

    fun solutionB(): Long = inputList.subList(0, inputList.indexOf(numberWithoutAddends))
        .flatMapIndexed { i, _ ->
            List(inputList.subList(i, inputList.indexOf(numberWithoutAddends)).size) { j ->
                inputList.subList(i, i + j)}
                .filter { it.sum() == numberWithoutAddends }
                .map { it.min() + it.max() } }
        .first()
}

fun main() {
    val other = OtherSolution()
    println(other.solutionA())
    println(other.solutionB())
}