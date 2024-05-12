package Lazy
class  _Demo{
    // can this be a shared memory *  NO...
    var count = 0 ;
    val MyName: String by lazy{

        println("At LAzy declaration....${count++}")
        "By Sathya"
    }

//
//    val MyName: String =
//        "By Sathya"


}


fun main(){
    var obj =  _Demo()
    var obj2 = _Demo()

    println(obj.MyName)
    println("  ${obj.MyName}")
    println("  ${obj.MyName}")

    println("  ${obj2.MyName}")
    println("  ${obj2.MyName}")
    println("  ${obj2.MyName}")

}
/*
At LAzy declaration....0
By Sathya
  By Sathya
  By Sathya
At LAzy declaration....0
  By Sathya
  By Sathya
  By Sathya
 */