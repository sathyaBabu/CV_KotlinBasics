/*
Kotlin map is a collection of key/value pairs, where each key is unique,
and it can only be associated with one value. The same value can be associated with multiple keys though.
 We can declare the keys and values to be any type; there are no restrictions.

A Kotlin map can be either mutable (mutableMapOf) or read-only (mapOf).

Maps are also known as dictionaries or associative arrays in other programming languages.


 */

fun main() {
    val theMap = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(theMap) // {one=1, two=2, three=3, four=4}

    val theMutableMap = mutableSetOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(theMutableMap) // [(one, 1), (two, 2), (three, 3), (four, 4)]

    /// using java hashMap


    val theMap2 = HashMap<String, Int>()

    theMap2["one"] = 1
    theMap2["two"] = 2
    theMap2["three"] = 3
    theMap2["four"] = 4

    println(theMap2)  // {four=4, one=1, two=2, three=3}


    // Using Pair while Creating Map

    val theMap3 = mapOf(Pair("one", 1), Pair("two", 2), Pair("three", 3))
    println(theMap3) // {one=1, two=2, three=3}

    // kotlin properties

    val theMap4 = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)

    println("Entries: " + theMap4.entries)
    println("Keys:" + theMap4.keys)
    println("Values:" + theMap4.values)

    // Keys:[one, two, three, four]
    // Values:[1, 2, 3, 4]

    // Loop through Kotlin Maps

    val theMap5 = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(theMap5.toString())  // {one=1, two=2, three=3, four=4}

    // using iterator

    val itr = theMap.keys.iterator()
    while (itr.hasNext()) {
        val key = itr.next()
        val value = theMap[key]
        println("${key}=$value")
    }
/*
one=1
two=2
three=3
four=4
 */

    // using for loop

    val theMap6 = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)

    for ((k, v) in theMap6) {
        println("$k = $v")
    }

    /*
    one = 1
two = 2
three = 3
four = 4

     */


    // using for each

    val theMap7 = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)

    theMap7.forEach {
            k, v -> println("Key = $k, Value = $v")
    }

/*
Key = one, Value = 1
Key = two, Value = 2
Key = three, Value = 3
Key = four, Value = 4
 */


    // size of kotlin map

    println("Size of the Map " + theMap7.size)  // Size of the Map 4
    println("Size of the Map " + theMap7.count()) // Size of the Map 4

    // The containsKey() & containsValue() Methods

    val theMap8 = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)

    if(theMap8.containsKey("two")){
        println(true)  // true
    }else{
        println(false)
    }

    if(theMap8.containsValue( 2 )){
        println(true)  // // true
    }else{
        println(false)
    }


    // The isEmpty() Method

    if(theMap8.isEmpty()){
        println(true)
    }else{
        println(false)  // false
    }


    // The get() Method

    // val theMap8 = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)

    println("The value for key two " + theMap8.get("two"))  // The value for key two 2
    // The shorthand [key] syntax is also supported.
    println("The value for key two " + theMap8["two"]) // The value for key two 2

    // map addition

    val firstMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    val secondMap = mapOf("one" to 10, "four" to 4)
    val resultMap = firstMap + secondMap

    println(resultMap)  // one=10, two=2, three=3, four=4}



    // map subtraction

    val theMap11 = mapOf("one" to 1, "two" to 2, "three" to 3)
    val theKeyList11 = listOf("one", "four")
    val resultMap11 = theMap11 - theKeyList11

    println(resultMap11)   //                     {two=2, three=3}

    // Removing Entries from Map


    val theMap12 = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    theMap12.remove( "two")
    println(theMap)

    theMap12 -= listOf("three")
    println(theMap12)
    /*
    {one=1, three=3, four=4}
{one=1, four=4}
     */

    // sorting map elements  SKIP!!! try to understand

    var resultMap12 = theMap.toSortedMap()
    println(resultMap12)
// {four=4, one=1, three=3, two=2}

    // filter value

    val theMap13 = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    var resultMap13 = theMap13.filterValues{ it > 2} // {three=3, four=4}
    println(resultMap13)

    resultMap13 = theMap13.filterKeys{ it == "two"} //
    println(resultMap13)

    resultMap13 = theMap13.filter{ it.key == "two" || it.value == 4}  // {two=2, four=4}
    println(resultMap13)

    // mapping map elements

    val theMap14 = mapOf("one" to 1, "two" to 2, "three" to 3)
    val resultMap14= theMap14.map{ (k, v) -> "Key is $k, Value is $v" }

    println(resultMap14)

    // [Key is one, Value is 1, Key is two, Value is 2, Key is three, Value is 3]



// Kotlin Mutable Map


    val theMapp = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)

    theMapp.put("four", 4)
    println(theMapp)

    theMapp["five"] = 5
    println(theMapp)

    theMapp.remove("two")
    println(theMapp)

//    {one=1, two=2, three=3, four=4}
//    {one=1, two=2, three=3, four=4, five=5}
//    {one=1, three=3, four=4, five=5}


}