val list = listOf("ab", "ac", "ad", "af")
val str = "a"
list.count { it.contains(str) } == list.size