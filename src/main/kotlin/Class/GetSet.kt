package Class

import java.lang.IllegalArgumentException
import java.util.*

class Registration( email:String , pwd :String , age:Int, gender :Char){

    // field has the data
    // value takes the input
    // field = value

    // var i = 10  : or get it
    //     set()        get()

    var email_id : String = email
    // custom getter
    get() {
        // field
        return field.lowercase(Locale.getDefault())  //  email sandeep@gmail.com  Depricated
    }
    var password : String = pwd
    set( value ) {   // value comes in when we set thee data type
        //  look t the brighter side of getter and setter
        // It can validate the data..

        field = if( value.length > 6 )  value else throw IllegalArgumentException("Pass word is toooo small.")
       // < 6 : java.lang.IllegalArgumentException: Pass word is toooo small.
    }

    var age:Int = age
    set(value){
        field = if( value > 19 )  value else throw IllegalArgumentException("Age must be 20 Yrs.")
    }

    var gender:Char = gender
        set(value){
            field = if( value == 'M')  value else throw IllegalArgumentException("Only for Male members...")
        }

}

fun main(){

  //  auto info = Registration() // deducing the type c++11 >

    val info = Registration("Sandeep@gmail.com","cool@123",39,'M')
    // getters and setters has to take over here..!!!!

   // info.age = 13  // Age must be 20 Yrs.

    println(" email ${info.email_id}")   // get
    println(" PWD  ${info.password}")
    println(" Age  ${info.age}")
    println(" Gender  ${info.gender}")


    //********* set() here
    
//    info.password = "abc"// java.lang.IllegalArgumentException: Pass word is toooo small.
//     println(" PWD  ${info.password}")

   // info.age = 13   //  calls the setter...  java.lang.IllegalArgumentException: Age must be 20 Yrs.

   // info.gender = 'F'   // java.lang.IllegalArgumentException: Only for Male members...


}