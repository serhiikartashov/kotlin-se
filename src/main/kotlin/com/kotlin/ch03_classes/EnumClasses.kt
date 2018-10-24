package com.kotlin.ch03_classes

enum class Priority (val value: Int) {
    MINOR(-1) {
        override fun text(): String {
            return "{miner priority}"
        } // 0
        override fun toString(): String {
            return "Minor Priority"
        }
    },
    NORMAL(0) {
        override fun text(): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }, // 1
    MAJOR(1) {
        override fun text(): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    },  // 2
    CRITICAL(10) {
        override fun text(): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }; // 3

    abstract fun text(): String
}

fun main(args: Array<String>) {
    val priority = Priority.NORMAL
    println(priority.toString())
    println(priority.value)
    println(priority.ordinal)
    println(Priority.CRITICAL.ordinal)

    for (value in Priority.values()) {
        println(value)
    }

    val p = Priority.valueOf("MAJOR")
    println(p.ordinal)
}