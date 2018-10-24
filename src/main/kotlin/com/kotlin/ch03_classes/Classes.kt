package com.kotlin.ch03_classes

import java.lang.IllegalArgumentException
import java.util.*

class Customer(initId: Int, initName: String) {
    // we can only declare a properties
//    var id = 0
//    var name: String = ""

    var id: Int = initId
    var name: String = initName

}

// init properties in constuctor
class Customer2(var id: Int, var name: String)

// property id won't be accessible as property
class Customer3(id: Int, var name: String)

class Customer4(var id: Int, var name: String) {
    init {
        name = name.toUpperCase()
    }

    // secondary constructor
    constructor(email: String) : this(0, "") {

    }
}

class Customer5(var id: Int, var name: String, val yearOfBirth: Int){
    val age: Int
//        get() = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth
        get() { return Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth }

    var socialsecurityNumber: String = ""
        set(value){
            if (!value.startsWith("SN")){
                throw IllegalArgumentException("Social Security should start with SN")
            }
            // field refers to value
            field = value
        }

    fun customerAsString(): String {
        return "Id: $id - Name: $name"
    }
}

fun main(args: Array<String>) {
    val customer = Customer(2, "Serhii")

    customer.id = 10
    customer.name = "Hadi"

//    val customer4 = Customer4(1, "Ivan", "email@mail.com")


}

