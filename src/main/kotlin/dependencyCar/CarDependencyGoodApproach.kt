package dependencyCar

class Engine2{
    fun start(){
        println("Engine started")
    }
}
class Car2(private val engine: Engine2) {

    fun start() {
        engine.start()
        println("Car started rolling..")
    }
}

fun main() {
    val engine = Engine2()
    val car = Car2(engine)
    car.start()
}