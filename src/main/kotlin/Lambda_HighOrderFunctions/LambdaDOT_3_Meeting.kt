package Lambda_HighOrderFunctions

//import DSL.Meeting

// 2
class Meeting(val  name_ : String){
    // 3

    val starts = this

    infix fun at( time: Double){

        println("$name_ meeting starts at $time")
    }

}

// 1
//fun String.meeting(function: () -> Unit): Meeting{
// 1.a
// infix fun String.meeting(block: () -> Unit): Meeting{
// step 3
//infix fun String.meeting(block: Meeting. () -> Unit): Meeting{
//    return Meeting( this)
//}

// step 4                     ( this(String)      )    returns this:Meeting
infix fun String.meeting(block: Meeting. () -> Unit) {
     Meeting(this).block()   // this is String( Vendor)
// Meeting( this ) context object calls the .block() that is  {  } of   "Vendor" meeting {
}
fun main(){
    // Goal

//    "Planing" .meeting {
//       this at 10.30
//       start at 10.30
//    }

  //  println( (10..30).javaClass)  // class kotlin.ranges.IntRange

    // 1  "Planing" .meeting {
    // 1.a  remove the dot : NOTE add infix to infix fun String.Meting(



        "Vendor" meeting {

            // step 3 add following line
             this at 10.30
            // starts (is a current object )
    }

}



// Vendor meeting  starts at 10..30