package com.kotlin.coroutines.ch08_concurrent_coroutines_using_select

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.selects.select

fun producer1() = produce{
    while(true) {
//        delay(200)
        send("from producer 1")
    }
}

fun producer2() = produce{
    while(true) {
//        delay(300)
        send("from producer 2")
    }
}

suspend fun selector(message1: ReceiveChannel<String>, message2: ReceiveChannel<String>) {
    // return Nothing -> Unit
    select<Unit> {
        message1.onReceive { value ->
            println(value)
        }
        message2.onReceive { value ->
            println(value)
        }
    }
}

fun main(args: Array<String>) = runBlocking<Unit> {
    val m1 = producer1()
    val m2 = producer2()

    repeat(150) {
        selector(m1, m2)
    }
}
