package bugertestprogram




/*
fun MealTypes(block:(Menu.()->Unit) ): Menu
{
    val personWorkout= Menu()

    block(personWorkout)

    return personWorkout
}*/


fun MealTypes(block: Menu.() -> Unit) = Menu().apply(block)




class Menu{




        var ingredients= mutableListOf<IngredientDish>()

        fun addIngredients(ingredient: IngredientDish){
            ingredients.add(ingredient)
        }


     fun build(): MutableList<IngredientDish> {
        return ingredients;
    }

}


