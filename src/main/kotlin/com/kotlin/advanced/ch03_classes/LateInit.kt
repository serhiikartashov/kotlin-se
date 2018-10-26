package com.kotlin.advanced.ch03_classes

interface Repository {
    fun getAll(): List<Customer>
}

class CustomerController() {
    lateinit var repository: Repository

    fun index(): String {
        return repository.getAll().toString()
    }
}

fun main(args: Array<String>) {

    val customerController = CustomerController()
    customerController.index()
}