package com.kotlin.introduction.ch09_standard_libs

fun main(args: Array<String>) {
    val elements = 1..10000000000000000

    /*val output = elements.asSequence().filter { it < 30 }.map { Pair("Yes", it) }

    output.forEach {
        println(it)
    }*/

    // parallel processing is not available in sequences
    val output = elements.asSequence().take(30).sum()
    println(output)

    val numbers = generateSequence(1) { x -> x +10}

    println(numbers.take(30).sum())

    val lazyInit: Int by lazy { 10 }


}