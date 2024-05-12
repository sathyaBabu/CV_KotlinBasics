package DesignPatterns

import SOLID.Sub
import java.util.*

abstract  class Observer{
    protected var subj: Subject? = null

    abstract  fun Update()
}

// observable..
class Subject {

    //1. declare number of observers..

    protected  val observers = arrayOfNulls<Observer>( 9 )

    private  var totObjs = 0 ;   // as of now 0 observers registered..

    var state = 0      // holds the change in the state

        // use fragment interface scenerio here!

    set( changedIntValue ){
        field = changedIntValue   // when there is a change in the state call notifyMe()
        notifyMe()
    }

    // following method will reg all the observers..
    fun attach( obs : Observer){
        observers[ totObjs++ ] = obs    // user is getting registered here... with their default this obj
        println("Attached : Processing the data STATE BUSy $totObjs")
    }

    fun notifyMe(){
        // we call all the reg users and inform about the change in the subject..
        for( i in 0 until totObjs){   // 3 times..
            observers[ i ]?.Update()  // 0 Bin 1 Hexa 2 Oct
        }

    }
    @JvmName("getState1")
    fun getState():Int {
        return  state
    }


}

// concrete observer   HEx  Bin Oct

class BinObserver( sub: Subject): Observer() {

    init {
        subj = sub
        subj?.attach(this)  // we are registering ourselves in the subject..
    }

    override fun Update() {
        println(" Bin : ${subj?.getState()?.let { Integer.toBinaryString(it) }}        ")
    }

} // close BinObserver


class OctObserver( sub: Subject): Observer() {

    init {
        subj = sub
        subj?.attach(this)  // we are registering ourselves in the subject..
    }

    override fun Update() {
        println(" OCT : ${subj?.getState()?.let { Integer.toOctalString(it) }}        ")
    }

} // close OctObserver


class HexObserver( sub: Subject): Observer() {

    init {
        subj = sub
        subj?.attach(this)  // we are registering ourselves in the subject..

    }

    override fun Update() {
        println(" Hex: ${subj?.getState()?.let { Integer.toHexString(it) }}        ")
    }

} // close HexObserver


fun main(){

    val subject = Subject()

    HexObserver( subject )  // we are passing the subject to the HexaObserver so that internally he can reg himself to Subject
    OctObserver( subject )
    BinObserver( subject )

// readln
    val scan =  Scanner( System.`in`)

    while( true){
        println(" Enter a number to convert...")
        subject.state = scan.nextInt()
    }

}

/*

Attached : Processing the data STATE BUSy 1
Attached : Processing the data STATE BUSy 2
Attached : Processing the data STATE BUSy 3
 Enter a number to convert...
10
 Hex: a
 OCT : 12
 Bin : 1010
 Enter a number to convert...
5
 Hex: 5
 OCT : 5
 Bin : 101
 Enter a number to convert...
12
 Hex: c
 OCT : 14
 Bin : 1100
 Enter a number to convert...

 */