package com.kotlin.introduction.ch06_tidbits

open class Person {

}

class Employee: Person() {
    fun vacationDays(days: Int) {
        if (days < 60) {
            println("You need more vacation")
        }
    }
}

class Contractor: Person() {

}

fun hasVacations(obj: Person){
    if (obj is Employee) {
        // smart cast, we don't need explicitly cast to Employee
        obj.vacationDays(20)
    }
}

var input: Any = 10

fun main(args: Array<String>) {

    val str = input as? String
    println(str?.length)
}