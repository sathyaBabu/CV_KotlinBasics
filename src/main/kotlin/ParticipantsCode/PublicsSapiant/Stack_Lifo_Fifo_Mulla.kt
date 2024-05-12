package ParticipantsCode



//bridge
//interface Stack
interface Stack {
    fun push(input: Any)
    fun pop()
    fun display() : MutableList<Any>
    val isEmpty:Boolean
    val isFull:Boolean
}

//Abstraction layer
abstract class IStack(private val stackContainer:MutableList<Any> = mutableListOf()):Stack {
    override fun push(input: Any) {
        stackContainer.add(input)
    }
    override fun pop() {
        stackContainer.removeLast()
    }
    override fun display(): MutableList<Any> {
        return stackContainer
    }
    override val isEmpty: Boolean = stackContainer.isEmpty()

    override val isFull: Boolean = stackContainer.isNotEmpty()
}

class LIFO(private val lifoStackContainer:MutableList<Any> = mutableListOf()):IStack(){
    override fun push(input: Any) {
        lifoStackContainer.add(input)
        println("Pushed Element $input -> $lifoStackContainer")
    }

    override fun pop() {
        println("Element popped -> ${lifoStackContainer.indexOf(lifoStackContainer.size -1 )}")
        lifoStackContainer.removeLast()
    }

    override fun display(): MutableList<Any> {
        lifoStackContainer.reverse()
        return lifoStackContainer
    }

    override val isEmpty = lifoStackContainer.isEmpty()

    override val isFull = lifoStackContainer.isNotEmpty()
}

class FIFO(private val fifoStackContainer:MutableList<Any> = mutableListOf()):IStack(){
    override fun push(input: Any) {
        fifoStackContainer.add(input)
        println("Pushed Element $input -> $fifoStackContainer")
    }
    override fun pop() {
        println("Element popped -> ${fifoStackContainer.removeFirst()}")
    }

    override fun display(): MutableList<Any> {
        return fifoStackContainer
    }

    override val isEmpty = fifoStackContainer.isEmpty()
    override val isFull = fifoStackContainer.isNotEmpty()
}

fun main() {
    val lifo = LIFO()
    lifo.push(1)
    lifo.push(2)
    lifo.push(3)
    lifo.push(4)
    lifo.push(5)
    lifo.pop()
    println(lifo.display())

    val fifo= FIFO()
    fifo.push(10)
    fifo.push(9)
    fifo.push(8)
    fifo.push(7)
    fifo.push(6)
    fifo.pop()
    println(fifo.display())

}
/*
Pushed Element 1 -> [1]
Pushed Element 2 -> [1, 2]
Pushed Element 3 -> [1, 2, 3]
Pushed Element 4 -> [1, 2, 3, 4]
Pushed Element 5 -> [1, 2, 3, 4, 5]
Element popped -> 3
[4, 3, 2, 1]
Pushed Element 10 -> [10]
Pushed Element 9 -> [10, 9]
Pushed Element 8 -> [10, 9, 8]
Pushed Element 7 -> [10, 9, 8, 7]
Pushed Element 6 -> [10, 9, 8, 7, 6]
Element popped -> 10
[9, 8, 7, 6]
 */