package com.kotlin.advanced.ch03_classes

class Customer() {
    private var myCustomeField = 10
    var lastPurchasedAmount: Double = 0.0
        get() = field
        set(value) {
            if (value > 100) {
                field = value
            }
        }
}

fun main(args: Array<String>) {
    val customer = Customer()

    println(customer.lastPurchasedAmount)
    customer.lastPurchasedAmount = 200.0
    println(customer.lastPurchasedAmount)
    customer.lastPurchasedAmount = 50.0
    println(customer.lastPurchasedAmount)

}