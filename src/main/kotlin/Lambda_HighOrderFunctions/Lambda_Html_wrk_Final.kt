package Lambda_HighOrderFunctions



//import sum1

// sathyahelp123@gmail.com
// data type
class _HTML {
    fun body() {
        println("in HTML  body")
    }
    var  age : Int = 32
    var name :String? = null

    fun calculate1( x :Int, y : Int , operation : (Int,Int) -> Int) : Int {
        //        an...{ a,b }
        //       ::Sum   ( x , y )
        return  operation( x , y )  // { a,b   -> (12 + 3)  }
    }



    //              this
    fun _html( function : _HTML. () -> Unit ) : _HTML {
        val html = _HTML()
        html.function()   //
        // this.function()  // this.body
        return  html
    }

    fun _add( function : ( Int, Int ) -> Unit){

    }

}
//
//fun calculate1( x :Int, y : Int , operation : (Int,Int) -> Int) : Int {
//    //        an...{ a,b }
//    //       ::Sum   ( x , y )
//    return  operation( x , y )  // { a,b   -> (12 + 3)  }
//}


// higher order function can be some function
fun sum(x:Int, y:Int) = x + y

fun operation1() : ( Int ) -> Int { return ::square }
fun square1(x : Int)  = x * x
fun div(x: Int, y: Int) = x/y

//fun _sum(x : Int, y:Int ) = x + y


fun main()
{
//    _html{
//        body()
//        name = "Sathya"
//        age  = 39
//    }
    var html = _HTML()

    html
        ._html {
            name = "satish"
            age = 23
            body()
        }
        //   val sumResult2 =
        .calculate1(12,3,  ::sum   )


    data class nums( val age1: Int, val age2: Int)
    //           MyClassCalc
    val people = listOf(

        nums(43,54),
        nums(34,33),
        nums(32,22),
        nums(78,34),
        nums(23,12),
        nums(71,34),


        )

    // where is html????
    var selectedPerson = people
//        .filter { it.name.startsWith("S") }    // .calculate{   ::Sum  }    url("Http://www.google.com/ssdsd")
        .maxOf { it.age1 } // .Display {   it/this  }    retrofit(  sdsdsd   )


//          Check on the following line
//        .calculate1(people[2].age1,people[2].age2 ::sum)
//        .calculate1(people[4] .age1,people[4].age2 ::div)
//



    // .Days("5")                                 // .myForEach{     }        UI( DisplayOn Ui )
    // .forEach  {    println( $it  )  }
    println("Here you go.. $selectedPerson")
   println(" Sum via HTML = ${ html._html { calculate1(10,20,::Sum) }}")
}