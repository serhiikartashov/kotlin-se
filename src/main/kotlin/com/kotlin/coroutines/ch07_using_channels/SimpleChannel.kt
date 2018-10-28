package com.kotlin.coroutines.ch07_using_channels

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking{
    val channel = Channel<Int>()

    val job = launch {
        for (x in 1..5){
            println("send $x")
            channel.send(x)
        }
    }

    println("receive: ${channel.receive()}")
    repeat(4) {
        println("receive: ${channel.receive()}")
    }
    job.join()
}