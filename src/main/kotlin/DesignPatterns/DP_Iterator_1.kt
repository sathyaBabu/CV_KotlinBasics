package DesignPatterns

//
//interface  myIterator{
//    fun HasNext()
//    fun next()
//   fun remove()
//}


// Write a code to Iterate through a simple L/R bin tree
// or iterate through composite

class Item(  var name : String, var price: Float ){
    override fun toString(): String {
        return "$name : Rs $price"
    }
}

class Menu {
/*
 the lateinit keyword is used for those variables which are initialized after the declaration or
 we can say that the variable which is late initialized is called a lateinit variable.
 */
    lateinit var menuItems: MutableList< Item >

    init {
        menuItems = ArrayList()
    }

    fun addItem( item: Item) {

        menuItems.add( item )
    }

   fun iterator() : MenuIterator {
        return  MenuIterator()
    }

    inner  class MenuIterator : MutableIterator<Item?>{
        var currentIndex = 0

        override fun hasNext(): Boolean {
           return  currentIndex < menuItems.size
        }

        override fun next(): Item? {
            print(" :  ->  $currentIndex   "   )
           return  menuItems[ currentIndex++ ]
        }

        override fun remove() {
           menuItems.removeAt( --currentIndex )  // Why this is not working Check on it..
        }

    }
}

fun main() {
    val i1 = Item( "paper Ream ",300.00f)
    val i2 = Item( "pen  ",30.00f)
    val i3 = Item( "Erser  ",20.00f)
    val i4 = Item( "White Board ",120.00f)
    val i5= Item( "Canvas",222.00f)

    val menu = Menu()
     menu.addItem( i1 )
    menu.addItem( i2 )
    menu.addItem( i3 )
    menu.addItem( i4)
    menu.addItem( i5)

    println(" Display Men Items Now :")

    // MenuIterator : MutableIterator<Item?>
    var iterator: MutableIterator<Item?> = menu.iterator()

    while ( iterator.hasNext()){
        println(iterator.next())
    }


    println("remove the last 2 element....")
    iterator.remove()
    iterator.remove()

   // var iterator: MutableIterator<Item?> = menu.iterator()


    while ( iterator.hasNext()){
        val item: Item? = iterator.next()
        println(item)
    }



}

/*
Display Men Items Now :
 :  ->  0   paper Ream  : Rs 300.0
 :  ->  1   pen   : Rs 30.0
 :  ->  2   Erser   : Rs 20.0
 :  ->  3   White Board  : Rs 120.0
 :  ->  4   Canvas : Rs 222.0

remove the last 2 element....

 */