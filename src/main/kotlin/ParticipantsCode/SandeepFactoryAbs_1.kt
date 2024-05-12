package ParticipantsCode





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

//class CAR1 : iBankLoan {
//    override fun rateOfIntrest() {
//        println("CAR rate of intrest 19%")
//    }
//
//}

// Factory creator....
class HouseLoanFactory : BankLoanfactory() {
    override fun BankLoan():iBankLoan = HOUSE()

}

class EducationLoanFactory : BankLoanfactory(){
    override fun BankLoan():iBankLoan = EDU()

}

// Following code creates HDFC/ICICI/CITI object numerous times...

abstract class BankLoanfactory {


    abstract fun BankLoan(): iBankLoan

    companion object {
        inline fun <reified T : iBankLoan> createFactory(): BankLoanfactory =
            when (T::class) {

                HOUSE::class -> HouseLoanFactory()
                EDU::class ->    EducationLoanFactory()

                else -> throw IllegalArgumentException()

            }
    }
}

//fun main(){
//
//
//    val factory = BankLoanfactory()
//
//    val bank = factory.queryFactory(BankerLoan.HOUSE)
//    bank?.rateOfIntrest()
//
//
//    val bank1 = factory.queryFactory(BankerLoan.CAR1)
//    bank1?.rateOfIntrest()
//
//    val bank2 = factory.queryFactory(BankerLoan.EDU)
//    bank2?.rateOfIntrest()
//
//}


interface  Bank_RBI {
    public fun rateOfIntrest()
}
class CITI_BANK : Bank_RBI
{
    override fun rateOfIntrest() {
        println("CITI rate of intrest on FD 10%")
    }
}

class HDFC_BANK : Bank_RBI {

    override fun rateOfIntrest() {
        println("HDFC rate of intrest on FD 10%")
    }
}
// Abstraction layer of the Bank...

class HDFCbankFactory : RBIbank_Factory() {
    override fun createBank(): Bank_RBI = HDFC_BANK()

}

class CITIbankFactory : RBIbank_Factory() {
    override fun createBank(): Bank_RBI = CITI_BANK()

}

abstract class  RBIbank_Factory {

    abstract  fun createBank() : Bank_RBI

    // single object..  What is the cost of the EDu loan 6%
    // What is Infosys Stock rate... NOW.. since the stock varies lets not use   companion object
    companion object {

        inline fun < reified T : Bank_RBI> createFactory() : RBIbank_Factory =
            when( T::class){

                CITI_BANK::class -> CITIbankFactory()
                HDFC_BANK::class -> HDFCbankFactory()

                else -> throw IllegalArgumentException()

            } // when



    }  // companion object..

}

fun main(){

    val bankFactory = RBIbank_Factory.createFactory<HDFC_BANK>()
    val bank = bankFactory.createBank()
    println("Created a BANK Object $bank")
    bank.rateOfIntrest()

    val bankLoanfactory=BankLoanfactory.createFactory<HOUSE>()
    val bank_loan=bankLoanfactory.BankLoan()
    println("Created a BANK Object $bank_loan")
    bank_loan.rateOfIntrest()


}

