package com.kotlin.coroutines.ch07_using_channels

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

data class Work(var x: Long = 0, var y: Long = 0, var z: Long = 0)

val numberOfWorkers = 10
var totalWork = 20
val finish = Channel<Boolean>()

var workersRunning = AtomicInteger()

suspend fun worker(input: Channel<Work>, output: Channel<Work>) {

    workersRunning.getAndIncrement()
    for (w in input) {
        w.z = w.x * w.y
        delay(w.z)
        output.send(w)
    }
    workersRunning.getAndDecrement()
    if(workersRunning.get() === 0)
    {
        output.close()
        println("Closing output")
    }
}

fun run() {
    val input = Channel<Work>()
    val output = Channel<Work>()

    println("Launch workers")
    repeat (numberOfWorkers) {
        launch { worker(input, output) }
    }
    launch { sendLotsOfWork(input) }
    launch { receiveLotsOfResults(output) }
}

suspend fun receiveLotsOfResults(channel: Channel<Work>) {

    println("receiveLotsOfResults start")

    for(work in channel) {
        println("${work.x}*${work.y} = ${work.z}")
    }
    println("receiveLotsOfResults done")
    finish.send(true)
}

suspend fun sendLotsOfWork(input: Channel<Work>) {
    repeat(totalWork) {
        input.send(Work((0L..100).random(), (0L..10).random()))
    }
    println("close input")
    input.close()
}

fun main(args: Array<String>) {
    run()
    runBlocking { finish.receive() }
    println("main done")
}

private object RandomRangeSingleton : Random()


fun ClosedRange<Long>.random() = (RandomRangeSingleton.nextInt((endInclusive.toInt() + 1) - start.toInt()) + start)