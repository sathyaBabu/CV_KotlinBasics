package task.Day6.burgermain

import java.text.DecimalFormat

// PLEase stick to the official terms
// visit(
// accept( Visitor v )

interface  Biller{
    fun viewBill( mealCombo   : BurgerComboBill)

    fun viewBill( wingsCombo   : WingsCombo)

}
interface  Billable{
    fun generateBill( biller : Biller)
}




class WingsCombo(val items:Int,val calories:Int,val cost:Int) : Billable {
    override fun generateBill(biller: Biller) {
        biller.viewBill(wingsCombo = this)
    }


}



class BurgerComboBill(val items:Int,val calories:Int,val cost:Int) : Billable {
    override fun generateBill(biller: Biller) {
        biller.viewBill(mealCombo = this)
    }


}



class BurgerAmount : Biller {

    override fun viewBill(mealCombo: BurgerComboBill) {

        print("Total Items $mealCombo.items --- Total cals ${mealCombo.calories} ---- Totaal amount ${mealCombo.cost}")


    }

    override fun viewBill(mealCombo: WingsCombo) {

        print("Total Items $mealCombo.items --- Total cals ${mealCombo.calories} ---- Totaal amount ${mealCombo.cost}")


    }


}




class WingsAmount : Biller {

    override fun viewBill(mealCombo: BurgerComboBill) {

        print("Total Items ${mealCombo.items} --- Total cals ${mealCombo.calories} ---- Totaal amount ${mealCombo.cost}")


    }

    override fun viewBill(mealCombo: WingsCombo) {

        print("Total Items $mealCombo.items --- Total cals ${mealCombo.calories} ---- Totaal amount ${mealCombo.cost}")


    }


}




