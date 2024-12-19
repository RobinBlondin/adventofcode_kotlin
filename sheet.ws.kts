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