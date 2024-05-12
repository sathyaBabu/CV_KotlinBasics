package Lambda_HighOrderFunctions

import Lambda_HighOrderFunctions.View.OnClickListener


// ***  Assignment look DOWN
/*

tasks{
    compileKotlin{
        var allWarningsAsErrors = true
    }
}
 */

//   input                    ret type         receive
val upperCase1 : (String) -> String = {     str:String   -> str.uppercase()  }
val upperCase2 : (String) -> String = {      str -> str.uppercase()          }
val upperCase3 = {  str:String -> str.uppercase() }
val upperCase4 : (String) -> String = {  it.uppercase() }
val upperCase5 : (String) -> String = String::uppercase
val productOf = { value:Int -> value * 2 }

// Phase II      & III                Sum
//    functional composition : (operation: ( Int, Int)  -> Int )
fun calculate( x:Int, y : Int , operation: ( Int, Int)  -> Int ) : Int {   // 1
    return  operation(x,y)    // operation has the address of Sum
}
        // val list:List<Int> = nums.filter(    ::isODD       )
        // ListMapFilter_1

fun Sum(x:Int, y:Int) = x + y+100   // 2




// Phase VI
fun operation() : (Int) -> Int { return  :: square}  // 1

fun square(x:Int) = x * x   //2
            //
            //fun div(x:Int) = x / 2   //2
            //////////////
fun callMe(greeting: () -> Unit) {
    greeting()
}
                        // Assignment on windows

                        class View {
                            interface OnClickListener{
                                fun onClick()
                            }
                        }

                        fun setOnClickListener(listener: (view: View) -> Unit){
                          //  listener(view)
                        }

//                                 provider function
private fun IntRange.mimic_forEach(function: (Int) -> Unit) {

                // iterator...  create your own..
                // O(n) o(1)
                //  var itr: IntRange = (1..5)
                // itr = itr.iterator()
                // nested for o( n*2 )   worst way of coding..
    println(" first....   ${this.first}")
    println(" Last....   ${this.last}")

    // lets pick the iterator from IntRange expression

    var itr = this.iterator()
    while(itr.hasNext()){

        // provider
        function( itr.next() )  // lets pass the it back to the lambda for the user to access the data
        // println(" myMimic ${itr.next()}") // MyOwnAlgo 1 ... 1o
    }

}


fun main(){

                   // Assignment on windows
                    setOnClickListener{
                        view->
                    }

    var i:Int = 99
    // Lambda can be a class
    // Lambda are called as functions too

    { println("Lambda expressions called....$i")   }()   // lambda function..

    val sayHello = { println("Hello!")}
    sayHello()

    println( upperCase1("My First   Hello via Lambda! ") )   // MY FIRST HELLO VIA LAMBDA!
    println( upperCase2("My Second  Hello via Lambda! ") )   // MY  SECOND   HELLO VIA LAMBDA!
    println( upperCase3("My Third   Hello via Lambda! ") )   //  MY THIRD   HELLO VIA LAMBDA!

    println( upperCase4("My Forth  Hello via Lambda! ") )   //  MY Forth  HELLO VIA LAMBDA!
    println( upperCase5("My Fifth  Hello via Lambda! ") )   //  MY FIFTH HELLO VIA LAMBDA!

     println(productOf(22))                                  // 44

    callMe({ println("Hello!") })

           // this.forEach{ print( it ) }
            // explain this in lambda

    (1..10).forEach {

        println("  for each lambda ${it.plus( 10 )}")
    }
    (1..5).mimic_forEach{
        println(" it... $it")

    }


    fun process(n : Int, func : (Int) -> Unit) {
        func(n * 2 )
    }


    // functional composition
   // Phase I
   // val sumResult = calculate(12,3,::Sum)  // 1st 12, 3   2nd ::Sum

  //  println("Sum2 from the FC is $sumResult")  // Sum2 from the FC is 15


   // Phase II LINE 27 fun Sum(x:Int, y:Int) = x + y+100   // 2
    val sumResult2 = calculate(12,3, ::Sum )  // 1st 12, 3   2nd ::Sum
//                                         { fun     }
    println("Sum from the FC is $sumResult2")  // Sum from the FC is 15

 //                                          { fun  receives a,b (A+B)       }
    val sumResult22 = calculate(12,3, { a,b -> a + b } )  // 1st 12, 3   2nd ::Sum
//                                         { fun     }
    println("Sum from the FC is $sumResult22")  // Sum from the FC is 15



    // Phase III lambda can be the last operator
    val sumResult3 = calculate(12,3, )  { a,b -> a * b }  // 1st 12, 3   2nd ::Sum

    println("Prod the FC is $sumResult3")  // Sum from the FC is 15


    // Phase III
    val sumResult4 = calculate(12,3, )  { a,b -> a / b }  // 1st 12, 3   2nd ::Sum

    println("Div the FC is $sumResult4")  // Div the FC is 4



    // Phase VI
    val func = operation()
    println(func(4 ))   // func : square( 4 )  is returned from lambda  // 16

     // Phase V


  //  myFunction() {  println("           Hey Lambda called from myFunctiojn() ")     }
    // --> refer end of code
    // this  lambda acts as a wrapper in getting the start time and end time also gets the bet connection
    fun downLoadSomeData(){
      println(" http://www.google.com/pictures.....")
    }

    myFunction  {

        downLoadSomeData()
    }
    ////// Refer down below
    // when...

    process(5){ e-> println( "Process has returned .. $e" ) } // Process has returned .. 10

    // *********Phase VI  --> refer end of code  :  function(variable) returns it
    // rec -> a string is received here
    val rec = receiveAvalue(23  )  {


        it in  20..30   // ->  { true }  //???
        println(" Lets Receive the value in our lambda RECEIVE...$it.")
    }
    println("Received from receiveValue $rec \n ")
//    Lets Receive the value in our lambda RECEIVE...23.
//    Job completed from RECEIVE

    /////////////////////////////////////////////

  //  when(12) {    }   // 1  or 1,2,3,4  is in  return

    ///////////////////  higher order  Phase VII


    fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
        return operation(x, y)                                          // 2
    }

    fun sum(x: Int, y: Int) = x + y                                     // 3

    // main
        val sumResult = calculate(4, 5, ::sum)                          // 4
        val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
        println("sumResult  Higher order $sumResult, mulResult $mulResult")

         ///////
         // . this operator ///////////////////    Phase VIII


    val greet : String.(String) -> Unit = { name -> println("$this $name ")}
    greet("Hi ","Sathya")  // hi gets in the space of this
    "Hello ".greet( "Sathya Babu") //  works but noisy

    /////////////////////////////////////////////
    println("Using . this operator")

    val intPlus: Int.(Int) -> Int = Int::plus

    println(intPlus.invoke(2,3))
    println(intPlus(2,30))
    println(12.intPlus(23))

// IMP JUST BEFORE . operator

    println(" String.(Int)")
    /*
     It represents a function that takes an Int parameter and returns
      a String. However, it's defined as an extension function on String
     */
    val repeatFun: String.(Int) -> String = { times -> this.repeat( times )}// times : num of times to repete
   // val twoParamaters: ( String,Int) -> String = repeatFun

    fun runTransformation( f: (String,Int) -> String ) : String {

        return f(" Hello ",3)  // passing hello , 3 here...
    }
    /*
    Here, repeatFun is passed as an argument to runTransformation. Since repeatFun matches the signature
     expected by runTransformation, it can be passed directly.
     */
    val result = runTransformation( repeatFun )
    println(result)

    println("--*--".repeat(30))

}


//                                  23   lambda comes in here
inline  fun receiveAvalue(variable: Int, function: (res:Int) -> Unit): String {

    println("received $variable")
    function( variable )   // Lets Receive the value in our lambda RECEIVE...23 via it.
   return "Job completed from RECEIVE"
}

// // Phase V
// inline fun will not use the stack..
 inline  fun myFunction( function: () -> Unit){

    // thread -- coroutine...

    println(" Lets try to find the start time GET THE NET CONNECTION ..")

        function()

    println(" Lets try to Get the end  time.  JOB DONE DISCONNECT THE NET.")

}

/*
res.fr.noida@fernhotels.com

komal

 Lets try to find the start time GET THE NET CONNECTION
         http://www.google.com/pictures....
 Lets try to Get the end  time.  JOB DONE DISCONNECT THE NET.
 */