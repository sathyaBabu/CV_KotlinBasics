package bugertestprogram



interface  Visitor{

    fun visit(mealsAmount: BurgerComboBill)


}



// Aman
interface  Visatable{
    fun accept( visitor : Visitor)
}



class BurgerComboBill(val amount: TotalAmount) : Visatable {
    override fun accept(visitor: Visitor) {
            visitor.visit(mealsAmount = this)
    }


}



class MealsAmount : Visitor {

    override fun visit(mealCombo: BurgerComboBill) {

        print("After Visit Total cals ${mealCombo.amount.cal()} ---- Totaal amount ${mealCombo.amount.cost()}")

    }


}





