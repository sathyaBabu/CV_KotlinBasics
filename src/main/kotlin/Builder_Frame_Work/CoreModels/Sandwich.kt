package Builder_Frame_Work.CoreModels

import Builder_Frame_Work.Filings.Ingredient


// Manage array of ingredients, calculate total calories
// and return completed array.
// Is holding the abstraction layer of the prodect...
class Sandwich {
    private val ingredients: MutableList<Ingredient> = ArrayList<Ingredient>()

    // Add individual ingredients
    fun addIngredient(i: Ingredient) {
        ingredients.add(i)
    }// Not a good Idea to add cal here..

    // Calculate calories in sandwich
    val kcal: Int
        get() {
            var cal = 0
            for (ingredient in ingredients) {
                cal += ingredient.kcal()
                // Not a good Idea to add cal here..
            }
            return cal
        }

    // Return all ingredients when selection is complete
    val sandwich: String
        get() {
            var sandwich = ""
            for (ingredient in ingredients) {
                System.out.println(
                    """ 
 Desc : ${ingredient.description().toString()} Cal : ${ingredient.kcal()}"""
                )
                sandwich += ingredient.description() + "\n"
            }
            return sandwich
        }
}
