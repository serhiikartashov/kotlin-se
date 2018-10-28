package com.kotlin.coroutines.ch05_coroutines_context

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking() {

    val jobs = arrayListOf<Job>()

    jobs += launch { // the 'default' context'
        println("          'default': In thread ${Thread.currentThread().name}")
    }
//    jobs += launch(Dispatchers.Default) {
    jobs += launch(DefaultDispatcher) { // the 'default' context'
        println("'defaultDispatcher': In thread ${Thread.currentThread().name}")
    }
//    jobs += launch(Dispatchers.Unconfined) {
    jobs += launch(Unconfined) { // not confined -- will work with main thread
        println("       'Unconfined': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(coroutineContext) { // context of the parent, runBlocking coroutine
        println(" 'coroutineContext': In thread ${Thread.currentThread().name}")
    }
//    jobs += launch(Dispatchers.Default) {
    jobs += launch(CommonPool) { // will get dispatched to ForkJoinPool.commonPool (or equivalent)
        println("       'CommonPool': In thread ${Thread.currentThread().name}")
    }
    // ThreadPooDispatcher
    jobs += launch(newSingleThreadContext("OwnThread")) { // will get its own new thread
        println("           'newSTC': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(newFixedThreadPoolContext(10, "FixedThreads")) { // will get its own new thread
        println("           'newSTC': In thread ${Thread.currentThread().name}")
    }

    jobs.forEach { it -> it.join() }


    println()
    println()
    println()
    var job = launch {

        println("  'launched Thread': In thread ${Thread.currentThread().name}")
        val jobs = arrayListOf<Job>()
        jobs += launch { // the 'default' context'
            println("          'default': In thread ${Thread.currentThread().name}")
        }

        jobs += launch(DefaultDispatcher) {            // the 'default' context'
            println("'defaultDispatcher': In thread ${Thread.currentThread().name}")
        }
        jobs += launch(Unconfined) {            // not confined -- will work with main thread
            println("       'Unconfined': In thread ${Thread.currentThread().name}")
        }
        jobs += launch(coroutineContext) {            // context of the parent, runBlocking coroutine
            println(" 'coroutineContext': In thread ${Thread.currentThread().name}")
        }
        jobs += launch(CommonPool) {            // will get dispatched to ForkJoinPool.commonPool (or equivalent)
            println("       'CommonPool': In thread ${Thread.currentThread().name}")
        }
        jobs += launch(newSingleThreadContext("OwnThread")) {            // will get its own new thread
            println("           'newSTC': In thread ${Thread.currentThread().name}")
        }

        jobs.forEach { it -> it.join() }
    }
    job.join()
}
