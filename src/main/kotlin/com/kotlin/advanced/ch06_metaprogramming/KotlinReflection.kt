package com.kotlin.advanced.ch06_metaprogramming

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

// star-projections are very much like Java's raw types, but safe.
fun getKotlinType(obj: KClass<*>){
    println(obj.qualifiedName)
}
fun main(args: Array<String>) {
/*
    println(Transaction::class)

    val classInfo = Transaction::class

    classInfo.memberProperties.forEach {
        println("Property ${it.name} of type ${it.returnType}")
    }

    classInfo.constructors.forEach {
        println("Constructor ${it.name} of type ${it.parameters}")
    }

    getKotlinType(Transaction::class)
*/

    val constructor = ::Transaction
    println(constructor)

    val transaction = constructor.call(1, 2000, "Some desc")
    val idParam = constructor.parameters.first { it.name == "id" }
    val amountParam = constructor.parameters.first { it.name == "amount" }

    val transaction2 = constructor.callBy(mapOf(constructor.parameters[0] to 1, constructor.parameters[1] to 2000))
    val transaction3 = constructor.callBy(mapOf(idParam to 1, amountParam to 2000))
    println(transaction2.description)

    val validateFunc = Transaction::validate

    val trans = Transaction(1, 20.0, "New Value")
    val nameProperty = Transaction::class.memberProperties.find { it.name == "description" }

    println(nameProperty?.get(trans))

//    println(transaction.description)
}