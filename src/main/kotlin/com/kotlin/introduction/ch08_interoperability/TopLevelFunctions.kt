@file:JvmName("UtilityClass")
package com.kotlin.introduction.ch08_interoperability


const val CopyrightYear = 2018
val CopyrightYear2 = 2018

fun prefix(prefix: String, value: String): String {
    return "$prefix-$value"
}