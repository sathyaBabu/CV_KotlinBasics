package ParticipantsCode

// Works good
interface iStack1{


    fun Push(value: Int)
    fun pop():Int
    fun top():Int
    fun isEmpty():Boolean
    fun isFull(num:Int):Boolean
}

// stack Array class

class StackArrayImp() :iStack1 {

    var array= arrayListOf<Int>()
    var size=array.size
    init {
        println("inside stack array")
        println("size is: $size")
    }

    override fun Push(value:Int) {

        array.add(value)
        size++
    }

    override fun pop():Int {
        return array.removeAt(--size)
    }

    override fun top(): Int {
        return array.removeAt(--size)
    }

    override fun isEmpty(): Boolean {
        return size <= 0
    }

    override fun isFull(num: Int): Boolean {
        return (size == num)
    }
}


//Stack List class

class StackListImp() :iStack1{

    var list= mutableListOf<Int>()
    var size=list.size

    init {
        println("inside stack list")
        println("size is: $size")
    }
    override fun Push(value: Int) {
        list.add(value)
        size++
    }

    override fun pop(): Int {
//        println("inside list" + list.removeAt(--size))
//        println("inside list")
        val ele=list.removeAt(--size)
//        println(ele)
        return ele
    }

    override fun top(): Int {
        return list.removeAt(--size)
    }

    override fun isEmpty(): Boolean {
        return size <= 0
    }

    override fun isFull(num: Int): Boolean {
        return list.size==num
    }

}

// Abstraction layer
interface Stack1
{
    val Istack:iStack1 // creating the bridge

    fun Push(value: Int)
    fun pop():Int
    fun top():Int
    fun isEmpty():Boolean
    fun isFull(num: Int):Boolean

}



class StackFifo(override val Istack: iStack1) :Stack1{

//    var temp = mutableListOf<Int>()

    override fun Push(value: Int) {
        Istack.Push(value)
    }

    override fun pop(): Int {
//        println("inside fifo" + Istack.pop())
//        println("inside fifo")
        val ele:Int=Istack.pop()
//        temp.add(ele)
        return ele
//        println(Istack.pop())
    }

    override fun top(): Int {
        return Istack.top()
    }

    override fun isEmpty(): Boolean {
        return Istack.isEmpty()
    }

    override fun isFull(num: Int): Boolean {
        return Istack.isFull(num)

    }
////    fun printfifo()
//    {
//        println("inside fifo")
//
////        println(list1.size)
//        list1.reverse()
//        for (i in list1)
//        println(i)
//    }



}


fun main() {

    var implement:StackFifo?=null


    println("please enter your choice array or list")
    val choice = readln().toLowerCase()

//    if (choice == "array") {
//        implement = StackFifo(StackArrayImp())
//    } else if(choice == "list") {
//        implement = StackFifo(StackListImp())
//    }
//    else{
//        println("Invalid input!!!!")
//    }
    when (choice)
    {
        "array" -> implement = StackFifo(StackArrayImp())
        "list" -> implement = StackFifo(StackListImp())
        else -> println("Invalid input!!!!")
    }

    println("enter number of element want to enter to the stack : ")
    val enter_number = readln().toInt()
    // user entering elements
    println("enter elements : ")

    while (implement?.isFull(enter_number)==false) {
        val element = readln().toInt()
        implement.Push(element)
    }

    var temp = mutableListOf<Int>() // temporary list to hold element

    while (implement?.isEmpty()==false) {
        // adding element to the temporary list
        temp.add(implement.pop())

    }
//    for(j in temp)
//    {
//        println("inside temp $j")
//    }
    // checking is the array or stack is empty or not
//    println(implement?.isEmpty())
// pushing element to stack or list
    println("Displaying the LIFO Stack output : ")
    for (j in temp) {
        print("  $j ")
        implement?.Push(j)
    }
    println()
    println("Displaying the FIFO Stack output : ")
    // display the fifo like first come first out
    while (implement?.isEmpty()==false) {
        print("  ${implement?.pop()} ")
    }

}


/*
input :- 1 2 3

LIFO:-last in first out
normal stack will print while poping:- 3 2 1

FIFO stack will print :- 1 2 3

FIFO:- first in first out

please enter your choice array or list
array
inside stack array
size is: 0
enter number of element want to enter to the stack :
4
enter elements :
12
22
34
56
Displaying the LIFO Stack output :
  56   34   22   12
Displaying the FIFO Stack output :
  12   22   34   56
Process finished with exit code 0

 */

