package Class

/*
This type of class is used to represent a restricted class hierarchy.
 Sealed allows the developers to maintain a data type of a predefined type.
 To make a sealed class, we need to use the keyword “sealed” as a modifier of that class.
 A sealed class can have its own subclass but all those subclasses need to be declared inside the same Kotlin file
 along with the sealed class.
 */
sealed class Expression {

    class Num(val value: Int)                                 : Expression ()
    class Sum(val left: Expression , val right: Expression )  : Expression ()

}

fun eval(e: Expression ): Int =
    when (e) {
        is Expression .Num -> e.value
        is Expression .Sum -> eval(e.right) + eval(e.left)
    }

fun main(args: Array<String>) {
    println(eval(Expression.Sum(Expression.Sum(  Expression.Num(1), Expression.Num(2)  ), Expression.Num(4))))


}
