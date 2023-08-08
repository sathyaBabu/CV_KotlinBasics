package DesignPatterns







interface Command{
    fun execute()   // part of command interface..
    fun UnExecute() // my fun
}

// Builder

class Calculator1 {

    private var current = 0;

    fun operation(operator: Char, operand: Int) {
        when (operator) {

            '+' -> current += operand
            '-' -> current -= operand
            '*' -> current *= operand
            '/' -> current /= operand
        }

        println("Current value = $current after $operator $operand")


    }
}



    //  I want to create a History

    class UserHistory {
   // generic here..
        private  val calculator = Calculator1()   // This can be any class we can use generic here..

        private  val commands    = ArrayList< Command >()   // history prototype...
        private  var  current    = 0 ;

        fun redo( levels : Int){
           println(" Redo : $levels levels")

            for( i in 0 until levels){
                if( current < commands.size){
                  val command = commands[ current++]
                    command.execute()
                }
            }
        }

        // find the cheese -> add yet another cheese..

        fun undo( levels : Int){
            println(" Undo : $levels levels")

            for( i in 0 until levels){
                if( current >= 0 ){
                    val command = commands[ --current ] // NOTE : he is extracting the current state of the object
                    command.UnExecute()                 // and calling the unExecute that fires the  CalculatorCommand
                }
            }
        }


        fun compute( operator: Char,operand: Int){

            // Command turns out to ba an expensive affair...
            // Protype is a way better concept

            val command : Command = CalculatorCommand( calculator , operator, operand )

            command.execute()


            // we are adding it to the history ArrayList < Command >
            // convert command to prototype ( A copy of it ) execution of our app will me faster compared to construction of an obj.

            commands.add( command  )    // +   -  *   /
            current++

        }

        class  CalculatorCommand(private val calculator: Calculator1, var operator: Char, var operand: Int): Command {

            override fun execute() {

                calculator.operation( operator,operand)
            }

            override fun UnExecute() {
               calculator.operation( undo( operator ),operand)
            }

            private  fun undo( operator: Char) :  Char{
                val undo : Char


                undo = when( operator){
                    '+' ->  '-'
                    '-' -> '+'
                    '*' -> '/'
                    '/' -> '*'
                    else -> ' '
                }
                return undo
            }


        }


    }



fun main(){

    val user = UserHistory()

    user.compute('+',100)
    user.compute('-',50)
    user.compute('*',10)
    user.compute('/',2)

    user.compute('+',100)

    user.undo( 3)
    user.undo( 1 )

}