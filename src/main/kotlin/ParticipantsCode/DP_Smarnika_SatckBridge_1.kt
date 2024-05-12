package ParticipantsCode

// Works good


interface IStack11{
    fun push(element:Int)
    fun pop()    :Int?
    fun top()    :Int?
    fun IsEmpty():Boolean
    fun IsFull() :Boolean
    fun size()   :Int
}
class ArrayStack11(size:Int):IStack11{

    private var stackSize = size;
    private var stackArr  = IntArray(stackSize);
    private var top = -1;

    override fun push(entry: Int) {
        if (this.IsFull()) {
            throw Exception("Stack is full. Can not add another element.")
        }
        top += 1
        this.stackArr[top] = entry
    }

    override fun pop(): Int {
        if (this.IsEmpty()) {
            throw Exception("Stack is empty. Can not remove element.")
        }
        var entry = this.stackArr[top--]
        return entry
    }

    override fun size(): Int {
        return top+1
    }
    override fun top(): Int {
        return stackArr[top]
    }
    override fun IsEmpty(): Boolean {
        return top === -1
    }
    override fun IsFull(): Boolean {
        return top === stackSize
    }
}

class ListStack11:IStack11{
    val elements: MutableList<Int> = mutableListOf()

    override fun IsEmpty():Boolean = elements.isEmpty()

    override fun size():Int { return elements.size}

    override fun push(item: Int){
        elements.add(item)
    }

    override fun pop(): Int? {
        val item = elements.lastOrNull()
        if (!IsEmpty()){
            elements.removeAt(elements.size -1)
        }
        return item
    }


    override fun IsFull(): Boolean {
        return true
    }

    override fun top() : Int? {
        return elements.lastOrNull()
    }

    override fun toString(): String {
        return elements.toString()
    }
}

interface Stack11{
    var impl : IStack11
    fun push(i:Int) {
        impl.push(i)
    }
    fun pop()    :Int? {
        return impl.pop()
    }
    fun top()    :Int? {
        return impl.top()
    }
    fun IsEmpty(): Boolean{
        return impl.IsEmpty()
    }
    fun IsFull() :Boolean {
        return impl.IsFull()
    }
}

class StackFifo11(override var impl: IStack11):Stack11 {
    private var fifoArray = mutableListOf<Int>();
    fun Push() {
        print("the elements of the stack :")
        for (i in 1..impl.size()) {
            print("${impl.top()} ")
            fifoArray.add(pop()!!)
        }
        println()
    }

    fun Pop(){
        for (i in 0..fifoArray.size-1){
            push(fifoArray[i])
        }
        println()
    }

    fun show(){
        print("the elements in fifo order is :")
        for (i in 1..impl.size()) {
            print("${impl.top()} ")
            impl.pop()
        }
        println()
    }
}


fun main(args: Array<String>) {
    var stacklist  = StackFifo11( ArrayStack11(15))
    println("No of element you want to enter : ")
    var noElem = Integer.valueOf(readLine())
    println("Enter your elements : ")
    for (i in 0..noElem-1){
        var element = Integer.valueOf(readLine())
        stacklist.push(element)
    }
    stacklist.Push()
    stacklist.Pop()
    stacklist.show()
}