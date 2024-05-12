package SOLID
// Open closed principle... voilate the O Principle here..
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


enum class Gender {
    MALE, FEMALE , SR_CITIZEN_FEMALE
}

// Open closed principle..
// Closed for modification..
class Individual( salary:Double , age : Int , name : String , gender : Gender){

    private  val gender : Gender
    val salary : Double
    val age : Int
    val name : String

    init {
        this.gender = gender
        this.salary = salary
        this.age = age
        this.name = name
    }

    fun getGender() : Gender {
        return  gender
    }

}

// Open closed principle..

// Closed for modification..
class TaxCalculator {

    fun calculateTax( individual: Individual) : Double {
        var tax = 0.0

        tax = when( individual.getGender()){
            Gender.FEMALE      -> 0.20 * individual.salary
            Gender.MALE        -> 0.25 * individual.salary

            Gender.SR_CITIZEN_FEMALE -> 0.15 * individual.salary

            else                -> { println("Unknown choice ")
            -1.0
            }
        }
        return tax
    }

}

fun main(){

    val  sruti      = Individual(1000.00 , 23 ,"sruti", Gender.FEMALE)
    val  smaranika  = Individual(1000.00 , 21 ,"smaranika", Gender.FEMALE)
    val  Sandeep    = Individual(1000.00 , 24 ,"Sandeep", Gender.MALE)
    val  Pranav      = Individual(1000.00 , 25 ,"Pranav", Gender.MALE)

    val  Alka      = Individual(1000.00 , 25 ,"Alka", Gender.SR_CITIZEN_FEMALE)

    val taxCalculator = TaxCalculator()

    println("1. Tax liability of Sruti is :      ${taxCalculator.calculateTax(sruti)}")
    println("2. Tax liability of  is  smaranika: ${taxCalculator.calculateTax(smaranika)}")
    println("3. Tax liability of Sandeep is :    ${taxCalculator.calculateTax(Sandeep)}")
    println("4. Tax liability of Pranav is :     ${taxCalculator.calculateTax(Pranav)}")
    println("4. Tax liability of Alka is :     ${taxCalculator.calculateTax(Alka)}")


}

/*
1. Tax liability of Sruti is :      200.0
2. Tax liability of  is  smaranika: 200.0
3. Tax liability of Sandeep is :    250.0
4. Tax liability of Pranav is :     250.0
4. Tax liability of Alka is :     150.0

Process finished with exit code 0

 */