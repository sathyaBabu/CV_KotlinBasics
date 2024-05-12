package List_Impl_1
/*
  Normal function

   we pass object to function
   we create object in a function
   we return object from a function

   HIGHER ORDER function are functional composition


   we pass   function to function
   we create function in a function
   we return function from a function

   passing a function to a function needs a reference to call back and forth

   lambda expressions are anonymous functions
   expected to be pure functions

   keep lambda as a single line body( NO MULti line or multiple functions )

   { ( paramater list ) -> Uint }



 */
// imperative programing we use for if while
val numbers = listOf(1,2,3,4,5,6,7,8,9,10)

var total = 0

fun main() {
    // External Iterator
    for (number in numbers) {
        if (number % 2 == 0) {
            total += number * 2
        }
    }
    println( total )

    // Passing a lambda
    // internal iterator
    numbers.forEach  { it -> println( it ) } // pass through lambda passes the argument

    // cleaner way
    numbers.forEach  {  println( it ) }

    // functional reference
    numbers.forEach  ( ::println )   // pass through lambda

    /// receiving a lambda
    // assign a lambda to a variable and print

    // take lambda and store it in a variable

    val printIt: (Int) ->Unit = { number -> println( number )}
    printIt(80);
    // cleaner
    val printIt2 = { number: Int -> println(number) }
    printIt(980);

     println("OK")


    // action is an annonymus function

    // opposite to imperative coding functional composition

    // ------> Not a preferred way!!!

    fun compute( action: ( Double ) -> Unit, n: Int,){
        action( n * 12.10)
    }
    compute({ result -> println( result ) } , 88 )

    //------->  preferred way!!!
    fun compute(n: Int, action: ( Double ) -> Unit){
        action( n * 12.10)
    }

       // Only when lambda is a last arg
       compute(10,{ result -> println( result ) } )  // 121.0

       // Only when lambda is a last arg
       compute(20 ) { result -> println( result ) }  // 221.0

    }

