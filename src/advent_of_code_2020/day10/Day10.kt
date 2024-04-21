package advent_of_code_2020.day10

import java.io.File

class Day10(path: String = "src/advent_of_code_2020/day10/input.txt") {
    private val adapterJolts = File(path).readLines().map { it.toInt() }.sorted().reversed()

    private fun countDiffs(): Int {
        var one = 1
        var three = 1
        adapterJolts.forEachIndexed { index, _ ->
            if (index + 1 >= adapterJolts.size ) return@forEachIndexed
            val difference = adapterJolts[index] - adapterJolts[index + 1]
            if( difference == 1) one++ else if (difference == 3)three++
        }
        return one * three
    }

    fun solutionA() = countDiffs()
    fun solutionB() =
        sequence {

            val set = emptySet<Int>().toMutableSet()
            for (i in 1 .. adapterJolts.size) {
                val mutable = adapterJolts.toMutableList()
                for ((index, element) in mutable.withIndex()) {

                    if (index + 3 < mutable.size && element - mutable[index + 3] <= 3) {

                        if (mutable[index + 1] in set) {
                            mutable.removeAt(index + 1)
                            mutable.removeAt(index + 2)
                            set.add(mutable[index + 2])
                            yield(mutable)
                            

                        } else {
                            mutable.removeAt(index + 1)
                            set.add(mutable[index + 1])
                            //yield(mutable)

                        }
                    } else if (index + 2 < mutable.size && element - mutable[index + 2] <= 3) {
                        mutable.removeAt(index + 1)
                        set.add(mutable[index + 1])
                        //yield(mutable)
                    }
                    yield(mutable)
                }
            }
        }
}

fun main() {
    val day10 = Day10()
    println(day10.solutionA())
    day10.solutionB().map { it }.toSet().forEach(::println)
}