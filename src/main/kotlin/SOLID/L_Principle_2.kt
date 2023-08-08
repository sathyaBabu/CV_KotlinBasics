package SOLID

interface  Flying { fun fly() }

class  FlyBehaviour : Flying{
    override fun fly() {
        println("I can fly")
    }
}


class  NonFlyBehaviour : Flying{
    override fun fly() {
        println("I can't fly")
    }
}

abstract  class  Duck_ : Flying

class BabyDuck    : Duck_(),  Flying  by FlyBehaviour()
class DonaldDuck  : Duck_() , Flying  by NonFlyBehaviour()
class RubberdDuck : Duck_() , Flying  by NonFlyBehaviour()

fun main(){

    val donald = DonaldDuck()
    donald.fly()
    val babyDuck = BabyDuck()
    babyDuck.fly()
}