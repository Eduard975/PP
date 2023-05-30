fun main(args: Array<String>) {
    val map = mutableMapOf<Int, String>(Pair(1, "abc"), Pair(2, "def"), Pair(3, "ghi"))

    val mirroredMap = map.entries.associate { (k, v) -> v to k }

    println("Initial Map:$map\nProgram result:$mirroredMap")
}