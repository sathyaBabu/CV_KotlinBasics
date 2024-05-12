package Class

interface SoundBehavior {                                                          // 1
    fun makeSound()
}

////////   we are preparing on a composition
class ScreamBehavior(val n:String): SoundBehavior {                                // 2
    override fun makeSound() = println("Screammmm .... . ${n.toUpperCase()} !!!")
}

class RockAndRollBehavior(val n:String): SoundBehavior {                           // 2
    override fun makeSound() = println("RockAndRoll : I'm The King of Rock 'N' Roll: $n")
}
//////////////////////////////////////////////

class Sathya(val n:String): SoundBehavior
{
    // 3
    override fun makeSound() =  println("override makeSound : $n ")

}
////// Till this point ************* Inheritance **************

// Coroutine  will work without stack faster parllely it will not block your code while running ... Asy calls in it
// it 's a rival for threqads out of thread
/*

     Thread t = new Thread( new Task() ).start().

     2 sec    run blocking scenerio..
     // hello world

 */


// composition on interface ( injecting by interface )
class  TomArya( val n:String) : SoundBehavior by  ScreamBehavior( n )
class  ElvisPresley(n:String) : SoundBehavior by  RockAndRollBehavior( n )

fun main(){

    val sathya = Sathya("A buddding singer")
    sathya.makeSound();
    val tomArya = TomArya("Thrash metal...")
    tomArya.makeSound();    // screeeeeaming

    val elvisPresley = ElvisPresley( "Dancing in the rain : Rock")
    elvisPresley.makeSound()    // Rock
}
/*
override makeSound : A buddding singer
Screammmm .... . THRASH METAL... !!!
RockAndRoll : I'm The King of Rock 'N' Roll: Dancing in the rain : Rock

 */