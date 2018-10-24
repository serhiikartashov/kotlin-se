package com.kotlin.ch04_inheritance

// interfaces can have implementation
// you can not maintain state in Interface, in Abstract class you can.
interface CustomerRepository {
    val isEmpty: Boolean
        get() = true
    fun store(obj: Customer){
        // implement code to store
    }
    fun getById(id: Int): Customer
}

interface EmployeeRepository {
    fun store(obj: Employee){

    }
    fun getById(id: Int): Employee
}

class SQLCustomerRepository: CustomerRepository {
    override fun getById(id: Int): Customer {
        return Customer()
    }

    override val isEmpty: Boolean
        get() = false

    override fun store(obj: Customer) {
        super.store(obj)
    }
}

interface Interface1 {
    fun funA() {
        println("Fun A from Interface 1")
    }
}

interface Interface2 {
    fun funA() {
        println("Fun A from Interface 2")
    }
}

class Class1And2: Interface1, Interface2{
    override fun funA() {
//        super<Interface1>.funA()
        println("Our own")
    }
}

fun main(args: Array<String>) {
    val c = Class1And2()
    c.funA()
}