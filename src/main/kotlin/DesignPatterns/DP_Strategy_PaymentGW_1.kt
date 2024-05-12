package DesignPatterns

interface PaymentStrategy{
    fun payment_bill_download(url: String?,amount2:Int?, filename: String?, path: String?)
}

class PaymentCheck private constructor() {
    class Payment {

        private var isConnect:Boolean? = false
        private var url:String? = ""
        var amount1 : Int? =0;
        var amount2 : Int? =0;
        private var filename:String? = ""
        private var libName:String? = ""
        private var path:String? = ""
        fun checkNetwork(url:String)= apply {
            this.isConnect = true
            this.url = url
        }
        fun calculate(amount2:Int)= apply { this.amount2=amount2 }
        fun paymentby_method(fileName:String)= apply { this.filename = fileName}
        fun useLib(libName:String)= apply { this.libName = libName}   // Card , Gpay Cash
        fun store(path:String)= apply { this.path = path}
        fun payment_bill_download() {
            if(isConnect==true){
                when(libName){
                    "Card" -> PaymentWithRetrofit().payment_bill_download(url,amount2,filename,path)  // checkout( builder, PayByCard(), ammount())
                    "Gpay" -> PaymentWithVolley().payment_bill_download(url,amount2,filename,path)
                    else -> println("wrong lib name")
                }
            }else{
                println("Out of Network")
            }
        }
    }

    //1
    class PaymentWithRetrofit : PaymentStrategy{
        override fun payment_bill_download(url: String?, amount2:Int?,filename: String?, path: String?) {
            println("Payment through - Website or App ,Amount- $amount2, Payment - $filename , Transation Id  - $1234AP ")
        }

    }

    //2
    class PaymentWithVolley : PaymentStrategy{
        override fun payment_bill_download(url: String?, amount2:Int?, filename: String?, path: String?) {
            println("Payment through - Website or App  ,Amount- $amount2, Payment - $filename , Transation Id  - $1234AP  ")
        }
    }

}

fun main() {

    PaymentCheck.Payment()
        .checkNetwork("www.google.com").calculate(200)
        .paymentby_method("GPay,PhonePay,crediCard,Upi")
        .useLib("Card")   // CARD
        .store("/desktop/")
        .payment_bill_download()

    PaymentCheck.Payment()
        .checkNetwork("www.Yahoo.com").calculate(200)
        .paymentby_method("Payment Done by Gpay,PhoePAy ,Upi")
        .useLib("Gpay")      // GPAY
        .store("/Computer/")
        .payment_bill_download()

}