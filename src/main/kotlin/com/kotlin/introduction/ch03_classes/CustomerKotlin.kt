package com.kotlin.introduction.ch03_classes

import java.io.IOException

// val @NotNull
// var @Nullable
data class CustomerKotlin(var id: Int, var name: String, val email: String) {

    @JvmField val someField: String = ""

    override fun toString(): String {
        return "$id" // etc.
    }

    @JvmOverloads fun changeStates(status: Status = Status.CURRENT){

    }

    // change the name for java. Why? Generics, overloaded functions
    @JvmName("preferential") fun makePreferred() {

    }

    @Throws(IOException::class) fun loadStatistics(filename: String) {
        if (filename == "")
            throw IOException("Cannot be blank!")
    }
}

enum class Status {
    CURRENT,
    PAST
}

fun CustomerKotlin.extension() {

}

fun main(args: Array<String>) {
    val customer1 = CustomerKotlin(1, "Serhii", "Email")
    val customer2 = CustomerKotlin(1, "Serhii", "Email")
    val customer3 = customer1

    if (customer1 == customer2){
        println("The same")
    }

    println(customer3.id)
    val customer4 = customer1.copy(email = "some email")
    println(customer4.id)
    println(customer4.name)
    println(customer4.email)

}