package DesignPatterns
//interface ATMMachine {
//    var cashInTheMachine: Double
//    fun getCash(cash: Double): Double
//    fun getContext(): ATMMachineImpl
//}
//
//open class ATMMachineImpl : ATMMachine {
//
//    override var cashInTheMachine: Double = 50000.0
//
//    override fun getCash(cash: Double): Double {
//        cashInTheMachine -= cash
//        return cash
//    }
//
//    override fun getContext(): ATMMachineImpl {
//        return this
//    }
//}
//
//
//interface ATMMachineProxy {
//    fun getCash(cash: Double): Double
//    fun getContext(): Double
//}
//
////class ATMProxy : ATMMachine{
//class ATMMachineProxyImpl : ATMMachineProxy {
//    //Create Get Cash Not Override
//    override fun getCash(cash: Double): Double {
//        val atmMachineImpl = ATMMachineImpl().getContext()
//        return if (atmMachineImpl.cashInTheMachine >= cash) atmMachineImpl.getCash(cash) else 0.0
//    }
//
//    override fun getContext(): Double {
//        val atmMachineImpl = ATMMachineImpl().getContext()
//        return atmMachineImpl.cashInTheMachine
//    }
//
//}
//
//fun main() {
//    val atmProxy = ATMMachineProxyImpl()
//    println(atmProxy.getCash(60000.0))
//    println(atmProxy.getCash(40000.0))
//    println(atmProxy.getContext())
//}
//

interface I_ATM {
    var cashInTheMachine: Double
    fun getCash(cash: Double): Double
    fun getContext(): ATM
}

open class ATM : I_ATM {
    override var cashInTheMachine: Double = 30000.0
    override fun getCash(cash: Double): Double {
        cashInTheMachine -= cash
        return cash
    }

    override fun getContext(): ATM {
        return this
    }
}


interface I_ATMProxy {
    fun getCash(cash: Double): Double
    fun getContext(): Double
}

class ATMProxy : I_ATMProxy {
    override fun getCash(cash: Double): Double {
        val atmMachineImpl = ATM().getContext()
        return if (atmMachineImpl.cashInTheMachine >= cash) atmMachineImpl.getCash(cash) else 0.0
    }

    override fun getContext(): Double {
        val atmMachineImpl = ATM().getContext()
       // return atmMachineImpl.cashInTheMachine
        return atmMachineImpl.getCash(200.00) // thats ur balance
        // we are not exposing  atmMachineImpl.cashInTheMachine
    }

}

fun main() {
    val atmProxy = ATMProxy()
    println(atmProxy.getCash(70000.0))
    println(atmProxy.getCash(30000.0))
    println("Get Context ${atmProxy.getContext()}")


}