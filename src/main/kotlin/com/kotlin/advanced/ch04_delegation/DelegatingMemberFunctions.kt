package com.kotlin.advanced.ch04_delegation

import com.kotlin.advanced.ch03_classes.Customer

interface Repository {
    fun getById(id: Int): Customer
    fun getAll(): List<Customer>
}

interface Logger {
    fun logAll()
}
// delegating functionality of Repository for instance that get in
class Controller(repository: Repository, logger: Logger): Repository by repository, Logger by logger {
    fun index(): String {
//        getAll()
//        logAll()
        return ""
    }
}