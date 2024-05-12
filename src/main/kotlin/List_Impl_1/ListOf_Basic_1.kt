package List_Impl_1

fun main(){
    val values = listOf(1,2,3,4,5)
    values.forEach {data ->println( data )}
    println("--- or----")
    values.forEach { println( it ) }
    println("--- or----")
    values.forEach ( ::println )
    println("---  Lambda  ----")


    val isEven = { n: Int -> n % 2 == 0 }
     println( isEven(4) )


    println("--- or----")

    val isEvenNow : (Int) -> Boolean = {  it % 2 == 0 }
    println( isEvenNow(4) )

    println("--- End ----")

    list1()
    listIterator1()
    listBuilderStrat()

}

fun listBuilderStrat() {

    // is already constructed and passed as a dependency to our builder api..
    fun isEven( n : Int) = n % 2 == 0   //  [2, 4, 6, 8, 10]
    fun isGT(n : Int) = n > 3   // [4, 5, 6, 7, 8, 9, 10]
    fun isDouble(n:Int) = n * 2  // [8, 10, 12, 14, 16, 18, 20]
    fun idOdd(n:Int) = n % 2 != 0

    // can also be a third party library.. The class cannot be constructed..

    val numberWithConditions = listOf(1,2,3,4,5,6,7,8,9,10)   // Not Just a class -> Builder -> internal/external Iterator -> Dependency

    // StringBuilder
//        .append()
//        .at()
//        .reverse()


    // Builder design pattern

    // .filter (  dependency of any kind )
    // .map (  dependency of any kind )
    // .first ( )
    // .last()

    /* right inside the filter we are going through an iteration that will fetch the data and its given to isEven
    *   .filter()  .map() .first() all the api reffers to a single instance..
    *
    *
    * .filter( :: isGT  )
    * .filter( ::isEven )
    * .filter { it > 3 }
    *  */

    println(

        numberWithConditions
            .filter { it % 2 != 0} // I need to say what kind of filter we need [2, 4, 6, 8, 10] : it is internal iterator
            /* filter is an api -> Composition / dependency isEven( n : Int)  */

            .map( ::isDouble )     // what kind of map
            .filter (::isEven )
           .last()  // it takes us to the last element


    )

}

fun listIterator1() {
    //  Class : theList
    // interface - Abstraction hasNext()  next()

    // Graph  -> Google maps..  n number of poli line we need to adress to travel from one end to the other..
    // Bin tree    ParentNode Left Right
    // theList.listIterator()

    val theList = listOf("one","two","three","four")

    val itr  = theList.listIterator()   // REVERSE , FORWARD BI DIRECTIONAL  iteration.. works on BinTree
    // external iterator


    while( itr.hasNext()){
        println(itr.next())  // one two three four
    }


    // lets display the list data
    theList.forEach { it-> println(it) }  // one two three four

}

fun list1() {

    // const
    val theList = listOf("one","two","three","four")
    println(theList)

    val theMutableList = mutableListOf("one","two","three","four")
    theMutableList.remove("two")
    println(theMutableList)



}