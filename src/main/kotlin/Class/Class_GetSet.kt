package Class

import java.lang.IllegalArgumentException
import java.util.*

class Registration( email : String , pwd : String , age : Int, gender: Char){

    var email_id : String = email

    get(){
        return field.lowercase(Locale.getDefault() )
    }
    var passWord : String = pwd
    set( value ){
        field = if( value.length > 6 ) value else throw IllegalArgumentException("Pass word id too small")
    }
    var age : Int  = age
    set ( value){
        field = if(  value > 19 ) value else throw IllegalArgumentException("Age must be 20 Plus...")
    }

    var gender : Char = gender
        set ( value){
            field = if( value == 'M') value else throw IllegalArgumentException("Only for Male Members.")
        }




}

fun main(){
    val info = Registration("Aameer","aameer@123",29,'M')


    println(" email : ${info.email_id}")   // get()
    println(" PWD  : ${info.passWord}")
    println(" Age  : ${info.age}")
    println(" Gender : ${info.gender}")

   // info.passWord = "abc"   // set()
    ///info.age = 13
    info.gender ='F'


}