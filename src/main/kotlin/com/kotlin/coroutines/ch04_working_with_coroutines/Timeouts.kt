package com.kotlin.coroutines.ch04_working_with_coroutines

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking {

    val job = withTimeoutOrNull(100) {
        repeat(1000) {
            yield()
            print(".")
            Thread.sleep(1)
        }
    }

    if(job == null){
        println("timout")
    }
    println("done")

}