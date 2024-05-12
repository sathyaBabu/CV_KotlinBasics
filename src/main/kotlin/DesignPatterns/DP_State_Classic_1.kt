package DesignPatterns
/*

  State :   ATM machine


 */
// Phase I
// When to use the interface and
// sealed class... dosen't allow us to further inherit..

interface AtmState{

    fun insertcard()
    fun ejectCard()
    fun insertPin( pinEntered: Int)
    fun requestCash(cashToWithDraw: Int)
}

// Phase III
class ATMmachine{

    // lets create a local variable for all the card sub class..

    private  var yesCardState : AtmState
    private  var noCardState  : AtmState
    private  var hasPin       : AtmState
    private  var noCashState  : AtmState

    var atmState :AtmState
    var cashInTheMachine = 5000
    var correctPinEntred = false

    init {
        // How to bring a generoic abstraction layer on top of this code
        // to controll this..
        /*

              Write a code which returns this * using that we can access
              all fun, var, every thing
              passing this * to the inherited class/some class breaks the complete code..

              cashinmachine = 5000
              getcash():Int

              Write an abstraction layer to it so as we should be able to pass what has to be passed to the
              sub class not *this.getcash()  // sub class should not access fun of the base or var of the
              base class..



         */
       // HasCard( function: ATMmachine.() ->Unit ){ atmMachine = new ATMmachine().apply(function)}
        yesCardState = HasCard(this)  // CardState
        noCardState  = NoCard( this)
        hasPin       = HasPin( this)
        noCashState  = NoCash( this)

        atmState     = noCardState

        if( cashInTheMachine < 0 ){
            atmState = noCashState
        }
    }

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
        atmState.insertPin(pinEntered)
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

/////////////////////////////////////////////////////////////////////////////////////////////////
// Phase II
class HasCard(newATMmachineCore : ATMmachine): AtmState{
    var atmMachine: ATMmachine

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

class HasPin(newATMmachineCore : ATMmachine): AtmState{

    lateinit var atmMachine : ATMmachine

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

class NoCard(newATMmachineCore : ATMmachine): AtmState{
    lateinit var atmMachine : ATMmachine

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

class NoCash(newATMmachineCore : ATMmachine): AtmState{
    var atMmachine : ATMmachine

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

// Phase Vi
fun main(){
    /*
   val atmMachine = ATMmachine()
     atmMachine.insertCard()
     atmMachine.insertPin(12345)
    */
    val atmMachine = ATMmachine().apply {

//        insertCard()
//        ejectCard()

        insertCard()
        insertPin(1234)

        requestCash( 4999)

        insertCard()
        insertPin(123)
        requestCash( 1)


        // state of the card has changed to nocard state..

      //  requestCash(100)
        //  You din't enter a CARD..  { we are taking an advantage of Interface segrigation principle.. }


    }

}