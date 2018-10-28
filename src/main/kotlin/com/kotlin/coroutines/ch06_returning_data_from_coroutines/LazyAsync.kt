package com.kotlin.coroutines.ch06_returning_data_from_coroutines

import kotlinx.coroutines.experimental.*

// 1. Should see output from doWorkLazy
//fun main(args: Array<String>) = runBlocking {
//    val job = launch {
//        val result = async {doWorkLazy()}
//        println("result is ${result.await()}")
//    }
//    delay(500)
//    job.join()
//}

// 2. Made async lazy, so never gets invoked -  Should see no output from doWorkLazy
//fun main(args: Array<String>) = runBlocking {
//    val job = launch {
//        val result = async(start = CoroutineStart.LAZY) {doWorkLazy()}
//    }
//    delay(500)
//    job.join()
//}

// 3. Added call to await so it gets invoked -  Should see output from doWorkLazy
fun main(args: Array<String>) = runBlocking {
    val job = launch {
        val result = async(start = CoroutineStart.LAZY) {doWorkLazy()}
        println("resultm is ${result.await()}")
    }
    delay(500)
    job.join()
}

suspend fun doWorkLazy(): Int {
    log("Be lazy")

    delay(200)

    log("Lazy done")

    return 42
}

fun log(msg: String) {
    println("$msg in ${Thread.currentThread().name}")
}