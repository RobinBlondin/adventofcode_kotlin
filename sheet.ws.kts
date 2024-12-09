fun Pair<Int, Int>.getDiffPoint(other: Pair<Int, Int>): Pair<Int, Int> {
    return Pair((this.first - other.first), (this.second - other.second))
}

val pair = Pair(1, 8)
pair.getDiffPoint(Pair(2, 5))

val list = listOf(10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11)

val list2 = list.takeLast(4)

println(list.indexOfLast { it == 10 })
