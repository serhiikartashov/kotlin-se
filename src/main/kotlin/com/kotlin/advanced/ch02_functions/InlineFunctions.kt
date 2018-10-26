package com.kotlin.advanced.ch02_functions

import java.lang.Exception

// inline provide for us optimization
// just copy that function and past it in place where it called
// noinline - don't inline this lambda
inline fun operation(noinline op: () -> Unit) {
    println("Before calling op()")
    op()
    println("After calling op()")
}

fun operation2(op: () -> Unit) {
    println("Before calling op()")
    op()
    throw Exception()
    println("After calling op()")
}

inline fun tryingToInline(noinline op: () -> Unit) {
    val reference = op
    println("Value")
    op()
}

fun anotherFunction() {
    operation { println()}
}

fun main(args: Array<String>) {
    operation { println("This is actual op function") }
    operation2 { println("This is actual op function") }
}