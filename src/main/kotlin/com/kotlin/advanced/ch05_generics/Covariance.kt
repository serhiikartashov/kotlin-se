package com.kotlin.advanced.ch05_generics

import com.kotlin.advanced.ch03_classes.Customer

open class Person
class Employee: Person()

fun operate(person: List<Person>){

}

// ? extends Person
// covariance
interface ReadOnlyRepo<out T> {
    fun getId(id: Int): T
    fun getAll(): List<T>
}

// contravariance
interface WriteRepo<in T> {
    fun save(obj: T)
    fun saveAll(list: List<T>)
}

fun main(args: Array<String>) {
    operate(listOf<Employee>())
    operate(listOf<Person>())

    val ro = ReadOnlyRepoImpl<Customer>()
    ro.getAll()

}