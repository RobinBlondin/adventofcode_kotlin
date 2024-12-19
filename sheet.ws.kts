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

val num = 6349492251099
          6349485688066


"11....22..333..444.." 8
 0  1  2  3 4  5 6 7

11444.22..333....... 7
0  1 2 3    4     5   6