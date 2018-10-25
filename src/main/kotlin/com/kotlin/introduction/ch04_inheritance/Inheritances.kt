package com.kotlin.introduction.ch04_inheritance


// by default class is closed
open class Person {
    open fun validate() {

    }
}

class Customer: Person(){
    final override fun validate() {

    }
//    constructor(): super(){
//
//    }
}

class SpecialCustomer: Person(){
    override fun validate() {

    }
}

data class CustomerEntity(val name: String): Person()

fun main(args: Array<String>) {
    val customer = Customer()
}