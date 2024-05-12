package StackBridge_App_1
/*
 This is Srinivasan . Using the bridge I did the Stack  Task



     Step 1 : Create the Interface “Istack” with push and pop function

     Step 2 : Create the “fifo” and “Lifo” Implementation class for Istack

     Step 3 : Create the Abstract class have the Stack that have the Istack abstract variable

     Step 4 :  Create the class stackLifo that extend the abstract class of Stack

     Step 5 :  From main create the stackLifo  call the push and pop value for both fifo and lifo






 */

interface IStack {
    fun push(i:Int)
    fun pop()
    fun getTheList(): MutableList<Any>
}

class FifoImpl : IStack {


    var mutablelist=mutableListOf<Any>();

    override fun push(i: Int) {

        mutablelist.add(i)
    }

    override fun pop() {

        mutablelist.removeFirst()

    }

    override fun getTheList(): MutableList<Any> {

        return mutablelist

    }
}


class LifoImpl : IStack {

    var mutablelist=mutableListOf<Any>();

    override fun push(i: Int) {
        mutablelist.add(i)
    }

    override fun pop() {

        mutablelist.removeLast()

    }

    override fun getTheList(): MutableList<Any> {

        return mutablelist;
    }

}


abstract class Stack() {

    abstract val stackimpl: IStack;
}


class StaackLifo(override val stackimpl: IStack):Stack() {
    fun push(i:Int) =stackimpl.push(i);
    fun pop() =stackimpl.pop()
    fun display()=stackimpl.getTheList()
}


fun main() {


    println("Fifo List")
    println("-----------------------")
    val fifo=StaackLifo( FifoImpl() )
    fifo.push(1)
    fifo.push(2)
    println("After Fifo Push")
    println(fifo.display())
    println("After Fifo Pop")
    fifo.pop()
    println(fifo.display())
    println("-----------------------")

    println("Fifo List")
    println("-----------------------")
    val lifo=StaackLifo(LifoImpl())
    lifo.push(1)
    lifo.push(2)
    println("After Lifo Push")
    println(lifo.display())
    println("After Lifo pop")
    lifo.pop()
    println(lifo.display())
    println("-----------------------")


}

/*
Fifo List
-----------------------
[1, 2]
[2]
-----------------------
Fifo List
-----------------------
[1, 2]
[1]
-----------------------*/

