package com.kotlin.introduction.ch01_basics

fun main(args: Array<String>) {
    var myString = "Not Empty"

    val result = if (myString != "") {
        print("Not empty")
        20
    } else {
        "empty"
    }

    println(result)

    val whenValue = when(result){
        is String -> {
            println("Excellent")
            "good"
        }
        "Value" -> {
            println("value")
            "returning the string"
        }
        else -> {
            println("It come to this?")
            "warning"
        }
    }
}