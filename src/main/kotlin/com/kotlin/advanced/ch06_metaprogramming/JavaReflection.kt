package com.kotlin.advanced.ch06_metaprogramming

import java.lang.reflect.Type

class Transaction(val id: Int, val amount: Double, var description: String = "Optional") {
    fun validate() {
        if (amount > 10000) {
            println("com.kotlin.advanced.ch05_metaprogramming.Transaction is too large")
        }
    }
}

fun introspectInstance(obj: Any){
    println("Class ${obj.javaClass.simpleName}")
    println("Properties\n")
    obj.javaClass.declaredFields.forEach {
        println("${it.name} of type ${it.type}")
    }
    println("Function\n")
    obj.javaClass.declaredMethods.forEach {
        println(it.name)
    }
    getType(Transaction::class.java)
    // KClass - Kotlin Reflection
//    getType(Transaction::class)
}

fun getType(obj: Type){
    println(obj.typeName)
}

fun main(args: Array<String>) {
    introspectInstance(Transaction(1, 200.0, "A simple transaction"))
}