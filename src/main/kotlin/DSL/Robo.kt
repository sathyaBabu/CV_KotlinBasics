package DSL

class Robot {


    val left  = "left"
    val right = "right"
    val fast  = "Fast"


        infix fun turns( direction:String) { println("Turns $direction") }
        infix fun runs( speed:String) { println("runs$speed") }



}

//  Robot.()   // this   Hey I donot want this to be genarated here.. PLEASE GIVE ME it
fun operate( block: Robot.( Robot ) -> Unit){

    // returning this

    val robot = Robot()    // students in it  : or other relevent info
 //   robot.block()  // this
    robot.block( robot )    // by passing the robot( this ) as a paramater to the block we can access robo in lambda as it
                           // this becomes the context object to run under..
                            // this in turn can be accessed as elements as it

}


fun main(){

//    //   operate { this  "second" { this  "third"{  }  }  }
//    operate {
//      "llll"  { this
//               "kjkjkj"   {
//                     "uyuyuyuy" {
//                    this
//                }
//                this
//            }
//        }
//    }

    operate {

        // it happens to the element of this..
        it turns left
        it turns right
        it runs   fast

    }
}

//private operator fun String.invoke(value: Any) {}

/*
package DSL

class Acticate
class Motor
class Coil


class Robot {


    val left  = "left"
    val right = "right"
    val fast  = "Fast"


        infix fun turns( direction:String) { println("Turns $direction") }
        infix fun runs( speed:String) { println("runs$speed") }



}

//  Robot.()   // this   Hey I donot want this to be genarated here.. PLEASE GIVE ME it
fun operate( block: Robot.( Robot ) -> Unit) {


    class Activate{

        // start = true
        // stop = false

        inner class Motor {



            fun operateMotor(block: Motor.() -> Unit) {

            }
            inner class CoilResponse {

                fun operateMotor(block: Coil.() -> Unit) {

                }
            }
    }




}
    // returning this

    val robot = Robot()    // students in it  : or other relevent info
 //   robot.block()  // this
    robot.block( robot )    // by passing the robot( this ) as a paramater to the block we can access robo in lambda as it
                           // this becomes the context object to run under..
                            // this in turn can be accessed as elements as it

}

fun main(){

    //   operate { this  "second" { this  "third"{  }  }  }
    operate {
      "llll"  { this
               "kjkjkj"   {
                     "uyuyuyuy" {
                    this
                }
                this
            }
        }
    }

    operate {

        // it happens to the element of this..
        it turns left
        it turns right
        it runs   fast

    }
}

private operator fun String.invoke(value: Any) {


}

 */