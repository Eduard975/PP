fun main(args: Array<String>) {
    val og = "aaaabbbccd"

    var ans = og.toCharArray().toList().groupingBy { it }.eachCount().toList().joinToString()

    println("String initial; $og")
    println("String nou: $ans")
}