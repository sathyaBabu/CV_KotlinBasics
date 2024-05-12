package ParticipantsCode

abstract  class  Stack_(){

    abstract fun  push( data:Double )
    abstract fun  pop( ):Double
    abstract fun  isStackEmpty( ):Boolean
    abstract fun  size(  ):Double
}

class UseStack : Stack_(){

    // fill in the meat for the abstraction layer..
    var Stack_list= mutableListOf<Double>()

    override fun push(data: Double) {
        Stack_list.add(data)

    }
    override fun pop():Double
    {
        return Stack_list.removeLast()
    }

    override fun isStackEmpty(): Boolean {
        return Stack_list.isEmpty()
    }
    override  fun  size(  ):Double{
        return Stack_list.size.toDouble()

    }
    fun display()
    {
        println("the element is Stack_ are:$Stack_list")
    }
}

fun main()
{
    val Stack_ = UseStack()
    Stack_.push(5.0)
    Stack_.push(12.22)
    Stack_.push(14.22)
    println(Stack_.display())
    println("the pop elements is : " +Stack_.pop())
    println("the size is : " +Stack_.size())
    println("is Stack_ empty : " +Stack_.isStackEmpty())

}