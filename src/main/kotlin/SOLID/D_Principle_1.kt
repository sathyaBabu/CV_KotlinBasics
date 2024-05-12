package SOLID

/*
  Road map.
  Coding...
    4 days..   Design patterns.. GOF
    Diagram Uscase factory - ABS factory.. Adapters...( limitations )
    Bridge.. Observers..( Live data - MVVM ) Network-> a b(Stock info ) c f( weather report ) j z( uploading the data )
    State Machine (  KOTlin ) ATM (  UI a b c d e f g h )

    Creational pattern     :
    Structural patteran    :
    Behavioural pattern    :



  Android :

      A project Start - End

      Dependency inversion principle...

      class a ,b,c is not dependent on class x,y,z

      calc/ s cal / Health care equipments.  regular cal     :           + - * / =  sqr sin con

      Bridge../ Stack

 */

//   + - * / =  sqr sin con  - > Following can be used as  plugin..


// Body  Frame a,b,c,d,e,f

 interface iOperation{
     fun Operation()
 }
// interface i sthe one which conects the objects to gether ( a --- interface --- b )  or  ( b --- interface --- a )
// BUtton -> interface( onClickListenet() -> which can be used by our app
// Scroll bar   interface   TextView( EditText )

class Add : iOperation {
    override fun Operation() {
        add()
    }
    private  fun add() {
        println(" Add now...")
    }

}

class Sub: iOperation {
    override fun Operation() {
        sub()
    }
    private  fun sub() {
        println(" Sub now...")
    }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Board..  frame

class  Calculator( calc : List< iOperation >){
    private val calc : ArrayList< iOperation >

    init {
        this.calc = calc as ArrayList< iOperation > /* = java.util.ArrayList<SOLID.iOperation> */

    }

    fun implement() {

        calc.forEach {
           it ->  it.Operation()
        }
    }


}

fun main(){

    val calc = ArrayList< iOperation >()

    val add = Add()
    val sub = Sub()

    calc.add( add )
    calc.add( sub )



    val calculatyor = Calculator( calc )
    calculatyor.implement()


}