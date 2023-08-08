package Lazy

class TaxCollector{
    init {
        println("Init tax collector")
    }
    fun payTaxes(salary:Int) = println("Paying taxes on salary of ${salary}...")
}

class Accountant{
    init {
        println("Init Accountant -> Should work when its called for..")
    }
    fun findTaxSavings() = println("\t Found tax savings!...")
}

private const val SALARY_THRESHOLD  = 100
private val taxCollector            = TaxCollector()

// Phase I
private val accountant              = Accountant()  // we may not use this at all still its  initialised

// Phase II
//private val accountant    by lazy { Accountant()}

// Phase III works for interface

//private val accountantDelegate    = lazy { Accountant() }
//private val accountant by accountantDelegate



fun main(){

    val salaries = listOf( 50, 90, 70 )

    for( salary in salaries){
        taxCollector.payTaxes( salary)
        if( salary > SALARY_THRESHOLD) accountant.findTaxSavings()
    }

    // Phase III same code with one extra check on initializer
/*

    println("Is accountant initialized ${accountantDelegate.isInitialized()}")
    // Only when you increase the salary threshold accountant class gets gets constructed

    val salaries = listOf( 50, 90, 70 )

    // try changing salary as follows and check
   // val salaries = listOf( 50, 190, 70 )

    for( salary in salaries){
        taxCollector.payTaxes( salary)
        if( salary > SALARY_THRESHOLD) accountant.findTaxSavings()
        println("Is accountant initialized ${accountantDelegate.isInitialized()}")
    }
    */

}



/*
Phase I
Init tax collector

Init Accountant -> Should work when its called for..
****** Accountant class got initialised even though we are not using it yet

Paying taxes on salary of 50...
Paying taxes on salary of 90...
Paying taxes on salary of 70...

Process finished with exit code 0


Phase II Lazy
Init tax collector
Paying taxes on salary of 50...
Paying taxes on salary of 90...
Paying taxes on salary of 70...

Process finished with exit code 0

Phase III Lazy with = lets you check if the object is initialised or not
println("Is accountant initialized ${accountantDelegate.isInitialized()}")
val salaries = listOf( 50, 190, 70 )

Init tax collector
Is accountant initialised false
Paying taxes on salary of 50...
Is accountant initialised false
Paying taxes on salary of 90...
Is accountant initialised false
Paying taxes on salary of 70...
Is accountant initialised false

Process finished with exit code 0

// WHEN salary changed above 100 then accountant threshold

Init tax collector
Is accountant initialized false
Paying taxes on salary of 50...
Is accountant initialized false
Paying taxes on salary of 190...
Init Accountant -> Should work when its called for..
	 Found tax savings!...
Is accountant initialized true
Paying taxes on salary of 70...
Is accountant initialized true

Process finished with exit code 0

*/
