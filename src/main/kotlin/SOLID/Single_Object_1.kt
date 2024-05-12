package SOLID


// S O L I D

// S  -> Single Object..

/*
       SMS

       Email

       Sandeep : 2 diffrent class for sms and email
       SriCharan   by

       injecting composition...

       class SMS
       class Email


       ....

       Whats app
       Facebook chat
       Google chat..

       Decompose your thought process.. into  --> Abstraction     Interface


 */

interface  MessageServices{
    fun sendMessage( msg: String, rec:String)
}


// used by the composition layer..
interface Consumer{
    fun processMessage(msg: String, rec:String)
}


// Shall help in our composition

open interface MessageServiceInjector{

    fun getConsumer(): Consumer?
}


class SMSServiceImpl : MessageServices{


    override fun sendMessage(msg: String, rec: String) {
       println("SMS sent to $rec with a message $msg")
    }

}


class EmailServiceImpl : MessageServices{
    override fun sendMessage(msg: String, rec: String) {
        println("Email sent to $rec with a message $msg")
    }

}

// Face book service


class FBServiceImpl : MessageServices{
    override fun sendMessage(msg: String, rec: String) {
        println("Face Book sent to $rec with a message $msg")
    }

}


//////////////////////////
// this will get injected by SMS or Email..
// Composition layer..

// He is not sure of the objects beeing passed...

// What ever he receives has to be a single object service..

class MyDIApplication(private  val service:MessageServices) : Consumer {
    override fun processMessage(msg: String, rec: String) {

        service.sendMessage(msg,rec)

    }

}

                //   EmailServiceInjector  a Single Object

                class  EmailServiceInjector : MessageServiceInjector{

                    override fun getConsumer(): Consumer? {

                        // Composition layer gets calledhere.. lets pass EmailServiceImpl() to it
                       return  MyDIApplication( EmailServiceImpl() )
                    }

                }


                //    SMSServiceInjector  a Single Object

                class  SMSServiceInjector : MessageServiceInjector{
                    override fun getConsumer(): Consumer? {

                        // Composition layer gets calledhere.. lets pass SMSServiceImpl() to it
                        return  MyDIApplication( SMSServiceImpl() )
                    }

                }



                //    FBServiceInjector  a Single Object

                class  FBServiceInjector : MessageServiceInjector{
                    override fun getConsumer(): Consumer? {

                        // Composition layer gets calledhere.. lets pass SMSServiceImpl() to it
                        return  MyDIApplication( SMSServiceImpl() )
                    }

                }



fun main() {

    var msg: String = " Hi Sruti"
    var email: String = "sruti@gmail.com"
    var phone : String = "0123456789"
    // var injector: MessageServiceInjector = Null


    // send a mail

    var injector: MessageServiceInjector = EmailServiceInjector() // to be injected...
    var app:Consumer? = injector.getConsumer()
    app?.let { it.processMessage(msg,email) }
    // JAVQ STYLE



    // send a FB message

    var injector2: MessageServiceInjector = FBServiceInjector() // to be injected...
    var app11:Consumer? = injector2.getConsumer()
    injector2.getConsumer()?.processMessage(msg, email)

    app11?.processMessage(msg,email)

    app11?.let {
        it.processMessage(msg,email)
    }
    // JAVQ STYLE

    /*

    if( app != null){
        app.processMessage(msg,email)
    }
     */
    injector.getConsumer()?.processMessage(msg, email)

    // send SMS

    injector = SMSServiceInjector()
    app = injector.getConsumer()

   //app?.processMessage(msg,phone)
   // app = null
    // JAVQ STYLE

    /*

    if( app != null){
        app.processMessage(msg,email)
    }
     */

  app?.let {

      it.processMessage(msg,phone)
  }

}
/*
Email sent to sruti@gmail.com with a message  Hi Sruti
SMS sent to 0123456789 with a message  Hi Sruti

Process finished with exit code 0

 */