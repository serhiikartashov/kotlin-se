package com.kotlin.advanced.ch03_classes

class Log private constructor() {

    // each class can have only one companion object
    companion object Factory {
        // @JvmStatic can avoid calling Factory object from java
        @JvmStatic fun createFileLog(filename: String): Log = Log(filename)
    }

    constructor(filename: String): this() {

    }
}

fun main(args: Array<String>) {
    // val log = Log.Factory.createFileLog("filename.txt")
    val log = Log.createFileLog("filename.txt")
}