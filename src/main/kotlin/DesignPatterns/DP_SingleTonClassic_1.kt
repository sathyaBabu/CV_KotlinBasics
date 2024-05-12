package DesignPatterns


 class CitiBankSingleTon private constructor() {
    init {
        // TODO Auto-generated constructor stub
        println("Right in the Private Constructor of  the citi bank")
    }

    fun canIhelpYou() {
        println("Hi Can I help u")
    }

    // We are creating a link to the factory QueryInterface
    fun QueryFactory(reqQuery: Int) {
        println(
            """
                Got a better way to deal with Bussiness Logistics
                Lets Deal with Factory pattern for the flex...
                """.trimIndent()
        )
    }

    companion object {
        var refCount = 0

        // voltile helps when this line called asyncly by concurrent threads
        @Volatile
        private var uniqueInstance: CitiBankSingleTon? =
            null // static var..// closure for synchronized( CitiBankSingleTon.class)

        // static function
        val instance: CitiBankSingleTon?
            get() {
                refCount++   // if the object is already created
                println(" Times called $refCount")
                synchronized(CitiBankSingleTon::class.java) {
                    if (uniqueInstance == null) {
                        uniqueInstance = CitiBankSingleTon()
                        println("CitiBankSingleTon obj is created " + refCount)
                    } else {
                        println("CitiBankSingleTon Obj is already Exists! ")
                    }
                } // closure for synchronized( CitiBankSingleTon.class)
                println("Right in tthe static fun of my Bank")
                return uniqueInstance
            }
    }
}

fun main() {
    //   conreate class..

        // TODO Auto-generated method stub

//		CitiBankSingleTon citi = new CitiBankSingleTon();
//		citi.canIhelpYou();
//

   // val cb = CitiBankSingleTon()

        val citi = CitiBankSingleTon.instance
        val citi1 = CitiBankSingleTon.instance
        val citi2 = CitiBankSingleTon.instance
        citi!!.canIhelpYou()
        citi.QueryFactory(2)
    citi1!!.QueryFactory(2)


        // All the citi customers can Enter the Bank...


//		CitiBankSingleTon citi1 = new CitiBankSingleTon();
//		citi1.canIhelpYou();
//
    }


/*
Right in the Private Constructor of  the citi bank
CitiBankSingleTon obj is created 1
Right in tthe static fun of my Bank
CitiBankSingleTon Obj is already Exists!
Right in tthe static fun of my Bank
CitiBankSingleTon Obj is already Exists!
Right in tthe static fun of my Bank
Hi Can I help u
Got a better way to deal with Bussiness Logistics
Lets Deal with Factory pattern for the flex...

Process finished with exit code 0

 */