package Lazy



class HeavyContainer1 {

    init {
       println("Heavy Container class Initialized...")

    }


    // single object...  11cf..

     companion object  HelperClassToHeavy{

        var heavy = HeavyContainer()
    }

}

//
//class HelperClassToHeavy{
//
//    var heavy = HeavyContainer()
//}


// Phase II
fun main(){


    // once only..
    for( i in 1..100000){

       // val accessHeavyContainer = HelperClassToHeavy()

        HeavyContainer1.heavy
    }


}