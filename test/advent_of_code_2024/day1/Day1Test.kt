package advent_of_code_2024.day1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test {
  private val day1 = Day1("test/advent_of_code_2024/day1/input.txt")
  @Test
  fun solutionA() {
   Assertions.assertEquals(11, day1.solutionA())
  }

  @Test
  fun solutionB() {
    Assertions.assertEquals(31, day1.solutionB())
  }
}