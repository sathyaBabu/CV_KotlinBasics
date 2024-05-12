package DesignPatterns

import Main_Basics.fishFood
import SOLID.Sub
import java.util.*


// Observer DP vs Live data ..
// To implement the same in M V C



// Observer
abstract  class Observer{
    protected  var subj: Subject? = null

     abstract fun Update()
}

// Subject
class Subject{

    protected  val observers =  arrayOfNulls< Observer >( 9 )

    private  var totObjects = 0
    var               state = 0


    // set

    set( changedIntValue ){
        field = changedIntValue
        // state change alert

        notifyMe()
    }


    @JvmName("getState1")
    fun getState() : Int {
        return  state     // frest state...
    }
    // Attach

    fun attach( observer: Observer) {

         observers[ totObjects++ ]  = observer
        println(" Attached : processing the data STATE  busy... $totObjects")
    }



    // detach
    fun detach(){
        println(" Please implement the detach functionality here...")
    }
    // notifyMe

    fun notifyMe() {

         for( regUsers in 0  until  totObjects )
             observers[ regUsers ]?.Update()
    }

}



// concreteObserver -> user Hex Bin Dec
// Model..

class  BinObserver( sub : Subject):  Observer() {

    init {
        subj = sub
        subj?.attach( this)
    }
    override fun Update() {
        // update has to reported the controller that there is a chane in the model
        // so contropller has to pass the data to the view
        // But where the controller can get the data from????

//        println("Bin : ${subj?.getState()?.let { Integer.toBinaryString( it ) }}     ")
    }

}



class  HexObserver( sub : Subject):  Observer() {

    init {
        subj = sub
        subj?.attach( this)
    }

    override fun Update() {
        println("Hex : ${subj?.getState()?.let { Integer.toHexString( it ) }}     ")
    }

}

// Model...
class  OctObserver( sub : Subject):  Observer() {


    init {
        subj = sub
        subj?.attach( this)
    }

    override fun Update() {
        // view is in front here...

        // Model state has changed
        // so model should requerst the controller to pass the changed data on to view..

        println("Oct : ${subj?.getState()?.let { Integer.toOctalString( it ) }}     ")
    }

}



fun main()
{

    val subject = Subject()



    // s = controller
    // M = Hex, dec, bin
    // V =

    // Assignment for now
    // 1.port the same on To M V C
    // 2 subject.attach( OctObserver() )
    // 3. detach

    HexObserver(  subject )
    OctObserver ( subject )
    BinObserver ( subject )

    val scan =Scanner( System.`in`)

    while( true ){
        println(" Please enter a number to convert..")

        subject.state = scan.nextInt()
        // set..
    }




}