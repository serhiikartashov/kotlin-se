package com.kotlin.coroutines.ch07_using_channels

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    val channel = Channel<Int>()
    launch {
        for (x in 1..5) channel.send(x * x)

        // 3. comment this out, show that the for..in does not return
        channel.close()
    }

    // 1. show this first - throws an exception
//    println(channel.receive())
//    repeat(5) { println(channel.receive()) }

    // 2. in channel
    for (y in channel) println(y)
    println("Done!")
}