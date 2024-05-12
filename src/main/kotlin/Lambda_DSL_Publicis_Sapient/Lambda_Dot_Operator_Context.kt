package Lambda

//(a ) got created

// Think weather to create a inner class or a stand alone.
class Body{
}

class Tag{
}

class HTML {
    fun body() { println(" At HTML Body() 1 \n") }
    fun body2() { println(" At HTML Body() 2 \n") }
    fun Button_() {
        println(" Button clicked  Name : $name  : Age $age\n")
    }

    var name:String =  "Hello from HTML"
    var age :Int = 20 ;
//    //  composition
//       val body_ = Body(init: Body.( ) -> Unit)
//           val tag = Tag()
}

// HTML. Context this
fun html( init: HTML.( ) -> Unit) : HTML {

    val html = HTML()               // created HTML obj  ( a ) //(a ) got created

        html.init()                 // this.body2()
    //  html.{}

  //  this.body()

    return  html  // {  name, age  , Button_() }
}


fun main(){

    html {

        name = "Rushi"
        age  = 23
        Button_()


//
//        Header{
//            Font{
//                Type{
//                    Size = 90
//                }
//            }
//        }

//           Body {
//               Tag{
//
//
//               }
//
//
//           }

        // Tag
        // Body


    }.apply { println("apply -> Name $name Age $age") } // deeepak

}