package Class

// Not a sealed class...
// sealed interface Expr  else statement is not necessary
sealed interface Expr

class Num(val value: Int)                   : Expr
class Sum(val left: Expr, val right: Expr)  : Expr



fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)

//        else ->
//            throw IllegalArgumentException("Unknown expression")
    }

fun main(args: Array<String>) {
    println(eval(Sum(Sum(  Num(1), Num(2)  ), Num(4))))
    //                          1st gets evaluated         2nd
}
