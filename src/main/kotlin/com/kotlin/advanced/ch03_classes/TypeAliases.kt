package com.kotlin.advanced.ch03_classes

typealias Name = String
typealias EmailData = String
data class Employee(var name: Name, val email: EmailData){
    fun printName(string: String) {
        name = string
    }
}

fun main(args: Array<String>) {
    val employee = Employee("Serhii", "s@gmail.com")
    employee.printName("A String")
}
