// Kotlin mutable or immutable sets do not allow to have duplicate elements.

fun main() {
    val theSet = setOf("one", "one", "two", "three", "four")  // repete of one one displaye only one

    println(theSet) // [one, two, three, four]

    val theMutableSet = mutableSetOf("one", "two", "three", "four")
    theMutableSet.add("Five")
    theMutableSet.add("Six")

    println(theMutableSet) // [one, two, three, four, Five, Six]

    // remove
    theMutableSet.remove("one")
    theMutableSet.remove("four")

    println(theMutableSet) //  [two, three, Five, Six]
    println("*".repeat(50))
    println(theSet.toString()) // [one, two, three, four]

    // Iterate
    val itr = theSet.asIterable().iterator()
    while (itr.hasNext()) {
        println(itr.next())  // // [one, two, three, four]
    }


    //  using for loop

    for (i in theSet.indices) {
        println(theSet.elementAt(i))  // same as above
    }

    // for each

    theSet.forEach { println(it) }


    // get the size of set

    println("Size of the Set " + theSet.size)   // Size of the Set 4

    // Using cast in

    if("two" in theSet){
        println(true)   // true
    }else{
        println(false)
    }

    // using contain method

    if(theSet.contains("two")){
        println(true)
    }else{
        println(false)
    }


    // using isEmpty

    if(theSet.isEmpty()){
        println(true)
    }else{
        println(false)  // false

    }


    // using index of

    println("Index of 'two' -  " + theSet.indexOf("two"))  // Index of 'two' -  1

    // get element at

    println("Element at 3rd position " + theSet.elementAt(2))  // Element at 3rd position three


    // add two sets

    val firstSet = setOf("one", "two", "three")
    val secondSet = setOf("one", "four", "five", "six")
    val resultSet = firstSet + secondSet

    println(resultSet) // [one, two, three, four, five, six]

    // set subtraction


    val resultSet2 = firstSet - secondSet

    println(resultSet2) // [two, three]


    // filter not null

    val theSet3 = setOf("one", "two", null, "four", "five")
    val resultSet3 = theSet3.filterNotNull()

    println(resultSet3) // [one, two, four, five]



    // Storing elements

    val theSet4 = setOf(10, 20, 30, 31, 40, 50, -1, 0)
    var resultSet4 = theSet4.sorted()
    println(resultSet4)

    resultSet4 = theSet4.sortedDescending()
    println(resultSet4)
//    [-1, 0, 10, 20, 30, 31, 40, 50]
//    [50, 40, 31, 30, 20, 10, 0, -1]


    // filtering elements

    val resultSet5 = theSet4.filter{ it > 30}

    println(resultSet5)

    // dropping elements


    resultSet4 = theSet4.drop(3)

    println(resultSet4)  // [31, 40, 50, -1, 0]



    // grouping of set elements

    val theSet6 = setOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultSet6 = theSet6.groupBy{ it % 3}

    println(resultSet6)  // {1=[10, 31, 40], 0=[12, 30, 9, -3, 0]}


    // Mapping set elements


    val theSet7 = setOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultSet7 = theSet7.map{ it / 3 }

    println(resultSet7)  // [3, 4, 10, 10, 13, 3, -1, 0]


    // chunking elements

    val theSet8 = setOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultSet8 = theSet8.chunked(3)

    println(resultSet8) // [[10, 12, 30], [31, 40, 9], [-3, 0]]

    // windowing elements


    val theSet9 = setOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultSet9 = theSet9.windowed(3)

    println(resultSet9) //[[10, 12, 30], [12, 30, 31], [30, 31, 40], [31, 40, 9], [40, 9, -3], [9, -3, 0]]

    // window 3 , 3

    val theSet10 = setOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultSet10 = theSet10.windowed(3, 3)

    println(resultSet10) // [[10, 12, 30], [31, 40, 9]]

}