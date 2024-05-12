package Class

/*
   Abstract functions

   1. different functionality
   2. Different use case

           Vehicle   : Ship Plane Car truck motorcycle
   1. decompose the problem CAR : fuel tank, engine AC seat tube ABC   gas
   2. break it into small elements
   3. find out the common functionalities
   3.a decide weather it's going to be an interface or an abstraction
   4. House : Color, Rooms , Height , size   Abstraction
   5. base class Building  Lets create abs  Color, Rooms , Height , size
   6   Sports house
   7   Hospital
   8   resturant


Sandeep : String ( Abstraction )   ***WRONG*****  String a BUilder..
var str : StringBuilder = "Sandeep"
     str.build("Is")
        .build("A")
        .build("Good boy");

        str.delete( index );
        str.insert( index ) ;

    What can be a string class???
    BUILDER DESIGNE ..

    Loop :   iterator   design   for(str in string) for( i in 1..10)   RANGE ... Progression ... iteration

    SRI Charan is RIGHT .... List  remove   ...pop   ABSTRACTIONS..

    STACK :  push(x) pop():Int isEmpty() size() Top()


 */




// List happens to be the parent to the stack
// abstract  class  Stack{  this will bridge the data to the list
//
//abstract  class  Stack{
//
//    abstract fun  push( data:Double )
//    abstract fun  pop( ):Double
//    abstract fun  isEmpty( ):Boolean
//    abstract fun  size(  ):Double
//}
//
//class UseStack : Stack{
//
//    // fill in the meat for the abstraction layer..
//
//}
//
//main()
//{
//    val stk = UseStack()
//    stk.push(12)
//    stk.push(20)
//}

abstract class _Vehicle(val name: String,
                        val color: String,
                        val weight: Double) {   // Concrete (Non Abstract) Properties

    // Abstract Property (Must be overridden by Subclasses)
    abstract var maxSpeed: Double

    // Abstract Methods (Must be implemented by Subclasses)
    abstract fun start()
    abstract fun stop()

    // Concrete (Non Abstract) Method
    fun displayDetails() {
        println("Name: $name, Color: $color, Weight: $weight, Max Speed: $maxSpeed")
    }
}


class _Car(name: String,
           color: String,
           weight: Double,
           override var maxSpeed: Double): _Vehicle(name, color, weight) {
    override fun start() {
        println("Car started..")
    }

    override fun stop() {
        println("Car stopped..")
    }


}


class Motorcycle(name: String,
                 color: String,
                 weight: Double,
                 override var maxSpeed: Double): _Vehicle(name, color, weight) {

    override fun start() {
        // Code to Start the Motorcycle
        println("Bike Started")
    }

    override fun stop() {
        // Code to Stop the Motorcycle
        println("Bike Stopped")
    }
}


fun main(args: Array<String>) {

    val car =        _Car("Ferrari 812 Superfast", "red", 1525.0, 339.60)
    val motorCycle = Motorcycle("Ducati 1098s", "red", 173.0, 271.0)

    car.displayDetails()
    motorCycle.displayDetails()

    car.start()
    motorCycle.start()

    val str = """
         | hello 
         | there
         | how are you
        
    """  //.trimIndent()  .trimMargin()
    println(str)
}
/*
Name: Ferrari 812 Superfast, Color: red, Weight: 1525.0, Max Speed: 339.6
Name: Ducati 1098s, Color: red, Weight: 173.0, Max Speed: 271.0
Car started..
Bike Started

         | hello
         | there
         | how are you

 */
