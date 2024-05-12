package DesignPatterns


interface  VisitableIndividual {
    fun accept(visitor: IndividualVisitor): Double
}

interface IndividualVisitor {
    fun visit(male: Male): Double
    fun visit(female: Female): Double
    fun visit(srCitizenMale: SrCitizenMale): Double
    fun visit(srCitizenFemale: SrCitizenFemale): Double
    fun visit(teenagerMale: TeenagerMale): Double
}

// Individuals inherit VisitableIndividual so that all implementations can accept a visitor. I left calculateTax() since that was part of previous code
interface Individual: VisitableIndividual {

    var salary : Double
    var age:Int
    var name : String
    fun calculateTax() : Double
}

// calculateTax() should be independent for Male , female SrCitFEMALE..  (( TOMorow  TEen Sr Male )
class Female(override var salary: Double, override var age: Int, override var name: String) : Individual{

    override fun calculateTax(): Double {
        return  0.20 * salary
    }
// should have inherited Individual
    override fun accept(visitor: IndividualVisitor): Double {
        return visitor.visit(this)
    }
}

class Male(override var salary: Double, override var age: Int, override var name: String) : Individual{

    override fun calculateTax(): Double {
        return  0.25 * salary
    }

    override fun accept(visitor: IndividualVisitor): Double {
        return visitor.visit(this)
    }
}

class SrCitizenFemale(override var salary: Double, override var age: Int, override var name: String) : Individual{

    override fun calculateTax(): Double {
        return  0.15 * salary
    }

    override fun accept(visitor: IndividualVisitor): Double {
        return visitor.visit(this)
    }
}

class TeenagerMale(override var salary: Double, override var age: Int, override var name: String) : Individual{

    override fun calculateTax(): Double {
        return  0.25 * salary
    }

    override fun accept(visitor: IndividualVisitor): Double {
        return visitor.visit(this)
    }
}

// Change we got it
class SrCitizenMale(override var salary: Double, override var age: Int, override var name: String) : Individual{

    override fun calculateTax(): Double {
        return  0.15 * salary
    }

    override fun accept(visitor: IndividualVisitor): Double {
        return visitor.visit(this)
    }
}


// Implements IndividualVisitor to visit Individuals and calculate Tax
class IndividualTaxVisitor: IndividualVisitor {
    override fun visit(male: Male): Double {
        return male.salary * 0.25
    }

    override fun visit(female: Female): Double {
        return female.salary * 0.20
    }

    override fun visit(srCitizenMale: SrCitizenMale): Double {
        return srCitizenMale.salary * 0.15
    }

    override fun visit(srCitizenFemale: SrCitizenFemale): Double {
        return srCitizenFemale.salary * 0.10
    }

    override fun visit(teenagerMale: TeenagerMale): Double {
        return teenagerMale.salary * 0.25
    }

}

// TaxCalculator has been modified to also take appropriate IndividualVisitor and then individual.accept() calculates tax
class  TaxCalculator{

    fun calculatorTax(individual: Individual, visitor: IndividualVisitor)  : Double{
        return individual.accept(visitor)
    }
}

fun main(){

    val aamer:Individual    = Male(10000.00, 29,"Aamer")
    val kalyani:Individual  = Female(33000.00, 80,"Kalyani")
    val jyothi:Individual    = Female(23000.00, 22,"Jyothi")
    val swapnil:Individual   = Male(12000.00, 23,"Swapnil")
    val sathya :Individual = Male( 33000.00, 89,"Sathya")

    val taxCalculator1 = TaxCalculator()
    val individualTaxVisitor = IndividualTaxVisitor()

    println("1. Tax liability of Aameer : ${taxCalculator1.calculatorTax(aamer, individualTaxVisitor)}")
    println("1. Tax liability of Kalyani : ${taxCalculator1.calculatorTax(kalyani, individualTaxVisitor)}")
    println("1. Tax liability of jyothi : ${taxCalculator1.calculatorTax(jyothi, individualTaxVisitor)}")
    println("1. Tax liability of swapnil : ${taxCalculator1.calculatorTax(swapnil, individualTaxVisitor)}")

}