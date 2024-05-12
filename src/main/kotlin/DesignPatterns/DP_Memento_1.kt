package DesignPatterns

data class Memento( val state: String)


// Originator knows about the Memento and its internal state..
class Originator( var state : String){

    fun createMemento() : Memento {
        return  Memento(state)
    }

    fun restore(memento: Memento){
        state = memento.state
    }

}

// He will not inspect the contents of the Memento He simply saves and retrives the same depending on the user request..

class CareTaker{

    private  val mementoList = ArrayList<Memento>()

    fun saveState( state: Memento){
        mementoList.add( state)
    }

    fun restore(index: Int): Memento{
        return  mementoList[ index ]
    }

}



fun main(){


    val originator = Originator("Initial State ")
    val careTaker = CareTaker()
    careTaker.saveState( originator.createMemento() )

    originator.state = "State #1"
    originator.state = "State #2"

    careTaker.saveState( originator.createMemento() )

    originator.state = "State #3"
    println("Current state : ${originator.state}")


   originator.restore(careTaker.restore(1))
    println("Current state : ${originator.state}")


    originator.restore(careTaker.restore(0))
    println("Current state : ${originator.state}")


}
/*
Current state : State #3
Current state : State #2
Current state : Initial State

Process finished with exit code 0

 */