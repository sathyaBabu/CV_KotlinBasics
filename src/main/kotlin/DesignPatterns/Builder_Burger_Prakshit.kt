package ParticipantsCode

// reffer to the folder Participants
// Project_Srinivas_2 -> Prakshit
/*

class Burger_ private constructor(
    ingredients :    List< Ingredient >     // we are taking an advantage out of the bas class...
) {
    init {
        val iterator = ingredients.iterator()
        var calories :Int = 0
        var cost : Double = 0.0
        var weight : Double = 0.0


        // You are breaking the SingleObject here.....
        // Lets come to this by end of the day..
        // after we understand the Iterator..

        // Iterator should not know about the internal elements of the class..
        // hasNext() next()..

        //  ?????? let this be here as of now...

        while (iterator.hasNext()){
            val ingredient: Ingredient = iterator.next()

            println("Adding $ingredient  ")
            println( "calories ${ingredient.calory} j"  )
            println( "cost ${ingredient.calory} rupees"  )
            println( "weight ${ingredient.weight}  gram"  )

            calories += ingredient.calory
            cost += ingredient.cost
            weight += ingredient.weight
        }
        println("Burger Prepared ")
        println("Total calories $calories j ")
        println("Total cost $cost Rupees")
        println("Total weight $weight grams ")
    }
    class BurgerBuilder(

        private var bun:      Ingredient? = null,
        private var lettuce: Ingredient?=null,
        private var chicken: Ingredient?=null,
        private var cheese: Ingredient?=null,
        private var cucumber: Ingredient?=null ,
        private var tomato: Ingredient?=null) {

        fun addBun(bread: ()-> Bun) = apply { bun = bread() ; println("added ${this.bun}") }
        fun addLettuce(vegetable: ()-> Lettuce) = apply { lettuce = vegetable() ; println("added ${this.lettuce}") }
        fun addChicken(meat: ()-> Chicken) = apply { chicken = meat() ; println("added ${this.chicken}") }
        fun addCheese(milkEgg: ()-> Cheese) = apply { cheese = milkEgg() ; println("added ${this.cheese}") }
        fun addCucumber(vegetable: ()-> Cucumber) = apply { cucumber = vegetable() ; println("added ${this.cucumber}") }
        fun addTomato(vegetable: ()-> Tomato) = apply { tomato = vegetable() ; println("added ${this.tomato}") }
        //
//            .myLambda{
//                this.bread = bread
//            }
//            .meat{
//                ::isTuna
//            }
//            .Bread{
//                ::isBunWithHoney
//            }
        fun buildBurger() =  apply {
            val ingredients =  arrayListOf<Ingredient>()
            bun?.let { ingredients.add(it) }
            lettuce?.let { ingredients.add(it) }
            chicken?.let { ingredients.add(it) }
            cheese?.let { ingredients.add(it) }
            cucumber?.let { ingredients.add(it) }
            tomato?.let { ingredients.add(it) }

            Burger_( ingredients )
        }
    }
}


// 2. access point for command...

interface Ingredient_ {
    val calory : Int
    val cost : Double
    val weight : Double
}
abstract class Bread_ : Ingredient_ {
}
abstract class Vegetable_ : Ingredient_ {
}
abstract class Meat_ : Ingredient_ {
}
abstract class MilkEgg_ : Ingredient {
}
class Bun_(override val calory: Int, override val cost: Double, override val weight: Double) :Bread(){
}
class Lettuce_(override val calory: Int, override val cost: Double, override val weight: Double) :Vegetable(){
}
class Cucumber_(override val calory: Int, override val cost: Double, override val weight: Double) :Vegetable(){
}
class Tomato_(override val calory: Int, override val cost: Double, override val weight: Double) :Vegetable(){
}
class Chicken_(override val calory: Int, override val cost: Double, override val weight: Double) :Meat(){
}
class Cheese_(override val calory: Int, override val cost: Double, override val weight: Double) :MilkEgg(){
}

fun main(){
    val burgerBuilder :Burger.BurgerBuilder = Burger.BurgerBuilder()
    burgerBuilder
        // 1. dependency.. for Burger
        .addBun {   Bun_(200,6.0,50.0) }
        .addCheese { Cheese(240,20.0,100.0) }
        .addChicken {Chicken(  270,70.0,200.0) }
        .addTomato { Tomato(100,20.0,80.0) }
        .addCucumber { Cucumber(50,19.0,120.0) }
        .addLettuce { Lettuce(60,13.0,10.0) }

        .buildBurger()
}*/
