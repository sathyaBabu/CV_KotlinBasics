package Class


// POJO model  -> in java we set and get the data from pojo class..( Boiler plate code... )

// get set
// deligation by

// sealed class

// companion objects.. -> Static  SingleTon
//
// Assignments...

// Lambda..
// Higher order function..

// Assignment..

// DSL -> the way Gradle looks like..



data class _Books( val name : String , val publisher : String, var review : Int)

fun main(){
    val book: _Books = _Books("Kotlin","BPB",5)
    println(" Book : ${book.name} Publisher ${book.publisher} rating ${book.review}")  // get()


    // Getter and setter??? its all default we use get() set() copy()
    book.review = 9
}
