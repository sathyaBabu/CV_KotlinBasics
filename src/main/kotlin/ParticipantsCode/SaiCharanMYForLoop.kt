package ParticipantsCode

fun MyFor(k : IntRange,block: (Int)-> Unit){

    // DisplayData(j:Int)
    block(k.last)   // k.last
}

fun DisplayData(j:Int) {
//
//
//    it.hasnext()
//    it.next()
//
    for(i in 1..j){
        println(i)
    }

}

fun main(){
    MyFor(1 until 10){
        DisplayData( it )
    }


}