package com.pp.laborator

/**
 * Arrays
 */
val intArray: Array<Int> = arrayOf(1, 2, 3)
val primitiveIntArray: IntArray = intArrayOf(1, 2, 3)
val copyOfArray: Array<Int> = intArray.copyOf()
val partialCopyOfArray: Array<Int> = intArray.copyOfRange(0, 2)

/**
 * Lists
 */
val intList: List<Int> = listOf(1, 2, 3) //Or arrayListOf(1,2,3)
val emptyList: List<Int> = emptyList() // Or listOf()
val listWithNonNullElements: List<Int> = listOfNotNull(1, null, 3) // --> List(1,3)

/**
 * Sets
 */
val aSet: Set<Int> = setOf(1) // Or hashSetOf(1) / linkedSerOf(1)
val emptySet: Set<Int> = emptySet() // Or setOf() / hashSetOf() / linkedSetOf()

/**
 * Maps
 */
val aMap: Map<String, Int> = mapOf("hi" to 1, "hello" to 2) // Or mapOf(Pair("hi", 1) / hashMapOf("hi" to 1) / linkedMapOf("hi" to 1)
val emptyMap: Map<String, Int> = emptyMap() // Or mapOf()/hashMapOf()/linkedMapOf()
val defaultingMap: Map<String, Int> = aMap.withDefault { key -> if (key == "no") 1 else 999 }


/**
 * Black sheep, mutables
 */
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
val mutableSet: MutableSet<Int> = mutableSetOf(1)
var mutableMap: MutableMap<String, Int> = mutableMapOf("hi" to 1, "hello" to 2)


/**
 * Operates on all iterables
 */
fun operate(): Unit {
    assert(listOf(1, 2, 3, 1) == intList + 1) // [1, 2, 3, 4]
    assert(listOf(2, 3) == intList - 1) // [2, 3]

    assert(listOf(1, 2, 3, 1, 2, 3) == intList + listOf(1, 2, 3)) // [1, 2, 3, 1, 2, 3]
    assert(listOf(3) == intList - listOf(1, 2)) // [3]

    assert(mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3) == aMap + Pair("Goodbye", 3)) // {hi=1, hello=2, Goodbye=3}
    assert(mapOf("hi" to 1) == aMap - "hello") // Takes in a key and removes if found

    assert(mapOf("hi" to 1, "hello" to 2, "Goodbye" to 3) == aMap + mapOf(Pair("hello", 2), Pair("Goodbye", 3))) // {hi=1, hello=2, Goodbye=3}
    assert(emptyMap<String, Int>() == aMap - listOf("hello", "hi")) // Takes in an iterable of keys and removes if found

    /**
     * For Black sheep - mutants
     */
    mutableList -= 2
    println(mutableList) // [1, 3]
    mutableList += 2
    println(mutableList) // [1, 3, 2]

    mutableMap.minusAssign("hello") // {hi=1} same as -=
    println(mutableMap) //
    mutableMap.plusAssign("Goodbye" to 3) // {hi=1, Goodbye=3} same as +=
    println(mutableMap)
}
