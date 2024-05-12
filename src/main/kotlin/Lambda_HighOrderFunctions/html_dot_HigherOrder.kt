package Lambda_HighOrderFunctions

import DSL.Days


// Phase II
/*

class HTML {
    fun body() {println("in HTML{ body() } $name you are  $age this year \n ") }
    var age:Int = 34
    var name:String? = null


    fun html(  init: HTML.() -> Unit): HTML {
        val html = HTML()  // create the receiver object HTML literally a this pointer
        html.init()        // this.body()  --> pass the receiver object to the lambda
        //    this.body()
        return html             // returns body() from HTML
    }

}
 */

// Phase I
class HTML {
    fun body() {println("in HTML{ body() }  \n ") }
    // fun body() {println("in HTML{ body() } $name \n ") }
    var age:Int = 34
    var name:String? = null


}

// receives this. lambda here in this bracket
// HTML.() points to this data type
// body gets into init

// move this block into HTML in Phase II
fun html(  init: HTML.() -> Unit): HTML {
    val html = HTML()  // create the receiver object HTML literally a this pointer
    html.init()  // html{ } = (init)      //  this.body()  --> pass the receiver object to the lambda
    //    this.body()
    return html             // returns body() from HTML
}

fun main() {
//
//    // calling a lambda function called as Higher order function
    html {       // lambda with receiver begins here
        body()   // calling a method on the receiver object
    }

    // phase II

    html {
        age = 34
        name = "Sathya P"
        body()
    }.apply { println("apply -> Name $name Age $age") }
    // Phase II
 /* var ht = HTML()
    ht.html {
                age = 34
        name = "Sathya P"
        body()
    }*/



    //////////////  Phase III implement the following
    // create a class of your own myListOf.. pass Person object and create a lambda over it
    // to mimic the following code

    val people = listOf(
        Person("Aamer", 24),
        Person("Sathya", 49),
        Person("Swapnil", 22),
        Person("Astha", 22),
        Person("Jyothi", 22),
        Person("Rushik", 28)
    )

    val selectedPerson = people
        .filter { it.name.startsWith("S") }
        .maxOf{ it.age }
        .Days("5")




    println("Here you go.. $selectedPerson")

}

// in HTML{ body() }

//