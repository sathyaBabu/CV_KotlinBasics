package Class
// final
open class A() {
    protected val i = 1
    private var value = 10  // Bank Cash

   protected  fun doSomething(){
        println("Inside doSomething" )
        println("Value of i is $i value is $value" )
    }

    private fun manager() {
        var cash:Int = 3000
        println("Manager can be acessed by the member functions.." )
    }
    // Member functions can access private data/ functions..
   fun localToA(){   // employee..
        println("Inside A Local to A Let me access private var $value" )
       manager()
    }
}
class B : A() {
    fun printValue(){
        doSomething()
        println("Value of i is $i" )
    }
}

fun main(args: Array<String>) {
    val a = A()

    val b = B()

  //  a.doSomething()  //  protected
    a.localToA()


    b.printValue()
}

/*
Inside doSomething
Value of i is 1
Value of i is 1

 */