package DesignPatterns


// Template with strategy...

interface  Strategy{
    fun Travel()      // Gen ALGO...
}

// Lets bring in the template..
abstract class TemplateDrive : Strategy{
    var travelled :Int = 0
    // Case A: functional composition
    override fun Travel() {   // template in turn drives the functionality of our code in an order..

       startDriving()
           while( true){
                 if( distanceTraveled()== 5 )  { travelled = distanceTraveled(); break;}
           }
        stopDriving(travelled)
    }

    protected abstract   fun startDriving()
    protected abstract   fun distanceTraveled() : Int
    protected abstract   fun stopDriving( travelled: Int)
}


// Lets bring in the template..
abstract class TemplateWalk : Strategy{


    // Case A: functional composition
    override fun Travel() {   // template in turn drives the functionality of our code in an order..

        startWalking()
             while(nextMileStone() && !isDestination)
        stopWalking()
    }
    protected abstract   fun startWalking()
    protected abstract   fun nextMileStone() : Boolean
    protected abstract   fun stopWalking()
    protected abstract   val isDestination: Boolean

}


class Walk : TemplateWalk() {
    private var KM = 1

    override fun startWalking() {
        println("Started Walking........   .....    ...   .")
    }

    override fun nextMileStone(): Boolean {
       println(" Mile Stone : ${KM++}")
        return true
    }

    override fun stopWalking() {
        println("Reached the destination Km = $KM. Stopped Walking... .")
    }

    override val isDestination: Boolean
        get() {
            println("is this your destination!! - ${KM == 5 }")
            return KM== 5
            }
}

class Drive  : TemplateDrive() {
    private  var KM = 1

    override fun startDriving() {
        println("Started Driving ...... .. .")
    }

    override fun distanceTraveled(): Int {
       if( KM == 5 ) return  KM else {
           println(" Covered ${KM++} Km.")
       }
        return KM
    }

    override fun stopDriving( travelled:Int) {
       println("Reached the destination Km = $travelled . Stopped Driving... .")
    }

}

fun main(){

    // functional composition.. Higher order function.. lambda expressions..


    //  Case B ...Dynamic. functional composition

    val algorithms = arrayOf( Walk(), Drive() )

    for( start in algorithms.indices){
        LetTheClientDecide(algorithms[ start ] as Strategy)
    }
}

fun LetTheClientDecide(start: Strategy) {

    start.Travel()    // Base class which has been used by Walk as well as Drive

}
/*
Started Walking........   .....    ...   .
 Mile Stone : 1
is this your destination!! - false
Reached the destination Km = 2. Stopped Walking... .
 Mile Stone : 2
is this your destination!! - false
Reached the destination Km = 3. Stopped Walking... .
 Mile Stone : 3
is this your destination!! - false
Reached the destination Km = 4. Stopped Walking... .
 Mile Stone : 4
is this your destination!! - true
Started Driving ...... .. .
 Covered 1 Km.
 Covered 2 Km.
 Covered 3 Km.
 Covered 4 Km.
Reached the destination Km = 5 . Stopped Driving... .

Process finished with exit code 0

 */