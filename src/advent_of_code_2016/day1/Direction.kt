package advent_of_code_2016.day1

class Direction(var current: Way = Way.NORTH) {
    fun turn(direction: String) {
        current = when(direction) {
            "R" -> {
                when (current) {
                    Way.NORTH -> Way.EAST
                    Way.EAST -> Way.SOUTH
                    Way.SOUTH -> Way.WEST
                    Way.WEST -> Way.NORTH
                }
            }
            "L" -> {
                when (current) {
                    Way.NORTH -> Way.WEST
                    Way.WEST -> Way.SOUTH
                    Way.SOUTH -> Way.EAST
                    Way.EAST -> Way.NORTH
                }
            }
            else -> Way.NORTH
        }
    }
}
