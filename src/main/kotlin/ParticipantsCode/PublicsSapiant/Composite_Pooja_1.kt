package ParticipantsCode

//Assignment1
// create mealplan and display the output

interface MenuItem {
    fun setItem(itemName: String)
    fun getPrice(): Double
    fun printItem()
}
class Meal(val mealPrice: Double) : MenuItem {
    var mealName: String = ""

    override fun setItem(itemName: String) {
        mealName = itemName
    }

    override fun getPrice(): Double {
        return mealPrice
    }


    override fun printItem() {
        println("$mealName - $mealPrice")
    }
}
class ComboMeal : MenuItem {
    private var mealName = ""
    private val items = mutableListOf <MenuItem >()


    fun addItem(menuItem: MenuItem) {
        items.add(menuItem)
    }


    override fun setItem(itemName: String) {
        mealName = itemName
    }

    override fun getPrice(): Double {
        var total = 0.0
        items.forEach {
            total += it.getPrice()
        }
        return total
    }

    override fun printItem() {
        println("$mealName - ${getPrice()}")
    }
}
fun main() {

    // WHY here?? you could have used items  which is already defined in ComboMeal : items = mutableListOf <MenuItem >()
    val menuItems = mutableListOf<MenuItem>()

    val burger = Meal(100.0).apply { setItem("Burger") }
    val wings  = Meal(50.0).apply  { setItem("wings") }
    val coco   = Meal(200.0).apply { setItem("coco") }
    val pizza  = Meal(300.0).apply { setItem("pizza") }

    val burgerCombo = ComboMeal().apply { setItem("Burger combo meal") }


    // Where is your DSL?

    burgerCombo.apply {
        addItem(burger)
        addItem(wings)
        addItem(coco)
        addItem(pizza)

    }
    // spilling the bean out side the object
    menuItems.addAll(listOf(burger, wings,coco,pizza, burgerCombo))

    // this too should be in ComboMeal
    menuItems.forEach {
        it.printItem()
    }
}

/*
Burger - 100.0
wings - 50.0
coco - 200.0
pizza - 300.0
Burger combo meal - 650.0

Process finished with exit code 0

 */