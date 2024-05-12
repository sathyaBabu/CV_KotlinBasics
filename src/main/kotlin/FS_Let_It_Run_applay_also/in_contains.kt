package FS_Let_It_Run_applay_also

// https://proandroiddev.com/kotlin-fun-with-in-8a425704b635

// Phase I

object CellPhone {
    operator fun contains(value: CharSequence): Boolean {
        return value == "network"
    }
}
// Phase II
class Contains(val text: String) {
    operator fun contains(value: CharSequence) = value.contains(text)
}
fun main(){
    val i : Int = 10

    when( i ){
         in 0..2 -> println("Found 10 in range")
         in IntRange(10, 99) -> println("found 10 in IntRange data type")
    }
// Phase I
    val connect_BT      = "bt"
    val connect_NetWork = "network"
    val connect_DLNA    = "dlna"

    when (connect_NetWork) {  // true
        in CellPhone -> println("You are on Wifi Network")
        else -> println("Network down..")
    }
    // Phase II
    when (connect_BT) {
        in Contains("bt") -> println("Connected to BT!")
        in Contains("network") -> println("Connected to Network Wifi")
    }

    when (connect_DLNA) {
        in listOf("bt", "dlna") -> println("Connected via DLNA protocol stack")
    }

    when{
        // why in at all since our statement is returning Boolean!
         CellPhone.contains( connect_NetWork) -> println("You are on Wifi Network..")
    }
}