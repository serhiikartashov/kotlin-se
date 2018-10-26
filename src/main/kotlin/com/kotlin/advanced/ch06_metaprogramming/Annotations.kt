package com.kotlin.advanced.ch06_metaprogramming

@Target(AnnotationTarget.CLASS)
//@Retention
//@MustBeDocumented
//@Repeatable
annotation class Table(val name: String)

@Target(AnnotationTarget.PROPERTY)
annotation class Field(val name: String)

@Table(name = "ContactTable")
//@Field(name = "NAME")
data class Contact(val id: Int, @Field(name = "NAME") val name: String, val email: String)

fun main(args: Array<String>) {
    val annotation = Contact::class.annotations.find { it.annotationClass.simpleName == "Table" }

    println(annotation)
}