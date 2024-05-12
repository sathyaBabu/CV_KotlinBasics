package Class



//
//
//sealed class Expression{
//
//    class Num( val value: Int)                                : Expression()
//    class Sum( val left:Expression, val right : Expression)   : Expression()
//
//}



sealed interface Expression

    class Num( val value: Int)                                : Expression
    class Sum( val left:Expression, val right : Expression)   : Expression


fun eval( e : Expression) : Int =
    when( e ){

//        is Expression.Num -> e.value
//        is Expression.Sum -> eval(e.right) + eval(e.left)

        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
    }



//tailrec fun factorial( number:Long) : Long{



fun main(){

    // stack..
    // Fact iterations.. 1 .. ffffffff    -> recurssion  Calls the STACK Stack over flow...
    // link list..
    // its solved in kotlin

    // BAD way of coding....


    println(   eval(Sum(  Sum( Num( 5 ),Num( 12)), Num(7)))   )

   // println(   eval(Expression.Sum(  Expression.Sum( Expression.Num( 5 ),Expression.Num( 12)), Expression.Num(7)))   )

}
// 24