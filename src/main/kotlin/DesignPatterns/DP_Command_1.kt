package DesignPatterns
/*
command :
Encapsulate a request as an object,
thereby letting you parameterize clients with different requests,
queue or log requests, and support undoable operations.

Command is expensive as it stores every class in itself.. Think where it can be used aptly

     Undo and redo word doc on top any editor
     Filling forms.. Undo redo
     While using -> and <- buttons..

     Media player
         -> API
            List the songs by genire.   Pick Hindi  - Songs 2020 - Top Songs for the year - Most Played.
            Play list
            Classics..
            Stream via network.
            Play via SD card..
            Most played song for 2019

     Give me demo of your media player..

     Store a set of API in Array/queue which you have picked for the demo
     When user pickes the demo .. Demo will automatically start..command will run through the picked API..


     Canvas Board..
         Drawing
             Arch   x,y
             rect   x,y
             circle  x,y, r
             cube    x,y
             xyz     x,y

 */

interface  Command {
    fun execute()
    fun unExecute()
}

// Abstracton functions..  NOT talking about the abstraction functions here...
// How abstract your class can remain..

class Calculator1 {
    private  var current = 0

    fun operation( operator: Char, operand: Int){
        when( operator){
            '+' -> current += operand
            '-' -> current -= operand
            '*' -> current *= operand
            '/' -> current /= operand
        }
        println("Current value = $current after $operator $operand")
    }

}

// User in turn will queue all the commands   objects..
class User5  {

    private  val calculator1 = Calculator1()
    private  val commands    = ArrayList< Command >()
    private  var current     = 0

    fun redo( levels:Int){
        println("Redo : $levels levels" )
        for( i in 0 until levels){
            if( current < commands.size){
                val command = commands[ current++ ]
                command.execute()
            }
        }
    }
    fun undo( levels: Int){

        println("Undo  : $levels levels" )
        for( i in 0 until levels){
            if( current >= 0){
                val command = commands[ --current ]
                command.unExecute()
            }
        }

    }

    //-->
    fun compute( operator: Char, operand: Int){

        val command: Command = CalculatorCommand( calculator1,operator,operand)
        command.execute()

        // we should queue up all the commands while compute gets executed..

        commands.add(command)       // 1 :  + 100  100  // 2 :  - , 50  50  // 3 * 10 500 //4  / 2 250
        current++     // level
    }




}
//   pass the                        builder to calculator1
class CalculatorCommand(private val calculator: Calculator1, var operator: Char, var operand: Int) : Command {
    override fun execute() {
         calculator.operation(operator,operand)
    }

    override fun unExecute() {  // + : -     100
        calculator.operation(undo(operator),operand)
    }

    private fun undo( operator: Char) : Char{
        val undo: Char

        undo = when( operator){
            '+' -> '-'
            '-' -> '+'
            '*' -> '/'
            '/' -> '*'
            else -> ' '

        }
        return undo
    }


}


fun main(){

    // create the user and let the userr compute

    val user =  User5()

    user.compute('+',100)
    user.compute('-',50)
    user.compute('*',10)
    user.compute('/',2)

    // all the operations are stored in compute arrayList

    user.undo( 4 )

    user.redo( 3 )



}
/*
Current value = 100 after + 100
Current value = 50 after - 50
Current value = 500 after * 10
Current value = 250 after / 2
Undo  : 4 levels
Current value = 500 after * 2
Current value = 50 after / 10
Current value = 100 after + 50
Current value = 0 after - 100
Redo : 3 levels
Current value = 100 after + 100
Current value = 50 after - 50
Current value = 500 after * 10

Process finished with exit code 0

 */