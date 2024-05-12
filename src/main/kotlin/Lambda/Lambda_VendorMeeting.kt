package Lambda

class ReleaseMeeting( val title: String){

    val Starts = this     // Passing Instance of the string..
    val Ends   = this

    var startTime : String = ""
    var endTime   : String = ""


    private fun convertToString( time : Double ) = String.format("%.02f",time)

            infix fun at( time : Double ) { startTime = convertToString( time ) }
            infix fun by( time : Double ) { endTime   = convertToString( time ) }


    override fun toString() =" $title Meeting starts  at $startTime end ends by $endTime"


}

 infix  fun String.ReleaseMeeting( block : ReleaseMeeting. () -> Unit) :ReleaseMeeting {

    var meeting = ReleaseMeeting( this )     // Passing Instance of the string..
    meeting.block()
    return meeting

    // Not a good idea displaying the data here...
   // println(meeting)
}


fun main(){



    val meetingDetails = "Vendor" ReleaseMeeting {
       // this   at 2.45

//        this   at 2.45
//        this   by 4.45

        Starts at 2.45
        Ends   by 4.45





    }
    println(meetingDetails)



}