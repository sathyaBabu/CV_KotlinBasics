package SOLID


// Deepak yes   Manish Right Pranav May be
//
//open interface vechile{
//
//    fun start()
//    fun stop()
//
//}
//interface Drone{
//
//    fun playRadio()
//    fun revCamera()
//}

// sms, email, whatapp, FaceBookMEs.. insta..

interface MessageServices{

    fun sendMessage(msg: String , rec:String)

}

// sms / email

interface Consumer{

    fun processTheMessage( msg: String, rec :String)
}

// Composition..

open interface MessageServiceInjector{

    // This has to be injected on sms / email users..

    fun getConsumer() : Consumer?


}

// Think about the design..

//

class SMSServiceImpl : MessageServices{
    override fun sendMessage(msg: String, rec: String) {
        println("SMS sent to $rec with a msg $msg")
    }


}


class EmailServiceImpl : MessageServices{
    override fun sendMessage(msg: String, rec: String) {
        println("Email sent to $rec with a msg $msg")
    }


}


class FBServiceImpl : MessageServices{
    override fun sendMessage(msg: String, rec: String) {
        println("FB  sent to $rec with a msg $msg")
    }


}


// dependency Injection..
// Excutor services....


// Dagger - HILT -> dependency inj..   1.
// 2. Testing.. DI..

// Third party library has to be provided or injected on to our app..
//  Picaso/Retrofit           //  Factory -> APP Provider -> obj.. a b c d e f  we have to provide(  Picaso / Retrofit  )


// Car  provide the eng..Dependency  Eng

class  MyDIApplication( private  val service:MessageServices) : Consumer {
    override fun processTheMessage(msg: String, rec: String) {

        // Broadcast
        // Notification
        // coroutines
        /// live data

        // db
        // server

        // processTheMessage( service )  is processing the following messages in a common way.
        // Sms
        // email
        // FB

        service.sendMessage(msg,rec)
    }

}

// Not a good way of coding!!!!

                    class  SMSServiceInjector : MessageServiceInjector{

                        // warpper DI
                        override fun getConsumer(): Consumer? {

                           // service.sendMessage(msg,rec)
                            return  MyDIApplication(  SMSServiceImpl()  )   // mocking class are passed in testing..
                        }

                    }

                    class  EmailServiceInjector : MessageServiceInjector{
                        override fun getConsumer(): Consumer? {

                            return  MyDIApplication(  EmailServiceImpl()  )
                        }

                    }


                    class  FBServiceInjector : MessageServiceInjector{
                        override fun getConsumer(): Consumer? {

                            return  MyDIApplication(  FBServiceImpl()  )
                        }

                    }




// Single respo

fun main()
{
    var msg: String = " Hi Vrishu"
    var email : String = "Vrishu@gmail.com"
    var phone : String ="0123456789"

    /// send a email'


    // WRONG****** way of coding......
    // Factory query for the obj

    val injector : MessageServiceInjector = EmailServiceInjector()
    var app:Consumer? = injector.getConsumer()

    // send a FB Messge


    val injector2 : MessageServiceInjector = FBServiceInjector()
    var app11:Consumer? = injector2.getConsumer()
    injector2.getConsumer()?.processTheMessage(msg,email)


        // send SMS

    val injector4 : MessageServiceInjector = SMSServiceInjector()
    var app12:Consumer? = injector4.getConsumer()

    // jave way
//    if( app12 != null){
//
//        injector4.getConsumer()?.processTheMessage(msg,email)
//    }

    app12?.let {
        it.processTheMessage(msg,email)
    }

    injector4.getConsumer()?.processTheMessage(msg,email)



}