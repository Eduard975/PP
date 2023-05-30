fun main(args: Array<String>) {
    val og = "aaaaabbbbbccccc"

    val ans = og.toCharArray().distinct().joinToString("")


    println("String Original $og")
    println("Program arguments: $ans")
}