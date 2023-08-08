package DesignPatterns


interface AtmState{



    fun insertcard()
    fun ejectCard()
    fun insertPin( pinEntered: Int)
    fun requestCash(cashToWithDraw: Int)
}

class  ATMmachine {

    // lets create a local variable for all the card sub class..

    private  var yesCardState : AtmState
    private  var noCardState  : AtmState
    private  var hasPin       : AtmState
    private  var noCashState  : AtmState

    var atmState :AtmState

    var cashInTheMachine = 5000
    var correctPinEntred = false

    init {
        yesCardState = HasCard(this)  // CardState
        noCardState  = NoCard( this)
        hasPin       = HasPin( this)
        noCashState  = NoCard( this)

        atmState     = noCardState

        if( cashInTheMachine < 0 ){
            atmState = noCashState
        }
    }

    // inint the data and state of th emachine



    @JvmName("setAtmState1")
    fun setAtmState(newAtmState:AtmState){
        atmState = newAtmState
    }


    fun setCashInMachine( newCashInMachine : Int){
        cashInTheMachine = newCashInMachine
    }

    fun ejectCard() {
        atmState.ejectCard()
    }
    fun insertPin(pinEntered: Int){
        atmState.insertPin( pinEntered )
    }

    fun insertCard() {
        atmState.insertcard()
    }

    fun requestCash( cashToWithDraw: Int){
        atmState.requestCash(cashToWithDraw)
    }

    // lets return the state of the card...
    // lets have the following under a inner class( CardState)

    fun getYesCardState(): AtmState {
        return  yesCardState
    }

    fun getNoCardState() :AtmState {
        return  noCardState
    }

    fun getHasPin() :AtmState{
        return  hasPin
    }

    fun getNoCashState() : AtmState? {
        return  noCashState
    }

    //  atmMachine.correctPinEntred = true


}


// Phase II

class HasCard( newwATMmachine : ATMmachine) : AtmState{
    var   atmMachine: ATMmachine


    init {
        atmMachine = newwATMmachine
    }
    override fun insertcard() {
        println("Card can be inserted only Once....")
    }

    override fun ejectCard() {
        println("Your card has been ejected...")
        atmMachine.getNoCardState()?.let { atmMachine.setAtmState( it) }
    }

    override fun insertPin(pinEntered: Int) {

        // TODO Auto-generated method stub
        if (pinEntered == 12345) {
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


class HasPin( newATMmachine : ATMmachine) : AtmState {
    lateinit var atmMachine : ATMmachine

    init {
        atmMachine = newATMmachine
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

}   // HasPin




class NoCard( newATMmachine : ATMmachine) : AtmState{
    lateinit var atmMachine : ATMmachine

    init {
        atmMachine = newATMmachine
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

class NoCash( newATMmachine : ATMmachine) : AtmState{
    var atMmachine : ATMmachine

    init {
        atMmachine = newATMmachine
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
fun main()
{
    val atmMachine = ATMmachine()

    atmMachine.setCashInMachine(30000)
    atmMachine.requestCash(3400)

    atmMachine.insertCard()
    atmMachine.insertPin(12345)

//
//    atmMachine.insertCard()
//    atmMachine.insertPin(12345)
//    atmMachine.requestCash(300)
//    atmMachine.ejectCard()
//
//    atmMachine.insertCard()
//    atmMachine.insertPin(123)
//    atmMachine.requestCash(120)

}