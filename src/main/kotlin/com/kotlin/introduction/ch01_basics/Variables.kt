package com.kotlin.introduction.ch01_basics

fun main(args: Array<String>) {

    // mutable variables in kotlin
    var streetNumber: Int
    var streetName: String = "High Street"
    var streetName1 = "High Street"

    // immutable variables
    val zip = "El1 P1"

    streetName = "Name"
//    zip = "zip"

    val myLong = 10L
    val myFloat = 100F
    val myHex = 0x0F
    val myBinary = 0xb01

    val myInt = 10
    val myLongAgain: Long = myInt.toLong()

    // String
    val myChar = 'a'
    val myString = "String"

    val escapeCharacters = "A adfsdf \n"
    val rawString = "Hello" +
            "3 strings"+
            "new"

    val multipleLines = """
        asdlfkjlasdf
        adsf
        asdf
        asdf
    """.trimIndent()

    val years = 10
    val message = "A decade is $years years"
    println(message)

    val name = "Merry"
    val anotherMessage = "Length of a name ${name.length}"
}