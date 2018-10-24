package com.kotlin.ch03_classes

data class CustomerKotlin(var id: Int, var name: String, var email: String) {
    override fun toString(): String {
        return "$id" // etc.
    }
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