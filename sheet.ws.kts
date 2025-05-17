fun encodeNumber(number: Int): Char {
    val baseOffset = 0x4E00
    val maxOffset = 0x9FFF
    val charCode = baseOffset + number
    return if (charCode in baseOffset..maxOffset) charCode.toChar() else {
        println("error zone")
        ' '
    }
}

fun decodeChar(encoded: Char): Int {
    val baseOffset = 0x4E00
    return encoded.code - baseOffset
}
val num = "20"
val (l, r) = num.chunked(num.length / 2)


val numStr = num
val mid = numStr.length / 2
val left = numStr.substring(0, mid).toLong()
val right = numStr.substring(mid).toLong()

println(left)
println(right)