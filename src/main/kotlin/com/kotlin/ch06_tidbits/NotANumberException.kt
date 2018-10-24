package com.kotlin.ch06_tidbits

import java.io.BufferedReader
import java.io.FileReader

class NotANumberException(message: String) : Throwable(message)

fun checkIsNumber(obj: Any) {
    when (obj) {
        !is Int, Long, Float, Double -> throw NotANumberException("This is not a number")
    }
}

fun main(args: Array<String>) {
    try {
        checkIsNumber("A")
    } catch (e: IllegalArgumentException) {
        println("Do nothing")
    } catch (e: NotANumberException) {
        println("${e.message}")
    }

    val buffer = BufferedReader(FileReader("input.txt"))
    val result = try {
        val chars = CharArray(30)
        buffer.read(chars, 0, 40)
    } catch (e: IndexOutOfBoundsException) {
        println("Exception handled")
        -1
    } finally {
        println("closing")
        buffer.close()
        -2
    }

    println(result)
}