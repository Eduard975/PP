fun dupelist(n:Int, list: MutableList<Int>): MutableList<Int> {
    var newList = mutableListOf<Int>();

    for(element in list){
        for(i in 0 until n){
            newList.add(element)
        }
    }

    return newList;
}

fun main(args: Array<String>) {
    var list = mutableListOf<Int>(1,2,3)
    println("Lista Originala: $list")

    val n = 3;

    list = dupelist(n, list);

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Lista Noua: $list")
}