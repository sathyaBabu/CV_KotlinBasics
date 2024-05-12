package Lambda_HighOrderFunctions

import java.time.LocalDateTime
//
val ago = "ago"
val FromNow= "From now"

// Phase I
infix fun Int.days_( tense: String){
    println("called")
}


// Phase II
infix fun Int.days( tense: String){
   when( tense ){
       ago     -> println(LocalDateTime.now().minusDays(this.toLong()))
       FromNow -> println(LocalDateTime.now().plusDays(this.toLong()))
       else -> println("Oops! What did you say!!!")
   }
}

fun main(){
    // Phase I
//    2 days_ "ago"
    2 days_ ago
    // Phase II
    2 days ago   // 2022-07-03T19:36:42.358870

    2 days FromNow  // 2022-07-07T19:40:07.584015


}