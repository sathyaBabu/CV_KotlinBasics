package Deligation

import kotlin.reflect.KProperty
// try this first By_interface
class Example {
    var p: String    by Delegate()  // getValue / setValue
    var name: String by Delegate()  // getValue / setValue        // 1


    override fun toString() = "Example Class"
}

class Delegate() {

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {        // 2
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) { // 2
        println("$value has been assigned to ${prop.name} in $thisRef")
    }

}

fun main() {
    println("*".repeat(40))
    val e = Example()
    println(e.p)  // e.p  getValue
    e.p = "NEW"    // setvalue


    println("*".repeat(40))

    println(e.name)  // e.p  getValue
    e.name = "NEW again"    // setvalue

}

/*
***************************************
Example Class, thank you for delegating 'p' to me!
NEW has been assigned to p in Example Class
****************************************
Example Class, thank you for delegating 'name' to me!
NEW again has been assigned to name in Example Class

Process finished with exit code 0
 */