package day2

import kotlin.collections.ArrayList

fun main() {
    val arr:ArrayList<Int> = mutableListOf<Int>() as ArrayList<Int>
    val lifo:Stack = Lifo(arr)
    val fifo:Stack = Fifo(arr)
    val stack: Stack = lifo
    val list: List = List(stack)
    list.display()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.display()
    list.remove()
    list.display()
//    println(arr)
//    stack.push(4)
//    println(arr)
//    println(stack.pop())
//    println(arr)
}

// When interface is required
//  class Stack  -> Push() pop() isTop()
// Aamir
// Interface can act as a bridge between the core class and implem.. class..
// can u see a tight coupling here..
// we create components interface can build a bridge between components..
// 1. Create a Stack interface
// 2  impliment the same on LIFO
// 3  impliment the same on FIFO
// 4 Create a List
// 5 make interface as a part of list
// 6. use lifo or fifo
// 7.  IMP  WAIT.. create an abstraction layer to hold the Stack
// 8 ABS layer is what gets used in your list.

// Stack interface defines abstract members that will be implemented by FIFO & LIFO
interface Stack{
    val arr:ArrayList<Int>
    abstract fun push(num: Int)
    abstract fun pop(): Int
    fun display() {
        println(arr)
    }
}

class Fifo(override val arr: ArrayList<Int>): Stack //  1 2 3 4 5 6 7 8 9 10
{
    override fun push(num: Int) {
        if(arr.size == 0)
            arr.add(num)
        else {
            arr.add(arr.get(arr.size - 1))
            for (i in (arr.size - 2) downTo 1) {
                arr[i] = arr[i - 1]
            }
            arr[0] = num
        }
    }

    override fun pop(): Int {
        var popval = -1
        when(arr.size) {
            0 -> println("Empty")
            1 -> {
                popval = arr.get(0)
                arr.removeAt(0)
            }
            else -> {
                popval = arr.get(0)
                for (i in 0 .. (arr.size-2)) {
                    arr[i] = arr[i+1]
                }
                arr.removeAt(arr.size-1)
            }
        }
        return popval
    }
}

class Lifo(override val arr: ArrayList<Int>) : Stack  // 10 9 8 7  6  5  4 3 2 1
{
    override fun push(num: Int) {
        arr.add(num)
    }

    override fun pop(): Int {
        var popval = -1
        when(arr.size) {
            0 -> println("Empty")
            1 -> {
                popval = arr.get(0)
                arr.removeAt(0)
            }
            else -> {
                popval = arr.get(0)
                for (i in 0 .. (arr.size-2)) {
                    arr[i] = arr[i+1]
                }
                arr.removeAt(arr.size-1)
            }
        }
        return popval
    }
}


// Abstract class will take object of Stack interface and use its push and pop methods
abstract class StackAbstraction() {
    abstract var stack: Stack
    fun push(num: Int) {
        stack.push(num)
    }
    fun pop() {
        stack.pop()
    }
}

// List implements abstract class
class List(override var stack: Stack) : StackAbstraction() {

    // Bridge..
    //  Stack stk ;
    // stk = lifo()  -> Bad practice..
    // iterator..   forward, reverse
    // its own algo which usses Lifo or fifo..
    fun add(num: Int) {
        stack.push(num)
    }

    fun remove() {
        stack.pop()
    }

    fun display() {
        stack.display()
    }
}

