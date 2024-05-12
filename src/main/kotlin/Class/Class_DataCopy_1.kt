package Class

data class  man( val name : String, val age : Int){

    var height: Int = 0 ;

}

fun main()
{
    val man1 = man("Aamer",28)

    val man2 = man1.copy(name = "Sathya")     // proxy..

    val man3 = man1.copy()

    man1.height = 100
    man2.height = 173
    man3.height = 123

    println("$man1 has ${man1.height } cm height")
    println("$man2 has ${man2.height } cm height")
    println("$man3 has ${man3.height } cm height")


}