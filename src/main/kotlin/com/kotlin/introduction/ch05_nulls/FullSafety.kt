package com.kotlin.introduction.ch05_nulls

import com.kotlin.introduction.ch03_classes.CustomerJava

class Service {
    fun evalueate(){}
}

class ServiceProvider {
    fun createServices(): Service? {
        return null
    }
}

fun main(args: Array<String>) {
    val message: String = "A message"
    // null safe language, type cannot be null
//    val message: String = null

    var nullMessage: String? = null
    val inferredNull = null

    println(message)
    // it's null safe
    // null safe operator
//    nullMessage = "Some Value"
    // green variable
    println(nullMessage?.length)
    println(nullMessage!!.length) // I know what I'm doing, it's my problem if it's null

    var nullMessage2: String? = null
    nullMessage2 = "String"
    println(nullMessage2.length)

    val customerJava = CustomerJava()
    println(customerJava.name.length)

    val sp = createsServiceProvider()
    sp?.createServices()?.evalueate()

}

private fun createsServiceProvider(): ServiceProvider? = ServiceProvider()