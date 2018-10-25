package com.kotlin.introduction.ch08_interoperability

import com.kotlin.introduction.ch03_classes.CustomerJava

fun main(args: Array<String>) {
    val customer = CustomerJava()
    customer.email = "mail@gmail.com"
    customer.prettyPrint()

    customer.neverNull()


    val runnable = Runnable { println("Invoking runnable")}

    val kr = KotlinCustomerRepo()
    val customerJava = kr.getById(10)
//    customerJava.id
}

class PersonKotlin: PersonJava() {

}

class RunnableKotlin: Runnable {
    override fun run() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class KotlinCustomerRepo: CustomerRepository {
    // ? - the value can be null
    // without ? means that value cannot be null
    override fun getById(id: Int): CustomerJava? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): MutableList<CustomerJava>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
