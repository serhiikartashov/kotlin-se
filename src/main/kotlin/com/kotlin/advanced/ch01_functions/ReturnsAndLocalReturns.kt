package com.kotlin.advanced.ch01_functions

inline fun <T> Iterable<T>.myForEach(action: (T) -> Unit): Unit {
    for (element in this) action(element)
}

fun containingFunction3() {
    val numbers = 1..100
    numbers.myForEach myLabel@{
        if (it % 5 == 0) {
            // inline allow such empty return
            return
        }
    }
    println("Hello")
}

fun containingFunction() {
    val numbers = 1..100
    numbers.forEach {
        if (it % 5 == 0) {
            return@forEach
        }
    }
    println("Hello")
}

// using label
fun containingFunction2() {
    val numbers = 1..100
    numbers.myForEach myLabel@{
        if (it % 5 == 0) {
            return@myLabel
        }
    }
    println("Hello")
}


@Suppress("UNUSED_EXPRESSION")
fun containingFunction4() {
    val numbers = 1..100
    numbers.forEach { fun(element: Int) {
        if (element % 5 == 0) {
            return
        }
    }}
    println("Hello")
}
fun main(args: Array<String>) {
    containingFunction()
    containingFunction2()
    containingFunction3()
}