package Enum

enum class FlightStatus {
    ONTIME,DELAYED
}

fun main () {

    var  flightStstua = FlightStatus.DELAYED

    when (flightStstua) {
        FlightStatus.DELAYED -> delayed()
        FlightStatus.ONTIME -> onTime()

    }
}

fun delayed() {
    println("Flight delayed ")
}

fun onTime() {
    println("Flight On Time")
}