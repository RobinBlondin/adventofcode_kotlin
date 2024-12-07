
val nums = listOf(11, 6, 16, 20)
val operators = listOf('*', '|', '*')
val list = listOf(6L, 8L, 6L, 15L)

fun calculateB(calc: List<Long>, index: Int, operators: List<Char> ): Long {
    if(index >= operators.size) return calc.first()

    val result = mutableListOf<Long>()

    when(operators[index]) {
        '*' -> result.add(calc[0] * calc[1])
        '+' -> result.add(calc[0] + calc[1])
        else -> result.add((calc[0].toString() + calc[1].toString()).toLong())
    }

    result.addAll(calc.drop(2))
    return calculateB(result, index + 1, operators)
}

calculateB(list, 0, operators)

