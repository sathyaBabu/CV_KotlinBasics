package bugertestprogram


interface ComponentMeal{
    fun display_Node_Leaf():MutableList<IngredientDish>
    fun close()
}


fun MealDishImpl(block:(Mealimpl.()->Unit) ): Mealimpl
{
    val personWorkout= Mealimpl()

    block(personWorkout)

    return personWorkout
}


class Mealimpl(var name: MutableList<IngredientDish>?=null) : ComponentMeal
{




    var mealDish= mutableListOf<IngredientDish>()



    override fun display_Node_Leaf():MutableList<IngredientDish>{




        var itr= name?.let { IngredientIteratorMeal(it) }
        if (itr != null) {
            while (itr.hasNext()){
                val data=itr.next();
                 mealDish.add(data)
                println("${data.name()} has calories= ${ data.cal()}----> cost=${data.cost()}")
            }
        }

            return mealDish


    }

    override fun close() {
        println("Print CLose")
    }


    fun build(): MutableList<IngredientDish> {
        return mealDish;
    }

}


class CompositeMeal() : ComponentMeal {

    // ComponentMeals can take a Leaf or a Node in a uniform way..
    private  var ComponentMeals : MutableList<ComponentMeal> = ArrayList()
    var node = 0
    // watch on this  -> Debug this and get the hang of it..
    override fun display_Node_Leaf() :MutableList<IngredientDish>
    {
        var mutableList= mutableListOf<IngredientDish>()

        for( ComponentMeal in ComponentMeals){


            for(displaymeal in ComponentMeal.display_Node_Leaf())
            {
                mutableList.add(displaymeal)
            }

            if( getComponentMeals().size > 0 )  print(" \t")
        }

        return mutableList

    }

    override fun close() {
        for( ComponentMeal in ComponentMeals){
            ComponentMeal.close()
        }
    }

    fun add( ComponentMeal: ComponentMeal){
        ComponentMeals.add( ComponentMeal)
    }

    fun getComponentMeals() : List<ComponentMeal>{
        return  ComponentMeals
    }







}





