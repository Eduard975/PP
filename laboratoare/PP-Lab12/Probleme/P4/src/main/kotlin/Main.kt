import kotlin.properties.Delegates

fun isPrime(n:Int):Boolean{
    if(n == 2 || n  == -2){
        return true;
    }
    if (n % 2 == 0 || n == 1 || n == -1){
        return false;
    }

    for(i in 3..n/2){
        if(n%i == 0){
            return false
        }
    }

    return true
}

var PrimeNR:Int by Delegates.vetoable(13) { _, _, n -> isPrime(n) }

fun main(args: Array<String>) {
    println("Val Initiala: $PrimeNR");

    PrimeNR = 12;

    println("Val noua? Nope tot $PrimeNR");

    PrimeNR = 7

    println("Val noua: $PrimeNR")
}