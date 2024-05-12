package DesignPatterns


// implementation
interface  Color{
    fun getColor()
}

class Yello : Color{
    override fun getColor() {
        println(" Painted with Yello")
    }

}

class Red : Color{
    override fun getColor() {
        println(" Painted with Red")
    }

}

class Green : Color{
    override fun getColor() {
        println(" Painted with Green")
    }

}


// Abstraction layer
interface House_{
    // ref used here in the abstraction layer is what is called as BRIDGE..
    val color : Color   // implementatiopn layer..

    fun show()
}

class WoodHouse( override  val color : Color) : House_{

    // Wrapper to the our color function..
    override fun show() {
        println("My Wood House is painted with :" )
        color.getColor()
    }

}


class GlassHouse( override  val color : Color) : House_{
    override fun show() {
        println("My Glass House is painted with :" )
        color.getColor()
    }

}

fun  main(){

    val greenHouse = WoodHouse ( Green() )
    greenHouse.show()
    val glassHouse = GlassHouse ( Yello() )
    glassHouse.show()

}