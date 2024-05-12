package bugertestprogram




interface IStrategyPayment{
    fun payment(cardnum: Int?, exprydate: String?,amount: Int?)
}



fun PaymentGateWay_(block: PaymentGateWay.() -> Unit) = PaymentGateWay().apply(block)


class PaymentGateWay {
   // class Pay {

        private var isConnect: Boolean? = false
        private var exprydate: String? = ""
        private var carnum: Int? = 0
        private var amount: Int? = 0
        private var typeofPayment: String = ""
        fun checkNetwork(inernet: Boolean) = apply {
            if (inernet) isConnect = true else this.isConnect = false
        }

        fun cardNum(cardnum: Int) = apply { this.carnum = cardnum }
        fun amount(amount: Int) = apply { this.amount = amount }   // Card , Gpay Cash
        fun expiryDate(exprydate: String) = apply { this.exprydate = exprydate }
        fun paymentMethod(typeofPayment: String) = apply { this.typeofPayment = typeofPayment }   // Card , Gpay Cash

        fun pay() {
            if (isConnect == true) {
                when (typeofPayment) {
                    "CARD" -> PayBycard().payment(
                        carnum,
                        exprydate,
                        amount
                    )  // checkout( builder, PayByCard(), ammount())
                    "UPI" -> PayByUPI().payment(carnum, exprydate, amount)
                    "CASH" -> PayBycash().payment(carnum, exprydate, amount)
                    else -> println("wrong lib name")
                }
            } else {
                println("Out of Network")
            }
        }
   // }

}

    //1
    class PayBycard : IStrategyPayment{


        override fun payment(cardnum: Int?, exprydate: String?, amount: Int?) {
           // println("CardNumber - $cardnum , ExpiryDate - $exprydate , Amount - $amount ")

            println("Amount Pay By Card is - $amount ")
        }

    }

    //2
    class PayByUPI : IStrategyPayment{

        override fun payment(cardnum: Int?, exprydate: String?, amount: Int?) {
            //println("CardNumber - $cardnum , ExpiryDate - $exprydate , Amount - $amount ")
            println("Amount Pay By UPI is - $amount ")

        }
    }





//1
class PayBycash : IStrategyPayment{


    override fun payment(cardnum: Int?, exprydate: String?, amount: Int?) {
        println(" Amount pay by cash  at the time  of Delivery is - $amount ")
    }

}



