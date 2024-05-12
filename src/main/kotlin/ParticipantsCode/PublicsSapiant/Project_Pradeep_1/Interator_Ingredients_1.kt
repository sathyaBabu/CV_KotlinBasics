package Design_Pattern


interface Iterator2<T> {
    fun hasNext():Boolean
    fun next():Ingredients
}

class BurgerIterator(private var burger: Burger):Iterator2<Any?> {
    private var index=0
    var ingredients=burger.getIngredients()
    override fun hasNext()=index < ingredients!!.size
    override fun next() = ingredients!![index++]
}

class WingInterator(private var wings: Wings):Iterator2<Any?> {
    private var index=0
    var ingredients=wings.getIngredients()
    override fun hasNext()=index < ingredients!!.size
    override fun next() = ingredients!![index++]
}

//class CompositeInterator(private var makeMeal: Composite):Iterator2 {
//    private var index=0
//    override fun hasNext()=index < makeMeal.components!!.size
//    override fun next() = makeMeal.components!![index++]
//}

