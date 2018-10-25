package com.kotlin.introduction.ch04_inheritance

abstract class StoredEntity {
    val isActive = true
    abstract fun store()
    fun status(): String{
        return isActive.toString()
    }
}

class Employee: StoredEntity() {
    override fun store() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun main(args: Array<String>) {
    val se = Employee()
    se.isActive
}