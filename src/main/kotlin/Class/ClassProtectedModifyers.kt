package Class
// final


open class A{

    protected  val i = 1
    private  var value = 10 ;

    protected fun doSomething() {
        println("Inside something")
        println("Value of i  is $i value is $value")
    }

    private  fun manager(){

        var cash : Int = 3000
        println(" Manager can be accesed by a member function..")

    }

    fun LocalToA() {
        println(" Inside A local to A let me access private var $value")
        manager()
    }

}

class B : A(){

    fun privateValue() {
        doSomething();
        println("value of I id $i")
    }

}

fun main()
{

    val a = A()
    val b = B()

    a.LocalToA()



}