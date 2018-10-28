package com.kotlin.coroutines.ch07_using_channels

import kotlinx.coroutines.experimental.cancelChildren
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

data class Comment(var hits: Int)

fun main(args: Array<String>) = runBlocking<Unit> {
    val discussion = Channel<Comment>() // a shared table

    launch(coroutineContext) { child("he did it", discussion) }
    launch(coroutineContext) { child("she did it", discussion) }

    discussion.send(Comment(0)) // serve the ball
    delay(1000) // delay 1 second
    coroutineContext.cancelChildren() // game over, cancel them
}

suspend fun child(name: String, discussion: Channel<Comment>) {
    for (comment in discussion) { // receive the comment in a loop
        comment.hits++
        println("$name $comment")
        delay(300) // wait a bit
        discussion.send(comment) // send the comment back
    }
}