package com.kotlin.coroutines.ch08_concurrent_coroutines_using_select

import kotlinx.coroutines.experimental.channels.*
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.selects.select

fun producer() = produce {
    var i = 0
    while(true) {
        delay(5000)
        send(i++)
    }
}

fun main(args: Array<String>) = runBlocking<Unit> {
    var msg = producer()
    select<Unit> {
        msg.onReceive {
            println(it)
        }
        onTimeout(100) {
            println("Timed out!!!")
        }
    }
}