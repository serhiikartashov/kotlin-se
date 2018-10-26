package com.kotlin.advanced.ch03_classes

open class PageResult{

}

// Sealed classes have to be located in the same file
class Success(val content: String): PageResult()
class Error(val code: Int, val message: String): PageResult()
class MediumSuccess(): PageResult()
fun getURLPage(url: String): PageResult {
    val wasValidCall = false
    if (wasValidCall) {
        return Success("The content")
    } else {
        return Error(404, "ERROR")
    }
}

fun main(args: Array<String>) {
    val pageResult = getURLPage("/")
    when(pageResult){
        is Success -> println(pageResult.content)
        is Error -> println(pageResult.message)
    }
}