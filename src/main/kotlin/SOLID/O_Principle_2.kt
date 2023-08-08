package SOLID


// Open closed principle
// open for extension and closed for modification
// changing a class may lead to series of changes on other classes...


// it helps us while using dependency injections...
/*

Siva Rama Sundar Devasubramaniam
👍 Interesting class hierarchy; Why can't this be achieved through adding an additional "Gender" attribute along with Age, instead?
And deriving the type of individual based on the Age + Gender combination? How's that different from defining a class hierarchy?
That can be shown in dataflow diagram.

 */

abstract  class Individual protected  constructor(

    protected  var salary : Double,
    protected  var age:Int,
    protected  var name : String
    ){

    abstract  fun calculateTax() : Double
}

// calculateTax() should be independent for Male , female SrCitFEMALE..  (( TOMorow  TEen Sr Male )


class Female( salry:Double ,age: Int, name : String) : Individual( salry,age,name!!){

    override fun calculateTax(): Double {
        return  0.20 * salary
    }
}

class Male( salry:Double ,age: Int, name : String) : Individual( salry,age,name!!){

    override fun calculateTax(): Double {
        return  0.25 * salary
    }
}

class SrCitizenFemale( salry:Double ,age: Int, name : String) : Individual( salry,age,name!!){

    override fun calculateTax(): Double {
        return  0.15 * salary
    }
}

class TeenagerMale( salry:Double ,age: Int, name : String) : Individual( salry,age,name!!){

    override fun calculateTax(): Double {
        return  0.25 * salary
    }
}

// Change we got it

class SrCitizenMale( salry:Double ,age: Int, name : String) : Individual( salry,age,name!!){

    override fun calculateTax(): Double {
        return  0.15 * salary
    }
}


// Fire it up
class  TaxCalculator{

    fun calculatorTax(individual: Individual)  : Double{
        return individual.calculateTax()
    }
}


fun main(){


    val aamer:Individual    = Male(10000.00, 29,"Aamer")

    val kalyani:Individual  = Female(33000.00, 80,"Kalyani")
    val jyothi:Individual    = Female(23000.00, 22,"Jyothi")
    val swapnil:Individual   = Male(12000.00, 23,"Swapnil")
    val sathya :Individual = Male( 33000.00, 89,"Sathya")

    val taxCalculator1 = TaxCalculator()

    println("1. Tax liability of Aameer : ${taxCalculator1.calculatorTax(aamer)}")
    println("1. Tax liability of Kalyani : ${taxCalculator1.calculatorTax(kalyani)}")
    println("1. Tax liability of jyothi : ${taxCalculator1.calculatorTax(jyothi)}")
    println("1. Tax liability of swapnil : ${taxCalculator1.calculatorTax(swapnil)}")

}