package Class

abstract class Person(val name: String) {
    abstract fun greet()
}

interface FoodConsumer {
    fun eat()
    fun pay(amount: Int) = println("Delicious! Here's $amount bucks!")
}

class RestaurantCustomer(name: String, val dish: String) : Person(name), FoodConsumer {
    fun order() = println("$dish, please!")
    override fun eat() = println("*Eats $dish*")
    override fun greet() = println("Hi , $name.")
}

fun main() {
    val sathya = RestaurantCustomer("Sathya ", "Mixed salad")

    sathya.greet() // An implementation of an abstract function Hi , Sathya .
    sathya.order() // A member function Mixed salad, please!
    sathya.eat() // An implementation of an interface function *Eats Mixed salad*
    sathya.pay(10) // A default implementation in an interface Delicious! Here's 10 bucks!
}