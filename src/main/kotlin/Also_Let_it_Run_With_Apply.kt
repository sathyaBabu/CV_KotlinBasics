

data class  Person( var name : String = "Zombi", var age : Int =20 , var city :String = "Dark City"){
    fun moveTo( newCity:String) { city = newCity}
    fun incrementAge() { age++ }
}

fun main(){

    val student : Person = Person()

//    student.SetName( name )

    // get()
    student.name = "Mayank"
    student.age = 22
    student.city = " Delhi"



    val studentApply = student.apply {

        name = " Kalyani "
        age = 23
        city = "Bangalore"

    }
    println(" Aply returned $studentApply")


    // it will not allow the user to enter the block when the data type is null..

  var check = student.let {

      it.name = "mayank"
      it.age = 34
      it.city = "Ooty"
      println("Name : ${it.name}")
      " This expression shall be returned as a last paramater..."
  }

    println(" let returned $check")

    // run cannot return
     student.run {

        name = " Kalyani "
        age = 23
        city = "Bangalore"


    }


    // also deals with it

    val numberList : MutableList<Int> = mutableListOf(1,2,3)
    println(" Original numbers $numberList")

    val duplicateNumberListAlso = numberList.also {

        println("The list of elements under also $it")
        it.add( 4 )
        println(" After adding a number $it")
        it.remove(2)
        println(" After removinga number $it")


    }

}