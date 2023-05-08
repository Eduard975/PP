import kotlin.concurrent.thread

class Vector(numbers: IntArray) {
    var array = numbers;
    var isSorted = false;
}

fun main(args: Array<String>) {
    val v = Vector(intArrayOf(26, 77, 32, 51, -14, 15, 20, 11, 6, 120));
    val alpha = 6;
    println("Vector initial: " + v.array.contentToString());

    thread(){
        for((i, number) in v.array.withIndex()){
            v.array[i] = v.array[i] * alpha;
        }
    }

    thread(){
        v.array.sort()
        v.isSorted = true;
    }


    thread(){
        while(!v.isSorted) {
            Thread.sleep(1);
        }
        println("Vectorul nou: " + v.array.contentToString());
    }
}