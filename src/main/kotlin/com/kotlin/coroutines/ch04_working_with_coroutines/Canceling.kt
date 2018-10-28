package com.kotlin.coroutines.ch04_working_with_coroutines

import kotlinx.coroutines.experimental.cancelAndJoin
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {

    val job = launch {
        repeat(1000) {
            delay(100)
            print(".")
        }
    }

    delay(2500)
//    job.cancel()
//    job.join()
    job.cancelAndJoin()

    println("done")

}