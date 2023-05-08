import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.concurrent.Executors
import kotlin.concurrent.thread


fun sum(n:Int):Int{
    return ((n+1)*n)/2;
}

fun coroutines(v : LinkedList<Int>) = runBlocking {
    var i = 0;
    val process0 = async { sum(v[0]) };
    val process1 = async { sum(v[1]) };
    val process2 = async { sum(v[2]) };
    val process3 = async { sum(v[3]) };

    println("---------Coroutines Processing---------\nRezultate Sume: \nSum 0..37: ${process0.await()}"
            + "\nSum 0..49: ${process1.await()}"
            + "\nSum 0..680: ${process2.await()}"
            + "\nSum 0..900: ${process3.await()}"
    )
}

fun threads(v : LinkedList<Int>) {
    val executor = Executors.newFixedThreadPool(4)
    var process0 = 0;
    var process1 = 0;
    var process2 = 0;
    var process3 = 0;

    thread(name = "p0"){
        process0 = sum(v[0]);
    }

    thread(name = "p1"){
        process1 = sum(v[1]);
    }.join()

    thread(name = "p2"){
        process2 = sum(v[2]);
    }.join()

    thread(name = "p3"){
        process3 = sum(v[3]);
    }.join()




    println("---------Threads Processing---------\nRezultate Sume: \nSum 0..37: ${process0}"
            + "\nSum 0..49: ${process1}"
            + "\nSum 0..680: ${process2}"
            + "\nSum 0..900: ${process3}"
    )
}

fun main(args: Array<String>) {
    val n = LinkedList<Int>();
    n.add(37);
    n.add(49);
    n.add(680);
    n.add(900);

    coroutines(n);
    threads(n);
}