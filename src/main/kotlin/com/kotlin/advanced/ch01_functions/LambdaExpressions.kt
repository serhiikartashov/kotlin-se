package com.kotlin.advanced.ch01_functions

class Request(val method: String, val query: String, val contentType: String)
class Response(var contents: String, var status: Status) {
    operator fun invoke(any: Status.() -> Unit) {

    }
}


class Status(var code: Int, var desctiption: String)
class RouteHandler(val request: Request, val response: Response) {
    var executeNext = false
    fun next() {
        executeNext = true
    }
}


// extension function of RouteHandler
fun routeHandler(path: String, f: RouteHandler.()->Unit): RouteHandler.()-> Unit = f
//fun response(response: Response.() -> Unit){}
//fun status(status: Status.() -> Unit){}

fun main(args: Array<String>) {
    routeHandler("/index.html") {
        if (request.query != ""){
            // process
        }
//        response.status.code = 404
//        response {
//            status {
//                code = 404
//            }
//        }
        response {
            code = 404
            desctiption = "Description"
        }

        response.contents = "Not found"
    }


    val manager = Manager()
    manager("Do Something")

}

class Manager {
    operator fun invoke(value: String) {

    }

}