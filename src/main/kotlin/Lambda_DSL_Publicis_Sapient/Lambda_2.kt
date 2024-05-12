package Lambda


// Higher order function..

fun call( greet : ( String ) -> Unit){
    Thread.sleep(5000)  // busy 5 ms
    greet("Aamer")  // passing aamer to {}

}
//   callContextOfTheOtherObject { name -> println(" ${this.toUpperCase()} $name") }  // 1c2f
//                               1c2f()
fun callContextOfTheOtherObject( greet: String. ( String ) -> Unit){
//                               greet   Foo.     Pranav
                                         "Foo ".greet("Pranav")
                     //            {}    this    name
                                  greet("Hello","Pranav")
                                  greet("Hi","Pranav")
                                  greet("Abey.. ","Pranav")

   // greet(this,"asas")
}

fun callMe() : Any {

    //
    // return x
    return 12

}

fun main(){

    // Phase I  higher order function..
    call { name -> println(" Hi $name ") } //  Hi Aamer

    // Phase II
    callContextOfTheOtherObject { name -> println(" ${this.toUpperCase()} $name") }  // 1c2f
/*
 this     name
 FOO      Pranav

 HELLO    Pranav
 HI       Pranav
 ABEY..   Pranav
 */
 val ref =    {"Hey lambda"}()   // 112f


   val  x = callMe()  // initiate..

}