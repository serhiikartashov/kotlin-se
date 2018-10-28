package com.kotlin.coroutines.ch04_working_with_coroutines

import kotlinx.coroutines.experimental.*
import java.lang.Exception

fun main(args: Array<String>) = runBlocking {

    val job = launch {
        try {
            repeat(1000) {
                delay(100)
                print(".")
            }
        } catch (e: CancellationException) {
            println()
            println("Canceled: ${e.message}")
        } finally {
//            run(NonCancellable) {
            withContext(NonCancellable) {
                println()
                println("In finally")
            }
        }
    }

    delay(2500)
//    job.cancel()
//    job.join()
//    job.cancel(CancellationException("Too many jobs"))
    job.cancel(Exception())
    job.join()

    println("done")

}