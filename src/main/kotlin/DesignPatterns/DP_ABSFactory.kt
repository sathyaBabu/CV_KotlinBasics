package DesignPatterns

interface  Bank_RBI

// Interface segrigation principle error **** DONT *****
//interface  Bank_RBI_LOAN


class CITI_BANK : Bank_RBI

class HDFC_BANK : Bank_RBI



// Abstraction layer of the Bank...
// 2
class HDFCbankFactory : RBIbank_Factory() {
    override fun createBank(): Bank_RBI = HDFC_BANK()

}

// 3
class CITIbankFactory : RBIbank_Factory() {
    override fun createBank(): Bank_RBI = CITI_BANK()

}

// 1  just declare shell use it on above class
abstract class  RBIbank_Factory {

    abstract  fun createBank() : Bank_RBI

    // Interface segrigation principle error **** DONT *****
   // abstract  fun createBankLoan() : Bank_RBI_LOAN

    // single object..  What is the cost of the EDu loan 6%
    // What is Infosys Stock rate... NOW.. since the stock varies lets not use   companion object
    companion object {
    // reified converts back to a proper data type
        // classType: Class<T>
        /*
        To access the information about the type of class, we use a keyword called reified in Kotlin.
        In order to use the reified type, we need to use the inline function.

        dosen't    work

         fun <  Bank_RBI> createFactory() : RBIbank_Factory =
            when( DesignPatterns.Bank_RBI::class){

         */
        inline fun < reified T : Bank_RBI> createFactory() : RBIbank_Factory =
            when( T::class){

                CITI_BANK::class -> CITIbankFactory()
                HDFC_BANK::class -> HDFCbankFactory()

                else -> throw IllegalArgumentException()

            } // when



    }  // companion object..

}

fun main(){

    val bankFactory = RBIbank_Factory.createFactory< CITI_BANK >()
    val bank = bankFactory.createBank()
    println("Created a BANK Object CITI  $bank")

    val bankFactory2 = RBIbank_Factory.createFactory< HDFC_BANK >()
    val bank2 = bankFactory2.createBank()
    println("Created a BANK Object HDFC  $bank2")


    //***************************************************************
    // just about redif without it

    genericsExample<String>(String::class.java, "Learning Generics!")
    genericsExample<Int>(Int::class.java, 100)

    //
    genericsExample2<String>("Learning Generics!")
    genericsExample2<Int>(100)


}

fun <T> genericsExample(classType: Class<T>, value: T) {
    println(value)
    println("Type of T: ${classType}")
}

inline fun <reified T> genericsExample2(value: T) {
  //  println(value)
    println("Type of T: ${T::class.java}")
}