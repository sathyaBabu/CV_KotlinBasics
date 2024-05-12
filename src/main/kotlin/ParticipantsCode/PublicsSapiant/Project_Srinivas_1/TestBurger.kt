package task.Day6.burgermain


enum class  MealType{ Burger, Wings }


interface Ingredients{
    fun cal():Int
    fun cost():Int
    fun name():String
}


interface Total{
    fun cal():Int
    fun cost():Int
    fun items():Int
}



class TotalAmount(items:Int,cal:Int,cost:Int):Total{

    private var cal=cal
    private var cost=cost
    private var items=items
    var number=items
        get(){
            return field
        }
    override fun cal(): Int {
        return cal
    }


    override fun cost(): Int{
        return cost
    }

    override fun items(): Int {
        return items;
    }
}


class Lettuce(name:String,number:Int,cal:Int,cost:Int):Ingredients{

    private var cal=cal
    private var cost=cost
    private var name=name
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

    override fun name(): String {
        return name;
    }
}

class Bun(name:String,number:Int,cal:Int,cost:Int):Ingredients{
    private var number=number
    private var cal=cal
    private var cost=cost
    private var name=name

    override fun name(): String {
        return name;
    }

    override fun cal(): Int {
        return cal
    }



    override fun cost(): Int{
        return cost
    }
}

class Tomato(name:String,number:Int,cal:Int,cost:Int):Ingredients{
    private var number=number
    private var cal=cal
    private var cost=cost
    private var name=name

    override fun name(): String {
        return name;
    }

    override fun cal(): Int {
        return cal*number
    }

    fun setCal(cal:Int){
        this.cal=cal*number
    }

    fun setCost(cal:Int){
        this.cal=cal
    }

    override fun cost(): Int{
        return cost
    }

}


class Chicken(name:String,number:Int,cal:Int,cost:Int):Ingredients{
    private var number=number
    private var cal=cal
    private var cost=cost
    private var name=name

    override fun name(): String {
        return name;
    }


    override fun cal(): Int {
        return cal*number
    }
    fun setCal(cal:Int){
        this.cal=cal*number
    }
    fun setCost(cal:Int){
        this.cal=cal
    }
    override fun cost(): Int{
        return cost
    }
}

class Cheese(name:String,number:Int,cal:Int,cost:Int):Ingredients{
    private var number=number
    private var cal=cal
    private var cost=cost
    private var name=name

    override fun name(): String {
        return name;
    }

    override fun cal(): Int {
        return cal*number
    }

    fun setCal(cal:Int){
        this.cal=cal*number
    }

    fun setCost(cost:Int){
        this.cost=cost
    }

    override fun cost(): Int{
        return cost
    }
}




open class Burger private constructor(ing: MutableList<Ingredients>?=null){
    var ingredients= ing
    private var totalCost=0





    //fun createIterator() =IngredientInterator(BurgerPlanImplentation(this))

    class BurgerBuilder{
         var ingredients= mutableListOf<Ingredients>()

        fun addIngredients(ingredient: Ingredients):BurgerBuilder{
            ingredients.add(ingredient)
            return this
        }


        fun buildBurger():Burger{
            return Burger(ingredients)
        }
    }



}

class IngredientsFactory{
    companion object{
        fun createIngredients(ingredient:String,number: Int,cal:Int,cost:Int): Ingredients? {
            return when (ingredient.lowercase()) {
                "lettuce" -> Lettuce(ingredient,number,cal,cost)
                "tomato"-> Tomato(ingredient,number,cal,cost)
                "cheese"->Cheese(ingredient,number,cal,cost)
                "chicken"->Chicken(ingredient,number,cal,cost)
                "bun"->Bun(ingredient,number,cal,cost)
                else -> null
            }
        }
    }
}



class WingsMealImpl (var name: Wings) : ComponentMeal{


    override fun display_Node_Leaf():MutableList<Ingredients> {

        var itr=IngredientInterator(WingsPlanImplentation(name))
        var ingredients= mutableListOf<Ingredients>()

        while (itr.hasNext()){
            val data=itr.next();
            ingredients.add(data)
            println("${data.name()} has calories= ${ data.cal()}----> cost=${data.cost()}")
        }
        println("-------------------------")

        return ingredients;
    }

    override fun close() {
        println("")
    }
}

open class ComboMeal(override val componentMeal: ComponentMeal): ComponentStack() {


    fun display_Node_Leaf() {

        componentMeal.display_Node_Leaf()
    }


    fun close()
    {
        componentMeal.close()
    }


}


abstract class ComponentStack() {
    abstract val componentMeal: ComponentMeal;
}



class Wings private constructor(private var ing: MutableList<Ingredients>?=null) {








     var ingredients = ing
     var totalCost = 0


   /* fun createIterator():WingsInterator{
        return WingsInterator(this)
    }*/


    class WingsBuilder {
        private var ingredients = mutableListOf<Ingredients>()
        fun addIngredients(ingredient: Ingredients): WingsBuilder {
            ingredients.add(ingredient)
            return this
        }

        fun buildWing(): Wings {
            return Wings(ingredients)
        }
    }

}


class BurgerMealimpl(var name: Burger) : ComponentMeal
{





    override fun display_Node_Leaf():MutableList<Ingredients> {



        var ingredients= mutableListOf<Ingredients>()

        var itr=IngredientInterator(BurgerPlanImplentation(name))
        while (itr.hasNext()){
            val data=itr.next();
            ingredients.add(data)
            println("${data.name()} has calories= ${ data.cal()}----> cost=${data.cost()}")
        }
        println("-------------------------")

            return ingredients

    }

    override fun close() {
        println("Print CLose")
    }

}


fun main(){





    var burger=IngredientsFactory


    var chicken=burger.createIngredients("chicken",1,10,40)
    var cheese=burger.createIngredients("tomato",1,10,40)//
    var lettuce=burger.createIngredients("cheese",1,30,35)//
    var bun=burger.createIngredients("bun",1,15,20)
    var burgerbuilder=Burger.BurgerBuilder()
    var Burger=burgerbuilder
        .addIngredients(cheese!!)
        .addIngredients(chicken!!)
        .addIngredients(bun!!)
        .addIngredients(lettuce!!)
        .buildBurger()





    var burger1=IngredientsFactory
    var chicken2=burger1.createIngredients("chicken",1,10,30)
    var lettuce4=burger1.createIngredients("cheese",1,30,25)
    var bun1=burger1.createIngredients("bun",1,15,10)
    var wings= Wings.WingsBuilder()
        .addIngredients(chicken2!!)
        .addIngredients(bun1!!)
        .addIngredients(lettuce4!!)
        .buildWing()








  //  val compositeMeal =BurgerMeal(chicken)
    val mealone=ComboMeal(BurgerMealimpl(Burger));
    var compositeMealone=CompositeMeal()
    compositeMealone.add(mealone.componentMeal);

    println("-----------------------------")
    var mealtwo=ComboMeal(WingsMealImpl(wings));
    val compositeMealTwo=CompositeMeal()
    compositeMealTwo.add(mealtwo.componentMeal);



    println(compositeMealone.display_Node_Leaf())

    var mealoneburger=calculateTotal(compositeMealone.display_Node_Leaf())

    var mealtwowings=calculateTotal(compositeMealTwo.display_Node_Leaf())



    val totalburgerDetails  = BurgerAmount()

    val burger_combo=BurgerComboBill(mealoneburger.items(),mealoneburger.cal(),mealoneburger.cost())

    println(
        burger_combo.generateBill( totalburgerDetails))



    val totalwingsDetails  = WingsAmount()

    val wingsCombo=BurgerComboBill(mealtwowings.items(),mealtwowings.cal(),mealtwowings.cost())

    println(
        wingsCombo.generateBill( totalwingsDetails))












}

fun calculateTotal(displayNodeLeaf: MutableList<Ingredients>): TotalAmount {

    var total :Int=0;
    var totalcal :Int =0;
    var totalItems :Int=0


    for(displayList in displayNodeLeaf)
    {
        totalcal += displayList.cal()
        total+=displayList.cost()
    }

    totalItems=displayNodeLeaf.size




    return TotalAmount(totalItems,totalcal,total)

}



/*



/Users/sripalan1/Library/Java/JavaVirtualMachines/openjdk-18.0.2/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=61328:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/sripalan1/Kotlin/Basic/TestKotlin/out/production/TestKotlin:/Users/sripalan1/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib-jdk8/1.7.10/kotlin-stdlib-jdk8-1.7.10.jar:/Users/sripalan1/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib/1.7.10/kotlin-stdlib-1.7.10.jar:/Users/sripalan1/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib-common/1.7.10/kotlin-stdlib-common-1.7.10.jar:/Users/sripalan1/.m2/repository/org/jetbrains/annotations/13.0/annotations-13.0.jar:/Users/sripalan1/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib-jdk7/1.7.10/kotlin-stdlib-jdk7-1.7.10.jar task.Day6.burgermain.TestBurgerKt
-----------------------------
tomato has calories= 10----> cost=40
chicken has calories= 10----> cost=40
bun has calories= 15----> cost=20
cheese has calories= 30----> cost=35
-------------------------
tomato has calories= 10----> cost=40
chicken has calories= 10----> cost=40
bun has calories= 15----> cost=20
cheese has calories= 30----> cost=35
-------------------------
tomato has calories= 10----> cost=40
chicken has calories= 10----> cost=40
bun has calories= 15----> cost=20
cheese has calories= 30----> cost=35
-------------------------
 	[task.Day6.burgermain.Tomato@1c20c684, task.Day6.burgermain.Chicken@1fb3ebeb, task.Day6.burgermain.Bun@548c4f57, task.Day6.burgermain.Cheese@1218025c]
tomato has calories= 10----> cost=40
chicken has calories= 10----> cost=40
bun has calories= 15----> cost=20
cheese has calories= 30----> cost=35
-------------------------
tomato has calories= 10----> cost=40
chicken has calories= 10----> cost=40
bun has calories= 15----> cost=20
cheese has calories= 30----> cost=35
-------------------------
tomato has calories= 10----> cost=40
chicken has calories= 10----> cost=40
bun has calories= 15----> cost=20
cheese has calories= 30----> cost=35
-------------------------
 	chicken has calories= 10----> cost=30
bun has calories= 15----> cost=10
cheese has calories= 30----> cost=25
-------------------------
chicken has calories= 10----> cost=30
bun has calories= 15----> cost=10
cheese has calories= 30----> cost=25
-------------------------
chicken has calories= 10----> cost=30
bun has calories= 15----> cost=10
cheese has calories= 30----> cost=25
-------------------------
 	Total Items task.Day6.burgermain.BurgerComboBill@1b28cdfa.items --- Total cals 65 ---- Totaal amount 135kotlin.Unit
Total Items 3 --- Total cals 55 ---- Totaal amount 65kotlin.Unit
 */