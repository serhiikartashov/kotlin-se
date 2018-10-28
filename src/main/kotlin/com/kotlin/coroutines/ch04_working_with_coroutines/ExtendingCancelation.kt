package com.kotlin.coroutines.ch04_working_with_coroutines

import kotlinx.coroutines.experimental.*
import java.io.IOException

// 4. Handling exceptions
//fun main(args: Array<String>) = runBlocking {
//    val job = launch (coroutineContext + CoroutineExceptionHandler({_, e ->
//        println("In handler ${e.message}")
//    })) {
//        try {
//            delay(1000)
//        } catch(ex: CancellationException) {
//            println("Cancelled: ${ex.message}")
//        }
//    }
//
//    // 1. Show message ("Job was cancelled normally")
//    // job.cancel()
//    // 2. Show message Reasons to be cheerful
//    //job.cancel(CancellationException("Reasons to be cheerful"))
//    // 3. Show that the exception is thrown to the top of the thread
//    job.cancel(IOException("Reasons to be cheerful"))
//
//    job.join()
//}


//fun main(args: Array<String>) = runBlocking {
//    val job = launch {
//        try {
//            delay(1000)
//        } catch(ex: CancellationException) {
//            println("Cancelled: ${ex.message}")
//        }
//    }
//
//    // 1. Show message ("Job was cancelled normally")
//    // job.cancel()
//    // 2. Show message Reasons to be cheerful
//    //job.cancel(CancellationException("Reasons to be cheerful"))
//    // 3. Show that the exception is thrown to the top of the thread
//    job.cancel(IOException("Reasons to be cheerful"))
//    // 4. Can fix this, but in the next chapter
//    job.join()
//}