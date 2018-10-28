package com.kotlin.coroutines.ch07_using_channels

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*

fun produceSquares() : ReceiveChannel<Int> = GlobalScope.produce(Dispatchers.Default, 2, null, {
    for (x in 1..5) {
        println("sending")
        send(x * x)
    }
    println("sending - done")
})

fun main(args: Array<String>) = runBlocking {
    val squares = produceSquares()
    squares.consumeEach { println(it) }
    println("Done!")
}