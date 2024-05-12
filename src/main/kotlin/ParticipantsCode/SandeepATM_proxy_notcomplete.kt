package DesignPatterns


/*

  State :   ATM machine


 */
// Phase I
interface AtmState45{

    fun insertcard()
    fun ejectCard()
    fun insertPin( pinEntered: Int)
    fun requestCash(cashToWithDraw: Int)
}

// Phase III
open class ATMmachine45{

    // lets create a local variable for all the card sub class..

    private  var yesCardState : AtmState45
    private  var noCardState  : AtmState45
    private  var hasPin       : AtmState45
    private  var noCashState  : AtmState45


    var atmState :AtmState45
    var cashInTheMachine = 5000
    var correctPinEntred = false

    init {
        yesCardState = HasCard45(this)
        noCardState  = NoCard45( this)
        hasPin       = HasPin45( this)
        noCashState  = NoCard45( this)


        atmState     = noCardState

        if( cashInTheMachine < 0 ){
            atmState = noCashState
        }
    }

    @JvmName("setAtmState1")
    fun setAtmState(newAtmState:AtmState45){
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

//     lets return the state of the card...

    fun getYesCardState(): AtmState45 {
        return  yesCardState
    }

    fun getNoCardState() :AtmState45 {
        return  noCardState
    }

    fun getHasPin() :AtmState45{
        return  hasPin
    }

    fun getNoCashState() : AtmState45? {
        return  noCashState
    }



}

/////////////////////////////////////////////////////////////////////////////////////////////////
// Phase II
class HasCard45(newATMmachineCore : ATMmachine45): AtmState45{
    var atmMachine: ATMmachine45

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

class HasPin45(newATMmachineCore : ATMmachine45): AtmState45{

    lateinit var atmMachine : ATMmachine45

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

class NoCard45(newATMmachineCore : ATMmachine45): AtmState45{
    lateinit var atmMachine : ATMmachine45

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

class NoCash45(newATMmachineCore : ATMmachine45): AtmState45{
    var atMmachine : ATMmachine45

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


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


// here oncreating the obj of atmproxy i m unable to call the function


class proxy12 {

    val atmProxy: _AtmState12 = atmProxy12()


    fun printdata()
    {
        print('\n')
        println("PRINTING PROXY DATA")
        print('\n')
        println(atmProxy.getNoCardState())
        println(atmProxy.getYesCardState())
        println(atmProxy.getHasPin())
        println("Cash in the machine :${atmProxy.cash_In_the_Machine}")

        println(atmProxy.getNoCashState())
    }



}
// abstract layer is done
interface _AtmState12{
    fun getYesCardState():AtmState45?
    fun getNoCardState() :AtmState45?
    fun getHasPin() :Boolean
    fun getNoCashState():AtmState45
    val cash_In_the_Machine:Int

}
// class is also returning the value but i m unable to call it
class atmProxy12: _AtmState12{
    var atM_machine=ATMmachine45()

    override fun getYesCardState():AtmState45?{
        return  atM_machine.atmState
    }

    override fun getNoCardState(): AtmState45? {
        return atM_machine.atmState
    }

    override fun getHasPin(): Boolean {
        return atM_machine.correctPinEntred
    }

    override fun getNoCashState() : AtmState45 {
        return  atM_machine.atmState
    }

    override val cash_In_the_Machine: Int=atM_machine.cashInTheMachine


}




// Phase Vi
fun main(){
    /*
   val atmMachine = ATMmachine()
    atmMachine.insertCard()

    */


    val atmMachine = ATMmachine45().apply {

//        insertCard()
//        ejectCard()
        insertPin(4567)
        requestCash(4000)
        ejectCard()
        insertCard()
        insertPin(1234)
        requestCash( 4999)

        insertCard()
        insertPin(1234)
        requestCash( 1)

        // state of the card has changed to nocard state..

        //  requestCash(100)
        //  You din't enter a CARD..  { we are taking an advantage of Interface segrigation principle.. }
        proxy12().printdata()

    }

}
