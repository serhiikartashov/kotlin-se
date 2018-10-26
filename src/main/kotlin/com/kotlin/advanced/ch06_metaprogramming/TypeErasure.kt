package com.kotlin.advanced.ch06_metaprogramming

fun <T> printList(list: List<T>) {
// won't work!
//    when (list) {
//        is List<String> -> println("This is list of String")
//        is List<Int> -> println("This is list of Int")
//    }

    if (list is List<*>) {
        println("this is the List")
    }
}

fun <T> printList(obj: T) {
    when (obj) {
        is Int -> println("This is an int")
        is String -> println("This is an string")
    }
}

inline fun <reified T> erased(input: List<Any>){
    if (input is T) {

    }
}

fun main(args: Array<String>) {
    val listStrings = listOf("One", "Two", "Three")
    val listNumbers = listOf(1, 2, 3)
}