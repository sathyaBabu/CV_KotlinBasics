package ParticipantsCode


// Phase I
interface AtmState11{

    fun insertcard()
    fun ejectCard()
    fun insertPin( pinEntered: Int)
    fun requestCash(cashToWithDraw: Int)
}

// Phase III
class ATMmachine11{

    // lets create a local variable for all the card sub class..

    private  var yesCardState : AtmState11
    private  var noCardState  : AtmState11
    private  var hasPin       : AtmState11
    private  var noCashState  : AtmState11

    var atmState :AtmState11
    var cashInTheMachine = 5000
    var correctPinEntred = false

    init {
        yesCardState = HasCard11(this)
        noCardState  = NoCard11( this)
        hasPin       = HasPin11( this)
        noCashState  = NoCard11( this)

        atmState     = noCardState

        if( cashInTheMachine < 0 ){
            atmState = noCashState
        }
    }

    @JvmName("setAtmState1")
    fun setAtmState(newAtmState:AtmState11){
        atmState = newAtmState
    }

    fun setCashInMachine( newCashInMachine : Int){
        cashInTheMachine = newCashInMachine
    }

    fun ejectCard() {
        atmState.ejectCard()
    }
    fun insertPin(pinEntered: Int){
        atmState.insertPin(pinEntered)
    }

    fun insertCard() {
        atmState.insertcard()
    }

    fun requestCash( cashToWithDraw: Int){
        atmState.requestCash(cashToWithDraw)
    }

    // lets return the state of the card...

    fun getYesCardState(): AtmState11 {
        return  yesCardState
    }

    fun getNoCardState() :AtmState11 {
        return  noCardState
    }

    fun getHasPin() :AtmState11{
        return  hasPin
    }

    fun getNoCashState() : AtmState11? {
        return  noCashState
    }

}

class HasCard11(newATMmachineCore : ATMmachine11): AtmState11{
    var atmMachine: ATMmachine11

    init {
        // TODO Auto-generated constructor stub
        atmMachine = newATMmachineCore
    }

    override fun insertcard() {
        println("Card can be inserted only Once....")
    }

    override fun ejectCard() {
        println("Your card has been ejected...")
        atmMachine.getNoCardState()?.let { atmMachine.setAtmState(it) }

    }

    override fun insertPin(pinEntered: Int) {
        // TODO Auto-generated method stub
        if (pinEntered == 1234) {
            println("You entered the correct pin")
            atmMachine.correctPinEntred = true
            atmMachine.getHasPin()?.let { atmMachine.setAtmState(it) }
        } else {
            println("You entered wrong Pin")
            atmMachine.correctPinEntred = false
            println("Your card is ejected")
            atmMachine.getNoCardState()?.let { atmMachine.setAtmState(it) }
        }
    }


    override fun requestCash(cashToWithDraw: Int) {
        println("You have not entered your PIN..")
    }

}

class HasPin11(newATMmachineCore : ATMmachine11): AtmState11{

    lateinit var atmMachine : ATMmachine11

    init {
        atmMachine = newATMmachineCore
    }
    override fun insertcard() {
        println("You have already inserted the card....")
    }

    override fun ejectCard() {
        println(" Your card has been ejected...")
        atmMachine.getNoCardState()?.let { atmMachine.setAtmState( it) }
    }

    override fun insertPin(pinEntered: Int) {
        println("You have already inserted the PIN....")
    }

    override fun requestCash(cashToWithDraw: Int) {

        if( cashToWithDraw > atmMachine.cashInTheMachine) {
            println("You do not have sufficient funds to withdraw...")
            println("Your has been ejected...")
            atmMachine.getNoCardState()?.let {
                atmMachine.setAtmState(it)
            }
        }

        else{
            println("$cashToWithDraw is provided by the machine..")
            atmMachine.setCashInMachine((atmMachine.cashInTheMachine - cashToWithDraw))
            println("Your has been ejected...")
            atmMachine.getNoCardState()?.let { atmMachine.setAtmState(it) }
            if (atmMachine.cashInTheMachine <= 0) {
                atmMachine.getNoCashState()?.let { atmMachine.setAtmState(it) }
            }

        }

    }


}

class NoCard11(newATMmachineCore : ATMmachine11): AtmState11{
    lateinit var atmMachine : ATMmachine11

    init {
        atmMachine = newATMmachineCore
    }

    override fun insertcard() {
        // lets get to the core ATMmachine.getCardState()
        println("Please Enter your PIN : ")
        atmMachine.getYesCardState()?.let{ atmMachine.setAtmState(it)}
    }

    override fun ejectCard() {
        println(" You din't enter a CARD..")
    }

    override fun insertPin(pinEntered: Int) {
        println(" You din't enter a CARD..")
    }

    override fun requestCash(cashToWithDraw: Int) {
        println(" You din't enter a CARD..")
    }

}

class NoCash11(newATMmachineCore : ATMmachine11): AtmState11{
    var atMmachine : ATMmachine11

    init {
        atMmachine = newATMmachineCore
    }

    override fun insertcard() {
        println("You dont'have sufficient funds to withdraw..")
    }

    override fun ejectCard() {
        println("You dont'have sufficient funds to withdraw..")
        println("Dont have a card to eject")
    }

    override fun insertPin(pinEntered: Int) {
        println("You dont'have sufficient funds to withdraw..")
    }

    override fun requestCash(cashToWithDraw: Int) {
        println("You dont'have sufficient funds to withdraw..")
    }

}
//************************************************************************************************
interface GetAtmData11 {
    val atmState: AtmState11
    val cashInMachine: Double
}

// abstractiobn layer..
open class atmProxy11 : GetAtmData11 {
    override val atmState: AtmState11
        get() {
            val atmMachine = ATMmachine11()
            return atmMachine.atmState
        }

    override val cashInMachine: Double
        get() {
            val atmMachine = ATMmachine11()
            return atmMachine.cashInTheMachine.toDouble()
        }
}

interface Visitor11 {
    fun visit( contract: atmProxy11):Double
}
// Double dispatch mach...  B

interface Visitiable11{
    fun accept( visitor: Visitor11):Double
}
class ExtendedAtmMachine111 : atmProxy11(),Visitiable11{
    override fun accept(visitor: Visitor11): Double {
        return visitor.visit(this)
    }
}

/*
 * Instead of Visitng ATMMAchine, we are visiting atmProxy.
 */
class MyFriend11 : Visitor11 {
    override fun visit(atm: atmProxy11): Double {
        println("Atm state is displayed in MyFriend class : " + atm.atmState)
        println("Cash in machine is: " + atm.cashInMachine)
        //atm.setCashInMachine(0);
        println("set cash in machine, we are not the bankers : " + atm.cashInMachine)
        return 0.0
    }
}

//************************************************************************************************

// Phase Vi






fun main() {
    //************************************************************************************************
    //creating object of Myfriend and passing this as parameter to the function accept of extendedAtMachine
    var visitorObject = MyFriend11()
    var operation = ExtendedAtmMachine111().accept(visitorObject)
    println(operation)
    println("-*-".repeat(40))

    //************************************************************************************************

    val atmMachine = ATMmachine11().apply {

        insertCard()
        insertPin(1234)
        requestCash(4999)

        insertCard()
        insertPin(1234)
        requestCash(1)


    }
}




/*

// ATMmachineCore

object FireAtmMachine_Proxy {
    @JvmStatic
    fun main(args: Array<String>) {
        // TODO Auto-generated method stub
        val atmMachine = ATMmachine()


        //atmMachine.requestCash(300);


        //atmMachine.insertCard();
        //atmMachine.ejectCard();

        //atmMachine.insertCard();  // has card
        //atmMachine.insertPin(1234);  // has pin

        //atmMachine.requestCash(1500);
        //atmMachine.insertCard();
        //atmMachine.insertPin(1234);

        //GetAtmData AtmMachine = new
        val atmProxy: GetAtmData = atmProxy()
        println("Current ATM State via firewall" + atmProxy.atmState)
        println("Get cash in machine : " + atmProxy.cashInMachine)
        //atmProxy.
        //ExtendedAtmMachine extendedAtmMachine = new ExtendedAtmMachine();
        //MyFriend myFriend = new MyFriend();

        //extendedAtmMachine.accept(myFriend);
    }
}

/* Wrapper for our ATM Machine. Abstraction layer..  this
 */
interface GetAtmData {
    val atmState: AtmState
    val cashInMachine: Double
}

// abstractiobn layer..
open class atmProxy : GetAtmData {
    // TODO Auto-generated method stub
    override val atmState: AtmState
        get() {
            // TODO Auto-generated method stub
            val atmMachine = ATMmachine()
            return atmMachine.atmState
        }

    // TODO Auto-generated method stub
    override val cashInMachine: Double
        get() {
            // TODO Auto-generated method stub
            val atmMachine = ATMmachine()
            return atmMachine.cashInTheMachine.toDouble()
        }
}


/*
 * instead of extending atmmachine, we are extending atmProxy
 */

interface Visitor {
        fun visit( contract: atmProxy):Double
}
// Double dispatch mach...  B

interface Visitiable{
    fun accept( visitor: Visitor):Double
}
class ExtendedAtmMachine : atmProxy(),Visitiable{
    override fun accept(visitor: Visitor): Double {
        // TODO Auto-generated method stub
        return visitor.visit(this)
    }
}

/*
 * Instead of Visitng ATMMAchine, we are visiting atmProxy.
 */
class MyFriend : Visitor {
    override fun visit(atm: atmProxy): Double {

        // TODO Auto-generated method stub
        println("Atm state is displayed in MyFriend class" + atm.atmState)
        println("Cash in machine is: " + atm.cashInMachine)
        //atm.setCashInMachine(0);
        println("set cash in machine, we are not the bankers" + atm.cashInMachine)
        return 0.0
    }
}

fun main(){
    var visitorObject = MyFriend()
    var operation = ExtendedAtmMachine().accept(visitorObject)
    println(operation)
}

 */