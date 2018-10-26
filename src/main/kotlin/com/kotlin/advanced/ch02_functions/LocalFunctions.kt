package com.kotlin.advanced.ch02_functions

fun foo(fooParam: String) {
    val outerFunction = "Value"
    fun bar(barParam: String) {
        println(barParam)
        println(fooParam)
    }


}

fun main(args: Array<String>) {
    foo("string")
}