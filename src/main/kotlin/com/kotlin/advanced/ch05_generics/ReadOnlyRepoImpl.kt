package com.kotlin.advanced.ch05_generics

class ReadOnlyRepoImpl<out T>: ReadOnlyRepo<T> {
    override fun getId(id: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}