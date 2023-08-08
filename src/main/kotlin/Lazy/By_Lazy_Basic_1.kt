package Lazy

import kotlin.properties.Delegates

/*

Object will be initialized only once. Thereafter, you receive the value from the cache memory.

The object will not be initialized until it has been used in the application.

 */
class Demo {
    val myName: String by lazy {
        println("Welcome to Lazy declaration");
        "By Sathya"
    }
}

fun main() {
    var obj = Demo();
    println(obj.myName);
    println("Let's  call to the same object ---> "+obj.myName);

    var max: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        newValue > oldValue
    }

    println(max) // 0

    max= 10
    println(max) // 10

    max = 5
    println(max) // 10

    var max2: Int by Delegates.observable(0) { property, oldValue, newValue ->
        newValue > oldValue
    }

    println(max2) // 0

    max2 = 10
    println(max2) // 10

    max2 = 5
    println(max2) // 10
}
/*
Welcome to Lazy declaration
By Sathya
Let's  call to the same object ---> By Sathya

Process finished with exit code 0

 */