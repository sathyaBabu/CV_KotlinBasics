package dependencyCar

// basics of dependency injection starts here

class Engine3{
    fun start(){
        println("Engine started")
    }
}
class Car3 {

    lateinit var engine: Engine3

    fun start() {
        engine.start()
        println("Car started rolling..")
    }
}

fun main() {
    val car = Car3()
    car.engine = Engine3()
    car.start()
}