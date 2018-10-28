package com.kotlin.coroutines.ch05_coroutines_context

import kotlinx.coroutines.experimental.*

// 1. show that parent waits for children automatically
// first run without a coroutineContext
// then run with a coroutineContext
fun main(args: Array<String>) = runBlocking {
    var inner: Job? = null
    val outer = launch {
        launch {
            repeat(100) {
                print(".")
                delay(1)
            }
        }
    }

    outer.join()
    println("Finished")
}

//1.a then run with a coroutineContext
//fun main(args: Array<String>) = runBlocking {
//    var inner: Job? = null
//    val outer = launch {
//        launch(coroutineContext) {
//            repeat(100) {
//                print(".")
//                delay(1)
//            }
//        }
//    }
//
//    outer.join()
//    println("Finished")
//}
