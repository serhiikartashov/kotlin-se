package com.kotlin.introduction.ch07_functional

fun String.hello() {
    println("It's me!")
}

fun String.toTitleCase(prefix: String): String {
    return this.split(" ").joinToString(" ") { "$prefix ${it.capitalize()}" }
}

fun main(args: Array<String>) {
    val string = "Another one"
    "Hello".hello()


    println("this is a sample string to Title Case it".toTitleCase("Again - "))
    val customer = Customer()
    customer.makePreferred("my new version")

    val instance : BaseClass = InheritedClass()
    val instance2 = InheritedClass() // will print "Inherited extension"
    instance.extension()
}

class Customer {
    fun makePreferred(){
        println("Customer version")
    }
}

// extension functions are statically resolved
fun Customer.makePreferred(message: String){
    println(message)
}

open class BaseClass
class InheritedClass: BaseClass()

fun BaseClass.extension(){
    println("Base extension")
}

fun InheritedClass.extension(){
    println("Inherited extension")
}