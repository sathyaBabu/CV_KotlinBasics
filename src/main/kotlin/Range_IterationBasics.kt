import java.util.*


fun main()
{
    println("Iteration")
    Iteration()
    secondIteration() // kotlin Way!!
    thirdIteration()
    println( dayOfTheWeek())  // Monday
    println("Day of the Week : ${dayOfTheWeek_2()}" )   // Day of the Week : monday
}
//  array list set maps

fun dayOfTheWeek_2(): String {
    var weekDay = ""

    val c = Calendar.getInstance()
    val dayOfWeek = c[Calendar.DAY_OF_WEEK]

    if (Calendar.MONDAY == dayOfWeek) {
        weekDay = "monday"
    } else if (Calendar.TUESDAY == dayOfWeek) {
        weekDay = "tuesday"
    } else if (Calendar.WEDNESDAY == dayOfWeek) {
        weekDay = "wednesday"
    } else if (Calendar.THURSDAY == dayOfWeek) {
        weekDay = "thursday"
    } else if (Calendar.FRIDAY == dayOfWeek) {
        weekDay = "friday"
    } else if (Calendar.SATURDAY == dayOfWeek) {
        weekDay = "saturday"
    } else if (Calendar.SUNDAY == dayOfWeek) {
        weekDay = "sunday"
    }
       return  weekDay ;
   // println(weekDay)

}
fun dayOfTheWeek()  : String{

    var daysArray =  listOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")

    var calendar = Calendar.getInstance()   //  class.Function()  : fun hast to be a static function
                                            // We do not have a static function in Kotlin
    var day      = calendar.get( Calendar.DAY_OF_WEEK)



    println(day-1)
    return  daysArray[ day - 1 ]

}

fun thirdIteration() {

    // Range iteration..

    var SUNDAY:Int    = 0 ;
    var SATURDAY:Int = 6 ;

    val days = SUNDAY..SATURDAY    // inTRange --> iterator

    val i = days.iterator()

    while( i.hasNext()) {
        val j = i.next()
        println("Day : ${j}")
    }


}

fun secondIteration() {
//    IntProgression
//    CharProgression
//    LongProgression

    // progression has iterator ingrined into it..

    var progression: IntProgression = IntProgression.fromClosedRange(1,3,1)

    var first = progression.first
    var last  = progression.last
    var step  = progression.step

    if( step > 0 ){
        if( step > last ) {
            return
           }
        } else if ( first < last){
            return
        }


          while ( true){
              print("__ $first");
              if( first == last ){
                  return
              }
              first += step ;
          }
    }



fun Iteration() {

    var i = 1;
    var end = 3
    if (i <= end) {
        while (true) {
            print("-- $i")
            if (i == end) {
                break;
            }
            ++i;
        }
    }
}
