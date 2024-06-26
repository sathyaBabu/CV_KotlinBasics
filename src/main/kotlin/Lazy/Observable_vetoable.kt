package Lazy

import kotlin.properties.Delegates

fun main(){


    // Observer will check for a change and displays the value
    var max : Int by Delegates.observable(10 ){
        property, oldValue, newValue ->
                newValue > oldValue
    }

    println(max)  // 10

    max = 9

    println(max)

    max = 20

    println(max)

    max = 1
    println(max)
    // 10 9 20 1


    var maxVeto : Int by Delegates.vetoable(10 ){
            property, oldValue, newValue ->
        newValue > oldValue
    }


    println(maxVeto)  // 10

    maxVeto = 9

    println(maxVeto)  // 10

    maxVeto = 20

    println(maxVeto)   // 20

    maxVeto = 1
    println(maxVeto)     // 20


    maxVeto = 10
    println(maxVeto)

}