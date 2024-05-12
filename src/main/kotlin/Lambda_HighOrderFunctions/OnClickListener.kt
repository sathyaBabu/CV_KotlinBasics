package Class.Lambda

// refer OnClickListenerLambda  code below
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



//
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

open class View1 {

    val login ="Login"

    interface OnClickListener{
        fun onClick(p: View1)
    }

    var observer: OnClickListener?=null


    fun setOnClickListener( obs:OnClickListener) {
        observer = obs
    }

    fun buttonClicked() { // param: Any?
        observer?.onClick(this) //         observer?.onClick(c)

    }

}


fun main(){


    val view = View1()
    view.setOnClickListener( object : View1.OnClickListener{

        override fun onClick(p: View1) {
            println("Call back received in observer Clicked on ${p.login}")

        }


    })

// Call back received in observer Clicked on Login

    view.buttonClicked(  )  // this
}