package Class


// When interface is required
//  class Stack  -> Push() pop() isTop()

// Aamir
// Interface can act as a bridge between the core class and implem.. class..
// can u see a tight coupling here..

// we create components interface can build a bridge between components..

// 1. Create a Stack interface
// 2  implement the same on LIFO
// 3  implement the same on FIFO

// 4 Create a List
// 5 make interface as a part of list
// 6. use lifo or fifo

// 7.  IMP  WAIT.. create an abstraction layer to hold the Stack
// 8 ABS layer is what gets used in your list.


interface Stack{
    // Push() pop() isTop()
}

// Abstraction layer  :  // stk = lifo()  -> Bad practice..

class List {

 private  var stack:Stack? = null



    // Bridge..
  //  Stack stk ;
   // stk = lifo()  -> Bad practice..
   // iterator..   forward, reverse
    // its own algo which usses Lifo or fifo..
}


class Fifo : Stack //  1 2 3 4 5 6 7 8 9 10
{

//     Push(  pop() )
//     pop()

}

class Lifo : Stack  // 10 9 8 7  6  5  4 3 2 1
{
//    Push()
//    pop()
}
class Zombi : Stack{

}

interface SoundBehaviour{
    fun makeSound()
}

class  ScreamBehavior( val n:String) : SoundBehaviour {
    override fun makeSound() = println(" Screammmmm  .....")
}


class  RockAndRollBehavior( val n:String) : SoundBehaviour {
    override fun makeSound() = println(" Rock and Roll .....")
}

class Sathya( val n: String) : SoundBehaviour
{
    override fun makeSound() = println(" overide makeSound")
}


// in is as by
// 5 in 1..10
// if( name is String )
// as for casting  Any on to int
// by



// Live data Android..
class  Tom( val n: String) : SoundBehaviour  by ScreamBehavior( n )
class  ElvisPres(n:String) : SoundBehaviour  by RockAndRollBehavior( n)


fun main(){

    val sathya = Sathya(" A budding singer...")

    sathya.makeSound()

    val tom  = Tom( " Thrash metal")
    tom.makeSound()

    val elvisPres = ElvisPres("Dancing on the rain..")
    elvisPres.makeSound()

}