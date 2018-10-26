package com.kotlin.advanced.ch02_functions

infix fun String.shouldBeEqualTo(value: String) = this == value

fun main(args: Array<String>) {
    "Hello".shouldBeEqualTo("Hello")


    val output = "Hello"
    output shouldBeEqualTo "Hello"
}