


//tailrec fun factorial( number:Long) : Long{

// will use the stack...

tailrec fun factorial( number:Long) : Long{
    return if( number <= 1 ){
        number.toLong()
    } else {
        number * factorial(( number -1 ))
    }


}  // we are totally avoiding the usage of stack..

fun main(){

    // stack..
    // Fact iterations.. 1 .. ffffffff    -> recurssion  Calls the STACK Stack over flow...
    // link list..
    // its solved in kotlin

    // BAD way of coding....

    val res  : Long  = 0

    factorial(900)

}

/*
Exception in thread "main" java.lang.StackOverflowError
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:8)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
	at Class_Fact_tailrecKt.factorial(Class_Fact_tailrec.kt:11)
 */