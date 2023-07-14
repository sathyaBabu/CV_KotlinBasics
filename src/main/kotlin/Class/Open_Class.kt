package Class

open class Vehicle {
    open fun drive() {
        println("Driving the vehicle")
    }
}

 class Car_ : Vehicle() {
    override fun drive() {
        println("Driving the car 4 wheel ")
    }
}

// This will throw an error stating make a Car open!!
//class CarSUV_ : Car_() {
//    override fun drive() {
//        println("Driving the SUV + 2 wheel")
//    }
//}
class Motorcycle_ : Vehicle() {
    override fun drive() {
        println("Driving the motorcycle")
    }
}

fun main() {
    val vehicle1: Vehicle = Vehicle()
    vehicle1.drive() // Output: Driving the vehicle

    val vehicle2: Vehicle = Car_()
    vehicle2.drive() // Output: Driving the car

    val vehicle3: Vehicle = Motorcycle_()
    vehicle3.drive() // Output: Driving the motorcycle

//    val suv : Vehicle = CarSUV_()
//    suv.drive();
}
