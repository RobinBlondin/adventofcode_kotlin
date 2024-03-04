val list = listOf(1, 2, 3, 4, 5, 6)

list.map { it }.reduce(Int::times)