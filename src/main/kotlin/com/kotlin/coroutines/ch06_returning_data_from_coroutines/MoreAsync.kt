package com.kotlin.coroutines.ch06_returning_data_from_coroutines

import kotlinx.coroutines.experimental.*

// 3. show the code as is
// 4. uncomment the result.await, shows the async is concurrent
fun main(args: Array<String>) = runBlocking {
    log("main")
    val job = launch {
        log("launch")
        val result = async(coroutineContext) {
            doWork("Work 1")
        }
        println(result.await())
        doWork("Work 2")

    }

    job.join()

    println("Active: ${job.isActive}")
    println("Cancelled: ${job.isCancelled}")
}

suspend fun doWork(msg: String): Int {
    log2("$msg - Working")
    delay(500)
    log2("$msg - Work done")
    return 42
}

fun log2(msg: String) {
    println("$msg in ${Thread.currentThread().name}")
}