package com.kotlin.introduction.ch09_standard_libs

import java.util.*

fun main(args: Array<String>) {
    var emptyList = emptyList<String>()
    var list = listOf("Fist entry", "Second entry")

    val numbers = 1..100
    var cities = listOf("Madrid", "London", "Paris")
    println(cities.javaClass)
    println(emptyList.javaClass)

    val arrayList = Arrays.asList("Madrid", "London")
    println(arrayList.javaClass)

    val mutableCities = mutableListOf("Madrid")

    mutableCities.add("London")

    val hashMap = hashMapOf(Pair("Madrid", "Spain"), Pair("Paris", "France"))
    val booleans = booleanArrayOf(true, false, false)
    val chars = charArrayOf('c', 'a')


}