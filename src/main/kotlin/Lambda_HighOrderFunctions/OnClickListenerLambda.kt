package Class.Lambda


// refer OnClickListener code above

//fab.setOnClickListener(new View.OnClickListener {

//fab.setOnClickListener(object : View.OnClickListener {
//    override fun onClick(p0: View?) {
//        TODO("Not yet implemented")
//    }
//
//}
//
//val listener= View.OnClickListener { view ->
//    when (view.getId()) {
//        R.id.button1 -> {
//            // Do some work here
//        }
//    }
fun interface OnClickListener{
    fun onClick(p: View?)
}
open class View : OnClickListener {
    var i:Int = 123
//    fun interface OnClickListener{
//        fun onClick(p: View?)
//    }

    var observer: OnClickListener? = null


    fun buttonClicked(){
        observer?.onClick( this )
    }
//
//    fun setOnClickListener( obs:OnClickListener) {
//        observer = obs
//    }




    fun setOnClickListener(listener: View.( View ) -> Unit) {
        // listener...
        val view = View( )
        view.listener( view )
        // view.listener(10)

        // return view

    }
    // Creating an instance using lambda
    val onClick = OnClickListener {
        println("Interface called from lambda ..")
    }

    override fun onClick(p: View?) {
        println("Interface called from regular interface implementation..")
    }
//    override fun onClick(p: View?) {
//        TODO("Not yet implemented")
//    }


}
// https://kotlinlang.org/docs/fun-interfaces.html#sam-conversions
// SAM
open class Cinterface{
    fun interface IntPredicate {
        fun accept(i: Int): Boolean
    }
}


val isEven = Cinterface.IntPredicate { it % 2 == 0 }

fun main(){

    println("Is 7 even? - ${isEven.accept(7)}")
//    val button = Button()
//    button.setOnClickListener {
//            v -> println("User has clicked on button! $v") }


//
//    button.setOnClickListener( View.setOnClickListener{
//
//    })

//    val view = View()
//    view.setOnClickListener( object : View.OnClickListener{
//        override fun onClick(p: View?) {
//            println("Call back received in observer")
//        }
//
//    })

    val view = View()
    view.setOnClickListener {
            view ->  println("hello view ${view.i}") // this.i

    }

  //  view.buttonClicked()

    view.setOnClickListener {
        println("hello view other way around ${this.i}") // this.i
    }
}
/*
    Is 7 even? - false
    hello view 123
    hello view other way around 123

Process finished with exit code 0

 */