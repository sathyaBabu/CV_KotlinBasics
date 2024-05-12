package DesignPatterns

enum class Banker{ HDFC, ICICI, CITI}

interface  iBank{
    public  fun  rateOfIntrest()

}

class HDFC : iBank {
    override fun rateOfIntrest() {
        println("HDFC rate of intrest on FD 10%")
    }

}

class ICICI : iBank {
    override fun rateOfIntrest() {
        println("ICICI rate of intrest on FD 11%")
    }

}

class CITI : iBank {
    override fun rateOfIntrest() {
        println("CITI rate of intrest on FD 12%")
    }

}

// Factory creator....


// Following code creates HDFC/ICICI/CITI object numerous times...


// single object

// Clone the class clonable ( Jave related object : Outdated..)
// instead use data Class

class Bankfactory {
   // companion object {
        fun queryFactory(type: Banker): iBank? {
            return when (type) {
                Banker.HDFC ->  HDFC()  // clone and return the object Deep/ Shallow copy prototype
                Banker.ICICI -> ICICI()
                Banker.CITI -> CITI()

                else -> null
            }
        }
   // }  // companion object
}

fun main(){


    val factory = Bankfactory()

    val bank = factory.queryFactory(Banker.HDFC)
    bank?.rateOfIntrest()


    val bank1 = factory.queryFactory(Banker.HDFC)
    bank1?.rateOfIntrest()

    val bank2 = factory.queryFactory(Banker.CITI)
    bank2?.rateOfIntrest()

}

/*
HDFC rate of intrest on FD 10%
HDFC rate of intrest on FD 10%
CITI rate of intrest on FD 12%

 */

/*

             val = vManager =        ServiceManager( VIB_SENSOR )
             vManger.getxyz();
               val = nManager =      ServiceManager( NOTIFICATION_ )
             nManger.notify();

 */