package ParticipantsCode

inline fun myfunc(k:Int,operator: (Any) -> Unit){

    println(" calling operator with a value(  $k ) ")
    operator( k )
}

fun displayTheType(s:Any) {

  //  s is Int -> "true "

    if(s is Int){
        println(" $s Integer type")
    }
    else if (s  is Long){
        println(" $s Long")
    }
    else{
        println(" $s String")
    }
}
fun main() {
    myfunc(12){
                       displayTheType( it )
    }
}