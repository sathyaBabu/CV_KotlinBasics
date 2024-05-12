package day7
//
//import ProjectWithDesignPatterns.MenuItem
import java.util.*
import kotlin.collections.ArrayList

//open class stack{
//   // intArray( 10 )  // 11 Array out of bound
//
//    fun push( x: Int)
//    fun pop()
//
//}
//class BugFix : stack(){
//
//    if( x > 10) : stop
//       elkse push( i )
//
//}
// How will you post the sasme on to composition???
// add mutableList...

// Stack with fixed array of size 3 and no checks for overflow or underflow
open class StackInheritance {
    val arr: IntArray = IntArray(3)
    var index: Int = 0

    open fun push(x: Int) {
        arr.set(index, x)
        index++
    }

    open fun pop(): Int {
        var popval: Int = arr[index-1]
        arr[index-1] = 0
        index--
        return popval
    }

    open fun display() {
        println(arr.contentToString())
    }
}

// Inherits stack and implements checks for overflow and underflow
class Bugfix1Inheritance: StackInheritance() {

    override fun push(x: Int) {
        if(index >= arr.size)
            println("Stack overflow")
        else {
            super.push(x)
        }
    }

    override fun pop(): Int {
        var popval: Int = -1
        if(index == 0)
            println("Stack underflow")
        else {
            popval = super.pop()
        }
        return popval
    }
}

// Inherits stack and implements a mutableList to handle overflow
class Bugfix2Inheritance: StackInheritance() {
    val arrExtra: ArrayList<Int> = mutableListOf<Int>() as ArrayList<Int>

    override fun push(x: Int) {
        if(index >= arr.size) {
            arrExtra.add(x)
            index++
        }
        else {
            super.push(x)
        }
    }

    override fun pop(): Int {
        var popval: Int = -1
        if(index == 0)
            println("Stack underflow")
        else if(index > arr.size) {
            popval = arrExtra.removeLast()
            index--
        }
        else {
            popval = super.pop()
        }
        return popval
    }

    override fun display() {
        println("${arr.contentToString()} ${arrExtra.toArray().contentToString()}")
    }
}

interface StackComposite {
    fun push(x: Int)
    fun pop()
    fun display()
}

// Complex node that has list of children and calls children at each function's implementation
class StackComplex: StackComposite {
    private var children: MutableList<StackComposite> = ArrayList<StackComposite>()

    fun add(child: StackComposite) {
        children.add(child)
    }

    fun remove(child: StackComposite) {
        children.remove(child)
    }

    fun getChildren(): MutableList<StackComposite> {
        return children
    }

    override fun push(x: Int) {
        for(child in children)
            child.push(x)
    }

    override fun pop() {
        for(child in children)
            child.pop()
    }

    override fun display() {
        for(child in children)
            child.display()
    }

}

// Leaf node with fixed array of size 3 and no checks for overflow or underflow
class StackLeaf: StackComposite {
    val arr: IntArray = IntArray(3)
    var index: Int = 0

    override fun push(x: Int) {
        arr.set(index, x)
        index++
    }

    override fun pop() {
        arr[index-1] = 0
        index--
    }

    override fun display() {
        println(arr.contentToString())
    }
}

// Leaf node with fixed array of size 3 and checks for overflow and underflow
class Bugfix1Leaf: StackComposite {
    val arr: IntArray = IntArray(3)
    var index: Int = 0

    override fun push(x: Int) {
        if(index >= arr.size)
            println("Stack overflow")
        else {
            arr.set(index, x)
            index++
        }
    }

    override fun pop() {
        if(index == 0)
            println("Stack underflow")
        else {
            arr[index-1] = 0
            index--
        }
    }

    override fun display() {
        println(arr.contentToString())
    }
}

// Leaf node with mutableList to handle overflow
class Bugfix2Leaf: StackComposite {
    val arr: ArrayList<Int> = mutableListOf<Int>() as ArrayList<Int>
    var index: Int = 0

    override fun push(x: Int) {
        arr.add(x)
        index++
    }

    override fun pop() {
        if(index == 0)
            println("Stack underflow")
        else {
            arr.removeLast()
            index--
        }
    }

    override fun display() {
        println(arr.toArray().contentToString())
    }
}

fun main() {
    val stackInheritance: StackInheritance = Bugfix2Inheritance()
    // Run Stack implementations using Inheritance
    for(num in 1 .. 10) {
        stackInheritance.push(num)
    }
    stackInheritance.display()
    for(num in 1 .. 8) {
        stackInheritance.pop()
    }
    stackInheritance.display()
    println("-*-".repeat(50))

    //Create complex stack object as well as required leaf object and add leaf to complex object
    val stackComplex = StackComplex()
    val stackLeaf= Bugfix2Leaf()
//    val stackLeaf2 = Bugfix1Leaf()
    stackComplex.add(stackLeaf)
//    stackComplex.add(stackLeaf2)
    // Run Stack implementations using Composition
    for(num in 1 .. 10) {
        stackComplex.push(num)
    }
    stackComplex.display()
    for(num in 1 .. 8) {
        stackComplex.pop()
    }
    stackComplex.display()
}