package ParticipantsCode

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

infix fun String.date( k: IntProgression){
    //IntProgression.fromClosedRange(k.first, k.last,k.step)
    println(" next monday is at ${k.first + k.step}")

}

//
//fun main(){
//    Calendar.getInstance()
//
//    "Display" date (Calendar.DAY_OF_MONTH..Calendar.DAY_OF_MONTH.plus(10) step 7)
//
//    println(Calendar.DAY_OF_MONTH)
//    println(Calendar.DAY_OF_MONTH.plus(10))
//}