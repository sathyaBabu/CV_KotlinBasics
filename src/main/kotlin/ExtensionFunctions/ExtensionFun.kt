package ExtensionFunctions

fun main(){
    val greet = "Hello"

    fun String.greetWithEuphoria() = toUpperCase()
    println(greet.greetWithEuphoria())


}