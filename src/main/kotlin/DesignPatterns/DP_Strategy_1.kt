package DesignPatterns

import Generic.display

interface Strategy{
    fun Travel()
}



/*



 */
// strategy..
//
//    StartWork
//        .TurnOnNetwork("http://werwer.werwer.com")
//        . Download( Titanic.mp3)
//        .useLib( retrofit() )   20%
//        .store( xyz.class)
//
//            . Display( UI )

// Hey this looks li builder..

//  AsyncTask<String,String,String>
abstract  class TemplateDrive : Strategy {

    // define all the abstraction functione here..

    var travelled : Int = 0 ;

    // Template..
    override fun Travel() {

        startDriving( )

           // Coroutines exception.. profile...
                while ( true ){
                    if(distanceTravelled() == 5 ) { travelled = distanceTravelled(); break }
                }

        stopDriving( travelled )


    }

   // Algorithms...

    protected abstract  fun startDriving()
    protected abstract  fun distanceTravelled() : Int
    protected abstract  fun stopDriving( travelled : Int )


}

abstract  class TemplateWalk : Strategy {

    override fun Travel() {


        startWalking()

              while( nextMileReached() && !isDestination)

        stopWalking()
    }



    protected abstract  fun startWalking()
    protected abstract  fun nextMileReached() : Boolean
    protected abstract  fun stopWalking()
    protected abstract  val isDestination : Boolean
}
// concrete Drive
class  Drive : TemplateDrive(){
    private var KM = 1

    override fun startDriving( ) {
        println("Start Driving.....   ..   .")
    }

    override fun distanceTravelled(): Int {


        if( KM == 5  ) return KM else
            {
                println("Covered ${KM++} Km.")
            }
               return  KM
    }

    override fun stopDriving(travelled: Int) {
       println("Reached the destination Km = $travelled. Stopped Driving")
    }

}

class Walk : TemplateWalk() {
    private var KM = 1

    override fun startWalking() {
       println("Start Walking............ ..... ...    ..     .")
    }

    override fun nextMileReached(): Boolean {
        println("Mile Stone : ${KM++}")
        return true
    }

    override fun stopWalking() {
       println("Reached the destination... Took a ROYAL walk for $KM Km.!!!!")
    }

    override val isDestination: Boolean
        get() {
            println("Is this my  destination!! - ${KM == 5 }")
            return KM == 5
        }



}
fun main(){

// Strategy vary algo ..
    val algorithms = arrayOf( Walk(), Drive() )


    // 1. clents want to travel can I travel by AIR ?  Travel agent ---> NO All flights are booked..
    //  Train
    //   CAB
    //


    // download a song : Volley or retrofit...

    // Strategy
//
//    for( start in algorithms.indices) {
//        LetTheClientDecide( algorithms[ start ] as Strategy)
//    }

    LetTheClientDecide( Drive() )


}

fun LetTheClientDecide(start: Strategy) {

    start.Travel()  // Context ( Template )
}

