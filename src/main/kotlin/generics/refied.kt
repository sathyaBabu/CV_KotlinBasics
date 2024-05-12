package generics

// Declaring Inline function
inline fun <reified T> myExample(name: T) {
    println("Name of your website -> "+name)
    println("Type of myClass: ${T::class.java}")  // Type of myClass: class java.lang.String
}

// Normal generic

class genericsExample_<T>(input:T) {
    init {
        println("I am getting called with the value "+input)
    }
}
fun main() {
// normal generic
    var objet = genericsExample_<String>("JAVA")
    var objet1 = genericsExample_<Int>(10)


    // reifid
    // calling func() with String
    myExample<String>("www.edureka.co")

    // calling func() with Int value
    myExample<Int>(100)

    // calling func() with Long value
    myExample<Long>(1L)

}
/*
I am getting called with the value JAVA
I am getting called with the value 10
Name of your website -> www.edureka.co
Type of myClass: class java.lang.String
Name of your website -> 100
Type of myClass: class java.lang.Integer
Name of your website -> 1
Type of myClass: class java.lang.Long

 */