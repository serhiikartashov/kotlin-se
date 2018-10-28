package com.kotlin.coroutines.ch07_using_channels

import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.runBlocking

fun produceNumbers() = GlobalScope.produce(Dispatchers.Default, 0, null, {
    var x = 1
    while (true) send(x++) // infinite stream of integers starting from 1
})

fun square(numbers: ReceiveChannel<Int>) = GlobalScope.produce(Dispatchers.Default, 0, null, {
    for (x in numbers) send(x * x)
})

fun main(args: Array<String>) = runBlocking<Unit> {
    val numbers = produceNumbers() // produces integers from 1 and on
    val squares = square(numbers) // squares integers
    for (i in 1..5) println(squares.receive()) // print first five
    println("Done!") // we are done
    squares.cancel() // need to cancel these coroutines in a larger app
    numbers.cancel()
}