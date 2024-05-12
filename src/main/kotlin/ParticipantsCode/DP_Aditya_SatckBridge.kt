/*


// Implement FIFO using  Bridge concept
//
// if (ConnectivityManager.EXTRA_NO_CONNECTIVITY != intent!!.action)
interface myStack
{
    var STACK: stack
    fun push(int :Int)
    fun pop():Int
    fun isEmpty():Boolean
}

class StackFIFO(override var STACK: stack):myStack
{
    override fun push(int: Int) {
        STACK.push(int)
    }

    override fun pop(): Int {
        return STACK.pop()
    }

    override fun isEmpty(): Boolean {
        return STACK.isEmpty()
    }

}
// Till here myStack
fun main() {
    var arrAr=Array<Int>(8){
            it -> 0
    }
    var arguArr = stackArr(arrAr,0)    //stackArr obj. is created and argument is the integer Array and pointer to the

    var Obj_ARRAY= StackFIFO(arguArr)
    Obj_ARRAY.push(10)
    Obj_ARRAY.push(11)
    Obj_ARRAY.push(20)
    Obj_ARRAY.push(26)
    Obj_ARRAY.push(12)
    Obj_ARRAY.push(18)
    Obj_ARRAY.push(99)
    Obj_ARRAY.push(38)
    var arrAr2=Array<Int>(8)  {it->0}           // again making an array
    var arguArr2=stackArr(arrAr2,0)
    var Obj_ARRAY2=StackFIFO(arguArr2)
    while (!Obj_ARRAY.isEmpty())             //In this while loop we are popping values from Obj_ARRAY(First stack) and pushing it
    {                                     // to Obj_ARRAY2(Second Stack) so using Stack we are able to implement FIFO structure
        var argForObj_ARRAY2=Obj_ARRAY.pop()
        Obj_ARRAY2.push(argForObj_ARRAY2)
    }
    println("STACK Array :")
    while (!Obj_ARRAY2.isEmpty())
    {
        println(Obj_ARRAY2.pop())               //Displaying the result
    }
    //*****List Part******
    println("STACK List:")
    var listNew= MutableList<Int>(0) { it->0 }
    var arguList=stackList(listNew)             //A List of size 0 and default value 0 is passed to stackList as Argument
    var Obj_LIST=StackFIFO(arguList)              //StackFIFO class accepts stackList object as it overrides the reference(Bridge) to stack interface
    Obj_LIST.push(40)
    Obj_LIST.push(23)
    Obj_LIST.push(7)
    Obj_LIST.push(9)
    Obj_LIST.push(8)
    Obj_LIST.push(14)
    Obj_LIST.push(19)
    Obj_LIST.push(18)
    var listNew2= MutableList<Int>(0) { it->0 }  //Again we are making a new List
    var arguList2=stackList(listNew2)                // and passing it as argument to stackList (again)
    var Obj_LIST2=StackFIFO(arguList2)
    while (!Obj_LIST.isEmpty())                        //In this while loop we are popping values from Obj_LIST(First stack) and pushing it
    {                                                 // to Obj_LIST2(Second Stack), so using Stack we are able to implement FIFO structure
        var argForObj_LIST2=Obj_LIST.pop()
        Obj_LIST2.push(argForObj_LIST2)
    }
    while (!Obj_LIST2.isEmpty())
    {
        println(Obj_LIST2.pop())                        //Displaying the Result
    }
}
// Till here main
//interface layer creating
interface stack
{
    fun push(num: Int)
    fun pop():Int
    fun top():Int
    fun isEmpty():Boolean
    fun isFull():Boolean
}
// class stack_Array implements stack interface
class stackArr( arr : Array<Int>,pointer: Int):stack         //it gets array reference and pointer value arguments from main()
{
    var arr :Array<Int>
    var pointer:Int
    init{
        this.arr=arr
        this.pointer=pointer
    }
    override fun push(num: Int) {
        arr[pointer++]=num
    }

    override fun pop(): Int {
        var lastElement: Int=arr[--pointer]
        return lastElement
    }

    override fun top(): Int {
        return arr[pointer-1]
    }

    override fun isEmpty(): Boolean {
        return pointer==0
    }

    override fun isFull(): Boolean {
        return pointer==arr.size
    }

}
// stackList class implements stack interface
class stackList(list: MutableList<Int>):stack            // class stackList get its argument i.e. a list from main()
{
    var list: MutableList<Int>
    init {
        this.list=list
    }
    override fun push(num: Int) {
        list.add(num)
    }

    override fun pop(): Int {
        return list.removeLast()
    }

    override fun top(): Int {
        return  list.last()
    }

    override fun isEmpty(): Boolean {
        return list.size==0
    }

    override fun isFull(): Boolean {
        return false
    }

}


*/


 */
