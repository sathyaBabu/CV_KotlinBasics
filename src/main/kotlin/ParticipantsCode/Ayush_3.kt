//package ParticipantsCode
//package Assignments
//
//abstract  class  Stack1(){
//
//    abstract fun  push( data:Double )
//    abstract fun  pop( ):Double
//    abstract fun  isEmpty( ):Boolean
//    abstract fun  size(  ):Int
//}
//
//class StackUse1 : Stack(){
//    var stack= mutableListOf<Double>()
//    override fun push(data: Double) {
//        stack.add(data) }
//    override fun pop(): Double {
//        return stack.removeLast() }
//    override fun isEmpty(): Boolean {
//        return stack.isEmpty() }
//    override  fun  size(  ):Int{
//        return stack.size }
//    fun display() {
//        println("the element is stack are: $stack") }
//}
//
//fun main()
//{
//
//    val stack = StackUse1()
//    println("check is the stack isempty :  ${stack.isEmpty()}")
//    stack.push(10.02)
//    stack.push(95.36)
//    stack.push(20.22)
//    println("popped value is ${stack.pop()}")
//    stack.push(12.12)
//    println("the size of the stack : ${stack.size()}")
//    println(stack.display())
//    println("popped value is ${stack.pop()}")
//    println("check is the stack isempty : ${stack.isEmpty()}")
//
//}