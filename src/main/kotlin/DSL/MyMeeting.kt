package DSL
//                 this ( "Vendor" )
class Meeting(val name:String){

     val Start = this
    // Phase II
    // val End   = this

   infix fun at( time: IntRange){
        println("$name meeting starts at $time PM ")
       //       Vendor                   2..45
    }

    infix fun by( time: IntRange){
        println("$name meeting Ends by $time PM ")
        //       Vendor                   2..45
    }

}
//                                this.()
infix fun String.Meeting(  bloc: Meeting.() ->Unit     )   {
    println("Kicked the meeeting")
   // return Meeting(this)   // can we invoke????
  //  Meeting( this).bloc()

//      Phase I
    var meeting = Meeting(this)
    bloc.invoke(meeting)

    // this.at(2..45)
  // meeting.at(2..45)


//      Phase II

   // Meeting( this).bloc()

}
fun main(){

    // "Vendor" Meeting { start at 2..45  }

    "Vendor" Meeting {
     //   this:Meeting
       // almost
       this.at(2..45)


        // Hey not this way!!!!
       // this at 2..45

        // "Vendor" Meeting start at 2..45

        // "Vendor" Meeting this at 2..45


       // this  at 2..45
       // define start inside  Meeting(.....)
        Start at 2..45
        // phase II
//       End  by  4..45
        this  by  4..45


    // it:int  this:Meeting
      // at 2..45    // to 4:00Pm  CONVERTED 2:45 TO A RANGE EXPRERSSION
    }
}