package ParticipantsCode

//SELECT column_list FROM table;

//class select(val Select :String){
//    infix fun FROM (table: List<Int>){
//        println(" $Select column_List FROM $table")
//    }
//}
//
//infix fun String.column_list(function: select.() ->Unit){
//    println("called the column_list")
//    select(this).function()// this will appear in the lambda of main class
//    }
//
//fun main(){
//
//    "SELECT" column_list {
//        FROM (listOf(1,2))
//    }
//
//
//}

// extention function taking string as an input and calling class select from that function to get the desire output

//SELECT * FROM table_name;

//
//class select(var star: String){
//    infix fun FROM (table: String){
//        println(" Select $star FROM $table")
//    }
//}
//
//infix fun String.Select(function: select.() ->Unit){
//    println("called the Select")
////    select(this).function()// this will appear in the lambda of main class
//    var sel=select(this)
//    sel.function()
//}
//
//fun main(){
//println("input table name:")
//    var table_name= readln()
//
//    "*" Select  {
//        FROM  (table_name)
//    }
//
//
//}

//could not able to achieve the exact SELECT * FROM table_name; i have created "*" SELECT FROM table_name;



///////////////////////////////////////////////////////////////////////////////////////////////////
//SELECT * FROM table_name;
// *   table_name   (INPUTS expected from you )
//class Select(var star: String){
//    infix fun FROM (table: String){
//        println(" Select $star FROM $table")
//    }
//}
//
//infix fun String.Select(function: Select.() ->Unit){
//    println("called the Select")
////    select(this).function()// this will appear in the lambda of main class
//    var sel=Select(this)
//    sel.function()
//}
//
//fun main() {
//    println("input table name:")
//    var table_name = readln()
//    println("enter what you want as output")
//    var out=readln()
//
//    "${out}" Select {
//        FROM (table_name)
//    }
//}


///sending the output in string is the only way to achieve that

//////////
//import sun.util.calendar.BaseCalendar
//import java.time.LocalDate
//import java.time.LocalDateTime
//import java.util.*
//import kotlin.time.Duration.Companion.days

/*
    // 1st assignment.. Got it almost..
    display { date in startDate..endDate step 7 }
*/
//display { date in startDate..endDate step 7 }
// class
//class display (var display: String) {
//
//
////    println(startDate)
////    println(endDate)
////    println(startDate.dayOfWeek)
//    infix fun _in(prog: IntProgression) {
//    var start_day = LocalDateTime.now().toLocalDate().dayOfWeek // holds the day of the week like tuesday
//    var next_date = LocalDateTime.now().toLocalDate() // holds the date
//
//
//    for (i in prog.first..prog.last step prog.step) {
//        println("$display today is $start_day date $next_date and next $start_day  is on ${next_date.plusDays(prog.step.toLong())}")
//        next_date=next_date.plusDays(prog.step.toLong())
//    }
//}
//// i have used the for loop to travel from start date and end date to get the desire output
//   // every time i increase the date by step to show the desire output...
//}
//
//// function literals with receiver
//infix fun String.date( first: display.() -> Unit) {
//    val dateGap = display( this)
//    dateGap.first()
//}
//
//fun main() {
////    val startDate = LocalDateTime.now().toLocalDate()
////    val endDate = LocalDateTime.now().toLocalDate().plusDays(124)
////    println(startDate)
////    println(endDate)
////    println(startDate.dayOfWeek)
//    val startDate = LocalDateTime.now().toLocalDate().dayOfYear
//    val endDate = LocalDateTime.now().toLocalDate().plusDays(50).dayOfYear
//    "display" date {_in (startDate..endDate step 7 )}
//
//}
// i have taken the dayofyear so that i can show the dates of the next month also


/*
    // 1st assignment.. Got it almost..
    display { date in startDate..endDate step 7 }
*/
//display { date in startDate..endDate step 7 }
// class
