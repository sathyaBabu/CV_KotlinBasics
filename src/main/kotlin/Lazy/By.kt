package Lazy
interface Base {
    fun display()
}

class BaseImpl(val x: Int) : Base {
    override fun display() { println( x ) }
}

// delegating the public method on the object b
class Derived( useCreatedBase : Base) : Base by useCreatedBase   // line 16

fun main(args: Array<String>) {
    val useCreatedBase = BaseImpl(10)
    // prints 10 :: accessing the printMe() method
    Derived( useCreatedBase ).display()
}