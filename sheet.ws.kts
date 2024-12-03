val str = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))\n\n"

val pattern = "do\\(\\)".toRegex()
pattern.containsMatchIn(str)


pattern.findAll(str).map { matchResult -> matchResult.value.replace("mul(", "").replace(")", "").split(",") }.toList()

