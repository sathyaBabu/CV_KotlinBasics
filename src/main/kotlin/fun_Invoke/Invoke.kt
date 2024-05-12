package fun_Invoke



class Configure{
    var count = 0   // MUST  init initilizer gets called here for once..


    // automatically invoke() gets executed.. we are chaining the responsibility to the invoke..
    operator  fun invoke(): Configure{
        count++
        return this
    }
}
fun main()
{
    val config = Configure()   // lazy initalization...

//    config()  // formally gets  initialized when we use it
//    config()
//    config()

    config()()()()  // chain of responsibility...
    // Think how to display the data using iteration on this..



    // this.this.this().this

    println(" Config is created and executed for  ${config.count}")  // 1
}