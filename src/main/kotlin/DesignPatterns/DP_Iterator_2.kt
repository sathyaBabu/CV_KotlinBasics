package DesignPatterns


interface Iterator<T> {

    fun hasNext() : Boolean
    fun next()    : Product
}

data class  Product( private val id : Int , private val name : String)
{
//  override fun toString() = "Product: {id= $id, name='$name'}"

}

class StoreData{

    val products = ArrayList< Product >()

    fun add( product: Product){
        products.add(product)
    }

    // Hook
    //    fun createIterator() : Iterator{
    //        return ListIterator(   this )
    //    }

    fun createIterator() = ListIterator( this )

}
// Iterator
class ListIterator( private val collection: StoreData) : Iterator<Any?> {

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
class RevIterator( private val collection: StoreData) : Iterator<Any?> {

    private var index = 0


    override fun next() : Product
    {
        return collection.products[ index++]
    }
    override fun hasNext() : Boolean {

        return index < collection.products.size
    }


}

fun main(){
    val collection = StoreData()

    collection.add( Product(1,"Computer"))
    collection.add( Product(2,"SSDr"))
    collection.add( Product(3,"Key Board"))
    collection.add( Product(4,"USB"))

    val iterator = collection.createIterator()

    while ( iterator.hasNext()){
        println(iterator.next())
    }
}