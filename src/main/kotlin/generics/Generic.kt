package generics

data class Address_Class(val street: String,
                         val number: Int,
                         val city: String)


//  generic is also called as template in other languages

class genericsExample<  T >( input: T){
    // in
    init{
        println("I'm getting called with a  IN  value $input")
    }
}

/*
inline fun <reified T> genericsExample(value: T) {
    println(value)
    println("Type of T: ${T::class.java}")
}
 */
///classType: Class<T>, value: T

//class  genericClassAddress< T >(classType: Address_Class){
class  genericClassAddress< T >(classType: Class<T>){

    inline fun <reified T> genericsExample(value: T) {
        println(" I'm getting called at Address. .... ${value.toString()}")
       // classType.let { it.city }
    }

}

class genericsExample1<  T >( input: T){
    // in
    init{
        println("I'm getting called with out value $input")
    }
}

fun callTypeOUT(){
// using OUT

    var obj1 = genericsExample1<Int>( 33)
    var obj2 = genericsExample1<Double>( 34.123)
    println(obj1)
    println(obj2)

}

fun main()
{
    // setters will call In as default
    var object1 = genericsExample<String>("Kotlin")
    var object2 = genericsExample<Int>(200)

    var addr = Address_Class("CMH St ",34,"Bangalore")
//   var address = genericClassAddress<Address_Class>( Address_Class::class.java)
//    address.genericsExample( addr)

    //println(address)

    // getters  will call OUT as default

    callTypeOUT()


}