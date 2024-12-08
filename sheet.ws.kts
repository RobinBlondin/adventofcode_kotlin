fun Pair<Int, Int>.getDiffPoint(other: Pair<Int, Int>): Pair<Int, Int> {
    return Pair((this.first - other.first), (this.second - other.second))
}

val pair = Pair(1, 8)
pair.getDiffPoint(Pair(2, 5))
