package ParticipantsCode


interface  _KFC{

    fun DisplayMenu()
    fun edit(item1: ITEM)
    fun delete(item2: ITEM)

}


class  ITEM( var item:String,var price:Double) :  _KFC{

    var _price=0.0
    override fun DisplayMenu() {
        println(" Item --> $item : $price")

    }

    override fun edit(item1: ITEM) {
        println("${item1.item} is added to the order")
    }

    override fun delete(item2: ITEM) {
        println(" ${item2.item} is removed from the order")
    }



}
// cmposite class
class  Meal_PLAN:  _KFC {

    private  var meal_plan : MutableList< _KFC> = ArrayList()
    var node = 0 ;


    override fun DisplayMenu() {

        for( component in meal_plan){
            print("MENU : ${node++}")
            component.DisplayMenu()// composite  Leaf..
//            if( getComponents().size > 0 ) print("\t")
            if( getComponents().size > 0 ) print("\t")
        }

    }

    override fun edit(item1: ITEM) {
        item1.edit(item1)
    }

    override fun delete(item2: ITEM) {

        item2.delete(item2)

    }


    // Leaf or Component
    fun add( component:  _KFC){
        meal_plan.add(component)
    }
    fun remove(component:  _KFC){
        print(meal_plan.remove(component))
    }

    fun getComponents() : List< _KFC>{
        return meal_plan
    }

    fun getComponent(index:Int):  _KFC{
        return  meal_plan[ index ]
    }


}

fun main(){

    val item1 = ITEM("Sandwich",400.00)
    val item2 = ITEM("Pizza",600.00)
    val item3 = ITEM("coffee",300.00)
    val item4 = ITEM("chicken-bucket",800.00)
    val item5 = ITEM("cold-drink",500.00)
    val item6 = ITEM("Popcorn",400.00)
    val item7= ITEM("french-fries",350.00)






    val meal_plan1 = Meal_PLAN()   // node  100 -> 11c / ->11a
    meal_plan1 .add( item1) // 100 -> 11c
    meal_plan1 .add( item2) // 100 -> 11a

    val total_price1=item1.price+item2.price

    val meal_plan2 = Meal_PLAN()  // 200
    meal_plan2.add( item3)        // 200 -> 21c
    meal_plan2.add(item4)         // 200 -> 21a

    val total_price2=item3.price+item4.price

    val meal_plan3 = Meal_PLAN()  // 300
    meal_plan3.add(item5)     // 300 -> 100 -> 11c : 11a
    meal_plan3.add(item6) // 300 -> 200 -> 21c 21a

    val total_price3=item5.price+item6.price

    // 300 -> 51c

    val mealPlan =Meal_PLAN() // 300 -> 100
    mealPlan.add(meal_plan1)
    mealPlan.add(meal_plan2)
    mealPlan.add(meal_plan3)

    val total_price4=total_price1+total_price3+total_price2

    val mealPlan1=Meal_PLAN()
    mealPlan1.add(meal_plan1)
    mealPlan1.add(item7)

    val total_price5=total_price1+item7.price





    println("Display MENU:-")
    item1.DisplayMenu() //
    item2.DisplayMenu()
    item3.DisplayMenu()
    item4.DisplayMenu()
    item5.DisplayMenu()
    item6.DisplayMenu()

    println("Display the FIRST COMBO:-")
    meal_plan1. DisplayMenu()
    println("price is:- $total_price1")


    println("Display the SECOND COMBO:-")
    meal_plan2. DisplayMenu()
    println("total price is:- $total_price2")

    println("Display the THIRD COMBO:-")
    meal_plan3. DisplayMenu()
    println("total price is:- $total_price3")


    println("Display the special combo")
    mealPlan. DisplayMenu()
    println("total price is:- $total_price4")

    println("Display budget friendly")
    mealPlan1. DisplayMenu()
    println("total price is:- $total_price5")

    mealPlan.delete(item5)

    mealPlan1.edit(item3)
    mealPlan1.add(item3)


    println("Number of item added to the order ${meal_plan2.getComponents().size}")




    // close all the nodes on composite 3






}
/*
Display MENU:-
 Item --> Sandwich : 400.0
 Item --> Pizza : 600.0
 Item --> coffee : 300.0
 Item --> chicken-bucket : 800.0
 Item --> cold-drink : 500.0
 Item --> Popcorn : 400.0
Display the FIRST COMBO:-
MENU : 0 Item --> Sandwich : 400.0
	MENU : 1 Item --> Pizza : 600.0
	price is:- 1000.0
Display the SECOND COMBO:-
MENU : 0 Item --> coffee : 300.0
	MENU : 1 Item --> chicken-bucket : 800.0
	total price is:- 1100.0
Display the THIRD COMBO:-
MENU : 0 Item --> cold-drink : 500.0
	MENU : 1 Item --> Popcorn : 400.0
	total price is:- 900.0
Display the special combo
MENU : 0MENU : 2 Item --> Sandwich : 400.0
	MENU : 3 Item --> Pizza : 600.0
		MENU : 1MENU : 2 Item --> coffee : 300.0
	MENU : 3 Item --> chicken-bucket : 800.0
		MENU : 2MENU : 2 Item --> cold-drink : 500.0
	MENU : 3 Item --> Popcorn : 400.0
		total price is:- 3000.0
Display budget friendly
MENU : 0MENU : 4 Item --> Sandwich : 400.0
	MENU : 5 Item --> Pizza : 600.0
		MENU : 1 Item --> french-fries : 350.0
	total price is:- 1350.0
 cold-drink is removed from the order
coffee is added to the order
Number of item added to the order 2

Process finished with exit code 0

 */