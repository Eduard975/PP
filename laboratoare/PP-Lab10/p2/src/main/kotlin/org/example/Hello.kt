package com.pp.laborator

import kotlinx.coroutines.*
import kotlin.system.*

sealed class ADT {
    data class adt(
        val durata: Int,
        val operatii: Int,
        val numarator: Int
    ) : ADT()
}
suspend fun CoroutineScope.massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n)
        {
            coroutineScope { launch { repeat(k) { action() } } }
        }
        jobs.forEach { it.join() }
    }

    Object ADT

}

@OptIn(DelicateCoroutinesApi::class)
val mtContext = newFixedThreadPoolContext(2, "mtPool")
var counter = 0
fun main() = runBlocking<Unit> {
    CoroutineScope(mtContext).massiveRun {
        counter++ //variabila comuna unde vor aparea erori
    }
    println("Numarator = $counter")
}
