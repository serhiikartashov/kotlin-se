package com.kotlin.coroutines.ch05_coroutines_context

import kotlinx.coroutines.experimental.*

// 1. show this running with the context names
// 2, then add the CoroutineName("main context") to the runBlocking call
// ask how to do this to launch (can't without combining)
// WON'T WORK!!!
fun main(args: Array<String>) = runBlocking(CoroutineName("main context")) {
//
//fun main(args: Array<String>) = runBlocking() {
    println("     'runBlocking': I'm working in thread ${Thread.currentThread().name}")

    val jobs = arrayListOf<Job>()
    jobs += launch(Unconfined) {
        // not confined -- will work with main thread
        println("    'Unconfined 1': I'm working in thread ${Thread.currentThread().name}")
        delay(500)
        println("    'Unconfined 1': After delay in thread ${Thread.currentThread().name}")
    }
    jobs += launch(coroutineContext ) {
        // context of the parent, runBlocking coroutine
        println("'coroutineContext': I'm working in thread ${Thread.currentThread().name}")
        delay(1000)
        println("'coroutineContext': After delay in thread ${Thread.currentThread().name}")
    }
    jobs.forEach { it.join() }

}

private suspend fun doWork() {

}