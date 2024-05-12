package dependencyCar

class Engine4{
    fun start(){
        println("Engine started")
    }
}
object ServiceLocator {
    fun getEngine(): Engine4 = Engine4()
}

class Car4 {
    private val engine = ServiceLocator.getEngine()

    fun start() {
        engine.start()
        println("Car started rolling..")
    }
}

fun main() {
    val car = Car4()
    car.start()
}