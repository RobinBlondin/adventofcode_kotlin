package advent_of_code_2024.day12

import java.io.File

class Day12(path: String = "./src/advent_of_code_2024/day12/input.txt") {
      val input = File(path).readLines().map { it.toCharArray().map { ch -> ch.toString() } }
      var currentPlot = ""
      val visited = mutableSetOf<Pair<Int, Int>>()
      val currentPlotCoordsAndFences = mutableMapOf<Pair<Int, Int>, Int>()

      fun solutionA(): Int {
            var totalPlotPrice = 0
            for (i in input.indices) {
                  for (j in input[i].indices) {
                        if (visited.contains(Pair(i, j))) continue
                        currentPlot = input[i][j]
                        recursivePlotTraversal(i, j, currentPlot)
                        totalPlotPrice += currentPlotCoordsAndFences.keys.size * currentPlotCoordsAndFences.values.sum()
                        println(currentPlotCoordsAndFences)
                        currentPlotCoordsAndFences.clear()
                  }

            }
            return totalPlotPrice
      }

      fun solutionB(): Int {
            return 0
      }

      fun recursivePlotTraversal(x: Int, y: Int, currentPlot: String) {
            if (x < 0 || x >= input.size || y < 0 || y >= input[0].size) return
            if(input[x][y] != currentPlot) return
            if (visited.contains(Pair(x, y))) return
            visited.add(Pair(x, y))
            countFences(Pair(x, y))

            recursivePlotTraversal(x + 1, y, currentPlot)
            recursivePlotTraversal(x - 1, y, currentPlot)
            recursivePlotTraversal(x, y + 1,  currentPlot)
            recursivePlotTraversal(x, y - 1, currentPlot)
      }

      fun countFences(current: Pair<Int, Int>): Int {
            val x = current.first
            val y = current.second
            var fenceCount = 0

            val list = listOf(
                  Pair(x + 1, y),
                  Pair(x - 1, y),
                  Pair(x, y + 1),
                  Pair(x, y - 1)
            )

            for(i in list) {
                  try {
                        if (input[i.first][i.second] != currentPlot) {
                              fenceCount++
                        }
                  } catch (e: Exception) {
                        fenceCount++
                  }
            }

            currentPlotCoordsAndFences[current] = fenceCount
            return fenceCount
      }
}

fun main() {
      val day12 = Day12()

      println("SolutionA: ${day12.solutionA()}")
      println("SolutionB: ${day12.solutionB()}")
}
