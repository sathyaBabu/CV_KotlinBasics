package FS_Let_It_Run_applay_also


open class Man

open class Person_ : Man() {
    val age: Int = 31
}


fun main(){
   val per:Person_? = Person_()
  //  val man:Man? = Man()

 //  val x:Man = Person_()
    val x = per


    if (per is Person_) {
        println(per.age) // look, no cast needed to access Person_
    }
    val guy = x as? Person_
    println(" he is a : ${x?.age} person is age is  ${guy?.age} ")

    // Phase II

    val y :Any ="Sathya"

    val str = y as String

    if (y is String) {
        print(" Length of Sathya is ${str.length} also  ${y.length} ")
    }


}