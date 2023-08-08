package DesignPatterns



sealed class RBILoan {
    object CITI_Bank : RBILoan() //Kotlin 1.0 could only be an inner class or object
}

object ICICI_Bank                              : RBILoan() //Kotlin 1.1 declared as top level class/object in the same file
class Amanath_Bank(  val someProperty: String) : RBILoan()
data class HDFC_Bank(val someProperty: String) : RBILoan() //Kotlin 1.1 data class extends other class
//object Federal_Bank : RBILoan()

class Percent(
    val code: Double
)

object LoanFactory {

    fun QueryForLoan(loan: RBILoan): Percent =
        when (loan) {
            is RBILoan.CITI_Bank -> Percent(12.02)
            is ICICI_Bank        -> Percent(13.20)
            is HDFC_Bank         -> Percent(11.12)
            is Amanath_Bank      -> Percent(10.10)

        }  //try to add a Federal_Bank :, it won't even compile without adding new branch to 'when'
}
fun main(){

    val intrestRate = LoanFactory.QueryForLoan(Amanath_Bank("")).code
    println("Amanath bank %: $intrestRate")

    val intRate= LoanFactory.QueryForLoan(RBILoan.CITI_Bank).code
    println("CITI bank % : $intRate")

}
//
//Amanath bank %: 10.1
//CITI bank % : 12.02
//
//Process finished with exit code 0
