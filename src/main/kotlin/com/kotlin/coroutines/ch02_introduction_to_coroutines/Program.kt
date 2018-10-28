package com.kotlin.coroutines.ch02_introduction_to_coroutines

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask
import kotlin.system.measureTimeMillis

val SEQUENTIAL_THRESHOLD1 = 5000

// For/Join impl by Kotlin
fun compute1(array: IntArray, low: Int, high: Int): Long {

    println("low: $low, high: $high  on ${Thread.currentThread().name}")

    return if (high - low <= SEQUENTIAL_THRESHOLD1) {
        (low until high)
                .map { array[it].toLong() }
                .sum()
    } else {
        val mid = low + (high - low) / 2
        val left = compute1(array, low, mid)
        val right = compute1(array, mid, high)
        return left + right
    }
}

internal class Sum(private var array: IntArray, private var low: Int, private var high: Int) : RecursiveTask<Long>() {

    override fun compute(): Long {
        return if (high - low <= SEQUENTIAL_THRESHOLD) {
            (low until high)
                    .map { array[it].toLong() }
                    .sum()
        } else {
            val mid = low + (high - low) / 2
            val left = Sum(array, low, mid)
            val right = Sum(array, mid, high)
            left.fork()
            val rightAns = right.compute()
            val leftAns = left.join()
            leftAns + rightAns
        }
    }

    companion object {
        val SEQUENTIAL_THRESHOLD = 5000

        fun sumArray(array: IntArray): Long {
            return ForkJoinPool.commonPool().invoke(Sum(array, 0, array.size))
        }
    }
}

fun main(args: Array<String>)  {

//    val list = mutableListOf<Int>()
//
//    var limit = 20_000_000
//
//    while (limit > 0) {
//        list.add(limit--)
//    }
//
//    var result = 0L
//    var time = measureTimeMillis {
//        result = compute1(list.toIntArray(), 0, list.toIntArray().size)
//    }
//
//    result = 0L
//    time = measureTimeMillis {
//        result = compute1(list.toIntArray(), 0, list.toIntArray().size)
//    }
//
//    print("$result in ${time}ms")

    val list = mutableListOf<Int>()

    var limit = 20_000_000

    while (limit > 0) {
        list.add(limit--)
    }

    var result = 0L
    var time = measureTimeMillis {
        result = Sum.sumArray(list.toIntArray())
    }

    result = 0L
    time = measureTimeMillis {
        result = Sum.sumArray(list.toIntArray())
    }

    print("$result in ${time}ms")

}