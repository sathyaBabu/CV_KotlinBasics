package Design_Pattern

interface Iterator{

    fun hasNext() : Boolean
    fun next()    : Product
}

data class  Product( private val id : Int , private val name : String)

class StoreStackData{

    val products = mutableListOf< Product >()

    fun push( product: Product){
        products.add(product)
    }

    fun pop() {
        products.removeAt(products.lastIndex)
    }

    fun top(): Product=products.last()
    // Hook
//    fun createIterator() : Iterator{
//        return ListIterator(   this )
//    }
    fun createIterator(iterationType:String):Iterator? {
        return when(iterationType.lowercase()){
            "lifo"->ListIterator( this )
            "fifo"->ReverseIterator(this)
            else->null
        }
    }

}
// Iterator
class ListIterator( private val collection: StoreStackData) : Iterator{

    private var index = 0
    override fun next() : Product
    {
        return collection.products[ index++]
    }
    override fun hasNext() : Boolean {
        return index < collection.products.size
    }

}
// Iterator
class ReverseIterator( private val collection: StoreStackData) : Iterator{
    private var index = collection.products.lastIndex
    override fun next() : Product
    {
        return collection.products[ index--]
    }
    override fun hasNext() : Boolean {

        return index >= 0
    }
}

fun main(){
    val collection = StoreStackData()
    collection.push( Product(1,"Computer"))
    collection.push( Product(2,"SSDr"))
    collection.push( Product(3,"Key Board"))
    collection.push( Product(4,"USB"))
    val iterator = collection.createIterator("fifo")!!
    while ( iterator.hasNext()){
        println(iterator.next())
    }
}