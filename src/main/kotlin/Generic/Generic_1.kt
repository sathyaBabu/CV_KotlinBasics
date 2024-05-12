package Generic



class genericExample<   T  >( input : T){
//
//    class receicveAClass< T >  myClass;
//    class receicveAFun< T >    funObj;
//

    init {
        println("I'm getting called with n a value $input")
    }
}

fun  display() {

    //
    var obj1 = genericExample< Int,  >( 34 )
    var obj2 = genericExample<Double>( 34.44)
    println(obj1)
    println(obj2)
}


fun main()
{

     var object1 = genericExample< String >("Kotlin")
     var object2 = genericExample< Int >(200)

    println(object1)
    println(object2)
    display()

}