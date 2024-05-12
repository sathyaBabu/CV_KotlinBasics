




// implementor Right  side of the diagram
interface Color{
    fun getColor()
}

class Green : Color {
    override fun getColor() {
        println(" Green color")
    }

}


class Red : Color {
    override fun getColor() {
        println(" Red color")
    }

}


class Yello : Color {
    override fun getColor() {
        println(" Yello color")
    }

}

// Left side of the Abstraction diagram
//
//interface House {
//// ref of Color used here in the abstraction layer That is what we call it a Bridge..
//
//    val color:Color    // picked it from implementation layer.. Let any one use it
//
//    fun paint()
//
//}


abstract class House {
// ref of Color used here in the abstraction layer That is what we call it a Bridge..

    abstract val color:Color    // picked it from implementation layer.. Let any one use it

    abstract fun paint()

}


class WoodHouse( override  val color : Color) : House() {
    override fun paint() {
        println("  ${color.getColor()} is used to paint the house ")
    }

}


class RockHouse( override  val color : Color) : House(){
    override fun paint() {
        println("  ${color.getColor()} is used to paint the house ")
    }

}


class PentHouse( override  val color : Color) : House(){
    override fun paint() {
        println("  ${color.getColor()} is used to paint the house ")
    }

}

fun main()
{

    // dependency is the implementor ( Color ) yello is been provided by( Color )
    // implementor is providing the dependency to the abstraction layer..

//    val woodHouse = WoodHouse( Yello() )
//    woodHouse.paint()

    val pentHouse = PentHouse( Green() )
    pentHouse.paint()

    val rockHouse = RockHouse( Red() )
    rockHouse.paint()



}


