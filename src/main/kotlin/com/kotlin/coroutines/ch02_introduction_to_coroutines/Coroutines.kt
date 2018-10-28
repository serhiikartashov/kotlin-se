package com.kotlin.coroutines.ch02_introduction_to_coroutines

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis


val SEQUENTIAL_THRESHOLD = 5000

suspend fun compute2(array: IntArray, low: Int, high: Int): Long {

//    println("low: $low, high: $high  on ${Thread.currentThread().name}")

    return if (high - low <= SEQUENTIAL_THRESHOLD) {
        (low until high)
                .map { array[it].toLong() }
                .sum()
    } else {
        val mid = low + (high - low) / 2
        val left = async { compute2(array, low, mid) }
        val right = compute2(array, mid, high)
        return left.await() + right
    }
}

fun main(args: Array<String>) = runBlocking {

    val list = mutableListOf<Int>()

    var limit = 20_000_000

    while (limit > 0) {
        list.add(limit--)
    }

    var result = 0L
    var time = measureTimeMillis {
        result = compute2(list.toIntArray(), 0, list.toIntArray().size)
    }

    result = 0L
    time = measureTimeMillis {
        result = compute2(list.toIntArray(), 0, list.toIntArray().size)
    }

    print("$result in ${time}ms")

}