package com.kotlin.advanced.ch05_generics

import java.io.Serializable

open class Entity(val id: Int)

// T could be anything even null (Any?)
class Repository<T: Entity> {
//class Repository<T> where T: Entity, T: Serializable {
    fun save(entity: T) {
        if (entity.id != 0) {
            // ...
        }
    }
}

fun <T: Serializable> streamObject(obj: T){

}

fun main(args: Array<String>) {
    val repo = Repository<CustomerEntity>()
}

class CustomerEntity: Entity(1) {

}
