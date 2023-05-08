import kotlin.concurrent.thread
import kotlinx.coroutines.*
class Vector(numbers: IntArray) {
    var array = numbers;
    var isSorted = false;
    var isMultiplied = false;
}

fun threads(v : Vector, alpha: Int){
    println("Procesare cu Threads\nVector initial: " + v.array.contentToString());

    thread(name="Inmultire"){
        for((i, number) in v.array.withIndex()){
            v.array[i] = v.array[i] * alpha;
        }
        v.isMultiplied = true;
    }

    thread(name="Sortare"){
        while(!v.isMultiplied) {
            Thread.sleep(1);
        }
        v.array.sort()
        v.isSorted = true;
    }

    thread(name="Afisare"){
        while(!v.isSorted) {
            Thread.sleep(1);
        }
        println("Vectorul nou: " + v.array.contentToString());
    }
}

fun coroutines(v : Vector, alpha: Int) = runBlocking<Unit>{
    println("Procesare cu Coroutines\nVector initial: " + v.array.contentToString());

    launch{
        for((i, number) in v.array.withIndex()){
            v.array[i] = v.array[i] * alpha;
        }
        v.isMultiplied = true;
    }

    launch{
        while(!v.isMultiplied) {
            delay(1);
        }
        v.array.sort()
        v.isSorted = true;
    }

    launch{
        while(!v.isSorted) {
            delay(1);
        }
        println("Vectorul nou: " + v.array.contentToString());
    }
}

fun main(args: Array<String>) {
    val v = Vector(intArrayOf(26, 77, 32, 51, -14, 15, 20, 11, 6, 120));
    val v2 = Vector(intArrayOf(226, -37, 22, 15, -1, 150, 201, 111, 62, 10));
    val alpha = 6;

    threads(v, alpha);
    coroutines(v2, alpha);
}