package SOLID
/*

   DI    Dependency inversion principle ( Turning the table around )
         // Manager or employee should not be dependent on each other...

                            A Managers
         Merc  ----->
                            Z Workers

   LSP  ?????? LSP is not OCP LSP is NOT DI


   Calculator       -> add sub div mul  mem C

   Speed o Meter CAR  -> speed


   add
   sub
   div
   mul

   // executor class can be a thread , pool , coroutine so on..
   cal.add( add )
   cal.add( sub )
   cal.add( mul )

   for( i in cal )
         i.result();

         Our stack Abstraction layer using stackInterface as a pointer to receive lifo fifo


GREAT Live EXAMPLE
// interface is the one which connects the objects to gether ( a --- interface --- b )  or  ( b --- interface --- a )
// BUtton -> interface( onClickListenet() -> which can be used by our app
// Scroll bar   interface   TextView( EditText )


 */

interface ICalculatorOperation{
    fun calculatorOperation()
}

class Add : ICalculatorOperation{
    override fun calculatorOperation() {
        //TODO("Not yet implemented")
        add()
    }
    private fun add() {
        println(" Add now...")
    }

}


class Sub : ICalculatorOperation{
    override fun calculatorOperation() {
        //TODO("Not yet implemented")
        sub()
    }
    private fun sub() {
        println(" Sub now...")
    }

}
class Calculator( calc: List< ICalculatorOperation >){
    private  val calc: ArrayList<ICalculatorOperation>

    init {
        this.calc = calc as ArrayList< ICalculatorOperation > /* = java.util.ArrayList<SOLID.ICalculatorOperation> */
    }

     fun implement(){
         calc.forEach {
               it.calculatorOperation() }
         //   it ->it.calculatorOperation() }  // works

     }
}

fun main(){

    val calc = ArrayList< ICalculatorOperation >()

    val add = Add()
    val sub = Sub()

    calc.add( add )
    calc.add( sub )

    val calculator = Calculator( calc)
    calculator.implement()


}

/*
 Add now...
 Sub now...
 */