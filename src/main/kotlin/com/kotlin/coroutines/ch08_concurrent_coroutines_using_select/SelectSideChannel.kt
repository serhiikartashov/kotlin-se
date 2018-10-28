package com.kotlin.coroutines.ch08_concurrent_coroutines_using_select

import kotlinx.coroutines.experimental.channels.*
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.selects.select

fun produceNumbers(side: SendChannel<Int>) = produce<Int> {
    for (num in 1..10) {
        delay(100)
        select<Unit> {
            onSend(num){}
            side.onSend(num){}
        }
    }
    println("Done sending")
}

fun main(args: Array<String>) = runBlocking<Unit> {

    val side = Channel<Int>()

    launch { side.consumeEach { println("side $it") }}

    val producer = produceNumbers(side)

    producer.consumeEach {
        println("$it")
        delay(500)
    }
}
