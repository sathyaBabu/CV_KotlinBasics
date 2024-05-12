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
/*
The Derived class implements the Base interface by delegating to another object
passed through its constructor.
Derived takes an object useCreatedBase of type Base in its constructor.
On line 16, Derived class delegates all calls to its display() method to the
 display() method of the useCreatedBase object it receives in its constructor.
 This is achieved using the by keyword followed by the object to which the
 delegation is done.
 */