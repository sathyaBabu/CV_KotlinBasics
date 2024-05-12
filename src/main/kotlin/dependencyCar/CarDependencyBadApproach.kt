package dependencyCar
// https://developer.android.com/training/dependency-injection#kotlin
class Engine{
    fun start(){
        println("Engine started")
    }
}
class Car {

    // it's a container class..
    private val engine = Engine()

    fun start() {
        engine.start()
        println("Car started rolling..")
    }
}

fun main() {
    val car = Car()
    car.start()
}