package DesignPatterns

import kotlin.concurrent.thread

fun beforeWork(){
    println("Before Work :")
}


fun afterWork(){
    println("After Work :")
}


fun operationTemplate(){
    beforeWork()
    println("I'm working here...")
    afterWork()
}

// kotlin

fun execute( task: () -> Unit){
    val startTime = System.currentTimeMillis()

    thread {

        Thread.sleep(5000)
    }
    task()
    println("Work took ${System.currentTimeMillis() - startTime} millis")
}

fun main(){

    execute {
          operationTemplate()
    }
}