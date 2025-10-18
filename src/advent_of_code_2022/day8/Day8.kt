package advent_of_code_2022.day8

import java.io.File

class Day8(path: String = "./src/advent_of_code_2022/day8/input.txt") {
      val input = File(path).readLines().map { it.toCharArray().map{ ch -> ch.digitToInt()} }
      val amountOfSurroundingTrees = input.size * 4 - 4
      var count = amountOfSurroundingTrees
      var highestScore = 0

      fun solutionA(): Int {
            for (i in 1 ..< input.size - 1) {
                  for (j in 1 ..< input[i].size - 1) {
                        val tree = input[i][j]
                        val north = isTreeVisible(tree, "N", j, i - 1)
                        val south = isTreeVisible(tree, "S", j, i + 1)
                        val west = isTreeVisible(tree, "W", j - 1, i)
                        val east = isTreeVisible(tree, "E", j + 1, i)

                        if(north || south || west || east) count++
                  }
            }
            return count
      }

      fun solutionB(): Int {
            for (i in 1 ..< input.size - 1) {
                  for (j in 1 ..< input[i].size - 1) {
                        val tree = input[i][j]
                        val north = getScenicScore(tree, "N", j, i - 1, 0)
                        val south = getScenicScore(tree, "S", j, i + 1, 0)
                        val west = getScenicScore(tree, "W", j - 1, i, 0)
                        val east = getScenicScore(tree, "E", j + 1, i, 0)

                        val score = north * south * west * east

                        if(score > highestScore) {
                              highestScore = score
                        }
                  }
            }
            return highestScore
      }

      fun isTreeVisible(tree: Int, direction: String, x: Int, y: Int): Boolean {
            if(x < 0  || y < 0 || x == input.size || y == input.size)  return true
            if(tree <= input[y][x]) return false

            return when(direction) {
                  "N" -> isTreeVisible(tree, direction, x, y - 1)
                  "S" -> isTreeVisible(tree, direction, x, y + 1)
                  "E" -> isTreeVisible(tree, direction, x + 1, y)
                  else -> isTreeVisible(tree, direction, x - 1, y)
            }
      }

      fun getScenicScore(tree: Int, direction: String, x: Int, y: Int, count: Int): Int {
            if(x < 0  || y < 0 || x == input.size || y == input.size)  return count
            if(tree <= input[y][x]) return count + 1

            return when(direction) {
                  "N" -> getScenicScore(tree, direction, x, y - 1, count + 1)
                  "S" -> getScenicScore(tree, direction, x, y + 1, count + 1)
                  "E" -> getScenicScore(tree, direction, x + 1, y, count + 1)
                  else -> getScenicScore(tree, direction, x - 1, y, count + 1)
            }
      }
}

fun main() {
      val day8 = Day8()

      println("SolutionA: ${day8.solutionA()}")
      println("SolutionB: ${day8.solutionB()}")
}
