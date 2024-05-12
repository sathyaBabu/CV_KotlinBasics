package Lambda

// sathyahelp123@gmail.com


// data type
class _HTML {
    fun body() {
        println("in HTML  body")
    }
    var  age : Int = 32
    var name :String? = null

    fun calculate( x :Int, y : Int , operation : (Int,Int) -> Int) : Int {
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


fun _sum(x : Int, y:Int ) = x + y


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

        .calculate(12,3,  ::_sum   )
//        ._html { ::_Sum  }
//        ._html { :: Mul }
//        ._html { :: Div}
//        .forEach_ { :: DisplayData }




    //////////////  Phase III implement the following
    // create a class of your own myListOf.. pass Person object and create a lambda over it
    // to mimic the following code

    // calc
    data class Person(val name: String, val age: Int)

    //           MyClassCalc
    val people = listOf(

        Person("Aamer", 24),
        Person("Sathya", 49),
        Person("Swapnil", 22),
        Person("Astha", 22),
        Person("Jyothi", 22),
        Person("Rushik", 28)
    )

    val selectedPerson = people
        .filter { it.name.startsWith("S") }    // .calculate{   ::Sum  }    url("Http://www.google.com/ssdsd")
        .maxOf { it.age }                             // .Display {   it/this  }    retrofit(  sdsdsd   )

    // .Days("5")                                 // .myForEach{     }        UI( DisplayOn Ui )
    // .forEach  {    println( $it  )  }




    println("Here you go.. $selectedPerson")
}
