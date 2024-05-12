//@file:Suppress("DEPRECATION")
//
//import java.lang.IllegalArgumentException
//import java.util.*
//import java.util.Date
//
//class Date(){
//
//    //    val step = 7
//    val date = this
//    var s = 0
//
//    infix fun between( date_: IntRange ){
//        println("display date between ${date_.first} and ${date_.last} in $s : ")
//        for(i in date_ step s){
//            println(i)
//        }
//    }
//
//}
//
//fun display(  bloc: Date.() ->Unit     )   {
//    var date = Date()
//    bloc.invoke(date)
//
//}
//fun main(){
//    display{
//        this.s = 7
//        date between  1..50
//        // INtRage has step built into it
//        // intRangeProgression
//
//
//      //  MyFor( 1 in 1 until 10){  it -> DisplayData( it )  }
//
//
//    }
//}