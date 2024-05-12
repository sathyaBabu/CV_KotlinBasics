package Design_Pattern


interface Ingredients{
    fun cal():Int
    fun cost():Int

}

class Lettuce(number:Int,cal:Int,cost:Int):Ingredients{

    private var cal=cal
    private var cost=cost
    var number=number
        get(){
            return field
        }
    override fun cal(): Int {
        return cal
    }

    override fun cost(): Int{
        return cost
    }
}

class Bun(number:Int,cal:Int,cost:Int):Ingredients{
     var number=number
         get(){
             return field
         }
    private var cal=cal
    private var cost=cost
    override fun cal(): Int {
        return cal
    }

    override fun cost(): Int{
        return cost
    }
}

class Tomato(number:Int,cal:Int,cost:Int):Ingredients{
     var number=number
        get(){
            return field
        }
    private var cal=cal
    private var cost=cost
    override fun cal(): Int {
        return cal
    }

    override fun cost(): Int{
        return cost
    }

}


class Chicken(number:Int,cal:Int,cost:Int):Ingredients{
     var number=number
         get(){
             return field
         }
    private var cal=cal
    private var cost=cost

    override fun cal(): Int {
        return cal
    }

    override fun cost(): Int{
        return cost
    }
}

class Cheese(number:Int,cal:Int,cost:Int):Ingredients{
    var number=number
        get(){
            return field
        }
    private var cal=cal
    private var cost=cost
    override fun cal(): Int {
//        println("Calories for cheese is $cal ")
        return cal
    }


    override fun cost(): Int{
        return cost
    }
}

open class Burger private constructor(ing: MutableList<Ingredients>?=null):Component,Visatable1{
     private var ingredients= ing
    private var totalCost=0
     fun addIngredients(ingredient: Ingredients){
        ingredients?.add(ingredient)
    }

     fun removeIngredients(i:Ingredients){
        ingredients?.remove(i)
    }

     fun getAllIngredients(){
        for(i in ingredients!!){
            println("  ${i.cal()} calories and cost = ${i.cost()}")
        }
    }

     fun getTotalCost(){
        for(i in ingredients!!){
            totalCost+=i.cal()
        }
        println("Total Cost of the burger is $totalCost")
    }
     fun createIterator():Iterator2<Any?> {
        return BurgerIterator(this)
    }

    override fun getIngredients(): MutableList<Ingredients> {
        return ingredients!!
    }

    override fun display_Node_Leaf() {
        TODO("Not yet implemented")
    }

    override fun accept(visitor: Visitor1) {
        visitor.calculateBill(this)
    }
    class BurgerBuilder{
        private var ingredients= mutableListOf<Ingredients>()
         fun addIngredients(ingredient: Ingredients):BurgerBuilder{
            ingredients.add(ingredient)
            return this
        }

        fun buildBurger():Burger{
            println(ingredients.size)
            return Burger(ingredients)
        }
    }

}

class IngredientsFactory{
    companion object{
        fun createIngredients(ingredient:String,number: Int,cal:Int,cost:Int): Ingredients? {
            return when (ingredient.lowercase()) {
                "lettuce" -> Lettuce(number,cal,cost)
                "tomato"-> Tomato(number,cal,cost)
                "cheese"->Cheese(number,cal,cost)
                "chicken"->Chicken(number,cal,cost)
                "bun"->Bun(number,cal,cost)
                else -> null
            }
        }
    }
}

open class Wings private constructor(ing: MutableList<Ingredients>?=null):Component,Visatable1{
    private var ingredients= ing
    private var totalCost=0
    fun addIngredients(ingredient: Ingredients){
        ingredients?.add(ingredient)
    }

    fun removeIngredients(i:Ingredients){
        ingredients?.remove(i)
    }

    fun getAllIngredients(){
        for(i in ingredients!!){
            println("  ${i.cal()} calories and cost = ${i.cost()}")
        }
    }

    fun getTotalCost(){
        for(i in ingredients!!){
            totalCost+=i.cal()
        }
        println("Total Cost of the burger is $totalCost")
    }

    class WingsBuilder{
        private var ingredients= mutableListOf<Ingredients>()
        fun addIngredients(ingredient: Ingredients):WingsBuilder{
            ingredients.add(ingredient)
            return this
        }

        fun buildWing():Wings{
            return Wings(ingredients)
        }
    }

    override fun display_Node_Leaf() {
        TODO("Not yet implemented")
    }

     fun createIterator(): Iterator2<Any?> {
        return WingInterator(this)
    }

    override fun getIngredients(): MutableList<Ingredients> {
        return ingredients!!
    }

    override fun accept(visitor: Visitor1) {
        visitor.calculateBill(this)
    }
}


fun main(){
    var burger=IngredientsFactory
    var chicken=burger.createIngredients("chicken",1,13,48)
    var lettuce=burger.createIngredients("lettuce",1,12,40)
    var cheese=burger.createIngredients("cheese",1,30,35)
    var bun=burger.createIngredients("bun",1,15,20)
    var burgerbuilder=Burger.BurgerBuilder()
    var Burger=burgerbuilder
        .addIngredients(cheese!!)
        .addIngredients(chicken!!)
        .addIngredients(bun!!)
        .addIngredients(lettuce!!)
        .buildBurger()

//    var chicken1= burger.createIngredients("chicken",1,10,40)
//    var cheese1= burger.createIngredients("tomato",1,6,30)
//    var lettuce1= burger.createIngredients("cheese",1,14,45)
//    var wingbuilder=Wings.WingsBuilder()
//        .addIngredients(cheese1!!)
//        .addIngredients(chicken1!!)
//        .addIngredients(lettuce1!!)
//        .buildWing()


    var itr=Burger.createIterator()
    while (itr.hasNext()){
        println(itr.hasNext())
        val data=itr.next()
        println("Burger has calories= ${ data.cal() }----> cost=${data.cost()}")
    }

}
