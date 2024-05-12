/*

  State :   ATM machine


 */
// Phase I
interface AtmState{

    fun insertcard()
    fun ejectCard()
    fun insertPin( pinEntered: Int)
    fun requestCash(cashToWithDraw: Int)
}

// Phase III
class ATMmachine{

    // lets create a local variable for all the card sub class..

    private  var yesCardState : AtmState = HasCard(this)
    private  var noCardState  : AtmState = NoCard( this)
    private  var hasPin       : AtmState = HasPin( this)
    private  var noCashState  : AtmState = NoCard( this)

    var atmState :AtmState
    var cashInTheMachine = 5000
    var correctPinEntred = false

    init {

        atmState     = noCardState

        when {
            cashInTheMachine < 0 -> {
                atmState = noCashState
            }
        }
    }

    @JvmName("setAtmState1")
    fun setAtmState(newAtmState:AtmState){
        atmState = newAtmState
    }

    fun setCashInMachine( newCashInMachine : Int){
        this.cashInTheMachine = newCashInMachine
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
            this.atmMachine.getHasPin()?.let { atmMachine.setAtmState(it) }
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
//yesCardState = HasCard(this)  // CardState
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
    */
    val atmMachine = ATMmachine().apply {

//        insertCard()
//        ejectCard()

        insertCard()
        insertPin(1234)
        requestCash( 4999)


        println("====".repeat(50))
        insertCard()
        insertPin(1234)
        requestCash( 1)

        // state of the card has changed to nocard state..

        //  requestCash(100)
        //  You din't enter a CARD..  { we are taking an advantage of Interface segrigation principle.. }

        println("====".repeat(50))
        insertCard()
        insertPin(1234)
        println("${atmProxy().atmState?.toString()}")
        println("${atmProxy().cashInMachine}")
        MyFriend().visit(atmProxy())

    }
    //atmMachine.ejectCard()



}

interface GetAtmData {
    val atmState: AtmState?
    val cashInMachine: Double
}

// abstractiobn layer..
open class atmProxy : GetAtmData {

    override val atmState: AtmState? = ATMmachine().atmState
    override val cashInMachine: Double = ATMmachine().cashInTheMachine.toDouble()

}


/*
 * instead of extending atmmachine, we are extending atmProxy
 */
class ExtendedAtmMachine : atmProxy(), Visitiable {
    override fun accept(visitor: atmProxy) = visitor.cashInMachine

}



interface Visitiable {
    fun accept(type : atmProxy): Double

}

/*
 * Instead of Visitng ATMMAchine, we are visiting atmProxy.
 */
class MyFriend : atmProxy() {
    fun visit(atm: atmProxy) {


        println("Atm state is displayed in MyFriend class" + atm.atmState)
        println("Cash in machine is: " + atm.cashInMachine)
        //atm.setCashInMachine(0);
        println("set cash in machine, we are not the bankers" + atm.cashInMachine)

    }
}