package DesignPatterns



enum class BankerLoan{ HOUSE, EDU, CAR1}

interface  iBankLoan{

    public  fun  rateOfIntrest()

}

class HOUSE : iBankLoan {
    override fun rateOfIntrest() {
        println("Housing  rate of intrest  14%")
    }

}

class EDU: iBankLoan {
    override fun rateOfIntrest() {
        println("Education  rate of intrest 6%")
    }

}

class CAR1 : iBankLoan {
    override fun rateOfIntrest() {
        println("CAR rate of intrest 19%")
    }

}

// Factory creator....


// Following code creates HDFC/ICICI/CITI object numerous times...

class BankLoanfactory{

    fun queryFactory( type : BankerLoan) : iBankLoan? {
        return  when( type){
            BankerLoan.HOUSE   -> HOUSE()
            BankerLoan.EDU  -> EDU()
            BankerLoan.CAR1  -> CAR1()

            else -> null
        }
    }
}

fun main(){


    val factory = BankLoanfactory()

    val bank = factory.queryFactory(BankerLoan.HOUSE)
    bank?.rateOfIntrest()


    val bank1 = factory.queryFactory(BankerLoan.CAR1)
    bank1?.rateOfIntrest()

    val bank2 = factory.queryFactory(BankerLoan.EDU)
    bank2?.rateOfIntrest()

}

/*
HDFC rate of intrest on FD 10%
HDFC rate of intrest on FD 10%
CITI rate of intrest on FD 12%

 */