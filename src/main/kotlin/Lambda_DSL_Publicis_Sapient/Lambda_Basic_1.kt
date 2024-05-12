package Lambda
//     println( upeerCase1("My first Hello to lambda expression") )
//    input                    ret type      body    trialing ret type
val upeerCase1 : ( String ) -> String = {  str:String -> str.uppercase()  }
val upeerCase2 : ( String ) -> String = {           it -> it.uppercase() }
val upeerCase_2 : ( String ) -> String = {          str  -> str.uppercase() }
val upeerCase3  =               {          str:String -> str.uppercase() }

val upeerCase4 : ( String ) -> String = {                 it.uppercase() }
val upeerCase5 : ( String ) -> String =  String::uppercase
val productOf = {  value:Int ->  value * 2 }



// At a bu=irds eye view this is what can be called as functional composition

//                                {}/ sum
//      2   :  Calculate(    12,3,           ::Sum )
//      1  :  { a,b -> a + b    }
fun Calculate( x:Int, y :Int ,  operation : (Int,Int) -> Int) : Int {
    return  operation(x , y)  // {  x , y }
           // {} // sum
}
//
//fun callMeDummy( myFun : () -> Unit ){
//    myFun()


fun Sum( x :Int,y:Int) =  x + y+100


fun main(){

    var i:Int = 99
    // What is Lambda... lamda is a function..

    {  println(" lambda expression called! $i") } ()

    val sayHello = { println("Hello from Lambda") }
        sayHello()

    println( upeerCase1("My first Hello to lambda expression") )
    println( upeerCase2("My second Hello to lambda expression") )
    println( upeerCase_2("My third Hello to lambda expression") )
    println( upeerCase3("My second Hello to lambda expression") )

    println( upeerCase4("My Fourth Hello to lambda expression") )
    println( upeerCase5("My Five  Hello to lambda expression") )

    println( productOf( 22 ) )


    // calling a
//               1                        {}
    val sumResult1 = Calculate(12,3, { a,b -> a + b    } )
    println("Sum from the FC is $sumResult1")


   // fun Sum( x :Int,y:Int) =  x + y+100
//                2
    val sumResult2 = Calculate(12,3, ::Sum )
    println("Sum from the FC is $sumResult2")

    //         greet
    callMe(    { println("Hey Deeepak!") }   )


    val ref =  { println("Hey Pragnya") }
    ref()

    val func = operation()
    println( "Square -> ${func( 4 ) }")  // Square -> 16


    // profiler....
    // creating our APIWrapper around the Wifi object to profile it.. to check the packet loss or the exewc speed..
    myFunctiion() { println("     Lets profile the data..") }
}
 //                { .. }
fun myFunctiion(wifiDataPAcket: () -> Unit) {
    // Async coroutines here..
    println("Lets try to find the start time")

          wifiDataPAcket() // Lets profile the data..

    println("Lets get the endtime")

}

fun operation() : ( Int ) -> Int {  return  :: square}
fun square(x:Int) = x * x
//
//fnptr = sum ;
//(*fnptr)(  object )
//fnptr()
//
//fun callMe(   greet: () -> Unit   ) {    // Unit -> returns nothing   -> Int
//  greet()     // println("Hey Deeepak!")
//}

fun callMe( myFun : () -> Unit ) {   // void* ( Any ) is replaced by Unit
    myFun()
}


// pre req....