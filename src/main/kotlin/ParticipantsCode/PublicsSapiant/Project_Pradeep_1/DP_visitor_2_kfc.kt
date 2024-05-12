package Design_Pattern

interface  Visitor1{
    fun calculateBill( burger: Burger )
    fun calculateBill( wings: Wings )
}

// Aman
interface  Visatable1{  // house education cell
    fun accept( visitor : Visitor1)
}

class generateBill:Visitor1{

    override fun calculateBill(burger: Burger) {
        var itr=burger.createIterator()
        var totalBillforBurger=0
        while (itr.hasNext()){
            val data=itr.next()
            totalBillforBurger+=data.cost()
            println("Burger has calories= ${ data.cal() }----> cost=${data.cost()}")
        }
        println("The total bill for the Burger is ${totalBillforBurger}")
    }

    override fun calculateBill(wings: Wings) {
       var itr=wings.createIterator()
        var totalBillforWings=0
        while (itr.hasNext()){
            val data=itr.next()
            totalBillforWings+=data.cost()
            println("Wings has calories= ${ data.cal() }----> cost=${data.cost()}")
        }
        println("The total bill for the Wing is ${totalBillforWings}")
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

    var chicken1= burger.createIngredients("chicken",1,10,40)
    var cheese1= burger.createIngredients("tomato",1,6,30)
    var lettuce1= burger.createIngredients("cheese",1,14,45)
    var Wing=Wings.WingsBuilder()
        .addIngredients(cheese1!!)
        .addIngredients(chicken1!!)
        .addIngredients(lettuce1!!)
        .buildWing()

    //visitor pattern independent class
    var generateBill=generateBill()

        Burger.accept(generateBill)
        Wing.accept(generateBill)

}
