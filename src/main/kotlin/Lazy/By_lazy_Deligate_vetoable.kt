package Lazy


class HeavyContainer {

    // phase I
    init {
        println("Heavy Container Initialized...")
    }

//    // step 2
//    companion object  HelpertoHeavy {
//        var heavy = HeavyContainer()
//    }

}
    // phase I

    class HelpertoHeavy {
     var heavy = HeavyContainer() // lets get initiated by a helper class
      //  val heavy by lazy { HeavyContainer() }  // acts as proxy
        // blocking the memory...

    }
fun main()
{

//    HeavyContainer.heavy
//    HeavyContainer.heavy

    val accessHeavyContainer = HelpertoHeavy()
    val accessHeavyContainer1 = HelpertoHeavy()
    val accessHeavyContainer2 = HelpertoHeavy()


    accessHeavyContainer.heavy
    accessHeavyContainer.heavy
    accessHeavyContainer.heavy


    // Very very expencive work
//    for( i in 1..10000){
//        accessHeavyContainer.heavy  // Heavy Container Initialized...
//
//
//    }

        accessHeavyContainer.heavy   // this gets called only once
        accessHeavyContainer.heavy
        accessHeavyContainer.heavy

}