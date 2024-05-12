import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.random.Random

import java.time.format.TextStyle
import java.util.*

/*

   C is a Skeleton  language for your OS you can fill up the API as you need
   so as KOTLIN -> Its propels three folds  further by letting you redesign  /model  the expressions

   it's an expressive language
   Car driveAt 100 Km

   10 plus 20 divide by 2

    is 10 an Int
    x as Int

     10 in listOf(10,20,30)
     5 in 1..10

     coffee by choice   It remembers I like coffee it will not create object repetedly


   class Car {
      void driveAt( int speed ) {...}
      }

   Any Class can be extended with a function a default characteristics provided by Kotlin
   Changes the landscape of object oriented programming
   Member function takes over first compared to extended function!!!
   It super seeds Java  why even c++!!

   Got the best out of many languages like scala, ruby groovy...
   By gives us the stupendous api, You  simply go gaga over the language

  deprecated  Static (But java static starts with it!! )null, if switch , casting .....
   *****--> Various Algo's Design patterns like SingleTon, Proxy, factory, Visitor, State, Observer

  Multi platform programming NATIVE
  common to Ios and Android KMM

    Goal Android :

       we shall witness the Confluence of Kotlin DS, DP into  Android
       At  the core it stems from  Linux OS  HAL(HIAL) -> C++ -> NDK ->  ServiceManagers -> (Culmination) Kotlin/Java


  Supports Profiling ->  Memory CPU GPU
  Debug
  dumpsys
  Log -> A circular buffer ( Worked on it )

     Install  Intillij idea   on your system It's a must.
     next week Saturday
     JDK > 1.8  Android studio framework ...  SDK.. ( 3 - 4 hrs )
//
//     SOLID principles. Mr Bob Martin fondly called as Uncle BOB
//     UML
//     Design patterns  GOF  PDF.
//
//    Android development..
//    BSP( HIKey 960 - 990+ AOSP / Kernel  ) - Cell phone - Emulator ( Embedded systems )
//
//    API
//
//    Project..
//
//
//    Kotlin....
    Kotlin API has built algorithm...

    int Intary[100 ] // sort the array
    Bubble sort  O(n2)
    for{.....}
       for{.... }
           sort..

           ary.sort()



Kotlin day wise training contents

Day 1 -  Main.kt

Str variables declaration and printing the same
data types
diffrentKindOfStringVar - multi line string

arrayof - usage
forindex  listOf ( names.indices) getting an index
How to use when instead of if
WhatToDo - using when  -> in is else  also getting systemInfo
systemInfo

MapCode - Pair maps  using it


vraiable_as   a as int vs Casting in c language
Using null in a better way by eradicating if  ——>  (  fishFoodTreats = fishFoodTreats?.dec() ?: 0 )
using let :   fishFoodTreats2?.let {

using if

if_when
do while

feedTheFish : using repeat   : return when( day )


randomDay(): Any   using any

for_range_Expressions until filter reverse using iterator( design pattern interface )
1.rangeTo(7)  intRange(1,10)

Extending forEach(….
(0..n).forEach{ print( it ) }  // 0 1 2 3 4 5 6 7 8 9

using sum average repeat on range

chaining

chainMEup() {

    val equipment = "FishNet" to "catching" to "NET"
using Triple returning Triple

inRangeProgression

using functions returning any etc


Day 2

ArrayOf_1.kt

Range_iterationBasics.kt
IntProgression.fromClosedRange

( Creating our range custom iterator LATER part of the session )


// Extended functions

letsGetGoingWithExtendedFunctions()

// INFIX
letsCalculateSomeThing()     // infix

for until using our own notation towards

date progression

feedMy Fish

List_impl_1
functional composition
list map filter

Collections
Collections_List
Collections_Map_1
Collections_Set_1


*** IMP
data object class
SingleTon
get() set()
how data object takes on proxy
Delegation


Class

Class_Abstraction
Class_CompanionObjects
Class_Data_Object_Class
Class_DataCopy
Class_DerivingOrder
Class_Interface
Class_interface_Composition
Class_interface_Sealed
Class_internalMember
Class_SealedClass
Class_constructors
Class_ProtectedModifiers
getSet


FS_let_it_run_aplay_also
fun_invoke


*******????????**



// Day 3
// List... Set Map same s Array..
// list map filter.. how to use evrything together
//              Class compositions.. Aggregations..
//  functional composition.. List
//   Higher order functions..   functional composition
//   Lambda.. IMP
// Break for assignments..

//generic.kt

//Lambda_HigherOrder functions



// DSL
// expressive coding!!!!!

// day 4 27th day after..
// class


// Functions

// Factorial   What is factorial of n numbers 1 2 3 4 5    5 * 4 * 3 * 2 * 1 = 120
// by using a for loop also by using a recursive function



Way our appliction looks
use compose ui instead

    val dialog: Dialog =
        /*
        verticalLayout( verticalLayout = true , margine_width = wrap_content ,....) {
        tabSheeet {
           tab( caption: "Button",HAND_IMG) {

             horizontalLayout( margine_width = wrap_content, margine_height = wrap_conyent {
                  button()
                  button(caption:"Lable")
                  button(caption:"Lable",HAND_IMG)
                  button(caption:"Click me ",onClick = { show(messsage : "Clicked") }
                  button(caption:"Click me ",HAND_IMG,{ show(messsage : "Clicked") }
                    // end Button
                  }
              }
           }

         */
        dialog {
            title {
                text = "Dialog Title"
            }
            message {
                text = "Dialog Message"
                color = "#FF00FF"
            }
            image {
                File.createTempFile("image", "jpg")
            }
           /*
                  button(caption:"Click me ",onClick = { show(messsage : "Clicked") }
                  button(caption:"Click me ",HAND_IMG, { show(messsage : "Clicked") }

            */


        }



tailRec for factorial




 */

fun main(){
//  fun main() = println("Hello World")





    dataTypes()
    println("-*-".repeat(40))

    strVariables()

    println("-*-".repeat(40))


    diffrentKindOfStringVar()
    println("-*-".repeat(40))
    let();
    println("-*-".repeat(40))
    array()
    println("-*-".repeat(40))
    /*

    // Extension functions..  **** IMP *****
    //  can be created on any class....
    // When we have to add a fun to a class we need to chang the class...
    // BAd practice  SOLID ----> hey use O principle
    // Open for extension and closed for modification

    // we are extending a String...
    // remember  repeat(40) is not a part of the string..

    // I can add a character to a Button String Car objects.. Without modifying it..

     */

    functions()

    println("-*-".repeat(40))

    letsGetGoingWithExtendedFunctions()

    println("-*-".repeat(40))


    forindex();
    println("-*-".repeat(40))

    println("-*-".repeat(40))
    expressive_in_is_as()

    println("-*-".repeat(40))

    db("Sathya",age = 48,sex = 'M')

    println("-*-".repeat(40))
    if_condition()


    println("-*-".repeat(40))
    if_When()

    println("-*-".repeat(40))
    println("When you Give me a data, Shall return the type!!")
    println(processMyDataPlease( 1 ) )   // One
    println(processMyDataPlease( 16 ) )  // A teen
    println(processMyDataPlease( "Hey there!" ) )// Hey that's a string of length 10
    println(processMyDataPlease( 23.23 ) ) // no clue!


    println("-*-".repeat(40))

//            println(createMemoFor("Supreeth"))
//
//
//            println("-*-".repeat(40))


    println(whatToDo("Sunday")) //
    // Relax
    println(whatToDo("Wednesday"))
    // Work hard
    println(whatToDo(3)) //Work hard
    println(whatToDo("Friday")) //Party
    println(whatToDo("Munday")) //What?
    println(whatToDo(8)) //No clue

    println("-*-".repeat(40))

    println(systemInfo())
    println("-*-".repeat(40))

  ////////////  mapCode();

    println("-*-".repeat(40))
   ///////////
    vraiable_as_null()   // let too!!

    println("-*-".repeat(40))




    println(" A function returned : ${whichReturns()}")  //  A function returned : 100

    println("-*-".repeat(40))



    do_While()

    println("-*-".repeat(40))

    feedTheFish()

    println("-*-".repeat(40))

    for_range_Expressions()

    println("-*-".repeat(40))

    chainMEup()

    // Day 2

    inRangeProgression()  // We shall come back to it in few min



    // Jump to RangeIteratorBasics and Come back..
    // Range progressions...

    // Day 3
    // List... Set Map same s Array..
    // list map filter.. how to use evrything together
    //              Class compositions.. Aggregations..
    //  functional composition.. List
    //   Higher order functions..   functional composition
    //   Lambda.. IMP
    // Break for assignments..


    // DSL
    // expressive coding!!!!!

    // day 4 27th day after..
    // class


    // Functions

    // Factorial   What is factorial of n numbers 1 2 3 4 5    5 * 4 * 3 * 2 * 1 = 120
    // by using a for loop also by using a recursive function

    //val number = 100000.toLong() will crash the system xception in thread "main" java.lang.StackOverflowError
    val number = 5.toLong()  // xception in thread "main" java.lang.StackOverflowError  :at MainKt.factorial(Main.kt:120)

    val result: Long

    result = factorial( number)
    println(" Factorial of $ number = $result")  //  Factorial of $ number = 120

    println("-*-".repeat(40))

    // recurssions  and its debacles...

    // Extended functions

                              letsGetGoingWithExtendedFunctions()

                                println("-*-".repeat(40))
                                delLastFiveLetterFromString()
                                println("-*-".repeat(40))
    // INFIX
    letsCalculateSomeThing()     // infix
    println("-*-".repeat(40))
    // INFIX

    // lets try to understand the range until in for loop




    // infix  making our code more readable more expressive..

   // infix progression

    // Assignment Sunday..Monday to feed the fish

    // IntProgression
    fun_Until()   // until   toWard.. step

    // date progression
    dayOfTheWeek_1()
    dateProgression()

    FeedMyFish()
//    presenter2()


}
////////////////////////////////////////
fun mapCode() {

    println(Pair("Tom", "Jerry")) //(Tom, Jerry)
    println(mapOf("Tom" to "Cat", "Jerry" to "Mouse")) //{Tom=Cat, Jerry=Mouse}


    val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
    val temperatures =
         airportCodes.map { it -> it to getTemperatureAtAirport(it) }  // OR
        airportCodes.map { code -> code to getTemperatureAtAirport(code) }
    for (temp in temperatures) {
        println("Airport: ${temp.first}: Temperature: ${temp.second}")
    }
}
fun getTemperatureAtAirport(code: String): String = "${Math.round(Math.random() * 30) + code.count()} C"


////////////////////////////////////////
fun systemInfo(): String {
    val numberOfCores = Runtime.getRuntime().availableProcessors()
    return when (numberOfCores) {
        1 -> "1 core, packing this one to the museum"
        in 2..16 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores!, I want your machine"
    }
}
/* Jave a freeky language forgets things often!

     public static void display( Object input ) {
     if( input instanceof String ) {
     system.out.println(
     " got a string length " + ( (String ) input).length);
     } else { ... }
     }

 */

fun whatToDo(dayOfWeek: Any) = when (dayOfWeek) {
        "Saturday", "Sunday" -> "Relax"
        in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard"
        in 2..4 -> "Work hard"
        "Friday" -> "Party"
        is String -> "What? is of length ${dayOfWeek.length}"
        else -> "No clue"
    }


fun forindex() {
    val names = listOf("Sathya", "Shashank", "Sneha")

    for ( name in names) {
        println ( name )
    }
    for ( entry  in names.withIndex()) {
        println ( " Output : $entry " ) //IndexedValue( index = 0, Value = Sathya )...
    }
/*
   Output : IndexedValue(index=0, value=Sathya)
   Output : IndexedValue(index=1, value=Shashank)
   Output : IndexedValue(index=2, value=Sneha)
 */
    // destructuring is tearing up the above as two elements
    for ( (i,name)  in names.withIndex()) {
        println ( " Output : $i --- $name" ) //0 -- sathya 1 -- Shashank 2 -- Sneha
    }
/*
Output : 0 --- Sathya
 Output : 1 --- Shashank
 Output : 2 --- Sneha
 */
    for (index in names.indices) {
        println("Position of ${names.get(index)} is $index")
    }
    /*
    Position of Sathya is 0
Position of Shashank is 1
Position of Sneha is 2
     */
}

//
//        fun String.formatString():Boolean{
//            if(this[8].toChar()> '1') {
//                println(this[8])
//                return true
//            }
//            else{
//                return false
//            }
//        }
//fun presenter2() {
//
//
//        // I want to feed my fish on Feb 3rd week Monday to Friday
//
//        val Jan_24th_22 = LocalDate.of(2022, 1, 1)
//        val Jan_24th_23 = LocalDate.of(2023, 12, 31)
//        //Today's date
//
//        if (LocalDate.now() in Jan_24th_22..Jan_24th_23)
//            println("Welcome to ${LocalDate.now()}")  // Welcome to 2022-01-24
//
//      //  val CurrentDate = LocalDate.now().toString()
//    var CurrentDate="2022-02-11"
//    var curMonth="FEBRUARY"
//       // val curMonth = LocalDate.now().month.toString()
//        when (curMonth) {
//            "FEBRUARY" -> {
//                var bool: Boolean = CurrentDate.formatString()
//                if (bool) {
//                    var daysArray = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
////                    var calendar = Calendar.getInstance()
//
//                        for (day in daysArray) {
//                            if (day == "Sunday") {
//                                continue
//                            }
//                            if (day == "Saturday") {
//                                continue
//                            }
//                            println("i am feeding the fish on $day")
//                        }
//                    }
//                }
//            }
//
//}

/////
                 //   I want to feed my fish on Feb 3rd week Monday to Friday

fun FeedMyFish(){
    val start_date       = LocalDate.of(2022,7,19)
    val end_date         = LocalDate.of(2022,7,25)
    val start_day_month  = start_date.dayOfMonth
    val end_day_month    =  end_date.dayOfMonth

    for (i in start_day_month..end_day_month)
    {
        var day_of_week  =  LocalDate.of(2022,7,i).dayOfWeek
        var day_array    =  listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY")

        if(day_array.contains(day_of_week.toString()))
            println("feed the fish on date ${LocalDate.of(2022,7,i)} and day is ${day_of_week}  ")
        // feed the fish on date 2022-07-19 and day is TUESDAY  ... feed the fish on date 2022-07-25 and day is MONDAY
    }
}

fun dayOfTheWeek_1() {
    val dateString = "2023-05-29"
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val date = LocalDate.parse(dateString, formatter)

    val dayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())

    println("The day of the week for $dateString is $dayOfWeek")

    // Phase II

    val daysOfWeek = mutableListOf<String>()
    val startDate = LocalDate.parse(dateString, formatter)

    for (i in 0 until 7) {
        val date = startDate.plusDays(i.toLong())
        val dayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
        daysOfWeek.add(dayOfWeek)
    }

    println("Days of the week from $dateString:")
    daysOfWeek.forEach { println(it) }
}
fun dateProgression() {


    // I want to feed my fish on Feb 3rd week Monday to Friday

    val Jul_26th_22 = LocalDate.of(2022,1,1)
    val Jul_27th_23 = LocalDate.of(2023,12,31)

      if(LocalDate.now() in Jul_26th_22..Jul_27th_23)
          println("Welcome to ${LocalDate.now()}")  // Welcome to 2022-07-26
    //  LocalDate.now.dayOfWeek()


}

fun fun_Until() {
// its all about IntProgression
    // reffer FS_Let_it_Run_With in as containes

    for( i in 1.until(10)){
        println(" $i ")  // 9 until 9++
    }

    // This can be done on our code too
    // lets take a peek

    letsCalculateSomeThing()

    for( i in 1 until 10){
        println(" $i ")  // 9 until 9++
    }

    for(i in 0 until 10  step 3){
        println(" $i until $i++ ")  // 9 until 9++
    }


    for( i in 1..10){
        println(" $i ")  // 9 until 9++
    }


    /////// my expression toWard

    for(i in 0 toWard 10 ){    // just below you will finr toWard
        println(" $i toward  $i++ ")  // from 0 ....  9 until 9++
    }


    for(i in 10 toWard 0 ){    // step -3
        println(" $i toward  $i++ ")  // 10 .. 0 9 until 9++
    }
      //  2 in 1 toWard 10

    for(i in 0..10 step 3  ){
        println(" $i regular $i++ ")  // 0 3 6 9 .... 9 until 9++
    }

    // range
    var range:IntRange = 1..5

    for (i in range.first until range.last step range.step){  // range.step = 1
        println ("Loop de loop $i")
    }
    println()
    range.forEach(::print) // prints: 1234
    println()
    range.reversed().forEach(::print) // prints: 4321
    println()

//     range = IntProgression.fromClosedRange(1, 4, 1)
//    range.forEach(::print) // prints: 1234
//    range.reversed().forEach(::print) // prints: 4321
//    range= IntProgression.fromClosedRange(1, 4, 1) as IntRange
//
//    for (i in range)
//        println(i) // out put 1234
//
//    for (i in range.reversed())
//        println(i)//out put 4321


}
//
//infix fun Int.toWard(to:Int) : IntProgression{
//
//    val step = 3
//
//    return  IntProgression.fromClosedRange(this,to,step)
//
//}
//        this toward  to
//         0  toWard   10
//         10 toWard   0
infix fun Int.toWard(to:Int) : IntProgression{
               //  0    > 10
    val step = if( this > to ) -1 else 1
    // or
   // val step = if( this > to ) -2 else 2

    return  IntProgression.fromClosedRange(this,to,step)
                        //                             0   10  1
                        //                             10   0 -1

}
/*
 0 toward  0++
 2 toward  2++
 4 toward  4++
 */

fun letsCalculateSomeThing() {

    val x:Int = 10
    val y:Int = 20 ;

    //before infix
    x.findTheGreaterValue( y )  //  y is greater 10

    val greater = x findTheGreaterValue y       // Greater : 20
    println("Greater : $greater")  // Greater : 20

//    x findTheGreaterValue y

    infix fun Int.add( b:Int) : Int = this + b

    val xa = 10.add(20)  //  Sum = 30

    val ya = 10 add 20   //  Sum = 30

    val yaa = x add y   //  Sum = 30

    println(" Sum = $xa  yaa---> $yaa")  // Sum = 30  yaa---> 30

}

infix fun Int.findTheGreaterValue( other:Int) : Int{

    if( this > other)
    {
        println(" x is greater $this")
        return this
    }
    else {
        println(" y is greater $this")
        return other
    }
}

// O Principle
fun delLastFiveLetterFromString(){
    fun String.removeLastFiveChar(): String =  this.substring(0, this.length - 5) // Bang


        val myString= "Bangalore"
        val result = myString.removeLastFiveChar()
        println("First character is: $result")

}
// O Principle
//////// This code is a part of extension function

// Existing class  // Phase II
class StringTransformer {
    fun transform(input: String): String {
        return input.toUpperCase()
    }
}

// Extension function for the existing class
fun StringTransformer.addExclamation(input: String): String {
    return transform(input) + "!"
}

fun letsGetGoingWithExtendedFunctions() {
//    println("-*-". repeat(40) )
// Phase I

    fun String.myFormatedString() : String {

        return "---------------\n   Hello $this how are you doing.. \n --------------"
    }

    println("Jyothi".myFormatedString())

    // Phase II

    val transformer = StringTransformer()
    val result = transformer.addExclamation("Hi there extension function")

    println(result) // Output: HI THERE EXTENSION FUNCTION!

}


// Soon as it finds tailRec,  Kotlin will stop using the stack..( iterator )
// by sufxing tailrec  Kotlin will not use stack for the recurssion..

  tailrec  fun factorial(number: Long): Long {
    // 5
    return  if ( number <= 1) {
        number.toLong()       // exit from the current function factorial()..
    }
    else {
        // 5 * factorial( 5 - 1)  //  wrong way of presenting
        // 4 * factorial( 4 - 1)
        // 3 * factorial( 4 - 1)
         number * factorial( number - 1 )
    }

}

/*
  cs : ip
  seg: off
  ffec:0100           xxx :   call myFun      // 5000000
  ffec:0107                    cmp ax, 2e.....


                               End..

  ffee:1c2e                   myFun :
                              .....
                              .....
                               ret    // this pops back SS:bp  to cs:ip  ff ec 01 07



//////////// This is how it works
SS  Stack segment
            sp( ffff )
                - - - - - - -
                - - - - - - -
                - - - - - - -
                - - - ff ec 01 07  BP

                // Segment over flow...

///////////

 */
/*
  // factorial is been pushed into the stack.. and retrived as follows

     factorial( 5 )
      factorial( 4 )  * 5
        factorial( 3)    * 4
          factorial( 2 )   * 3
            factorial( 1 )  * 2
            returning 2 * 1 = 2
           returning 3 * 2 = 6
          returning $ * 6  = 2 4
        returning 5 * 24 = 12 0


 */
fun functions() {

    println(funReturnAstring())  // Hey There!
    println(funReturnAstring2())  // "Hey There in a simple way..!"
    Hey()                 // : Unit          // Hey functions are fun to use...
    println(SayHiToGuys(s="sandeep") )  //Hi sandeep  Zombi...
    println(SayHiToGuys("sandeep", anotherGuy = "Annanya") )  //  Hi sandeep  Annanya

    sum()  // Sum = 11
    println( sum(  number1 = 12,20))  // 32

    // Pair 2  , Triplet 3

    val (name,age,gender)= featchPersonDetails()
    println("$name $age $gender")

    println("*".repeat(40))

    // Pair

    val( tool1,tool2 ) = giveMeAtool()
    println("fishing.. tool received : $tool1 $tool2 r")  // fishing.. tool received : FishNet Boat

    println("*".repeat(40))

//    repeat(40){       }
//    when( name ) {    }


}

fun giveMeAtool() : Pair<String,String>{
    return Pair("FishNet","Boat")
}

fun featchPersonDetails()  : Triple<String,Int,Char>{

    val name = "Arunabha"
    val age = 22
    val gender = 'M'

    return  Triple(name,age,gender)
}
//
//fun SayHiToGuys(s: String)  : String{
//   return " Hi $s"
//}

fun sum() {
    val value1 = 5
    val value2 = 6

    println("Sum = ${value1+value2}")
}

fun sum( number1 : Int, number2 :Int) :Int  {

    val add = number1 + number2
    return  add
}

fun SayHiToGuys(s: String, anotherGuy:String="Zombi...")  : String{
    return " Hi $s  $anotherGuy"
}

// Trailing return types..  ->

fun funReturnAstring() : String {

    return "Hey There!"
}


fun funReturnAstring2() : String  = "Hey There in a simple way..!"


fun Hey(): Unit {

    println("Hey functions are fun to use...")
}

fun inRangeProgression() {

             val myrange : IntRange =  1..5

                    val itr = myrange.iterator()
                    while( itr.hasNext()){
                        println(itr.next())
                    }

    var s: String = "x"
    when (s) {
        in "a".."z" -> println("its between a and z  its is $s")
        else -> println("its not in the alphabet")  // its between a and z  its is x  ASCII value
    }

    // Let's come back to it in few min...

    // Range
    // range progression

//    IntProgression
//    CharProgression
//    LongProgression

    //StringPogression  Not with kotlin

  //  when(      s       ){    }


    val Sunday   :  Int  = 0
    val Saturday :  Int  = 6
    val day      :  Int  = 1    // Calandar..

   // hello( s ) {  }  // Yes we CAN!!!
    s in "a".."z"

    day  in  Sunday..Saturday  // Hey today is 1 Monday lets get to work
    println("Hey today is  $day lets get to work")

    println( " Result :  ${s in "a".."z"} "  );  //  Result :  true

}

fun chainMEup() {

    println("Chain me up")
    val equipment = "FishNet" to "catching" to "NET"
    println(equipment)             // ((FishNet, catching), NET)
    println(equipment.first)       //  (FishNet, catching)
    println(equipment.first)       // (FishNet, catching)
    println(equipment.second)      // NET

    val testChain = ("A" to "B" to "C") to "D"
    println(testChain)                  // (((A, B), C), D)
    println(testChain.first)            // ((A, B), C)
    println(testChain.first.first)      // (A, B)
    println(testChain.first.first.first)   //Z




    val triple: Triple<Int,Int,Int> =  Triple(1,2,3)
    val ( first,second,third)       =  Triple(1,2,3)


    println("*** Triplet $first ** $second  $third")

    val fishnet = "FishNet" to "Catching fish"
    val( tool, use ) = fishnet ;
    println("*** FishNet $fishnet ** $use  ***$tool") // *** FishNet (FishNet, Catching fish) ** Catching fish  ***FishNet

    println("-*-".repeat(40))




}

fun for_range_Expressions() {

    // in 1..10    range expression..


    // 1.until(6)      Extended functions    1.until( 5 )
    //                 infix extensions

    for( x in 1.until(6) )
        print(x)

    // infix : 1 until 5   ( Drive at 40      1 until 5
    for( x in 1 until 5 )
        print(x)


    for( x in 1..10){
        print(x)
    }

    println("-*-".repeat(40))
    for( x in 1 until 10 step 2 )
        println(x)
    println("-*-".repeat(40))

    for( x in 10 .. 1)
        println(x)

   // in "monday".."Sunday" -> {   print("kkkkk") }





    for( nums in 5 .. 15){
        if( nums == 10 ) {
            break;
        }
        println(nums)
    }

    println("-*-".repeat(40))
    for( nums in 5 .. 15){
        if( nums == 10 ) {
            continue
        }
        println(nums)
    }
    println("-*-".repeat(40))

    // Lets quickly visit a lambda expression  Lambda_Basics_1.kt
    // range expressions..
     println( (1..10).filter { it % 2 == 0}  )  // [2, 4, 6, 8, 10]



    println((1..10).filter { it % 2 == 0 })

//    Assignment reverst the number and display
   // Guess what we are adding an extension function to the range expression!! IntRange.
   println("Range with MyOwnalgo() ")
    (1..5).MyOwnAlgo()

     println(  (1..5).MyOwnAlgo() )
    // impliment lambda on it..
    println((1..5).MyOwnAlgo_2{
        println( it) } )


    for( x in (1..5).reversed() )  print( x )
    println("-*-".repeat(40))


    for( chars in 'a'..'g'){
        println(chars)
    }

    println("-*-".repeat(40))

    // Range expressions in detail..

    val range =  1..5
    println(range)  // 1..5
    println(" 3 is in range of 1 .. 5 ? ${ 3 in range}")  //  3 is in range of 1 .. 5 ? true

    val str = "Monday" .. "Sunday"
    println(str)

    println(" 3 is in range of 1 .. 5 ? ${ 3 in range}")

    val chars = 'a'..'f'
    val it = chars.iterator()      // design pattern
    while( it.hasNext()){
        val x = it.next()
        println("in Range ...a..f   $x")  // a b c d e f
    }

    println("-*-".repeat(40))

    var rangee : IntRange = 1.rangeTo(5)   // Extension functions
    println("Printing the value from range ")
    for( x in rangee){
        print("$x")   // 12345-
    }
    println("-*-".repeat(40))

    var range2 : IntRange = IntRange(1,5)
    println("Printing the value from range... ")
    for( x in range2){
        print("$x")   // 12345-
    }
    println("-*-".repeat(40))

    println("Reversed range..")
    var range1 = 1 .. 5
    for( x in range1.reversed()){
        print("$x")
    }
    println("-*-".repeat(40))

    val n = 9
    println(0..(n+1))  // 0..10

    (0..n).forEach{ print( it ) }  // 0 1 2 3 4 5 6 7 8 9

    val range3 : IntRange = 1 .. 10
    for( x in range3 step 2 )
        print(x)

    // think about iterator() hasNext next

    val first = (( range3 step 2).first)
    val last  = (( range3 step 2).last)

    println(" First value from the range : $first")

    println(" First value from the last : $last")
    // BUILDER DESIGN PATTERN goes here..
    (0..n).forEach{ print( it ) }  // 0 1 2 3 4 5 6 7 8 9
    (1..5).forEach(   ::println )   // Wait for the list to write such passing reffrences..
    (1..5).reversed().forEach { e -> print("$e") }// forEach { ..} lambda passed to reversed

    println("-*-".repeat(40))

    val r = ( 1..10)
    println(r.sum())   // 55
    println(r.average())   // 5.5
    println("-*-".repeat(40))


    ////////////////
}

//println((1..5).MyOwnAlgo_2{
//    println( it) } )

//// Assignment
private fun IntRange.MyOwnAlgo_2(function: (  Double ) -> Unit): Any? {
    // retrive the data from range and provide it to MyOwnAlgo_2 lambda
    this.forEach{
        println("Providing --> ")
        function( it.toDouble()  ) }

    return true
}

private fun IntRange.MyOwnAlgo(): Any? {
    println(" in My Own algo()  ${this.first} ")

// Time for us to create an ALGO..  Data Structures..

    // this is a rangeExpresssion
    // so it can be achived by using a for on a simple expression 1.. 10
    // Intrange

    // .forEach{ is an extended lambda expression!! YOU WILL LEARN THIS IN LAMBDA

    this.forEach{
        print( it ) }
    // explain this in lambda
    (1..10).forEach {

        println("  for each lambda ${it.plus( 10 )}")
    }
    println(" in My Own algo() reversed")

    // but if you treat this as a node of a Bin Tree.. We shall have PreOrder PostOrder InOrder traversal..
    // That will have th impending req of  this.iterator()
    // this.iterator()

    // Usecase
    //   mealPlan    1780 cal..  // price 450 RS..
    // Burger,     Rice,

    // Wings

    // .iterator() is an extended lambda expression!!
    var itr = this.iterator()
    while(itr.hasNext()){
        println(" MyOwnAlgo ${itr.next()}") // MyOwnAlgo 1 ... 1o
    }

    println(" In my own Algo() ${this.first}")


    for( x in this.reversed() )  print( "reversed algo $x" )

    println(" in My Own algo() reversed using lambda ")
    this.reversed().forEach { e -> print("$e") }
    println(" Done with it. Just about to return  a number... \n ")
    return 123;
}

fun feedTheFish() {

    repeat(10) { index ->
        println(" We are feeding the fish on the ${index+1}. Day")
        letsFeedFish()
    }


}

fun letsFeedFish() {

     val day = randomDay()
    // let the day be treated/Casted as a String..
     val food = fishFood( day  as String)   // in case of string day is just fine..
      println( "Today is $day and the food to feed $food")
}


fun fishFood( day: String) : String{
    return  when( day ){


      //  in  "Monday".."Saturday" -> "Flackes..."


        "Monday"    -> "Flakes..."
        "Tuesday"   -> "Red Worms..."
        "Wednesday" -> "Granules..."
        "Thursday"  -> "Mosquitoes..."
        "Friday"    -> " lettuce.."
        "Saturday"  -> " Caned food.."
         else        -> " Fasting..."


    }

}

fun randomDay(): Any {     // instead of : String
        val week = listOf(

            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        )

    return week[  Random.nextInt( 7 )]



}

fun do_While() {


    var i = 0
    do{
        println(i)
        i++
    }while( i < 5 )
}


fun whichReturns(): Int
{
    val x : Int = 100
    return x

}


fun if_condition() {

    var a   : Int = 10 ;
    var b   : Int = 20 ;

    var max : Int = 0 ;

    max = if( a > b ) a  else b

    println("Max = $max")

    max = if( a > b ){
        println(" A is greater")
         a
    } else {
        println(" B is greater")
        b
    }

    println(" Received a val from if condition $max")  //  Received a val from if condition 20

}


fun  if_When() {

    var animal: String = "Cat"

    if (animal == "Cat") {
        println("Found a Cat")
    } else if (animal == "Dog") {
        println("Found a Dog")
    } else if (animal == "Horse") {
        println("Found a Horse")
    } else {
        println("Hey That's not an animal....")   // Found a Cat
    }

    // Kotlin way of using the same

    // Clean code.. instead of switch( eliminated in kotlin)

    when (animal) {
        "Cat" -> println(" When : Found a Cat")
        "Dog" -> println(" When : Found a Dog")
        "Horse" -> println(" When : Found a Horse")
        else -> {
            println("Hey That's not an animal....")  //  When : Found a Cat
        }
    }

    val greeting = when (animal) {
        "Cat" -> "Hey Cat How are you?"
        "Dog" -> "Hey Bow Bow!"
        else -> "I don't know thatAnimal yet :("
    }
    println(greeting)

    var number: Int = 14
    when (number) {
        1 -> println(" number = 1 ")
        2 -> println(" number = 2 ")

        else -> {
            println("number is neither 1 nor 2 ")   // 2
        }
    }


    when( number){
        1,2 -> println("number == 1 or number == 2 ")
        else -> println("Otherwise..")  // number == 1 or number == 2

    }

    when(number){
        in 13..20 -> println(" Hey you are a teen..")
        !in 10..20 -> println(" out of range..")
        else -> println(" None of the above")  //  Hey you are a teen..
    }


   // var aaaInt: Int? =  aaa as? Int


    var variable: Any = 789 ;
    when( variable){
        is Int    -> println("It is an Int...")
        is String -> println("It is an Int...")
        is Double -> println("It is an Int...")

    }

    ///////////////////////
}

fun processMyDataPlease( data :Any ) = when( data ){

    1 -> "One"
    in 13..19 -> "A teen"
    is String -> "Hey that's a string of length ${data.length}"// smart casting sinnce u r under string
    else -> "no clue!.."
}


    fun vraiable_as_null() {

    // we are declaring a variable that can take a null too
    var myStr : String? = null
    println(myStr)  // null

    println("-*-".repeat(40))


   // CTRL + Shift + /   -->  /* */

    var a = "1"  // String
    var b = 5    // default its an Int

    var aInt : Int?  = a as? Int
    var bInt : Int?  = b as? Int    // casting

//
//    int i = 65   // e
//    char ch  = (char)i;   // casting i as a Char



    println(aInt)
    println(bInt)

    // Int? Means that  fishFoodTreats  can take null too as a paramater
     var fishFoodTreats : Int? =     100 //   null

    // Phase I  Not a good practice...

                //    // Java style or c++(Legacy)
        // if fishFoodTreats is null following line is not valid
        // fishFoodTreats?.dec() ?: 0 not valid

                    if( fishFoodTreats != null)
                    {
                        fishFoodTreats = fishFoodTreats - 1
                    } else {
                        // Hey it null
                    }

    // Phase II  Beautiful way of expressing a statement
       fishFoodTreats = fishFoodTreats?.dec() ?: 0
    println(fishFoodTreats)    // 99
//
//        fishFoodTreats?.let {
//            // it is me...
//            //  println("We may not get here!!!! Let will not allow us if fishFoodTreats is set to NULL")
//            println("Lets check on ${it-1}")  // Lets check on 99
//
//        }
/*

                    // Let will not allow us if fishFoodTreats is set to NULL
                   var fishFoodTreats2 : Int? =  100


                    // Phase III
                    // Let the Guard be on Jon
                    // fishFoodTreats? is not null, I want people fall through the Let {}
                    // fishFoodTreats? is null do not fall through Let{  }

                    //   fishFoodTreats2?  is a var for that has been extended by .let {

                    fishFoodTreats2?.let {
                        // it is me...
                      //  println("We may not get here!!!! Let will not allow us if fishFoodTreats is set to NULL")
                        println("Lets check on ${it-1}")  // Lets check on 99

                    }
*/

                   //  println(" Out of LET...")   //  Out of LET...


    println("-*-".repeat(40))

    val aa = "Kotlin"
    val bb : String? = "Sathya. " //null ;

    println("has to be 1 : ${bb?.length}")  // null  // ${bb!!.length}") // throws an exception
    println("has to be 2 : ${aa?.length}")  // 6


    // depricated way
    val  l = if( bb != null ) bb.length else -1 ;

    //  A better approach
    // replacement..
    bb?.let {  println("is bb null No it's len is  -> ${ it.length} }" )  }// nothing
    aa?.let {  println( " foo here ${it.length}") }  // 6




}
fun let() {
    val name: String? = "Sathya"

    name?.let {
        println("Length of name: ${it.length}")
        println("Uppercase name: ${it.toUpperCase()}")
    }

    val nullableValue: Int? = null

    nullableValue?.let {
        println("This won't be executed")
    }
}

fun array() {
//    val fruits = arrayOf<Any>(1,2,3,"Apple","Mango","Banana","Orange","Apple")
    val fruits = arrayOf<String>("Apple","Mango","Banana","Orange","Apple")
    // Any data type
    // <String> narrowed it down to one type
   // arrayOf(1,2,3,4,"Apple","Mango","Banana","Orange","Apple")

// now array dosen't have any data type

    println(fruits[ 0 ]) // Apple
    println(fruits[ 3 ])  // Orange

    println("-*-".repeat(40))

    println(fruits.get(0))  // Apple
    println(fruits.get(3))  // Orange

    println("-*-".repeat(40))

    fruits.set(3,"Guava")
    println(fruits.get(3))

    println(" Size of fruit array ${fruits.size}")  // 5

    println("-*-".repeat(40))

//
//    for(val i = 0 ; i < 10 ; i++ ){
//
//    }

    // expressive way of coding..

    for( item in fruits){
        println(item)
    }

    println("-*-".repeat(40))
            for(index in fruits.withIndex()){
                println(" $index ")
            }

    println("-*-".repeat(40))

    for((index,name ) in fruits.withIndex()){
        println(" $index--> $name ")
    }

    println("-*-".repeat(40))

    if( "Mango" in fruits){
        println("mango exists in fruits")
    } else {
        println("mango does not exists in fruits")
    }

    // distinct avoids display of duplicates

val distinct = fruits.distinct()
    for( item in distinct){
        println("  ->   ${item}")   // ->   Apple   displays all other names too
    }

    println("-*-".repeat(40))

    val fruitsEmpty = arrayOf<String>()
        println("array is empty : ${fruitsEmpty.isEmpty()}")  // true


}

fun diffrentKindOfStringVar() {



    val  escapedString : String = " I'm escaped string \n" + " yet another line \n  " + " Let me stop this nonsense..\n"

    var  multipleString : String = """
          ~ This is going to be a multiline string
          ~ My next line goes here
          ~ My last line
        
        
    """.trimIndent()


    var  multipleString2 : String = """
        ~ This is going to be a multiline string
        ~ My next line goes here
        ~ My last line
        
        
    """.trimMargin("~")
    println(escapedString)

    println("-*-".repeat(40))


    println(multipleString)
    println(multipleString2)


}

fun dataTypes() {

    val a : Int    = 123
    val d : Double = 100.00
    val f : Float  = 12.22f
    val l : Long   = 1000000
    val s : Short  = 10
    val b : Byte   = 1
    val c : Char  = 'A'
    val aBool : Boolean = true
    val bBool : Boolean = false

    println(" Int value is  $a")
    println(" Double value $d ")
    println(" Float value is  $f")
    println(" Long value $l ")
    println(" Short value is  $s")
    println(" Byte value $b ")
    println(" Charvalue $c ")
    println(" Boolean a value  $aBool ")
    println(" Boolean b value  $bBool ")


    val x : Int = 100 ;
    val y : Long =  x.toLong() // ok

    println(" Converted in to long $y ")  // 100

    // we are declaring a variable that can take a null too
    var myStr : String? = null

    //println( myStr!! )  // null / "main" java.lang.NullPointerException
  //  myStr   = "myStr Sathya"
   // println( myStr!! )  // null / "main" java.lang.NullPointerException
    // (!!) converts any value to a non-null type and throws an exception if the value is null
    println( myStr )  // prints null

    myStr   = "myStr Sathya.."
    println("  my str ${myStr}")  // null


    var name     : String     = "Sathya"
    var lastName : String     = "Pdmanabhan"

    println("Length of my name $name is ${name.length}   let me display a char at 3rd index ${name[3]}")
    println("Length of my name is ${name.count()}")
    println("my name in Uppercase  ${name.uppercase(Locale.getDefault())}")

    println(" Full name $name $lastName")
    println(" Full name ${name.plus(lastName)}")

    println(" Full name ${name.drop(3)} ")  // Satya
    println(" Full name ${name.dropLast(2)} ")  // Satya

    var str : String = "Meditation and Yoga are synonymous with Indians"
    println("Index of Yoga in the string  ${str.indexOf("Yoga")}")





}
fun createMemoFor(name: String): String { if (name == "Supreeth") {
    val memo = """Dear $name, a quick reminder about the
| party we have scheduled next Tuesday at
| the 'Low Ceremony Cafe' at Noon. | Please plan to..."""
   // return memo
    return memo.trimMargin()

}
    return "" }

    ////////


fun  expressive_in_is_as() {

    val value1 = 1
    val value2 = 10
//                val range :IntRange = 23..33
//                24 in range

//    var nullableShapeObject : Circle? = shapeObject as Circle?

    println("Frekey in  ${ 5 in value1 .. value2 }")  // true
    println("Frekey is  ${ "Sathya" is String }")           // true


// https://agrawalsuneet.github.io/blogs/typecheck-is-and-cast-as-in-kotlin/

    // as Int    : ( Int ) 234.444

    val any = 12 ;

    val i  :Int  =  any as Int
    // CTRL + Shift + /

    var a = "1"  // String
    var b = 5    // default its an Int

    var aInt : Int?  = a as? Int
    var bInt : Int?  = b as? Int    // casting
    println("Frekey i as Int   ${ i }")  // 12
    println("Frekey as  ${ a }")  // 1
    println("Frekey as  ${ b }")  // 5

//
//    int i = 65   // e
//    char ch  = (char)i;   // casting i as a Char
    println(aInt) // null
    println(bInt)   // 5


}

fun db(name : String ,age:Int ,sex:Char){

    println("Your data : ${name} Age $age Sex $sex")
}
fun strVariables() {
    // int i = 10 ;
    // val by default this has been tread as final
    // val age  = 21 ;


    val name: String = "Sathya"  // flow algo..
    val number: Double = 34.90
    var age: Int = 21    // mutable variable

    // println("Still works...My value : "+value)
    println("Hello $name you are   $age today")

    age = 22


    println("Hello $name you will be   $age next year ")

    println("-*-".repeat(40))

    // we are declaring a variable that can take a null too
    var myStr : String? = null
    println(myStr)  // null   println(myStr!!)   "main" java.lang.NullPointerException
   // at MainKt.strVariables(Main.kt:1683)
    myStr = "myStr Sathya"
    println("  my str ${myStr}")  // null



    // Drive  at 40km

//    drive.at(40);
}



























