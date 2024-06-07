package advent_of_code_2021.day4

import java.io.File

class Day4(val path: String = "src/advent_of_code_2021/day4/input.txt") {
    val input = File(path).readLines()
    private val numbers = input[0].split(",").map { it.toInt() }
    private val boards = input.drop(1).filter { it.isNotBlank() }.chunked(5) { chunk ->
        chunk.map { it.trim().split(Regex("\\s+")).map(String::toInt) }
    }
    private val resultList = mutableListOf<Int>()


    fun solutionA(): Int {
        loop@
        for(i in 5 until numbers.size) {
           for (j in boards.indices) {
               val result = bingoCheck(boards[j], numbers.subList(0, i))
               if (result != 0) {
                   return result
               }
           }
        }
        return 0
    }

    fun solutionB(): Int {
        val map = mutableMapOf<Int, List<List<Int>>>()
        outer@
        for (board in boards) {
            for (i in 5 until numbers.size) {
                val row = checkRows(board, numbers.subList(0, i))
                val column = checkRows(rotateBoard(board), numbers.subList(0, i))
                if(row || column) {
                    map[i] = board
                    continue@outer
                }
            }
        }
        val lastWinningBoard = map[map.keys.max()]
        val drawnNumbersForLastWinningBoard = numbers.subList(0, map.keys.max())
        val boardWithoutDrawnNumbers = lastWinningBoard!!.map { it.filter { boardNum -> !drawnNumbersForLastWinningBoard.contains(boardNum) } }
        return boardWithoutDrawnNumbers.sumOf { it.sum() } * drawnNumbersForLastWinningBoard.last()
    }

    private fun bingoCheck(board: List<List<Int>>, numbers: List<Int>): Int {
        if (checkRows(board, numbers)) {
            val totalSum = board.sumOf { it.filter { num -> !numbers.contains(num) }.sum() }
            return (totalSum) * numbers.last()
        } else if (checkRows(rotateBoard(board), numbers)) {
            val totalSum = rotateBoard(board).sumOf { it.filter { num -> !numbers.contains(num) }.sum() }
            return (totalSum) * numbers.last()
        } else
            return 0
    }

    private fun checkRows(board: List<List<Int>>, numbers: List<Int>): Boolean {
        for (row in board) {
            if(numbers.containsAll(row)) {
                return true
            }
        }
        return false
    }

    fun rotateBoard(board: List<List<Int>>): List<List<Int>> {
        val list: MutableList<MutableList<Int>> = MutableList(board.size) { mutableListOf() }
        for (i in board.indices) {
            for(j in board.indices) {
                list[i].add(board[j][i])
            }
        }
        return list.toList()
    }
}

fun main() {
    val day4 = Day4()
    println("Solution A: ${day4.solutionA()}")
    println("Solution B: ${day4.solutionB()}")
}

