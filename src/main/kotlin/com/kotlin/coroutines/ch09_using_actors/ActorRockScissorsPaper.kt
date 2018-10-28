package com.kotlin.coroutines.ch09_using_actors

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor
import java.util.*

sealed class Move {
    override fun toString(): String {
        return this.javaClass.simpleName.toString()
    }
}

object Rock : Move()
object Paper : Move()
object Scissors : Move()

sealed class Game
class Start(val response: CompletableDeferred<Int>) : Game()
class Play(val sender: Channel<Game>, val name: String) : Game()
class Throw(val actor: String, val move: Move) : Game()

fun playerActor() = actor<Game> {
    var name: String

    for (msg in channel) {
        when (msg) {
            is Play -> {
                name = msg.name

                val selection = (1..4).random()
                lateinit var move: Move

                when (selection) {
                    1 -> move = Rock
                    2 -> move = Paper
                    3 -> move = Scissors
                }
                msg.sender.send(Throw(name, move))
            }
        }
    }
}

fun coordinatorActor() = actor<Game> {
    lateinit var response: CompletableDeferred<Int>

    val player1 = playerActor()
    val player2 = playerActor()

    for (msg in channel) {
        when (msg) {
            is Start -> {
                response = msg.response
                player1.send(Play(channel, "Player 1"))
                player2.send(Play(channel, "Player 2"))
            }
            is Throw -> {
                val playerA = msg.actor
                val moveA = msg.move
                val msg2 = channel.receive() as Throw
                val playerB = msg2.actor
                val moveB = msg2.move
                announce(playerA, moveA, playerB, moveB)
                response.complete(0)
            }

        }
    }
}

fun announce(playerA: String, moveA: Move, playerB: String, moveB: Move) {
    var awin = false

    print("$playerA -> $moveA, $playerB -> $moveB ")

    if (moveA == moveB) {
        println("Draw")
        return
    }
    when (moveA) {
        is Rock -> {
            when (moveB) {
                is Scissors -> {
                    awin = true
                }
            }
        }
        is Scissors -> {
            when (moveB) {
                is Paper -> {
                    awin = true
                }
            }
        }
        is Paper -> {
            when (moveB) {
                is Rock -> {
                    awin = true
                }
            }
        }
    }

    if (awin) {
        println("$playerA wins")
    } else {
        println("$playerB wins")
    }
}

fun main(args: Array<String>) = runBlocking<Unit> {
    repeat(10) {
        val response = CompletableDeferred<Int>()
        var coord = coordinatorActor()
        coord.send(Start(response))

        response.await()
    }
}

fun log2(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start
