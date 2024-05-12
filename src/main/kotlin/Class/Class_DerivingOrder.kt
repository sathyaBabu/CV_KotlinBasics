package Class

open class MyBase {   // Vtable c++
    init{
        println("I am in Base class")
    }
}
open class MyChild: MyBase() {
    init{
        println("I am in Child class")
    }
}
class GrandChild: MyChild() {
    init{
        println("I am in Grand Child class")
    }
}
fun main(args: Array<String>) {
    var a = GrandChild()

}

/*
I am in Base class
I am in Child class
I am in Grand Child class

 */