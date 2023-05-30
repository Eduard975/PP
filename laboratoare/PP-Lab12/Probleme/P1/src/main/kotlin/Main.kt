fun Int.isPrime():Boolean{
    if(this == 2 || this  == -2){
        return true;
    }
    if (this % 2 == 0 || this == 1 || this == -1){
        return false;
    }

    for(i in 3..this/2){
        if(this%i == 0){
            return false
        }
    }

    return true
}

fun main(args: Array<String>) {
    val n = 17;
    println("Este prim? ${n}: ${n.isPrime()}")
}