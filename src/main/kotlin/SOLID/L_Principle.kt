package SOLID
/*

   Car    base class
         ^
         |
       Method
         |
         v
   Wheel  Sub class

 * Liskov Substitution principle (LSP) states that,

Methods that use references to the base classes must be able to use the objects
 of the derived classes without knowing it

This principle was written by Barbara Liskov in 1988.

The idea here is that the subtypes must be replaceable for the super type references without
affecting the program execution.

This principle is very closely related to Open Closed Principle(OCP),
violation of LSP in turn violates the OCP.
Also in line with dependency inversion principle

 */

open class Bird{
    open fun eat(){}
    open  fun fly(){
        println("Birds can fly...")
    }
}

/////   Intermediat layer...

open class FlightBird : Bird()

open class NonFlightBird : Bird() {
    override fun fly() {
        //super.fly()
        println("Oops I can't fly...")
    }
}




///////////////////////



open  class Crow : FlightBird() {
    override fun fly() {
       // super.fly()
        println("Crow. can fly...")
    }
}



open  class Ostrich : NonFlightBird() {
    override fun fly() =  println("Ostrich. can't fly...")

}



fun main(){

    val birdsList: MutableList<Bird> = ArrayList()

      birdsList.add(Bird())
      birdsList.add(Crow())
    birdsList.add(Ostrich())

    letTheBirdsFly( birdsList )

}

fun letTheBirdsFly(birdsList: MutableList<Bird>) {

       for( b in birdsList){
           b.fly()
       }
}
