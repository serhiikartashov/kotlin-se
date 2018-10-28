package com.kotlin.coroutines.ch10_coroutines_in_ui_apps

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor
import kotlin.coroutines.experimental.CoroutineContext

//sealed class PiMessage
//class Start(val response: CompletableDeferred<Double>, val workers: Long) : PiMessage()
//class Work(var channel: Channel<PiMessage>, val start: Long, val end: Long, val worker: Long) : PiMessage()
//class Result(val result: Double) : PiMessage()
//
//fun piActor(context: CoroutineContext) = actor<Work>(context + actor) {
//    var total = 0.0
//
//    for (msg in channel) {
//        for (i in msg.start until msg.end) {
//            if (isActive) {
//                if (i % 100_000_000 == 0L) print(msg.worker)
//                total += 4.0 * (1 - (i % 2) * 2) / (2 * i + 1)
//            } else {
//                throw CancellationException()
//            }
//        }
//        msg.channel.send(Result(total))
//    }
//}
//
//
//fun workerActor(context: CoroutineContext) = actor<PiMessage>(context + actor) {
//    lateinit var response: CompletableDeferred<Double>
//    var total = 0.0
//    var workers: Long = 0
//    var finished: Long = 0
//
//    val iterations: Long = 4_000_000_000
//
//    for (msg in channel) {
//        when (msg) {
//            is Start -> {
//                response = msg.response
//                workers = msg.workers
//                // break down the work into chucks
//                val range: Long = iterations / workers
//                for (i in (0 until workers)) {
//                    val start: Long = i * range
//                    val end: Long = ((i + 1) * range) - 1
//                    piActor(context).send(Work(channel, start, end, i))
//                }
//            }
//            is Result -> {
//                finished++
//                total += msg.result
//                if (finished == workers) {
//                    response.complete(total)
//                }
//            }
//        }
//    }
//}
//
//fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
