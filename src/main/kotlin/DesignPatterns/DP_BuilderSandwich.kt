//////////// fillings
/*


class SandwichBuilder {
    // private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    fun build(sandwich: Sandwich, ingredient: Ingredient?): Sandwich {
        sandwich.addIngredient(ingredient!!)
        return sandwich
    }
}


// Manage array of ingredients, calculate total calories
// and return completed array.

// Is holding the abstraction layer of the prodect...

// Manage array of ingredients, calculate total calories
// and return completed array.
// Is holding the abstraction layer of the prodect...
class Sandwich {
    private val ingredients: MutableList<Ingredient> = ArrayList()

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
                println(
                    """ 
 Desc : ${ingredient.description()} Cal : ${ingredient.kcal()}"""
                )
                sandwich += """
                     ${ingredient.description()}
                     
                     """.trimIndent()
            }
            return sandwich
        }
}


class Salt : Ingredient {
    override fun description(): String? {
        return "Salt"
    }

    override fun kcal(): Int {
        return 0
    }
}

class SmokedSalmon : Filling() {
    override fun description(): String {
        return "Smoked salmon"
    }

    override fun kcal(): Int {
        return 300
    }
}


interface Ingredient {
    fun description(): String?
    fun kcal(): Int
}


abstract class Filling : Ingredient { // EMPTY FOR NOW
}

class CreamCheese : Filling() {
    fun description(): String {
        return "Cream cheese"
    }

    fun kcal(): Int {
        return 250
    }
}


////////////////


///////////// decoration

class Toasted(private val bread: Bread) : BreadDecorator() {

    override var decoration: String
        get() = "Toasted"
        set(decoration) {
            super.decoration = decoration
        }
    override var decorationKcal: Int
        get() = 0
        set(decorationKcal) {
            super.decorationKcal = decorationKcal
        }

    // Required but not used
    //@Override
    fun description(): String? {
        return null
    }

    // @Override
    fun kcal(): Int {
        return 0
    }
}


abstract class BreadDecorator : Bread() {
    abstract override var decoration: String?
        set(decoration) {
            super.decoration = decoration
        }
    abstract override var decorationKcal: Int
        set(decorationKcal) {
            super.decorationKcal = decorationKcal
        }
}


/////////

///// breads
class Bun : Bread() {
    // @Override
    fun description(): String {
        return "Bun with ..."
    }

    // @Override
    fun kcal(): Int {
        return 150
    }
}


abstract class Bread : Ingredient {
    var decoration: String? = null
    var decorationKcal = 0
}

class Bagel : Bread() {
    // @Override
    fun description(): String {
        return "Bagel with ..."
    }

    //  @Override
    fun kcal(): Int {
        return 250
    }
}


fun main(){

    val builder: SandwichBuilder
    var sandwich: Sandwich

    val bread: Bread? = null

    // public CheckBox egg, cress;
//    public Switch salt;
//    public TextView order;
//    public Switch toasted;
//    private RadioButton bagel;
//
//


    // public CheckBox egg, cress;
//    public Switch salt;
//    public TextView order;
//    public Switch toasted;
//    private RadioButton bagel;
//
//
    builder = SandwichBuilder()
    sandwich = Sandwich() // Creates a platform to hold the Abstraction Layer.


    val toast: String
    var extraKcal = 0

    // Radio button group : Bread
//        if (bagel.isChecked()) {


    // Radio button group : Bread
//        if (bagel.isChecked()) {
    sandwich = builder.build(sandwich, Salt()) // prototype


    sandwich = builder.build(sandwich, Bagel())
//        } else {
//            sandwich = builder.build(sandwich, new Bun());
//        }
//

    // Switch : Toasted
    // if (toasted.isChecked()) {
    // Not used
    //        } else {
//            sandwich = builder.build(sandwich, new Bun());
//        }
//

    // Switch : Toasted
    // if (toasted.isChecked()) {
    // Not used
    val t = Toasted(bread)
    toast = t.getDecoration()
    extraKcal += t.getDecorationKcal()

//        } else {
//            toast = "";
//        }
    // we can wrp this conditions with template or with state
    // Check boxes : Filling
//        if (egg.isChecked()) {

//        } else {
//            toast = "";
//        }
    // we can wrp this conditions with template or with state
    // Check boxes : Filling
//        if (egg.isChecked()) {
    sandwich = builder.build(sandwich, SmokedSalmon())
//        }
//
//        if (cress.isChecked()) {
    //        }
//
//        if (cress.isChecked()) {
    sandwich = builder.build(sandwich, CreamCheese())
//        }
//
//        // Switch : Salt
//        if (salt.isChecked()) {
    //        }
//
//        // Switch : Salt
//        if (salt.isChecked()) {
    sandwich = builder.build(sandwich, Salt())
//        }
//
//        // Display output
    //        }
//
//        // Display output
    println(
        StringBuilder()
            .append("$toast ")
            .append(sandwich.getSandwich())
            .append("\n")
            .append(sandwich.getKcal() + extraKcal)
            .append(" kcal")
            .append("\n")
            .toString()
    )
}*/
