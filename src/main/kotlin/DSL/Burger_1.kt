class Burger {
    private val ingredients = mutableListOf<Ingredient>()

    fun ingredient(block: Ingredient.() -> Unit) {
        val ingredient = Ingredient().apply(block)
        ingredients.add(ingredient)
    }

    fun buildBurger() {
        println("Building a burger with the following ingredients:")
        ingredients.forEach { ingredient ->
            println("- ${ingredient.name}, Quantity: ${ingredient.quantity}, Calories: ${ingredient.calories}, Cost: ${ingredient.cost}")
        }
    }
}

class Ingredient {
    var name: String = ""
    var quantity: Int = 0
    var calories: Int = 0
    var cost: Int = 0
}

fun mealPlanOne(block: MutableList<String>.() -> Unit) {
    val mealPlan = mutableListOf<String>()
    mealPlan.block()

    println("Meal Plan One:")
    mealPlan.forEach { item ->
        println("- $item")
    }
}

fun mealPlanTwo(block: MutableList<String>.() -> Unit) {
    val mealPlan = mutableListOf<String>()
    mealPlan.block()

    println("Meal Plan Two:")
    mealPlan.forEach { item ->
        println("- $item")
    }
}

fun buildBurger(block: Burger.() -> Unit) {
    val burger = Burger()
    burger.block()
    burger.buildBurger()
}

fun makeMeal(block: MutableList<String>.() -> Unit) {
    val mealPlan = mutableListOf<String>()
    mealPlan.block()

    println("Making Meal with Plan One:")
    mealPlan.forEach { item ->
        println("- $item")
    }
}

fun makeMeal2(block: MutableList<String>.() -> Unit) {
    val mealPlan = mutableListOf<String>()
    mealPlan.block()

    println("Making Meal with Plan Two:")
    mealPlan.forEach { item ->
        println("- $item")
    }
}

fun generateBill(block: MutableList<String>.() -> Unit) {
    val items = mutableListOf<String>()
    items.block()

    println("Generating Bill:")
    items.forEach { item ->
        println("- $item")
    }
}

fun main() {
    Burger().apply {
        ingredient {
            name = "Bun"
            quantity = 1
            calories = 21
            cost = 20
        }
        ingredient {
            name = "Lettuce"
            quantity = 1
            calories = 0
            cost = 10
        }
        ingredient {
            name = "Chicken"
            quantity = 1
            calories = 210
            cost = 80
        }
    }.buildBurger()

    mealPlanOne {
        add("Burger")
        add("Nugget")
        add("Wings")
    }//.apply(::makeMeal)

    mealPlanTwo {
        add("Burger")
        add("Coke")
    }//.apply(::makeMeal2)

//    billMeal {
//        add("MealPlanTwo")
//        add("PayByCard")
//    }.apply(::generateBill)
}
/*
Meal Plan One:
- Burger
- Nugget
- Wings
Meal Plan Two:
- Burger
- Coke

Process finished with exit code 0

 */