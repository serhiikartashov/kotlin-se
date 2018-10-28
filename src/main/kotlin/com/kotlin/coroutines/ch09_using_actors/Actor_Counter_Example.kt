package com.kotlin.coroutines.ch09_using_actors

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.actor
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.system.measureTimeMillis

suspend fun run(context: CoroutineContext, numberOfJobs: Int, count: Int, action: suspend () -> Unit): Long {
    // action is repeated by each coroutine
    return measureTimeMillis {
        val jobs = List(numberOfJobs) {
            launch(context) {
                repeat(count) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
}

sealed class CounterMsg
object InitCounter : CounterMsg()
object IncCounter : CounterMsg()
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()

fun counterActor() = GlobalScope.actor<CounterMsg>(Dispatchers.Default, 0, CoroutineStart.DEFAULT, null, {
    var counter = 0
    for(msg in channel) {
        when(msg) {
            is InitCounter -> counter = 0
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
})

fun main(args: Array<String>) = runBlocking<Unit> {
    val jobs = 100
    val count = 10000

    val counter = counterActor()

    counter.send(InitCounter)

    val time = run(CommonPool, jobs, count) {
        counter.send(IncCounter)
    }

    var response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))

    println("Completed ${jobs * count} actions in $time ms")
    println("result is ${response.await()}")
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
