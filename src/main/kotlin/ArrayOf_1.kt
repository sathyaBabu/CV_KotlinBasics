import DSL.Meeting
import java.util.*

fun main(){


    println("*".repeat(50))

    val nums = intArrayOf(1,2,3,4,5)
    val avg = nums.average()
    println("The average is : $avg")

    val noOfValues =  nums.count();
    println("There are $noOfValues  elements present")

    val sum = nums.sum()
    println("Sum  $sum  ")

    var myArray1 = arrayOf(1,10,4,6,15)
    var myArray2 = arrayOf<Int>(1,10,4,6,15)
    var myArray3 = arrayOf<String>("Tom","Hen","Cat","Rat","Mat")
    var myArray4 = arrayOf(1,10,"Sathya","Sanath","some name")
    /*
    booleanArrayOf()
    longArrayOf()
    shortArrayOf()
    byteArrayOf()
    intArrayOf()
    charArrayOf()*/

    var myArray5 : IntArray = intArrayOf(5,10,15,20,25,30)
    var myArray6 : CharArray = charArrayOf('a','c','d')
    var myArray7:  BooleanArray = booleanArrayOf(false,false)

    var MyArray = Array<Int>( 5 ){ 0 }

    /////


    val asc = Array(5, { i -> (i * i).toString() })
    for(s in asc){
        println(s);
    }

    ///////


    val MyCars = arrayOf("Merc","Ford","MBW","tata")
    println(MyCars[ 0 ])
    MyCars[0] = "Creta"

    MyCars.set(1,"Funny Car")

    for( x in MyCars){
        println(x)
    }

    println("*".repeat(50))

    for( x in myArray5){
        println(x)
    }
     println("Size of My cars array : ${MyCars.size}")   // 4
    println("*".repeat(50))

    if( 2 in myArray5){
        println("It exists!")
    }
    else {
        println("It  Dosentexists!")
    }

    println("*".repeat(50))

    for(( index,value ) in myArray5.withIndex()){
        println("The element at $index is $value")
    }
    println("*".repeat(50))

    val myValues = arrayOf(1,2,3,4,5,6,7)
    myValues.forEach { it -> print(" $it") }
    myValues.forEachIndexed { index, element  -> println(" myValues[ $index ] = $element")  }

    println("*".repeat(50))

    val itr: Iterator<Int> = myArray5.iterator()

    while ( itr.hasNext()){
        val element = itr.next()
        println("$element")

    }

    println("*".repeat(50))

    // BUbble Soert to sort the given array.. in Kotlin..

    val array = arrayOf(7,3,3,4,5,9,1)
    val sortedArray = array.sortedArray()
    println(Arrays.toString(sortedArray))
    val sortedArrayDESC = array.sortedArrayDescending()
    println(Arrays.toString(sortedArrayDESC))
    println("*".repeat(50))



    val _array = arrayOf(intArrayOf(1,2),
        intArrayOf(3,4),
        intArrayOf(5,6,7) )

    println(Arrays.deepToString(_array))


    println("*".repeat(50))

    for( row in _array){
        println(row.contentToString())
        println("${row.get(1)}")
        println("${row[ 1 ]}")
    }
    println("*".repeat(50))

    val rows = 3
    val cols = 4
    var var_i = 0

    val iarr = Array( rows ){ IntArray( cols )}
    for( row in iarr){
        println(row.contentToString())
    }
    println("*".repeat(50))
    val iarr2 = Array( rows ){ IntArray( cols ) { var_i++} }
    for( row in iarr2){
        println(row.contentToString())
    }

    println("*".repeat(50))
    val iarr3 = Array( rows ){ r -> val intArray = IntArray(cols){ c -> r + c }
    intArray
    }
    for( row in iarr3){
        println(row.contentToString())
    }
    println("*".repeat(50))
    ( 1..10).forEach {
        println(it)
    }

}

/*
    1. Write an App for Bubble sort     //  10  nested for
    2. Sequential search in a string array  { "Rat", "Cat","Dog","Elephant","Horse" } //  single for   5 min
       print at which index did you find the element
    3


    // 15 min  ALGO   - 10 min for coding
    // Before coding please write psudocode for this app
    // Create an ALGO and a code for this app
    4. If we increase the size of the double dim array  8 x 8 the same Algo should work

    01   05  03  00
    10   02  06  04
    14   13  09  07
    11   05  08  12


    Dont's
    //1 Avoid using For : How should I know which house is 00
    // Avoid using for  : loop to search which house is empty  - Dont
    // Avoid for loops  : - is the house sorted    - Dont

    Do's
      Android Image...
      Imagine we are dragging numbers on to the space( Hole)
      Imagine User can press arrow keys to move the number
      Imagine How that will be If computer has to play





    // Cross word puzzle      Take Home Assignment...  50x50  nip

 */