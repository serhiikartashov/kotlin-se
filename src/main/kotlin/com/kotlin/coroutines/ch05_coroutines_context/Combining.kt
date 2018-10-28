package com.kotlin.coroutines.ch05_coroutines_context

import kotlinx.coroutines.experimental.*

// 1. combining to give a context a name
//fun main(args: Array<String>) = runBlocking {
//    println("     'runBlocking': I'm working in thread ${Thread.currentThread().name}")
//
//
//    val job = launch(CoroutineName("kevin-context") + coroutineContext) {
//        // not confined -- will work with main thread
//        println("'coroutineContext': I'm working in thread ${Thread.currentThread().name}")
//    }
//
//    job.join()
//
//}

// 2. Combining behaviour
fun main(args: Array<String>) = runBlocking {
    println("     'runBlocking': I'm working in thread ${Thread.currentThread().name}")


    val jobs = arrayListOf<Job>()
    jobs += launch(coroutineContext) {
        // not confined -- will work with main thread
        println("'coroutineContext': I'm working in thread ${Thread.currentThread().name}")
    }

    jobs += launch(coroutineContext + CommonPool) {
        delay(1)
        // not confined -- will work with main thread
        println("        'combined': I'm working in thread ${Thread.currentThread().name}")
    }

    jobs.forEach{it -> it.join()}

}

// 1. problem with this code is that the singleThreadContext is expensive
//fun main(args: Array<String>) = runBlocking {
//
//
//    val job = launch(newSingleThreadContext("SingleThreadContext")) {
//        // not confined -- will work with main thread
//        println("'SingleThreadContext': I'm working in thread ${Thread.currentThread().name}")
//    }
//
//    job.join()
//
//}

// 2. maybe use this instead
//fun main(args: Array<String>) = runBlocking {
//
//
//    newSingleThreadContext("SingleThreadContext").use { ctx ->
//        val job = run(ctx) {
//
//            println("'SingleThreadContext': I'm working in thread ${Thread.currentThread().name}")
//        }
//
////        job.join()
//    }
//
//}

