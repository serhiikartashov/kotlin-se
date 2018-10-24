package com.kotlin.ch02_functions

fun hello(): Unit { // void
    println("hello")
}

fun throwingExceptions(): Nothing { // nothing means throws an exception
    throw Exception("nothing to throw")
}

fun returnAFour(): Int {
    return 4
}

fun sum1(x: Int, y: Int): Int {
    return x + y
}

fun sum2(x: Int, y: Int): Int = x + y // single expression function

fun sum3(x: Int, y: Int = 0, w: Int = 3): Int = x + y // single expression function

fun printDetails(name: String, email: String = "", phone: String = "NA"){
    println("name: $name - email: $email - phone: $phone")
}

fun printStrings(vararg strings: String){
    reallyPrintingStrings(*strings) // spread operator
}

private fun reallyPrintingStrings(vararg strings: String){
    for (string in strings) {
        println(string)
    }
}

fun main(args: Array<String>) {
    hello()

    val value = returnAFour()

    sum3(1,2,3)
    sum3(1,2)
    printDetails("Serhii", phone = "555 123", email = "555 123")


    printStrings("1")
    printStrings("1", "2")
    printStrings("1", "2", "3")
}