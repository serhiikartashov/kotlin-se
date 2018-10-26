package com.kotlin.advanced.ch04_delegation

import kotlin.properties.Delegates

typealias Name = String
typealias EmailData = String

data class Employee(var name: Name, val email: EmailData){

    var department: String by Delegates.observable("") { property, oldValue, newValue ->
        println("Property ${property.name} has changed from $oldValue to $newValue")
    }

    fun printName(string: String) {
        name = string
    }
}

fun main(args: Array<String>) {
    val employee = Employee("Serhii", "s@gmail.com")
    employee.printName("A String")

    employee.department = "IT"
    employee.department = "Account"

    val veto = Veto()

    println(veto.value)
    veto.value = "London"
    println(veto.value)
    veto.value = "Spain"
    println(veto.value)
}

class Veto {
    var value: String by Delegates.vetoable("String"){property, oldValue, newValue -> newValue.startsWith("S") }
}

