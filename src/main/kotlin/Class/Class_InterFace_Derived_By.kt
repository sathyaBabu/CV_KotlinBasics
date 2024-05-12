package Class

interface Base {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base {
    override fun printMessage() { print(x) }
    override fun printMessageLine() { println(x) }
}

class Derived(b: Base) : Base by b {
    override fun printMessage() { println("abc") }
}

fun main() {
    val b = BaseImpl(10)
    Derived( b ).printMessage()   // abc
    Derived( b ).printMessageLine()   // 10
}