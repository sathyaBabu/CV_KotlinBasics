package Builder_Frame_Work.CoreModels

import Builder_Frame_Work.Filings.Ingredient



class SandwichBuilder {

    // private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    fun build(sandwich: Sandwich, ingredient: Ingredient?): Sandwich {
        sandwich.addIngredient(ingredient!!)
        return sandwich
    }
}
