package Class


// abstraction vs interface...


abstract class _Vehicle( val  name : String ,
                         val color : String ,
                         val weight : Double ){

    abstract  var maxSpeed : Double

    //Abs Methods

    // State machine...

    // Assignment create a function on to of abstract fun's
  final  fun DriveMyCar(){
        // Note we are calling functions here not declaring!!!
          fillGas()
          start()
          drive()
          stop()
  }
        abstract  fun start()
        abstract  fun drive()
        abstract  fun stop()

        fun fillGas() { println(" Fill 40 lTr Gas")

        }


    fun displayDetails() {
        println(" Name : $name , Color : $color , Weight $weight , Max speed $maxSpeed")
    }
}

class _Car(
       name : String,
       color : String ,
       weight : Double,
       override var maxSpeed : Double ) : _Vehicle( name, color, weight){

                        override fun drive() {
                            println("Car stopped")

                        }

                        override fun stop() {
                            println("Car stopped")

                        }


                        override fun start() {
                            println("Car started...")
                        }


       }








fun main(){


    val car = _Car( "Ferrari 812 Super fast car ","Red",1765.0, 399.99)
    car.displayDetails()
    car.DriveMyCar()
}

/*
Name : Ferrari 812 Super fast car  , Color : Red , Weight 1765.0 , Max speed 399.99
 Fill 40 lTr Gas
Car started...
Car stopped
Car stopped

 */