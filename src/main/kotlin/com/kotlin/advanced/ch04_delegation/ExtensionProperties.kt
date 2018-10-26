package com.kotlin.advanced.ch04_delegation

val String.hasAmpersan: Boolean
    get() = this.contains("&")

fun main(args: Array<String>) {
    println("Sell".hasAmpersan)
    println("Sell & Buy".hasAmpersan)
}