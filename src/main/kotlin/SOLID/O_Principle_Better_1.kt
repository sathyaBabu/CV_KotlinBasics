package SOLID


// Open closed principle...
//
// Designed a
// Class
// -> Open for extension
// -> Closed for modification
//
// Use case :  calc tax on Male Female ---->Add----> not predicted as of now.. Sr cicizens..
// MALE    0.25%
// FEMALE  0.20
// SR_CITIZEN FEMALE = 0.15%

// Teean ager
// Sniffer Dog
// Elephant to move the logs
// Eagles to keep the building clean
// Robot to clean the floor of the building..

// ........



// Open closed principle..
// Closed for modification..

abstract class Individual1 protected  constructor(
    protected  var salary:Double ,
    protected  var age : Int ,
    protected  var name : String ){

   abstract  fun calculateTax() : Double


}


// Individuals can be visited by the TaxCalculator...

class Female( salary:Double ,age : Int, name : String?) : Individual1(salary,age,name!!){
    override fun calculateTax(): Double {
        return  0.20 * salary ;
    }

}


class Male( salary:Double ,age : Int, name : String?) : Individual1(salary,age,name!!){
    override fun calculateTax(): Double {
        return  0.25 * salary ;
    }

}


class SrCitizenFemale( salary:Double ,age : Int, name : String?) : Individual1(salary,age,name!!){
    override fun calculateTax(): Double {
        return  0.15 * salary ;
    }

}



class TeenagerMale( salary:Double ,age : Int, name : String?) : Individual1(salary,age,name!!){
    override fun calculateTax(): Double {
        return  0.28 * salary ;
    }

}

// Open closed principle..

// Closed for modification..
// Hoock so that we can add sub functionalities...

class TaxCalculator1 {

    // myDIApplication(....)
    // Composition layer..
    fun calculateTax( individual: Individual1) : Double {
        return  individual.calculateTax()
    }


}

fun main(){

    val  sruti : Individual1     = Female(1000.00 , 23 ,"sruti")
    val  smaranika :Individual1 = Female(1000.00 , 21 ,"smaranika")
    val  Sandeep:Individual1  = Male(1000.00 , 24 ,"Sandeep")
    val  Pranav: Individual1  = Male(1000.00 , 25 ,"Pranav")

    val  Sathya: Individual1  = TeenagerMale(1000.00 , 18 ,"Sathya")

    val  Alka :Individual1 = SrCitizenFemale(1000.00 , 25 ,"Alka")

    val taxCalculator = TaxCalculator1()

    println("1. Tax liability of Sruti is :      ${taxCalculator.calculateTax( sruti )}")
    println("2. Tax liability of  is  smaranika: ${taxCalculator.calculateTax(smaranika)}")
    println("3. Tax liability of Sandeep is :    ${taxCalculator.calculateTax(Sandeep)}")
    println("4. Tax liability of Pranav is :     ${taxCalculator.calculateTax(Pranav)}")
    println("4. Tax liability of Alka is :       ${taxCalculator.calculateTax(Alka)}")
    println("4. Tax liability of Sathya is :     ${taxCalculator.calculateTax(Sathya)}")


}

/*
1. Tax liability of Sruti is :      200.0
2. Tax liability of  is  smaranika: 200.0
3. Tax liability of Sandeep is :    250.0
4. Tax liability of Pranav is :     250.0
4. Tax liability of Alka is :     150.0
4. Tax liability of Sathya is :     280.0

Process finished with exit code 0

 */