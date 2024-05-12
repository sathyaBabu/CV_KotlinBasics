package DesignPatterns

interface  Bank_RBI


class CITI_BANK : Bank_RBI

class HDFC_BANK : Bank_RBI





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

    val bankFactory = RBIbank_Factory.createFactory<CITI_BANK>()
    val bank = bankFactory.createBank()
    println("Created a BANK Object $bank")





}

