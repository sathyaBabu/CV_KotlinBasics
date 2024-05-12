package Lambda


// Higher order function..

fun call( greet : ( String ) -> Unit){
    Thread.sleep(5000)  // busy 5 ms
    greet("Aamer")

}
//                               1c2f()
fun callContextOfTheOtherObject( greet: String. ( String ) -> Unit){

    "Foo ".greet("Pranav")

    greet("Hello","Pranav")
    greet("Hi","Pranav")
    greet("Abey.. ","Pranav")

   // greet(this,"asas")
}

fun callMe() : Any {

    //
    //
    //
    //
    //
    // return x
    return 12

}

fun main(){

    // Phase I  higher order function..
    call { name -> println(" Hi $name ") }

    // Phase II
    callContextOfTheOtherObject { name -> println(" ${this.toUpperCase()} $name") }  // 1c2f

 val ref =    {"Hey lambda"}()   // 112f


   val  x = callMe()  // initiate..

}