package Lambda_HighOrderFunctions

import DSL.Days

// 1

fun call(greet: (String) -> Unit){
    greet("Pranav")
}

// 2 how to pass a context object

       // NOTE String. is a context object associated with it
//   make String as a generic type     T.
fun   callContextOfOther(greet: String. (String) -> Unit){
           // String. this("HEY") is a String which gets passed to the callee, name
           greet("Hey ","Pranav")
           "Hello".greet("Pranav")// HELLO Pranav
            "Wow ".greet("Pranav")
}

/////////////// phase III

data class Person(val name: String, val age: Int)


fun main(){
// 1
   // greet calls {}  greet("pranav") "pranav"   is sent as it
    call { it -> println(" Hi $it") }  //  Hi Pranav

    // dummy
    call{

    }
    // 2 callContextOfOtherObhect

    // lets initiate function and wait for the paramaters
    callContextOfOther { name -> println(" ${this.toUpperCase()} $name") } //  HEY  Pranav
   // callContextOfOther{ println(" ${this.toUpperCase()} $it") } //  HEY  Pranav

//  implicit  receiver
//    val greet : String.(String) -> Unit = { name -> println("$this $name ")}
//    greet("Hi ","Sathya")  // hi gets in the space of this
//    "Hello ".greet( "Sathya Babu") //  works but noisy



    //////////////  Phase III implement the following
    // create a class of your own myListOf.. pass Person object and create a lambda over it
    // to mimic the following code

    val people = listOf(
        Person("Aamer", 24),
        Person("Sathya", 49),
        Person("Swapnil", 92),
        Person("Astha", 22),
        Person("Jyothi", 22),
        Person("Rushik", 28)
    )

    val selectedPerson = people
        .filter { it.name.startsWith("S") }
        .maxOf{ it.age }

        //.Days("5")




    println("Here you go.. ${selectedPerson.toString()}")

  //  val selectedPerson2 = people.maxOf({ person ->  person.name })
    println("Selected guy! .. ${ people.maxOf({ person ->  person.name })}")



}