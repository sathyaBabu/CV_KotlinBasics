package FS_Let_It_Run_applay_also

fun main(){

    /*
    JAVA style
    if (str != null) {
        System.out.println(str);
    }*/

/*
       The type String is non-nullable by default. Therefore,
       you cannot directly assign a null value to a variable of type String.
       If you want to allow a null value for the variable,
       you need to use the nullable type String? instead.
 */
//    var str : String = null


    var str:String? = null //"Hello World"
    // if the above statement is null let will not let you pass through the below statement
    str?.let { println("$it!!") }
}