package Lazy

import kotlin.properties.Delegates


// recreating the object willl cost us heavy
class HeavyContainer101 {
    // phase II
    init {
        println("Heavy Container Initialized...")
    }

}
// phase II
class HelpertoHeavy101 {

   // var heavy = HeavyContainer101() // lets get initiated by a helper class

  val heavy by lazy { HeavyContainer1() }  // acts as proxy..
    // construct the object HeavyContainer1() while using it
    // blocking the memory...

    // Phase III  live data weight gets to be live from now on.
    var weight: Int by Delegates.observable(2000){
        property, oldValue, newValue ->  println("Old value $oldValue New value $newValue")
    }

    // Phase Vi vetoable
    var minWeight : Int by Delegates.vetoable(1999){
        property, oldValue, newValue ->  println("Old value $oldValue New value $newValue")
        newValue >= 1999
    }

}


fun main()
{
    // Phase I
    val accessHeavyContainer = HelpertoHeavy101()
    // This is where we willl be using the constructed above objjj..
    // NO
    // Yes

    // Very very expencive work
//    for( i in 1..10000){
//       accessHeavyContainer.heavy  // Heavy Container Initialized...
//       }

    accessHeavyContainer.heavy  // Heavy Containerwill init only once due to lazy Initialized...
    accessHeavyContainer.heavy
    accessHeavyContainer.heavy

    // Phase III
//
//    accessHeavyContainer.weight = 2210  // Old value 2000 New value 2210
//    accessHeavyContainer.weight = 3456 //  Old value 2210 New value 3456
//
//    accessHeavyContainer.minWeight = 1000
//    println(" Min Weight ${accessHeavyContainer.minWeight}")
//    accessHeavyContainer.minWeight = 1800
//    println(" Min Weight ${accessHeavyContainer.minWeight}")
//
//    accessHeavyContainer.minWeight = 3000
//    println(" Min Weight ${accessHeavyContainer.minWeight}")
//
//    accessHeavyContainer.minWeight = 1200
//    println(" Min Weight ${accessHeavyContainer.minWeight}")
//
//    accessHeavyContainer.minWeight = 2100
//    println(" Min Weight ${accessHeavyContainer.minWeight}")

}

/*
Heavy Container Initialized...
Old value 2000 New value 2210
Old value 2210 New value 3456
Old value 1999 New value 1000
 Min Weight 1999
Old value 1999 New value 1800
 Min Weight 1999
Old value 1999 New value 3000
 Min Weight 3000
Old value 3000 New value 1200
 Min Weight 3000
Old value 3000 New value 2100
 Min Weight 2100

Process finished with exit code 0

 */