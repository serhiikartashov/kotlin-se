package com.kotlin.coroutines.ch05_coroutines_context

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking() {

    val jobs = arrayListOf<Job>()
    jobs += launch(Unconfined) { // not confined -- will work with main thread
        println("    'Unconfined 1': I'm working in thread ${Thread.currentThread().name}")
        delay(500)
        println("    'Unconfined 1': After delay in thread ${Thread.currentThread().name}")
    }
    jobs += launch(Unconfined) { // not confined -- will work with main thread
        println("    'Unconfined 2': I'm working in thread ${Thread.currentThread().name}")
        yield()
        println("    'Unconfined 2': After yield in thread ${Thread.currentThread().name}")
        delay(500)
        println("    'Unconfined 2': After delay in thread ${Thread.currentThread().name}")
    }
    jobs += launch(coroutineContext) { // context of the parent, runBlocking coroutine
        println("'coroutineContext': I'm working in thread ${Thread.currentThread().name}")
        delay(1000)
        println("'coroutineContext': After delay in thread ${Thread.currentThread().name}")
    }
    jobs.forEach { it.join() }

}

private suspend fun doWork() {

}