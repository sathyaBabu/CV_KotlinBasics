package Lazy







class HeavyContainer22 {

    init {
        println("Heavy Container class Initialized...")

    }
}


class HelperClassToHeavy22{

    var heavy = HeavyContainer22()

    // Phase II

    // lazy  creates a single object..returns same object over and over again
    // heavy gets created only when the user usses it..
   // val heavy by lazy {   HeavyContainer22() }
}

fun main(){

    val accessHeavyContainer = HelperClassToHeavy22()  // but  HeavyContainer2() is not created..

    // once only..
    for( i in 1..10){


        accessHeavyContainer.heavy  // here HeavyContainer2() is constructed..
    }


}