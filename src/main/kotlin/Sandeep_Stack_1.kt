abstract  class  Stack(){

    abstract fun  push( data:Double )
    abstract fun  pop( ):Double
    abstract fun  isEmpty( ):Boolean
    abstract fun  size(  ):Int
}


       // List   interface   Stack

class UseStack : Stack(){

    // fill in the meat for the abstraction layer..
    var list= mutableListOf<Double>()

    override fun push(data: Double) {
        list.add(data)

    }
    override fun pop():Double
    {
        return list.removeLast()
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }
    override  fun  size(  ):Int{
        return list.size

    }
    fun display()
    {
        println("the element is stack are:$list")
    }
}

fun main()
{
    var element:Double
    val stk = UseStack()
    println("enter how many element want to enter in stack: ")
    var loop = readln().toInt()
    for ( i  in 1 .. loop)
    {
        element= readln().toDouble()
        stk.push(element)
    }
    println("check is the stack isempty : ${stk.isEmpty()}")
    println("the size of the stack : ${stk.size()}")
    println(stk.display())
    for(i in loop downTo 1) {
        println("element removed : ${stk.pop()}")
    }
    println("check is the stack isempty : ${stk.isEmpty()}")

}
