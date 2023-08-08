package SOLID



// BAD design


// POJO class : model
data class student(val name:String,val age:Int,val section:String)
// m , f , srS ,Teeen


// O open for extenstion and closed for modification..
enum class Gender  {

    MALE,FEMALE, SR_CITIZEN_FEMALE,SR_CITIZEN_MALE

}


class  Individual1( salary:Double, age :Int, name : String, gender: Gender){
    private  val gender : Gender
    val salary          : Double
    val age             : Int
    val name            : String

    init {

        this.gender = gender
        this.salary = salary
        this.age    = age
        this.name   = name
    }

    fun getGender() : Gender {
        return gender
    }

}

// cannot be a object
class TaxCalculator1 {

    // Single object. DB -> name Table use...
    // 300 people shall be using DB

    fun calculateTax( individual :Individual1) : Double {

        var tax = 0.0

        tax = when (individual.getGender()) {
            Gender.MALE -> 0.20 * individual.salary
            Gender.FEMALE -> 0.25 * individual.salary
            Gender.SR_CITIZEN_FEMALE -> 0.15 * individual.salary
            Gender.SR_CITIZEN_MALE-> 0.15 * individual.salary
            else -> {
                println(" Oops! unknown choise")
                -1.0
            }
        }
        return tax
    }
}

fun main(){


    // Aamer
    // 8000 .....

     val aamer    = Individual1(10000.00, 29,"Aamer",Gender.MALE)
     val kalyani  = Individual1(33000.00, 80,"Kalyani",Gender.SR_CITIZEN_FEMALE)
     val jyothi   = Individual1(23000.00, 22,"Jyothi",Gender.FEMALE)
     val swapnil  = Individual1(12000.00, 23,"Swapnil",Gender.MALE)
      val sathya = Individual1(33000.00, 89,"Sathya",Gender.SR_CITIZEN_MALE)

     val taxCalculator1 = TaxCalculator1()

    println("1. Tax liability of Aameer : ${taxCalculator1.calculateTax(aamer)}")
    println("1. Tax liability of Kalyani : ${taxCalculator1.calculateTax(kalyani)}")
    println("1. Tax liability of jyothi : ${taxCalculator1.calculateTax(jyothi)}")
    println("1. Tax liability of swapnil : ${taxCalculator1.calculateTax(swapnil)}")



}

/*
1. Tax liability of Aameer : 2000.0
1. Tax liability of Kalyani : 4950.0
1. Tax liability of jyothi : 5750.0
1. Tax liability of swapnil : 2400.0

 */