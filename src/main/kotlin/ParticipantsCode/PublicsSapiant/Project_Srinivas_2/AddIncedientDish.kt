package bugertestprogram


class AddIngredientDish(name:String,quantity:Int,cal:Int,cost:Int): IngredientDish {

    private var cal=cal
    private var cost=cost
    private var name=name
    private var quantity=quantity




    override fun quantity() : Int {
        return quantity
    }


    override fun cal(): Int {
        return cal
    }


    override fun cost(): Int{
        return cost
    }

    override fun name(): String {
        return name;
    }
}




interface Total{
    fun cal():Int
    fun cost():Int
    fun items():Int
}



class TotalAmount(items:Int,cal:Int,cost:Int):Total{

    private var cal=cal
    private var cost=cost
    private var items=items
    var number=items
        get(){
            return field
        }
    override fun cal(): Int {
        return cal
    }


    override fun cost(): Int{
        return cost
    }

    override fun items(): Int {
        return items;
    }
}



/*
class IngredientsFactoryItems{
    companion object{
        fun createIngredients(name:String,quantity: Int,cal:Int,cost:Int): AddIngredientDish? {
            return AddIngredientDish(name,quantity,cal,cost)
            }
        }
    }
*/







