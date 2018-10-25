package com.kotlin.introduction.ch06_tidbits

const val CopyrightAuthor = "Mark Tven"

object Copyright {
    const val author = "Mark Tven"
}

fun main(args: Array<String>) {
    Copyright.author
    CopyrightAuthor
}