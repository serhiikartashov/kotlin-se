package com.kotlin.coroutines.ch05_coroutines_context

import kotlinx.coroutines.experimental.*

// 2. Point of this is to show that can cancel the children without the parents
fun main(args: Array<String>) = runBlocking {
    var inner: Job? = null

    val outer = launch {
        try {
            inner = launch(coroutineContext) {
                try {
                    repeat(2000) {
                        print(".")
                        delay(10)
                    }
                } catch (ex: Exception) {
                    println()
                    println("In inner catch")
                } finally {
                    println("In inner finally")
                }
            }
        } catch (ex: CancellationException) {
            println("In outer catch")
        } finally {
            println("In outer finally")
        }
    }

    delay(200)
    outer.cancelChildren()
    outer.join()
    delay(4000)
    println()
    println("inner.isCancelled? ${inner?.isCancelled}")
    println("inner.isCompleted? ${inner?.isCompleted}")
    println("outer.isCancelled? ${outer.isCancelled}")
}


// 3. add the delay (without try catch around it)
//fun main(args: Array<String>) = runBlocking {
//    var inner: Job? = null
//    val outer = launch {
//        try {
//            inner = launch(coroutineContext) {
//                try {
//                    repeat(2000) {
//                        print(".")
//                        delay(10)
//                    }
//                } catch (ex: Exception) {
//                    println()
//                    println("In inner catch")
//                } finally {
//                    println("In inner finally")
//                }
//            }
//            println("About to delay")
//            delay(5000)
//            println("After to delay")
//        } catch (ex: CancellationException) {
//            println("In outer catch")
//        } finally {
//            println("In outer finally")
//        }
//    }
//
//    delay(200)
//    outer.cancelChildren()
//    outer.join()
//    delay(2000)
//    println()
//    println("inner.isCancelled? ${inner?.isCancelled}")
//    println("inner.isCompleted? ${inner?.isCompleted}")
//    println("outer.isCancelled? ${outer.isCancelled}")
//}


// 4. With the try..catch around the delay, show that delay throws the exception
// and that this makes sense as the parent should know if the child has been cancelled
//fun main(args: Array<String>) = runBlocking {
//    var inner: Job? = null
//    val outer = launch {
//        try {
//            inner = launch (coroutineContext) {
//                try {
//                    repeat(2000) {
//                        print(".")
//                        delay(10)
//                    }
//                } catch (ex: Exception) {
//                    println()
//                    println("In inner catch")
//                } finally {
//                    println("In inner finally")
//                }
//            }
//            try {
//                // propagates the CancellationException
//                // don't need the delay as the parent joins its children automatically
//                // but shows what happens when cancellation happens
//                delay(5000)
//            }catch(ex: CancellationException) {
//                println()
//                println("Caught: ${ex.message}")
//            }
//        } catch (ex: CancellationException) {
//            println("In outer catch")
//        } finally {
//            println("In outer finally")
//        }
//    }
//
//    delay(200)
//    outer.cancelChildren()
//    outer.join()
//    delay(4000)
//    println()
//    println("inner.isCancelled? ${inner?.isCancelled}")
//    println("inner.isCompleted? ${inner?.isCompleted}")
//    println("outer.isCancelled? ${outer.isCancelled}")
//}
