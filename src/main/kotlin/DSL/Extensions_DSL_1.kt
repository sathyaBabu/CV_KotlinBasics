package DSL

import java.time.LocalDateTime


fun Int.years(tense:String){
    println("Called years")
}

infix fun Int.Days(tense:String){
    val ago = "ago"
    val from_now = "from_now"

    when( tense){

        ago      ->  println( LocalDateTime.now().minusDays( this.toLong() ) )
        from_now ->  println( LocalDateTime.now().plusDays( this.toLong() ) )

        else -> println("Oops!!!!!")
    }
    println("Called days..")
}
fun main(){

    val ago = "ago"
    val from_now = "from_now"

    //100 years ago
    // Extension function
//    100.years("Ago")
    // 100 years ago
    //10 days ago
   //  5 days from now
    // 5 days after..

    100.years("Ago")

   // 10 Days ago

    5 Days ago

    5 Days from_now

}