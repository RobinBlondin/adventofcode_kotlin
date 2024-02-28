val map = mapOf("bright white" to listOf("1 shiny gold bag.", "2 shiny gold bag"))

map.values.sumOf { it.count { it.contains("gold") }}