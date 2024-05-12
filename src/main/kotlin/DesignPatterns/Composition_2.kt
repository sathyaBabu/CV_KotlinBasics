package DesignPatterns

import Utils.Const

open class Vech_Engine{

}
open class Engine1000CC : Vech_Engine(){

}
open class Engine4400CC : Engine1000CC(){

}


open class ShipEngine84400CC : Vech_Engine(){

}


class Engine1{

    fun start(){
        println("Started the regular Engine")
    }
}

open class Engine4000CC{

    fun start(){
        println("Started the 4000CC Engine")
    }
}

class Car1(  val engine:Engine1000CC){

    //var enginee =engine
    fun start(){
       // engine.start()
    }
}

fun main(){

    val engine = Engine1000CC()  // is this from the above inheritance???

    // ANS Can be NO : I picked it from a Factory  Engine4000CC()

    val car = Car1( engine )   // composition.. we are injecting the engine..
    car.start()

   // println(" MySal ${Const.MY_SAL}")

}