package DesignPatterns

import Utils.Const.MY_SAL


// Single Object..

// Global object...   SingleTon..
// const, KEY_USERNAME
/*

   1. Takes care of Volitile stuff for thread racing..
   2. syncronise() is been tajken care off from threads..
   3. if the obj is not created create a SingleObject
       else return the exixting object..
   4. We created the constructor under private to stop people creating many objects
   5. Kotlin destroyed the word called as Static!!! Say GOOD BYE!!!!

   Above characterstics were housed in SingleTon were completely removed by kotlin
   by calling it as  a boiler plate code...

   So the final outcome of creating singleObject remains below...

 */

object  SingleTon {
    init {
        println("SingleTon Kotlin Way.....")
    }

    var message = "Kotlin Rocks!!!"

    fun saySomeThing(){
        println(message)
    }

}

class Test{
    init {
        SingleTon.saySomeThing()
    }

}
fun main() {

    SingleTon.saySomeThing()
   // val sad = SingleTon()

    SingleTon.saySomeThing()

    SingleTon.message = " Kotlin is a cool subject..."
    val test = Test()


    // we can set our global var in our project..

    println(" MySal ${MY_SAL}")


}