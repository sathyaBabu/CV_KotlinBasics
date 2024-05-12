package DesignPatterns

interface checkOutStrategy {
    fun checkOut(ammount: Double)
}

class PayByCash : checkOutStrategy {
    override fun checkOut(ammount: Double) {
        println("ammount are checkOuted using Cash.")
    }
}

class PayByCard: checkOutStrategy {
    override fun checkOut(ammount: Double) {
        println("ammount are checkOuted using Card.")
    }
}
fun main() {
    val ammount : Double = 5000.00

    // Simple call I

//    checkOut(PayByCash(), ammount) // Output: ammount are checkOuted using Bubble checkOut.
//    checkOut(PayByCard(), ammount) // Output: ammount are checkOuted using Merge checkOut.


    val algorithms = arrayOf( PayByCard(),PayByCash() )

    for( start in algorithms.indices){
        LetTheClientDecide(algorithms[ start ] as checkOutStrategy, ammount)
    }
}

fun LetTheClientDecide(start: checkOutStrategy, amt:Double) {

    checkOut(start,amt)  // Base class which has been used by Walk as well as Drive

}
fun checkOut(checkOutStrategy: checkOutStrategy, ammount: Double) {
    checkOutStrategy.checkOut(ammount)
}