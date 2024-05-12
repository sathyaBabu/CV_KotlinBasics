package DSL

class ReleaseMeeting(val title:String){

    val Start = this
    val End   = this

    var startTime :String =""
    var endTime : String = ""

    private  fun  convertToString(time:Double) = String.format("%.02f",time)

        infix fun at( time: Double){  startTime = convertToString(time) }
        infix fun by( time: Double){ endTime    = convertToString(time) }

    override  fun toString() = "$title Meeting starts $startTime ends $endTime"   // think about intProgression here

}
//                                this.()
infix fun String.ReleaseMeeting(  bloc: ReleaseMeeting.() ->Unit     )   {
    println("Kicked the meeeting")
    // return Meeting(this)   // can we invoke????
    //  Meeting( this).bloc()

//      Phase I
    var meeting = ReleaseMeeting(title = this)
    bloc.invoke(meeting)

//     this.at(2..45)
//     meeting.at(2..45)


//      Phase II
//    var meeting = ReleaseMeeting(this)
//    meeting.bloc()
//    println(meeting)   // not a right way.. Just to get our output working it supports toString

}
fun main(){

    // "Vendor" Meeting { start at 2..45  }

    "Release" ReleaseMeeting {
        //   this:Meeting
        // almost
       // this.at(2..45)


        // Hey not this way!!!!
        // this at 2..45

        // "Vendor" Meeting start at 2..45

        // "Vendor" Meeting this at 2..45


        // this  at 2..45
        //  this at 2.45

          Start at  2.45
          End   by  4.45

        // at and by is using a single class we are dealing with two functions in a single class

        // every thing should be a class by itself so as at and BY
        // I would not advice you to use at by function in a single class
        // Following code goes well with O principle

        /*
        class StartTime{
            at()   // we can change the behaviour of at at any point
        }
        class EndTime {
            by()
        }
        */


        // it:int  this:Meeting
        // at 2..45    // to 4:00Pm  CONVERTED 2:45 TO A RANGE EXPRERSSION
    }
}