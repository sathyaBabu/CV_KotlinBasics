package Lambda_HighOrderFunctions





import java.util.*

//private val <E> MutableList<E>.copy: E
//    get() {}

data class preapareMeal(val name: String,
                        var storemeal: storeMeal?)

data class storeMeal(val Item: String,
                     val calories: Int,
                     val cost: Int)

class  genericClass1< T >(input : T ) {
    init {
        println(" I'm getting order .... $input")
    }
}
class  genericClass2< T >(input : T ) {
    init {
        println(" you have to pay .... $input rs")
    }
}
class  genericClassMeal< T >( input: T){

    init {
        println(" I'm getting what I have ordered. .... ${input.toString()}")
    }

}

fun mealfun(block: MealBuilder.() -> Unit): preapareMeal = MealBuilder().apply(block).build()

// Till you understand.. compare both the blocks
//    fun person2(block: (Person2) -> Unit): Person2 {
//        val per = Person2()
//        block(per)
//        return per
//    }
/*
       list()
       .filter{ ::isEven   }
       .forEach{  println( $it ) }
 */
class MealBuilder {

    var name: String = ""
    var storemeal: storeMeal? = null
    // Link list to hold on to numerous class..
    fun storemeal(block: StoremealBuilder.() -> Unit) {
        storemeal = StoremealBuilder().apply(block).build()
    }
    // returning PersonClass when build() is called!!!
    fun build(): preapareMeal = preapareMeal(name, storemeal)

}

class StoremealBuilder {

    var item: String = ""
    var calories: Int = 0
    var cost: Int = 0
    fun build() : storeMeal = storeMeal(item, calories, cost)

}

fun main(){
//
//        val meal = mealfun {
//        name = "Burger"
//        storemeal {
//            item = "Bun"
//            calories = 21
//            cost = 20
//        }
//        storemeal{
//            item = "Lettuce"
//            calories = 1
//            cost = 10
//        }
//        storemeal{
//            item = "Chicken"
//            calories = 210
//            cost = 80
//        }
//    }
//     println(meal)

    data class  storeMeal(val item:String,val calories: Int,val cost: Int)

    var object1 = genericClass1<String>( "Burger")
    var object2 = genericClass2<Int>( 1 )
    var addr1 = mutableListOf(

        storeMeal("bun",1,20),
        storeMeal("Lettuce",1,40),
        storeMeal("chicken",4,80),

        )
    var addr2=addr1

    var address1 = genericClassMeal( addr2)
    println(object1)
    println(object2)
//    println("${addr2.toString()}")
    println(address1)
}



