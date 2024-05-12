package bugertestprogram





interface MealIterator{
    fun hasNext():Boolean
    fun next():IngredientDish
}



class IngredientIteratorMeal(private var burger: MutableList<IngredientDish>): MealIterator {
    private var index=0
    override fun hasNext()=index < burger!!.size
    override fun next() = burger!![index++]
}




