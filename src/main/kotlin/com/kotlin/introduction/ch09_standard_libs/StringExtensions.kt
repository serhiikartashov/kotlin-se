package com.kotlin.introduction.ch09_standard_libs

import java.io.File

fun main(args: Array<String>) {

    val file = File("filename.txt")

    with(file){

    }

    val string : String? = "Some value"

    string?.let {
        it.length
    }
}