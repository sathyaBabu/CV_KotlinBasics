package ParticipantsCode



//import sun.util.calendar.BaseCalendar
//import java.time.LocalDate
import java.time.LocalDateTime
//import java.util.*
//import kotlin.time.Duration.Companion.days

class _display (var display: String) {


    ////    println(startDate)
////    println(endDate)
////    println(startDate.dayOfWeek)
    infix fun _in(prog8: IntProgression) {
        var start_day = LocalDateTime.now().toLocalDate().dayOfWeek // holds the day of the week like tuesday
        var next_date = LocalDateTime.now().toLocalDate() // holds the date


        for (i in prog8.first..prog8.last  ) {   //  prog8.step  : check on this error
            println("$display today is $start_day date $next_date and next $start_day  is on ${next_date.plusDays(prog8.step.toLong())}")
            next_date=next_date.plusDays(prog8.step.toLong())
        }

    }
//// i have used the for loop to travel from start date and end date to get the desire output
//   // every time i increase the date by step to show the desire output...
}
//
//// function literals with receiver
infix fun String.date( first: _display.() -> Unit) {
    val dateGap = _display( this)
    dateGap.first()
}

fun main() {
//    val startDate = LocalDateTime.now().toLocalDate()
//    val endDate = LocalDateTime.now().toLocalDate().plusDays(124)

    val startDate11 = LocalDateTime.now().toLocalDate().dayOfYear
    val endDate11 = LocalDateTime.now().toLocalDate().plusDays(50).dayOfYear
    "display" date { _in ((startDate11..endDate11 step 7) as IntProgression)   }
//
}

/*
display today is WEDNESDAY date 2022-02-02 and next WEDNESDAY  is on 2022-02-09
display today is WEDNESDAY date 2022-02-09 and next WEDNESDAY  is on 2022-02-16
display today is WEDNESDAY date 2022-02-16 and next WEDNESDAY  is on 2022-02-23
display today is WEDNESDAY date 2022-02-23 and next WEDNESDAY  is on 2022-03-02
display today is WEDNESDAY date 2022-03-02 and next WEDNESDAY  is on 2022-03-09
display today is WEDNESDAY date 2022-03-09 and next WEDNESDAY  is on 2022-03-16
display today is WEDNESDAY date 2022-03-16 and next WEDNESDAY  is on 2022-03-23
display today is WEDNESDAY date 2022-03-23 and next WEDNESDAY  is on 2022-03-30
 */
