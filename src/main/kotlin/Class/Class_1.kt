package Class
//class Car

class Car(val year:Int) {

}

val car = Car(2023)
// val year: is a member property not a field

fun main(){
println(car.year)  // 2023
}