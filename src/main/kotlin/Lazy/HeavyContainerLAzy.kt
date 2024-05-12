package Lazy
class HeavyContainer2 {

    // huge memory allocation happens here..
    init {
        println("Heavy Container class Initialized...")

    }

}
   class HelperClassToHeavy2{

      //  var heavy = HeavyContainer2()

        // Phase II

        // lazy  creates a 11cf single object..returns same object over and over again
        // heavy gets created only when the user usses it..
//
        val heavy by lazy {  println("Right in Lazy")

            HeavyContainer2()
        }
    }

fun main(){

    val accessHeavyContainer = HelperClassToHeavy2()  // but  HeavyContainer2() is not created..

    // once only..
    for( i in 1..10){
        accessHeavyContainer.heavy  // here HeavyContainer2() is constructed..


    }


}