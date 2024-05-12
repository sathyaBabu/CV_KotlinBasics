package task.Day6.burgermain



interface MealPlanIterator{
    fun hasNext():Boolean
    fun next():Ingredients
}

class BurgerPlanImplentation (private var burger: Burger): MealPlanIterator
{

    private var index=0
    override fun hasNext()=index <burger.ingredients!!.size
    override fun next() = burger.ingredients!![index++]


}


class  WingsPlanImplentation (private var burger: Wings): MealPlanIterator
{

    private var index=0
    override fun hasNext()=index <burger.ingredients!!.size
    override fun next() = burger.ingredients!![index++]


}

    abstract class MealPlanImple()
    {
        abstract val mealImpl:MealPlanIterator
    }

class IngredientInterator(override val mealImpl: MealPlanIterator): MealPlanImple() {

     fun hasNext()=mealImpl.hasNext()
     fun next() = mealImpl.next()


}

