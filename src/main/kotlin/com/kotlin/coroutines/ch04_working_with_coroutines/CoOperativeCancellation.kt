package com.kotlin.coroutines.ch04_working_with_coroutines

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking {

    val job = launch {
        repeat(1000) {
//            if (!isActive) throw CancellationException()
            if (!isActive) return@launch
//            if (!isActive) return@repeat
            print(".")
//            yield()
            Thread.sleep(1)
        }
    }

    delay(2500)
    job.cancelAndJoin()
    println("done")

}