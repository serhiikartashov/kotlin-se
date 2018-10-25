package com.kotlin.introduction.ch03_classes

object Global {
    val PI = 3.14
}

fun main(args: Array<String>) {

    val localObject = object {
        val PI = 3.14159
    }

    println(localObject.PI)

    println(Global.PI)
}