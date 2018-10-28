package com.kotlin.coroutines.ch02_introduction_to_coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {

    launch {
        delay(1000)
        println("World")
    }
    print("Hello, ")
    Thread.sleep(1500)

//    thread {
//        sleep(1000)
//        println("World")
//    }
//    println("Hello, ")
//
//    Thread.sleep(1500)
}