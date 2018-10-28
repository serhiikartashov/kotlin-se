import kotlinx.coroutines.experimental.*

// 5. Show this and explain why non-idiomatic
// Should opt-in to concurrent code, this is always concurrent
// use the async builder like in previous demos
fun main(args: Array<String>) = runBlocking{

//    val job = launch {
//        val result = async (coroutineContext) {
//            doWork("Work 1")
//        }
//        result.await()
//        doWork("Work 2")
//    }
//    job.join()

    val result = doWorkAsync("Hello")

    runBlocking {
        println(result.await())
    }
}

suspend fun doWork(msg: String): Int {
    log("$msg - Working")
    delay(500)
    log("$msg - Work done")
    // return from the closure
    return 42
}

fun doWorkAsync(msg: String): Deferred<Int> = async {
    log("$msg - Working")
    delay(500)
    log("$msg - Work done")

    // return from the closure
    return@async 42
}

fun log(msg: String) {
    println("$msg in ${Thread.currentThread().name}")
}