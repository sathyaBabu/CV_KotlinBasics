package FS_Let_It_Run_applay_also

// function scope also_Let_it_run_with_apply
// Without the above scope our code will not be consice and it will be difficult to manage


// Just  king of POJO  class whicg stores the data for you
data class Person( var name : String="Zombi" , var age: Int=20 , var city:String="Dark Sky"){
//    fun moveTO( newCity :String) { city = newCity}
//    fun incrementAge() { age++ }
}

fun main(){

    var student: Person = Person()


    // student.SetName( name )  // getters and settrs used to come into the picture

    student.name =" Manas"
    student.age = 21
    student.city = "Delhi"

    // this points to the entire class

    val studentApply =  student.apply {

       name = "Shruti"
        age = 23
        city = "USA"

    }
    println("Apply rerurned $studentApply")

    // let it : takes only a single value it

/*
       The type String is non-nullable by default. Therefore,
       you cannot directly assign a null value to a variable of type String.
       If you want to allow a null value for the variable,
       you need to use the nullable type String? instead.
 */
//    var str : String = null
    var str : String? = null
    // if the above statement is null let will not let you pass through the below statement
    str?.let { println("did we fall in  $it!!") }  // no


    var check = student.let {


        it.name = "Akshay"
        it.age = 21
        it.city = "Ooty"

        println(it.name)
        println(it.age)
        println(it.city)
//
       "this expression shall be returned as a last paramater...."

    }

    println("$check")

// val retType =
       student.run {
           name = "Suraj"
           age = 21
           city = "WB"
       }

   // println("$retType")  // run cannot return the objects data back
    // apply

    // also deals with it

    val numbersList : MutableList<Int> = mutableListOf(1,2,3)
    println("Original numbers $numbersList")

    val duplicateNumbersAfterAlso = numbersList.also {

        println("The listt of element under also $it ")
        it.add(4)
        println("The listt of element under also after adding a number $it ")

        it.remove(2)
        println("The listt of element after removing  a number $it ")

    }


//  is used to change instance properties without
//  the need to call dot operator over the reference every time.

    with(student)
    {
        name = "Zombi"
        age  =  21
        city = "Delhi"
    }
    println("With : $student")



}