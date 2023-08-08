//
//enum class FlightStatus {
//    ONTIME,DELAYED
//}
//
//interface IFlightStatus {
//    fun FlightDelayed()
//    fun FlightOnTime()
//}
//
//open class JetAir {
//    // flag = true or false enum
//    // onFlight delayed call notify() to notify the registered users about filigt dalay or on time
//
//    var status : Int = 0
//    var iFlightStatus: IFlightStatus? = null
////
////                        if( !status){
////
////                            notify( FlightStatus.DELAYED)
////                        }
//    // JetAir : this...
//    val reg   = mutableListOf<  IFlightStatus >()
//    fun Register(iRegClient: IFlightStatus?, refCount :Int ) {
//
////        reg.add(refCount, iRegClient!!)
////        reg.get(0).FlightDelayed()
//
//
//        reg.add( iRegClient!! )
//        for( i in reg){
//            i.FlightDelayed()
//        }
////        reg.get(0).FlightDelayed()
////        reg.get(1).FlightDelayed()
//
//
//        // Phase I
//       // iFlightStatus = iRegClient
//        // NOW JetAir has your address..
//        //@@@@@@@@@@@@@@@@@@@@
//
//        // on some condition lets call FlightDelayed()..
//       // iFlightStatus!!.FlightDelayed()
//    }
//    fun setState( status:Int )  {
//       // notify( status )
//    }
//   /* fun  notify( status:Int ) {
//          if( status == 1 ){
//             // println("FlightStatus : Ontime ")
//              val size = reg.size
//              for( x in 1 until size ){
//                  reg.get( x ).FlightOnTime()
////                  println("FlightStatus : Ontime ")
//              }
//            //  reg.forEach { println("Printing form forEach ${it.FlightOnTime()}") }
//
//          }else{
////              println("FlightStatus : Delayed ")
////              reg.forEach { println("Printing form forEach ${it.FlightDelayed()}") }
//              val size = reg.size
//              for( x in 1 until size ){
//                  reg.get( x ).FlightDelayed()
////                  println("FlightStatus : Ontime ")
//              }
//          }*/
//
//    }
//
//    //@@@@@@@@@@@@@@@@@@@@
//
////                    fun notify(flightStstua :FlightStatus){
////
////                        var  flightStstua = FlightStatus.DELAYED
////
////                        when (flightStstua) {
////                            FlightStatus.DELAYED -> reg.get( 0).FlightDelayed()
////                            FlightStatus.ONTIME -> reg.get( 0).FlightOnTime()
////
////                        }
////                    }
////}
//
//class You1  constructor() : JetAir(), IFlightStatus {
//    // this pointer holds the address of the object..
//    var refCount: Int = 0
//
//    init {
//        Register(this, refCount )
//        refCount++
//    }
//
//    // we have to reg with JetAir object by passing our this.
//    // Lets call this as Events which will be called by its originator.
//    override fun FlightDelayed() {
//        // TODO Auto-generated method stub
//        println("\n Flight Delayed in You 1 ...")
//    }
//
//    override fun FlightOnTime() {
//        // TODO Auto-generated method stub
//        println("\n Flight is on time You 1 ")
//    } // we need to reg ourselves with JetAirways...
//}
//
//
//class You2  constructor() : JetAir(), IFlightStatus {
//    // this pointer holds the address of the object..
//    var refCount: Int = 0
//
//    init {
//        Register(this, refCount )
//        refCount++
//    }
//
//    // we have to reg with JetAir object by passing our this.
//    // Lets call this as Events which will be called by its originator.
//    override fun FlightDelayed() {
//        // TODO Auto-generated method stub
//        println("\n Flight Delayed in You 2 ...")
//    }
//
//    override fun FlightOnTime() {
//        // TODO Auto-generated method stub
//        println("\n Flight is on time You 2 ")
//    } // we need to reg ourselves with JetAirways...
//}
//
//
//fun main(){
//
//    val jetAir = JetAir()
//    jetAir.setState( 1 )
//    val you1 = You1()
//    val you2 = You2()
//}
/*

In Kotlin, the open keyword is used to explicitly declare a class, method,
or property as open, which means it can be inherited or overridden by other
 classes. By default, classes and their members are final in Kotlin,
 meaning they cannot be subclassed or overridden. However,
  when you mark a class as open, it allows other classes to inherit from it.



 */
interface IFlightStatus {
    fun flightOnTime()
    fun flightDelayed()
}

open class JetAir_ {
    val user = mutableListOf<IFlightStatus>()

    fun register(iFlightUser: IFlightStatus) {
        user.add(iFlightUser)
    }

    fun getRegUserCount(): Int {
        return user.size
    }

    fun setState(state: Int) {
        notify(state)
    }

    fun notify(state: Int) {
        if (state != 0) {
            for (currentUser in user) {
                currentUser.flightOnTime()
            }
        } else {
            for (i in user.indices) {
                user[i].flightDelayed()
            }
        }
    }
}

class Jatin : JetAir_(), IFlightStatus {
    init {
        println("Jatin Object is created...")
       // register(this)
    }

    override fun flightOnTime() {
        println("Jatin Flight is on time")
    }

    override fun flightDelayed() {
        println("Jatin Flight is Delayed")
    }
}

class Ritika : JetAir_(), IFlightStatus {
    init {
        println("Ritika Object is created...")
    }

    override fun flightOnTime() {
        println("Ritika Flight is on time")
    }

    override fun flightDelayed() {
        println("Ritika Flight is Delayed")
    }
}

class Narandera : JetAir_(), IFlightStatus {
    init {
        println("Narandera Object is created...")
    }

    override fun flightOnTime() {
        println("Narandera Flight is on time")
    }

    override fun flightDelayed() {
        println("Narandera Flight is Delayed")
    }
}

fun main() {
    println("Observer... JetAir notifying the reg user..")

    val jetAir = JetAir_()
    val jatin = Jatin()
    val ritika = Ritika()
    val narandera = Narandera()

    val regUsers = listOf<IFlightStatus>(jatin, ritika, narandera)

    for (cUser in regUsers) {
        jetAir.register(cUser)
    }

    jetAir.setState(1) // This state is set by the pilot saying he is on time

    println("Number of reg users: ${jetAir.getRegUserCount()}")
}
