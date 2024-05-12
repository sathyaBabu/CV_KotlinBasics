package WeakReference

import ParticipantsCode.Display
import java.lang.ref.WeakReference

internal class MyClass {
    fun Display() {
        println("Display Function invoked ...")
    }
}
fun main() {

        var obj: MyClass? = MyClass()

        // creating a weak reference of type MyClass

        // creating a weak reference of type MyClass
        val wobj: WeakReference<MyClass> = WeakReference(obj)
        println(
            "-> Calling Display Function using strong object:"
        )
        obj!!.Display()  // Display Function invoked ...

        println("-> Object set to null")
        obj = null
        obj = wobj.get()
        println(
            "-> Calling Display Function after retrieving from weak Object "
        )
//    if (obj != null) {
//        obj.Display()
//    }

 //   obj.Display();  // take the rem out to see the error



//
//    var check = obj.let {
//
//        //  Display()
//
//
//        println(" Object is not released")
//
////
//        " Object is not released...."
//
//    }
//    println(" Object is  released!!!")

}
