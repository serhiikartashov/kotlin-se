package com.kotlin.coroutines.ch02_introduction_to_coroutines

import kotlinx.coroutines.experimental.launch
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    val result = AtomicInteger()

    for (i in 1..1_500_000) {
        // shared pool of threads
        launch {
            result.getAndIncrement()
        }

//        thread(start = true) {
//            result.getAndIncrement()
//        }
    }

    Thread.sleep(1000)
    println(result.get())
}