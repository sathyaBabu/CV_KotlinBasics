package Lambda_HighOrderFunctions



// https://typealias.com/start/kotlin-lambdas/


val taxMultiplier = 1.09

fun calculateTotal(
    initialPrice: Double,
    applyDiscount: (Double) -> Double
): Double {
    // Apply coupon discount
    val priceAfterDiscount = applyDiscount(initialPrice)
    // Apply tax
    val total = priceAfterDiscount * taxMultiplier // goes as tax

    return total
}

fun discountRsFive(price: Double) = price - 5.0
fun discountTenPercent(price: Double): Double = price * 0.9
fun noDiscount(price: Double) = price

fun main(){

    val withRsFiveOff = calculateTotal(200.0, ::discountRsFive)            //  Rs.212.55
    val withTenPercentOff  = calculateTotal(200.0, ::discountTenPercent)  // Rs.  196.2
    val fullPrice          = calculateTotal(200.0, ::noDiscount)          // Rs. 218.0
    println("Rs. $withRsFiveOff")
    println("Rs. ${withTenPercentOff.toFloat()}")
    println("Rs. ${fullPrice.toFloat()}" )


}

//
//fun processLanguages(languages: List<String>, action: (String) -> Unit) {
//    languages.forEach(action)
//}
//
//fun main() {
//    val languages = listOf("Kotlin", "Java", "Swift", "Dart", "Rust")
//    val action = { language: String -> println("Hello $language") }
//
//    processLanguages(languages, action)
//}
//// No type arguments expected for class List