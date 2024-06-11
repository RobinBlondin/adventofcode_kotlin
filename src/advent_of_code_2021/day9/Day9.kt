package advent_of_code_2021.day9

import java.io.File

class Day9(path: String = "./src/advent_of_code_2021/day9/input.txt") {
    val input = File(path).readLines().map { it.toCharArray().map { digit -> digit.toString().toInt() } }

    fun solutionA(): Int {
        return findLowPoints(input).sumOf { input[it.first][it.second] + 1 }
    }

    fun solutionB(): Int {
        var visited = mutableSetOf<Pair<Int, Int>>()
        val lowPoints = findLowPoints(input)
        val listOfSums = mutableListOf<Int>()

        for(point in lowPoints) {
            visited = mapOutBasinsRecursive( point.first, point.second, visited, checkNeighbors(point.first, point.second, input))
            listOfSums.add(visited.size + 1)
            visited.clear()
        }
        return listOfSums.sorted().reversed().subList(0, 3).reduce { acc, num -> acc * num }
    }

    fun mapOutBasinsRecursive(i: Int, j: Int, visited: MutableSet<Pair<Int, Int>>, oldNeighbors:MutableList<Pair<Int, Int>>): MutableSet<Pair<Int, Int>> {
        visited.addAll(oldNeighbors)
        val neighbors = checkNeighbors(i, j, input)
        neighbors.forEach { mapOutBasinsRecursive(it.first, it.second, visited, neighbors) }
        return visited
    }

    fun findLowPoints(matrix: List<List<Int>>): List<Pair<Int, Int>> {
        val lowPoints = mutableListOf<Pair<Int, Int>>()
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (checkLowPoint(i, j, input)) lowPoints.add(Pair(i, j))
            }
        }
        return lowPoints
    }

    fun checkNeighbors(i:Int, j:Int, matrix: List<List<Int>>): MutableList<Pair<Int, Int>> {
        val neighborCoords = listOf(
            Pair(i-1, j),
            Pair(i+1, j),
            Pair(i, j-1),
            Pair(i, j+1))

        return neighborCoords.filter { matrix.getOrNull(it.first)?.getOrNull(it.second) != null }.filter { pair ->
                val current = matrix[i][j]
                val neighbor = matrix[pair.first][pair.second]

            (neighbor > current) && (neighbor != 9)
            }.toMutableList()

    }

    fun checkLowPoint(indexA: Int, indexB: Int, matrix: List<List<Int>>): Boolean {
        val current = matrix[indexA][indexB]
        val around = listOf(
            if (indexA > 0) matrix[indexA - 1][indexB] else current + 1,
            if (indexA < matrix.size - 1) matrix[indexA + 1][indexB] else current + 1,
            if (indexB > 0) matrix[indexA][indexB - 1] else current + 1,
            if (indexB < matrix[0].size - 1) matrix[indexA][indexB + 1] else current + 1
        )

        return around.all { it > input[indexA][indexB] }
    }
}

fun main() {
    val day9 = Day9()

    println("SolutionA: ${day9.solutionA()}")
    println("SolutionB: ${day9.solutionB()}")
}
