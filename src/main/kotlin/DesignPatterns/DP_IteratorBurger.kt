package DesignPatterns

class Condiments( var name : String , var price : Float){
    override fun toString(): String {
        return "$name : Rs $price"
    }

}




class Burger {

    lateinit var  burgerItems: MutableList< Condiments >   // say goodBye to mutableList.. My own Composition..( Bin tree )

     init {
         burgerItems = ArrayList()
     }
    fun addItem(  condiments: Condiments){
        burgerItems.add( condiments )
    }

    // Hook  -> MFC -> DLL

       fun iterartor() : BurgerIterator {
        return  BurgerIterator()
    }



    inner class BurgerIterator : MutableIterator< Condiments? >{

        var currentIndex = 0 ;

        override fun hasNext(): Boolean {
           return  currentIndex < burgerItems.size
        }

        override fun next(): Condiments? {
           println(" : -> $currentIndex")
            return  burgerItems[ currentIndex++]
        }

        override fun remove() {
           burgerItems.removeAt( --currentIndex)
        }

    }



} // end of the Burger
fun main(){
    val i1 = Condiments("Cheese ",20.0f)
    val i2 = Condiments("Bread ",10.0f)
    val i3 = Condiments("Chicken ",70.0f)
    val i4 = Condiments("Onion",2.0f)

    val bureger = Burger()

    bureger.addItem( i1 )
    bureger.addItem( i2 )
    bureger.addItem( i3 )
    bureger.addItem( i4 )

    var burgerIterator : MutableIterator< Condiments? >   = bureger.iterartor()



    while ( burgerIterator.hasNext()){
        println(burgerIterator.next())
    }


    println("---***---".repeat(30))

    /////// vs IntRange Iterartor

    var chars = 'a' .. 'f'
    // to retrive the data BiDirectional, reverse , regular
    val it = chars.iterator()  // Design pattern
    // Iterator design pattern has two interface
    // hasNext  , it.next()   we will be implimenting

    while( it.hasNext() ){
        val x = it.next()
        println("in range .... a...f $x ")
    }

}