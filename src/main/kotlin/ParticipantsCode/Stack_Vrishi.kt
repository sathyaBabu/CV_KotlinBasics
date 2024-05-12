package ParticipantsCode
//
//interface Stack {
//    fun push(value: Int)
//    fun pop(): Int
//    fun isTop(value: Int): Boolean
//    fun hasNext(): Boolean
//}
//interface List<T> {
//    abstract val size: Any
//
//    fun addData(value: Int)
//    fun removeData(value: Int)
//    fun reverseQueue()
//    fun showData()
//}
//fun main() {
//    ListClass().call()
//}
//fun takeInput(outputMessage: String): String? {
//    println(outputMessage)
//    return readLine()
//}
//class ListClass() : List<Any?> {
//    private val queueOfData = FifoLifo(true)
//    private val stackOfData = FifoLifo(false)
//    fun call() {
//        println("Choose an option 1 for insert, 2 for remove - value , 3 show data , 4 to exit")
//        when (readLine()) {
//            "1" -> {
//                addData(takeInput("Enter integer value  you want to add")!!.toInt())
//                call()
//            }
//            "2" -> {
//                removeData(takeInput("Enter integer value you want to remove")!!.toInt())
//                call()
//            }
//            "3" -> {
//                showData()
//                call()
//            }
//            else -> return
//        }
//    }
//    override fun addData(value: Int) {
//        queueOfData.push(value)
//    }
//    override fun removeData(value: Int) {
//        while (queueOfData.hasNext()) {
//            if (!queueOfData.isTop(value)) {
//                stackOfData.push(queueOfData.pop())
//            } else {
//                queueOfData.pop()
//            }
//        }
//        while (stackOfData.hasNext()) {
//            queueOfData.push(stackOfData.pop())
//        }
//        reverseQueue()
//    }
//    override fun reverseQueue() {
//        while (queueOfData.hasNext()) {
//            stackOfData.push(queueOfData.pop())
//        }
//        while (stackOfData.hasNext()) {
//            queueOfData.push(stackOfData.pop())
//        }
//    }
//    override fun showData() {
//        println("${queueOfData.queueStack.toList()}")
//    }
//}
//class FifoLifo(var isQueue: Boolean) : Stack {
//    var queueStack: MutableList<Int> = mutableListOf()
//    override fun push(value: Int) {
//        queueStack.add(value)
//    }
//    override fun isTop(value: Int): Boolean {
//        return if (queueStack.isNotEmpty()) if (isQueue) queueStack.first() == value else queueStack.last() == value else false
//    }
//    override fun hasNext(): Boolean {
//        return queueStack.isNotEmpty()
//    }
//    override fun pop(): Int {
//        val value = if (isQueue) queueStack.first() else queueStack.last()
//        if (isQueue) queueStack.removeAt(0) else queueStack.removeAt(queueStack.size - 1)
//        return value
//    }
//}