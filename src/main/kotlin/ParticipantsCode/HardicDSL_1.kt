package ParticipantsCode
import java.time.LocalDateTime
import java.util.*

/*
    // 1st assignment.. Got it almost..
    display { date in startDate..endDate step 7 }
*/

// class
class _Display_ {

    val date = "date"
    val startDate = LocalDateTime.now().toString().toInt()
    val endDate = LocalDateTime.now().plusDays(124).toString().toInt()


    operator fun Any.contains(date: String): Boolean {
        if(date in startDate..endDate) {
            println(date)
        }
        else {
            println("Out of Range")
        }
        return true
    }
}


// extension function
infix fun <T : Comparable<T>> ClosedRange<T>.step(i: Int): Any {
    println("i")
    return ""
}


// function literals with receiver
fun display( first: _Display_.() -> Unit) {
    val dateGap = _Display_()
    dateGap.first()
}

fun main() {

    display {

        date in startDate..endDate step 7

    }

}