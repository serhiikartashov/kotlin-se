package com.kotlin.introduction.ch04_inheritance

interface Repository<T>{
    fun getById(id: Int): T
    fun getAll(): List<T>
}

fun main(args: Array<String>) {
    val customerRepo = GenericRepositoryImpl<Customer>()
    val customer = customerRepo.getById(1)

}