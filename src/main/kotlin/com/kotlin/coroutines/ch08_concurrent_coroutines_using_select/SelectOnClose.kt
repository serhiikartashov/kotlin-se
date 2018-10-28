package com.kotlin.coroutines.ch08_concurrent_coroutines_using_select

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.selects.select

fun producer11() = produce {
    send("from producer 1")
}

fun producer22() = produce {
    send("from producer 2")
}

suspend fun selector2(message1: ReceiveChannel<String>, message2: ReceiveChannel<String>): String =
        // return String
        select<String> {
            // onReceiveOrNull
            message2.onReceiveOrNull { value ->
                value ?: "Channel 2 is closed"
            }
            message1.onReceiveOrNull { value ->
                value ?: "Channel 1 is closed"
            }
        }


fun main(args: Array<String>) = runBlocking<Unit> {
    val m1 = producer11()
    val m2 = producer22()

    repeat(15) {
        println(selector2(m1, m2))
    }
}
