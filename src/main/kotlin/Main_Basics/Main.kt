package Main_Basics

import Utils.Const
import org.w3c.dom.ranges.RangeException
import java.time.LocalDate
import java.util.*
import kotlin.math.roundToInt
import kotlin.random.Random.Default.nextInt
import kotlin.random.Random

class Car{

        val wheel : Int = 4


        fun door() {}

    // add a fun
    // calls for a modification..

}
// Behaviour of car closed for modification
// open for extension -> repeat(30);

fun main() {

    println("Welcome to the world of  Kotlin")

    dataTypes()
    println("-*-". repeat(40) )
    diffrentKindOfStringVar()
    println("-*-". repeat(40) )
    nullwithQuestionMark()
    println("-*-". repeat(40) )
    array()
    println("-*-". repeat(40) )
    letsGoWithExtensionFunctions()

    println("-*-". repeat(40) )
    if_When()
    println("-*-". repeat(40) )
    sum1()
    println("-*-". repeat(40) )
      println(sum2( 12 ,23 ) )
    println("-*-". repeat(40) )
  println( SayHiToGuys("Rushik"))
    println( SayHiToGuys("Rushik","Mayank"))
    println("-*-". repeat(40) )
  // pair
    val( tool1, tool2) = giveMeaTool()
    println(" Fishing tool received.. : $tool1, $tool2")

    println("-*-". repeat(40) )
    println(featchPersonDetail())
    println("-*-". repeat(40) )
    letsGoWithExtensionFunctions()
    println("-*-". repeat(40) )
     letsCalculateSomething()
    println("-*-". repeat(40) )
         forIntProgression()
    println("-*-". repeat(40) )
      feedTheFish()

    println("-*-". repeat(40) )

     dateProgression()

    println("-*-". repeat(40) )

    dateProgressionToFeedMyFish()

    println("-*-". repeat(40) )

    MyRange()

    println("-*-". repeat(40) )

    MyRangeIterations()
    println("-*-". repeat(40) )

      listOf_1()

    println("-*-". repeat(40) )

      notAProxy()

    println("-*-". repeat(40) )
    println("-*-". repeat(40) )
    //reffer Utils package object Const is declared in it
    Const.value = 1234; // global
    println("Const... ${Const.value}")

}

// List<Int> is a const
val systemUsers : MutableList<Int> = mutableListOf(1,2,3,4,5,6)

// proxy can be achived using Lazy or the Proxy DP
val sudoUsers: List<Int> = systemUsers

fun addSystemUser( newUser:Int){
    // error
    //  sudoUsers.add(newUser)
    systemUsers.add(newUser)
}

fun getSystemSudoUsers() : List<Int> {
    return sudoUsers
}

fun notAProxy() {

    addSystemUser( 10 )
    println("Total number of users : ${getSystemSudoUsers()}")
    getSystemSudoUsers().forEach {
        systemUsers-> println("some info about the users $systemUsers")
    }
}

fun isODD( x : Int): Boolean{
    return ( x % 2 ) != 0
}

fun listOf_1() {

    val values = listOf(1,2,3,4,5)     // const
    values.forEach {
        data -> println( "print via data $data" )
    }

    values.forEach { println( "print via it $it" ) }

    values.forEach ( ::println ) // takes it by default

    println(isODD( 3) ) // true
    println(isODD( 12) ) // false

    // Phase II

    val nums : List<Int> = listOf(1,2,3,4,5,6,7,8,9)
    val list:List<Int> = nums.filter( ::isODD ) // declared on top
    println( list )

}

fun MyRangeIterations() {

    var chars = 'a' .. 'f'
    // to retrive the data BiDirectional, reverse , regular
    val it = chars.iterator()  // Design pattern
    // Iterator design pattern has two interface
    // hasNext  , it.next()   we will be implimenting

    while( it.hasNext() ){
        val x = it.next()
        println("in range .... a...f $x ")
    }

}

fun MyRange() {

      println( (1 .. 10).filter { it % 2 == 0 } )  // print evn

       println( (1 .. 10).MyOwnAlgo() )
    // Tomorrow..
       println( (1 .. 10).MyOwnAlgo_2{ 2 == 0 } )


}

//  To try it out.. Bring in your own proprties here..lambda expressions..
private fun IntRange.MyOwnAlgo_2(function: () -> Boolean): Any? {

    return  1;
}

private fun IntRange.MyOwnAlgo(): Any? {

    println("In my own Algo() ${this.first}")
    this.forEach {  it-> println(it) }    // works in a diffrent memory space Higher order expression
   // this.forEach {  println(it) }

    for( x in this.reversed())  // auto from lib
        println("Reversed Algo $x")

    println(" Done with reusing expressions in MyOwnAlgo..")
    // write your own Algo here
   return 123;
}

fun dateProgression() {

    val Jul_4th_23  = LocalDate.of(2023,7,4)
    val Jul_11th_23 = LocalDate.of(2023,7,11)

    if( LocalDate.now() in  Jul_4th_23  .. Jul_11th_23){
        println("Welcome to ${LocalDate.now()}")
    }

}


fun dateProgressionToFeedMyFish() {

    val Jul_4th_23  = LocalDate.of(2023,7,4)
    val Jul_11th_23 = LocalDate.of(2023,7,11)
    val start_day_month = Jul_4th_23.dayOfMonth
    val end_day_month   = Jul_11th_23.dayOfMonth
/*
     GOOGLE MAP : FIND CUBBON PARK
     GoogleMap.polyLine(CUBBON PARK)   GoogleMap.polyLine(MG ROAD)
     GoogleMap.currentLocation
     GoogleMap.Start(CUBBON PARK)  -  GoogleMap.End(MG ROAD)

     x,y ( 3 ) x -> y polylines  (house -> right -> 100 met -> left -> 1 km -> right) Map_A  - Map_B
     Graph DS to hold all th poly lines..

      for( find  in Maps_A .. MaPS_B){ -> prints the direction
 */
    for( presentDay in start_day_month .. end_day_month){

        var day_of_week = LocalDate.of(2023,7,presentDay).dayOfWeek
        var day_array   = listOf("MONDAY","TUESDAY","WEDNESDAY","THURSDAY","Friday".uppercase())

        println(" day of the week $day_of_week ")

        if( day_array.contains(day_of_week.toString()))
             println("Feed the fish on date : " +
                     "${LocalDate.of(2023,7,presentDay)} and day is ${day_of_week} ")

    }

    if( LocalDate.now() in  Jul_4th_23  .. Jul_11th_23){
        println("Welcome to ${LocalDate.now()}")
    }

}

fun feedTheFish() {

    // Lets feed the fish for a week or 10 days...
   // repeat() happens to be a lambda function since it takes the lambda expressions
    repeat( 10 ){
        index-> println("We are feeding the fish on the ${index+1} Day")
        letsFeedTheFish()
    }
}

fun letsFeedTheFish() {
    // lets feed the fish on random days
    val day = randomDay()
    val food = fishFood( day as String)
    println("Today is $day and the food to feed is $food")
}

fun fishFood(day: String): String {
    return  when( day ){
        "Monday"    -> "Flakes..."
        "Tuesday"   -> " Red Worms"
        "Wednesday"  -> "Granules"
        "Thursday"   -> "Greens Lettuce"
        "Friday"     -> "Caned food"
        else -> "Fasting...."
    }

}
// for( day in "Monday" .. "Friday")
//{
//    println($day)
//}


//  index can be used as rangeExpr...
// 1 .. 10
// "Aamer" .. "Vrushi"

fun randomDay(): Any {

    val week = listOf(
        "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"
    )
    return  week[  Random.nextInt(7 ) ]

}

fun forIntProgression() {

    for( i in 1 .. 10){   // range has IntProgression as an inhate char
        println(" range.. $i ")
    }


    for( i in 1.until(10)){   // Extension functions..
        println(" until( $i )")
    }



    for( i in 1 until 10){   // Extension functions..
        println("until.. $i ")
    }


    for( i in 1 until 10 step 3 ){   // Extension functions..
        println("until step 3  $i ")
    }

    println("-*-". repeat(40) )


    // towards, backwards, Node : Bintree inOrder preOrder PostOrder
    //                                       1       2        3

    for( i in 1 toWards 10){   // Extension functions..
        println(" --- ToWard $i ")
    }
/* Assignment

        for( i in row  display Allcolums ){   // Extension functions..
        println(" --- ToWard $i ")
    }

     for( i in BeginArray display EndArray ){   // Extension functions..
        println(" --- ToWard $i ")
    }


    /* BinTree
         inheritance of InOrder : PostOrdder : PreOrder
         Composition

 */


    // TYo get an Idea  Inturn shall display IOnOrder
     for( i in BinTreeParentNode  display InOrder ){   // Extension functions..
        println(" --- ToWard $i ")
    }

    // TYo get an Idea  Inturn shall display IOnOrder PostOrdr and PreOrder
     for( i in BinTreeParentNode  display EntireTree ){   // Extension functions..
        println(" --- ToWard $i ")
    }

 */
    println("-*-". repeat(40) )


    for( i in 10 toWards 1 ){   // Extension functions..
        println(" --- ToWard $i ")
    }

    println("-*-". repeat(40) )


    for( i in 1 toWards 10){   // Extension functions..
        println(" --- ToWard $i ")
    }

    println("-*-". repeat(40) )

}
infix fun Int.toWards(to:Int) : IntProgression{
    // Algo Bin tree
    // Data structure
    // Link list toward backward'
    // Graph -> google Maps..
    // arrayOf() -> double Dim array

   // Assignment
    // arry[ 10 ][ 5 ]
    // Row 1 : Col 12 34 65 34 12
    /*
        val first : Array<IntArray> = arrayOf()(
            intArrayOf(12,34,56),
            intArrayOf(23,4,78)
        )*/
    // Object Rushik  this ref to current obj( here current obj is Int.
   // val step = if( this > to ) -1 else 1   // progression by 1
    val step = if( this > to ) -2 else 2   // progression by 1

    println("Working on $this towards $to step $step")
    return  IntProgression.fromClosedRange(this,to,step)
    //                                                 1   10   1
    //                                                 01  10   2
}

fun letsCalculateSomething() {

    val x: Int = 10
    val y : Int = 20 ;

                  x . findTheGreaterValue ( y )

    val greater =  x  findTheGreaterValue  y

    infix fun Int.add( b:Int ) : Int = this + b

    val xa = 10.add( 20 )    // is this right or wrong
    println(" xa $xa")
    val xb= 10 add 20
    println(" xb $xb")
    val yaa = x add y
    println(" yaa $yaa")


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

fun letsGoWithExtensionFunctions() {
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

fun giveMeaTool(): Pair<String,String> {

    return Pair("FishNet", "Boat")
}


fun  featchPersonDetail(): Triple<String,Int,Char> {

    val name = "Meghna"
    val age = 22
    val gender = 'F'
    return Triple(name,age,gender)
}
fun SayHiToGuys(s: String, anotherGuy: String ="Zombi")  : String{

    return " Hi $s $anotherGuy"

}
// trialing return type
// java c++
//
//  auto mul(int i, int k) int {
//       return i * k
//   }

fun sum2(i: Int, i1: Int) : Int {

    val add = i + i1
    return  add

}

fun sum1() {
    val value1 = 6 ;
    val value2 = 5
    println(" Sum  = ${value1 + value2}")
}

fun if_When() {

    var animal: String = "Cat"

    if (animal == "Cat") {
        println("Found a Cat")
    } else if (animal == "Dog") {
        println("Found a Dog")
    } else if (animal == "Horse") {
        println("Found a Horse")
    } else {
        println("Hey Thats not an animal....")   // Found a Cat
    }

    // clean code

    when( animal){

        "Cat"    -> println(" When : Found a Cat")
        "Dog"    -> println(" When : Found a Dog")
        "Horse"  -> println(" When : Found a Horse")

        else ->
             println(" Hey that's noty an animal")

    }

    val greeting =  when( animal){

            "Cat"    -> println(" When : Found a Cat..")
            "Dog"    -> println(" When : Found a Dog")
            "Horse"  -> println(" When : Found a Horse")

            else ->
                println(" Hey that's noty an animal")

        }
    println(greeting)

    var number : Int = 23
    when( number){
        1 -> println(" number = 1 ")
        2 -> println(" number = 2 ")
        else -> {
            println(" number neither 1 or 2  ")
        }
    }

       when( number){
           1,2 -> println(" number = 1  or number = 2 ")
           else -> println(" Otherwise ")
       }


    when( number){
        in 13 .. 70 -> println(" Hey we found it.. ")
        in 13 .. 20  -> println(" Out of range.. ")
        else -> println(" Otherwise ")
    }

       var variable : Any = 789

    when( variable){

        is Int   -> println("It is an Int")
        is String -> println("It is an String")
        is Double -> println("It is an Double")
    }

       var a : Int = 10 ;
       var b : Int = 20 ;

       var res : Int = 0 ;

    res = if( a > b ) a else b    // ? 1 : 0

    res = if( a > b ){
        println(" A is greater  Now ")
        a
    }else {
        println("B is greater ")
        b   // return typr
    }
    println(" Received a val from if condition $res")



}
fun nullwithQuestionMark(){
    /*
    The !! operator is called the non-null assertion operator.
When you use !!, you're telling the compiler that you're sure that the value cannot be null at that point, and you want to access the value directly without a null check.
If the value is indeed null, a NullPointerException will be thrown at runtime.
It should be used with caution and only when you're absolutely sure that the value is not null, otherwise, it can lead to runtime exceptions.

     */

    // error : Main_Basics.MainKt.nullwithQuestionMark(Main.kt:587)
//            val str: String? = null
//            val length = str!!.length // This will throw NullPointerException if str is null
//            println("length $length")

    /*
    The ? operator is called the safe call operator.
When you use ?, you're telling the compiler to perform a null-check before accessing the property or calling the method.
If the object is null, the entire expression will evaluate to null, and no exception will be thrown.
It's a concise way to handle nullability without the risk of NullPointerExceptions.

     */
    val str3: String? = null
    val length3 = str3?.length // This will not throw an exception if str is null
    println("length $length3") // length null
    /*
    In summary, !! is used when you're absolutely certain that the value is not null,
    while ? is used for safe access when the value might be null, allowing you to handle
     nullability without risking exceptions. It's generally recommended to use the safe
      call operator (?) whenever dealing with nullable types, and only resort to the
      non-null assertion operator (!!) when you're certain that a value cannot be null.
*/

}
// DS Algo..
fun array() {


    // Void* i ; // this holds only the memory location but noy  the type c++

    val fruits = arrayOf<String>( "Apple","Mango","Banana","Orange","Apple")

    val fruitsOfMultiDataType = arrayOf<Any>( 1,2,3,"Apple","Mango","Banana","Orange","Apple")

    println(fruits[ 0 ])
    println(fruits[ 3 ])

    // Extension functions..  **** IMP *****
    //  can be created on any class....
    // When we have to add a fun to a class we need to chang the class...
    // BAd practice  SOLID ----> hey use O principle
    // Open for extension and closed for modification

    // we are extending a String...
    // remember  repeat(40) is not a part of the string..

    // I can add a charactics to a Button String Car objects.. Without modifying it..

    var str : String = "asdasadad";

    println("-*-". repeat(40) )
   // println(car.repeat(40) )

    println(" Size of fruit array ${fruits.size}")
    println("-*-". repeat(40) )
//
//    for( int i = 0 ; i<= 10 ; i++ ){
//
//    }


    for (item in fruits){
        println(item)

    }
    println("-*-". repeat(40) )
    for (index in fruits.withIndex()){
        println("$index")

    }

    println("-*-". repeat(40) )


    for ( (index,name ) in fruits.withIndex()) {
        println("$index --> $name")
    }
        println("-*-". repeat(40) )


   if("Mango" in fruits){
        println("Mango found in fruits")

    }else {
        println("Mango not found in fruits")
    }

    println("-*-". repeat(40) )


    expresssive_in_is_as()

    }////////// END /////

fun expresssive_in_is_as() {

  //  if( "Mango" in fruits)

     val value1 = 1
    val  value2 = 20
    //var : RangeException = 34 .. 56

        // .. range expression
    println(" in ${5 in value1..value2}")
    println(" Str check : is ${"Sathya " is String}")

    val any  = 65 ;   // 65 or Asciii

//    65.toChar();

   // var aChar : Char = any as Char

   // var  number :Int = null

    var  number :Int? = null

    var fishFood = 10

    if( fishFood != null){
        fishFood = fishFood.dec()  // 9
    }
    fishFood = fishFood?.dec() // 8

    println(" Fish as of now $fishFood") // 8

var fishFood2:Int? = null
    fishFood = fishFood2?.dec() ?: 0

    println(" Fish as of now $fishFood")
    // let?   run apply with




    // let expression
//
//    var myStr : String? = null
//    println(myStr)

    //  class java.lang.Double cannot be cast to class java.lang.Character (java.lang.Double and java.lang.Character are in module java.base of loader 'bootstrap')
    //	at Main_Basics.MainKt.expresssive_in_is_as(Main.kt:121)

    // to over come the ull error we have to inpliment let on a null var   // let expression


}


fun diffrentKindOfStringVar() {

    var multipleString : String = """ 
        ~ This is going to be a multi line string'
        ~ My next line goes here
        ~ My last Line
        
        
   
    """.trimIndent()
//    """.trimMargin("~") // shift this up
    println(multipleString)
}

fun dataTypes() {

    val num = 100

    var    a : Int  = 10 ;  // const  mutable
    val v :Long =   a.toLong()
    val d : Double = 123.23
    val f : Float = 12.22f
    val l : Long = 100000
    val s : Short = 1
    val b : Byte = 1
    val c : Char = 'a'

    val aBool : Boolean = true ;
    val bBool : Boolean = false;


   // a = (Int) 23   // out dated..

    println(" Int value is "+a) // outdated... Java style

    println(" Int value is $a ")
    println(" Int Double is $d ")
    println(" Int Float  is $f")
    println(" Int Long is $l ")
    println(" Int char  is $c ")

    // null !!!!!

    var name     : String = "Sathya"
    var lastName : String = "Padmanabhan"

    println("Length of my name $name is ${name.length}")
    println("Index of my name $name is ${name[3]}")
    println("Length of my name $name is ${name.count()}")

    println(" my name  in upper case  ${name.uppercase( Locale.getDefault())}")
    var str : String = " Meditation and Yoga are synonymous with Indians.."
    println("Index of yoga in String  ${str.indexOf("Yoga")}")




}


