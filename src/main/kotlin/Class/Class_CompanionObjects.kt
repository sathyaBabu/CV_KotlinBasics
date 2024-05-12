package Class


// bring in this insted of static

class MasterClass {
    // can also be treated s helper class
    // we are trying to bring a static in Kotlin
    // Static is not a part of kotlin
    // companion object  represents static in kotlin
    // companion is a must

      companion object StaticKindTest {
        var someInteger: Int = 10
        fun callMe() = println("You are calling me :)")
    }
}
fun main(args: Array<String>) {


    val a = MasterClass()
   // a.   **** Static functions are not exposed to object a

    // Static has to be used even before constructing a class


    MasterClass.callMe()

    MasterClass.callMe()         // You are calling me :)  Loks on the lines of calling a static function
    MasterClass.someInteger = 112 ;
    println(MasterClass.someInteger)  // 112
}

