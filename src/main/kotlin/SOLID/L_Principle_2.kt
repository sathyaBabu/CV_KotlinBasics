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

This principle is very closely related to Open Closed Principle(OCP), violation of LSP in turn violates the OCP.
Also in line with dependency inversion principle

 */
// Air Land Sea , Rocky...

interface  Flying { fun fly() }

class FlyBehaviour : Flying {
    override fun fly() {
        println("I can fly")
    }

}

class NoFlyBehaviour : Flying {
    override fun fly() {
        println("I can't fly")
    }

}

//// intermediate level;

abstract  class Duck : Flying   // not representing super or sub

class BabyDuck   : Duck(), Flying by FlyBehaviour()
class DonaldDuck : Duck(), Flying by NoFlyBehaviour()
class RubberDuck : Duck(), Flying by NoFlyBehaviour()


fun main(){

    val donald = DonaldDuck()  // I can't fly
    donald.fly()
    val babyDuck = BabyDuck()  // I can fly
    babyDuck.fly()
}

