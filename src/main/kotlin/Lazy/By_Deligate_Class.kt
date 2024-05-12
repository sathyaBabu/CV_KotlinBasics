package Lazy

interface MyInterface {
    val myValue: String
}
object MyDelegate: MyInterface {
    override val myValue = "value is provided by MyDelegate Override"
}

class MyClass: MyInterface by MyDelegate
fun main(){
    val myObject = MyClass()
    println(myObject.myValue)
}
