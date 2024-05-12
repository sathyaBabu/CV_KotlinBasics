package DesignPatterns
/*

   Abstraction -> this will decompose the car into various components..

   Encaptulations  creating a class with ID Data( State)  member( beh..)

   Polymorphism

   Inheritance would lead to a disauster since we are tightly coupling our code!!!!!

   Composition is better compared to inheritance..


   Higher order function
   Functional composition

   Interface -> Composition...
   Sruti : Sound behiv..



   Composition  Has -A             -          Aggregation Is - A
   car has-a engine                            player -> Ground
   dependency injections..



   class Stack{

   var:Int[10] = {0,0,0,0,0,0,0,,,,,,,};
   var tos : Int = 0 ;

   push( var x :Int){}
   pop() : Int {}

   }
   class BugFix : Stack() {

   push( var x:Int){
     if( tos >= 10 )
     {
        println("Stack over flow ");
     }
     super::Push( x ) {}

   }


   }

   class someThingMoreStack : BugFix() {

   }




     Class

      ID


      State variables
      data



      Behaviour
      Member var










 */


// Lets create a composition

class Engine{

    fun start() {
       println("Started the Engine...")

    }
}

class Car(i: Int) {

    lateinit var engine: Engine   // by lazy

    fun start(){

        engine.start()
    }

}

fun main(){

    val car = Car(70000)
    car.engine = Engine()

    car.start()

}