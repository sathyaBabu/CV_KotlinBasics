package Class


// static object..

object SingleTon{

    init{
        println("Singleton object Instanciated!")
    }

    var name= " Dummy data "


    // static creation but it's not static any more..
    fun setDat( str:String){
        name = str
    }
    fun printDetails(){
        println(name)
    }

}

fun main()
{

    //val st = SingleTon()
    SingleTon.setDat("Hi SingleTon!")
    SingleTon.printDetails();

}