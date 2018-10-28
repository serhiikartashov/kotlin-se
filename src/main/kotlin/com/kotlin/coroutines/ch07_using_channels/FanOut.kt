package com.kotlin.coroutines.ch07_using_channels

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.produce

fun produceNumbers2() = GlobalScope.produce(Dispatchers.Default, 2, null, {
    var x = 1 // start from 1
    while (true) {
        send(x++) // produce next
        delay(100) // wait 0.1s
    }
})

fun consumer(id: Int, channel: ReceiveChannel<Int>) = GlobalScope.launch(Dispatchers.Default, CoroutineStart.DEFAULT, null, {
    channel.consumeEach {
        println("Processor #$id received $it in thread ${Thread.currentThread().name}")
    }
})

fun main(args: Array<String>) = runBlocking<Unit> {
    val producer = produceNumbers2()
    repeat(5) { consumer(it, producer) }
    println("launched")
    delay(950)
    producer.cancel() // cancel producer coroutine and thus kill them all
}