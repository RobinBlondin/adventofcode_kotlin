val str = "aaaaabbbbcc"
val range:IntRange = 1..5
str.count {it.toString() == "a"} in range
