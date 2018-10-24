package com.kotlin.ch06_tidbits

import com.kotlin.ch03_classes.CustomerKotlin

fun capitalAndPopulation(country: String): Pair<String, Long> {
    return Pair("Madrid", 2_300_000)
}

fun countryInformation(country: String): Triple<String, String, Long> {
    return Triple("Madrid", "Europe", 2_300_000)
}

fun main(args: Array<String>) {

    val result = capitalAndPopulation("Madrid")

    println(result.first)
    println(result.second)

    val countryInfo = countryInformation("Spain")
    countryInfo.third


    // deconstruction values
    val (capital, population) = capitalAndPopulation("Madrid")

    println(capital)
    println(population)

    val (id, name, email) = CustomerKotlin(1, "Serhii", "email")

    val listCapitalsAndCountries = listOf(Pair("Madrid", "Spain"), "Paris" to "France")

    for ((capital, country) in listCapitalsAndCountries){
        println("$capital - $country")
    }

}