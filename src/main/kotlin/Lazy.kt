
class  Demo{

   //  O( 1 ) o( n )

    // can this be a shared memory *  NO...

    val MyName: String by lazy{
        println("At LAzy declaration....")
        "By Sathya"
    }

//
//    val MyName: String =
//        "By Sathya"


}


fun main(){
    var obj =  Demo()
    var obj2 = Demo()

    println(obj.MyName)
    println("  ${obj.MyName}")
    println("  ${obj.MyName}")

    println("  ${obj2.MyName}")
    println("  ${obj2.MyName}")
    println("  ${obj2.MyName}")







}