package Class

object Singleton {
    init {
        println("Singleton object instantiated!")
    }

    var name = "Dummy data"

    fun setData(str:String){
        name = str

    }
    fun printDetails() {
        println(name)
    }
}

fun main() {
    Singleton.setData("Hello there!")
    Singleton.printDetails()
}