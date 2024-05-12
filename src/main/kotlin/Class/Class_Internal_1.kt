package Class

// Network packet.. we need to turn on the network

open  class  IA {


    internal  val i = 1 ;


    internal  class InternalHelperClass {
        internal var ii = 100;

        // House keeping work.. turn on the network
        // get the speed..
        internal fun InternalHelperFunctionDoSomeThing() {

            println("Inside internal helper function do something")
            println(" value of internal helper ii is $ii ")
        }
    }

        internal   fun doSomeThing(){
            println("Do some thing")
            println(" value of internal helper i is $i ")
        }

}

class IB : IA() {

    fun printValue(){
        doSomeThing()
        println("value of i is $i")
    }
}



fun main(){

    val a = IA()
    val b = IB()


    val c = IA.InternalHelperClass()
    c.ii = 123
    a.doSomeThing()
    b.printValue()


}