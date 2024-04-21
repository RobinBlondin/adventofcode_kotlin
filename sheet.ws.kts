val mutable = mutableListOf(1, 2, 3, 4, 8, 20)

for((index, element) in mutable.withIndex()) {
    if (mutable[index + 3] - element <= 3) {
        for (i in 1..2) mutable.removeAt(index + i)
    }
    println("""
        Index: $index
        Element: $element
    """.trimIndent())
}