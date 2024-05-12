package Class

open class IA() {
    internal val i = 1

    internal class InternalHelperClass{
        internal var ii = 100;
        internal fun InternalHelperFunDoSomething(){
            println("Inside Internal Helper function doSomething" )
            println("Value of internal helper  ii is $ii" )
        }
    }/////
    internal fun doSomething(){
        println("Inside doSomething" )
        println("Value of i is $i" )
    }
}
class IB : IA() {
    fun printValue(){
        doSomething()
        println("Value of i is $i" )
    }
}

fun main(args: Array<String>) {
    val a = IA()
    val b = IB()

    val c = IA.InternalHelperClass()  // just the obj is created

    c.ii = 200
    c.InternalHelperFunDoSomething()

    a.doSomething()

    b.printValue()
}

/*
Inside doSomething
Value of i is 1
Inside doSomething
Value of i is 1
Value of i is 1
 */