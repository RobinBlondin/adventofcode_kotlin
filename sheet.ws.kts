val nums = listOf(11, 6, 16, 20)
val operators = listOf('*', '|', '*')
val list = listOf(6L, 8L, 6L, 15L)

fun calculateB(length: Int, chars: CharArray): MutableList<String> {
    if (length == 0) return mutableListOf("")

    val combinations = calculateB(length - 1, chars)
    val result = mutableListOf<String>()

    for (combo in combinations) {
        for (char in chars) {

            result.add(combo + char)
        }
    }

    return result
}

calculateB(4, charArrayOf('1', '0'))

