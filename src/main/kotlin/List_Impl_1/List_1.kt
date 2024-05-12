package List_Impl_1
data class User( val id : Int, val name : String )
data class PaidUSer( val id : Int, val name : String, val type:String )


fun main(){

    // ALgo - iterator , builder.
    val nums : List<Int> = listOf( 1,2,3,4,5)

    val list1 : List<Int> = nums.filter(  { it % 2 != 0 }   )  // [1, 3, 5]
    println(list1)

    val list2 : List<Int> = nums.filter { myVar:Int -> myVar % 2 != 0 }    // [1, 3, 5]
    println(list2)

    val list3 : List<Int> = nums.map { it * it  }    // [1, 3, 5]
    println(list3)

    fun isGT( n:Int) = n > 3
    fun isEven(n:Int) = n % 2 == 0
    fun double(n:Int) = n * 2

    val numberWithConditions = listOf(1,2,3,4,5,6,7,8,9,10)

    // Builder design patterns

    println(  numberWithConditions
                               //.filter( ::isGT)
                               .filter( :: isEven )
                               .map( ::double)
                               //.first()
                                .takeLastWhile { it > 15 } // [16, 20]
    )

    // strategy..
//
//    StartWork
//        .TurnOnNetwork("http://werwer.werwer.com")
//        . Download( Titanic.mp3)
//        .useLib( retrfit() )
//        .store( xyz.class)
//
//            . Display( UI )

     // Hey this looks li builder..

        //  AsyncTask<String,String,String>


    val fruits = listOf("Bananna","Grape","Avocado","Apple","Kiwi fruit",)
    fruits.filter {  it.startsWith("A") or it.startsWith("a") }

        .sortedBy { it }

        .map { it.uppercase() }
        .forEach { println( it) }

}
/*
1, 3, 5]
[1, 3, 5]
[1, 4, 9, 16, 25]
[16, 20]
APPLE
AVOCADO

 */