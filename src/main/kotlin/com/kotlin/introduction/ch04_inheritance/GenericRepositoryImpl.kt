package com.kotlin.introduction.ch04_inheritance

class GenericRepositoryImpl<T> : Repository<T> {
    override fun getById(id: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface Repo {
    fun <EntityType> getById(id: Int): EntityType
    fun <R> getAll(): List<R>
}

class MyRepo: Repo{
    override fun <T> getById(id: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <R> getAll(): List<R> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}