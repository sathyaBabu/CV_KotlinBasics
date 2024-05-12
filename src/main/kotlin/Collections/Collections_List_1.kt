import java.lang.Math.abs

fun main(args: Array<String>) {

    list1()
    println("*".repeat(40))
    listIterator()
    println("*".repeat(40))
    usingForLoop()
    println("*".repeat(40))
    forEach()
    println("*".repeat(40))
         forListLambda()
    println("*".repeat(40))
    sizeOfList()
    println("*".repeat(40))
    inOperator()  // true
    println("*".repeat(40))
    containMethod()  // true
    println("*".repeat(40))
    emptyMethod()  // false
    println("*".repeat(40))
    indexOf()  // index of two : 1
    println("*".repeat(40))
    getMethod() // Element at 3rd position three
    println("*".repeat(40))

    listAddition()
    println("*".repeat(40))
    listSubtraction()
    println("*".repeat(40))
    slicingAlist()
    println("*".repeat(40))
    removingNull()
    println("*".repeat(40))
    filteringElements()
    println("*".repeat(40))
    droppingFirstNelements()
    println("*".repeat(40))
    groupingListElement()
    println("*".repeat(40))
    mappingListElements()
    println("*".repeat(40))
    chunkingListElements()
    println("*".repeat(40))
    windowingListElements()
    println("*".repeat(40))
    slidingWindow()
    println("*".repeat(40))
    mutableList()
    println("*".repeat(40))
    listIntAny()
    println("*".repeat(40))
    subListDrop()
    println("*".repeat(40))

    findTheWord()
    println("*".repeat(40))




    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))  // [a, b, c]
    println("*".repeat(40))

    println(letters.slice(10..13)) // [k, l, m, n]
    println("*".repeat(40))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>()) // [one, three]
    println("*".repeat(40))

    printContents(listOf("abc", "bac"))  // abc, bac
    println("*".repeat(40))

    printFirst(listOf("Svetlana", "Dmitry"))
    println("*".repeat(40))

    printFirst(listOf(100,234)) // 100 , 234
    println("*".repeat(40))

    val nums = listOf(11, 5, 3, 8, 1, 9, 6, 2)

    val len = nums.count()
    //val max = nums.max()
    //  val min = nums.min()
    val sum = nums.sum()
    val avg = nums.average()

    val msg = """
           
               count: $len, sum: $sum,
               average: $avg
              """

    //  //   max: $max, min: $min,
    println(msg.trimIndent())
    println("*".repeat(40))

    firstLast()
    println("*".repeat(40))

    count()

    println("*".repeat(40))

// flatMap
    flatMap()
    println("*".repeat(40))

    sorted()
    println("*".repeat(40))
    zip()
    println("*".repeat(40))
}

fun zip() {
    val A = listOf("a", "b", "c")                  // 1
    val B = listOf(1, 2, 3, 4)                     // 1

    val resultPairs = A zip B                      // 2
    val resultReduce = A.zip(B) { a, b -> "$a$b" } // 3

    println(resultPairs) // [(a, 1), (b, 2), (c, 3)]
    println(resultReduce) // [a1, b2, c3]
}

fun sorted() {
    val shuffled = listOf(5, 4, 2, 1, 3, -10)                   // 1
    val natural = shuffled.sorted()                             // 2
    val inverted = shuffled.sortedBy { -it }                    // 3
    val descending = shuffled.sortedDescending()                // 4
    val descendingBy = shuffled.sortedByDescending { abs(it)  } // 5
    println(shuffled)
    println(natural)
    println(inverted)
    println(descending)
    println(descendingBy)

}

fun flatMap() {
    val fruitsBag = listOf("apple","orange","banana","grapes")  // 1
    val clothesBag = listOf("shirts","pants","jeans")           // 2
    val cart = listOf(fruitsBag, clothesBag)   // [[apple, orange, banana, grapes], [shirts, pants, jeans]]
    // Higher order {  }
    val mapBag = cart.map { it }   //[[apple, orange, banana, grapes], [shirts, pants, jeans]]
    val flatMapBag = cart.flatMap { it } //[apple, orange, banana, grapes, shirts, pants, jeans]
    println(cart)
    println(mapBag)
    println(flatMapBag)
}

fun count() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val totalCount = numbers.count()                     // 2
    val evenCount = numbers.count { it % 2 == 0 }        // 3
}

fun firstLast() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val first = numbers.first()                          // 2
    val last = numbers.last()                            // 3

    val firstEven = numbers.first { it % 2 == 0 }        // 4
    val lastOdd = numbers.last { it % 2 != 0 }           // 5
}
// Builder is used here
fun subListDrop(){
    var stringList: List<String> = listOf<String>("Ajay","Vijay","Prakash","Vijay","Rohan")
    var intList1: List<Int> = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
    var list: List<String> = listOf<String>("Ajay","Vijay","Prakash")
    for(element in stringList){
        print(element+" ")
    }
    println()
    println(stringList.get(0))
    println(stringList.indexOf("Vijay"))
    println(stringList.lastIndexOf("Vijay"))
    println(stringList.size)
    println(stringList.contains("Prakash"))
    println(stringList.containsAll(list))
    println("**************")
    println(stringList.subList(2,2)) // [Prakash, Vijay]
    println(intList1.subList(3,4)) // 4
    val k = intList1.subList(2,3)    // 3
    println(" $k got a value from 2,3 ")

    println("**************")
    println(stringList.isEmpty()) // false
    println(stringList.drop(1)) // [Vijay, Prakash, Vijay, Rohan]
    println(stringList.dropLast(2)) // [Ajay, Vijay, Prakash]
}

fun listIntAny(){
    var intList: List<Int> = listOf<Int>(1,2,3)
    var stringList: List<String> = listOf<String>("Ajay","Vijay","Prakash")
    var anyList: List<Any> = listOf<Any>(1,2,3,"Ajay","Vijay","Prakash")
    println("print int list")
    for(element in intList){
        println(element)
    }
    println()
    println("print string list")
    for(element in stringList){
        println(element)
    }
    println()
    println("print any list")
    for(element in anyList){
        println(element)
    }
}

fun list1() {
    val theList = listOf("one", "two", "three", "four")
    println(theList)  // [one, two, three, four]

    val theMutableList = mutableListOf("one", "two", "three", "four")
    theMutableList.remove("two")
    println(theMutableList)  // [one, three, four]
}

// Iterator pattern
fun listIterator() {
    val theList = listOf("one", "two", "three", "four")

    val itr = theList.listIterator()
    while (itr.hasNext()) {
        println(itr.next())  // one two three four
    }
}

fun usingForLoop() {
    val theList = listOf("one", "two", "three", "four")

    for (i in theList.indices) {
        println(theList[i])  // one two three four
    }
}

fun forEach() {
    val theList = listOf("one", "two", "three", "four")
    // forEach is a provider..
    theList.forEach { println(it) }
}

fun sizeOfList() {  // Size of the list 5
    val theList = listOf("one", "two", null, "four", "five")

    println("Size of the list " + theList.size)
}

fun inOperator() {
    val theList = listOf("one", "two", "three", "four")

    if("two" in theList){
        println(true)
    }else{
        println(false)
    }
}

fun containMethod() {
    val theList = listOf("one", "two", "three", "four")


    if(theList.contains("two")){
        println(true)
    }else{
        println(false)
    }

}

fun emptyMethod() {
    val theList = listOf("one", "two", "three", "four")

    if(theList.isEmpty()){
        println(true)
    }else{
        println(false)
    }
}


fun indexOf() {
    val theList = listOf("one", "two", "three", "four")

    println("Index of 'two' :  " + theList.indexOf("two"))
}


fun getMethod() {
    val theList = listOf("one", "two", "three", "four")

    println("Element at 3rd position " + theList.get(2))
}

fun findTheWord(){
    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")  // 1

    val first = words.find { it.startsWith("some") }                                // 2
    val last = words.findLast { it.startsWith("some") }                             // 3

    val nothing = words.find { it.contains("nothing") }                             // 4
}


fun listAddition() {
    val firstList = listOf("one", "two", "three")
    val secondList = listOf("four", "five", "six")
    val resultList = firstList + secondList

    println(resultList)
}

fun listSubtraction() {
    val firstList = listOf("one", "two", "three")
    val secondList = listOf("one", "five", "six")
    val resultList = firstList - secondList

    println(resultList)
}
fun slicingAlist() {
    val theList = listOf("one", "two", "three", "four", "five")
    val resultList = theList.slice( 2..4)

    println(resultList)
}

fun removingNull() {
    val theList = listOf("one", "two", null, "four", "five")
    val resultList = theList.filterNotNull()

    println(resultList)
}

fun filteringElements() {
    val theList = listOf(10, 20, 30, 31, 40, 50, -1, 0)
    val resultList = theList.filter{ it > 30}  // [31, 40, 50]

    println(resultList)
}

fun droppingFirstNelements() {
    val theList = listOf(10, 20, 30, 31, 40, 50, -1, 0)
    val resultList = theList.drop(3)  // [31, 40, 50, -1, 0]

    println(resultList)
}
fun groupingListElement() {
    val theList = listOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultList = theList.groupBy{ it % 3}  // {1=[10, 31, 40], 0=[12, 30, 9, -3, 0]}

    println(resultList)
}

fun mappingListElements() {
    val theList = listOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultList = theList.map{ it / 3 } // [3, 4, 10, 10, 13, 3, -1, 0]

    println(resultList)
}

fun chunkingListElements() {
    val theList = listOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultList = theList.chunked(3) // [[10, 12, 30], [31, 40, 9], [-3, 0]]

    println(resultList)
}

fun windowingListElements() {
    val theList = listOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultList = theList.windowed(3)

    println(resultList)
    // [[10, 12, 30], [12, 30, 31], [30, 31, 40], [31, 40, 9], [40, 9, -3], [9, -3, 0]]
}

fun slidingWindow() {
    val theList = listOf(10, 12, 30, 31, 40, 9, -3, 0)
    val resultList = theList.windowed(3, 3)

    println(resultList) // [[10, 12, 30], [31, 40, 9]]
}
fun mutableList() {
    val theList = mutableSetOf(10, 20, 30)

    theList.add(40)
    theList.add(50)
    println(theList) // [10, 20, 30, 40, 50]

    theList.remove(10)
    theList.remove(30)
    println(theList) // [20, 40, 50]
}

/////////////////////////////////////////////////////////////////////////

fun printContents(list: List<Any>) {
    println(list.joinToString())  //  // abc, bac
}

fun <T> printFirst(list: List<T>) {
    if (list.isNotEmpty()) {
        //  println(list.first()) // 100
        println(list) // [100,234]
    }
}
fun forListLambda()
{
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
}

/*
/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=57109:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/lib/tools.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.6.10/e80fe6ac3c3573a80305f5ec43f86b829e8ab53d/kotlin-stdlib-jdk8-1.6.10.jar:/Users/malsneha/AndroidStudioProjects/A_Kotlin/collections/build/classes/kotlin/main:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk7/1.6.10/e1c380673654a089c4f0c9f83d0ddfdc1efdb498/kotlin-stdlib-jdk7-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.6.10/b8af3fe6f1ca88526914929add63cf5e7c5049af/kotlin-stdlib-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains/annotations/13.0/919f0dfe192fb4e063e7dacadee7f8bb9a2672a9/annotations-13.0.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-common/1.6.10/c118700e3a33c8a0d9adc920e9dec0831171925/kotlin-stdlib-common-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-test/1.6.10/59bace81228ddb06ac0dc81bd3a554bb19799715/kotlin-test-1.6.10.jar:/Users/malsneha/.m2/repository/org/jetbrains/kotlinx/kotlinx-coroutines-core/1.3.3/kotlinx-coroutines-core-1.3.3.jar:/Users/malsneha/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib/1.3.61/kotlin-stdlib-1.3.61.jar:/Users/malsneha/.m2/repository/org/jetbrains/annotations/13.0/annotations-13.0.jar:/Users/malsneha/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib-common/1.3.61/kotlin-stdlib-common-1.3.61.jar ListBasics_1Kt
objc[6447]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/bin/java (0x1027c34c0) and /Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/lib/libinstrument.dylib (0x10af4e4e0). One of the two will be used. Which one is undefined.
[one, two, three, four]
[one, three, four]
****************************************
one
two
three
four
****************************************
one
two
three
four
****************************************
one
two
three
four
****************************************
Size of the list 5
****************************************
true
****************************************
true
****************************************
false
****************************************
Index of 'two' :  1
****************************************
Element at 3rd position three
****************************************
[one, two, three, four, five, six]
****************************************
[two, three]
****************************************
[three, four, five]
****************************************
[one, two, four, five]
****************************************
[31, 40, 50]
****************************************
[31, 40, 50, -1, 0]
****************************************
{1=[10, 31, 40], 0=[12, 30, 9, -3, 0]}
****************************************
[3, 4, 10, 10, 13, 3, -1, 0]
****************************************
[[10, 12, 30], [31, 40, 9], [-3, 0]]
****************************************
[[10, 12, 30], [12, 30, 31], [30, 31, 40], [31, 40, 9], [40, 9, -3], [9, -3, 0]]
****************************************
[[10, 12, 30], [31, 40, 9]]
****************************************
[10, 20, 30, 40, 50]
[20, 40, 50]
****************************************
print int list
1
2
3

print string list
Ajay
Vijay
Prakash

print any list
1
2
3
Ajay
Vijay
Prakash
****************************************
Ajay Vijay Prakash Vijay Rohan
Ajay
1
3
5
true
true
**************
[]
[4]
 [3] got a value from 2,3
**************
false
[Vijay, Prakash, Vijay, Rohan]
[Ajay, Vijay, Prakash]
****************************************
****************************************
[a, b, c]
****************************************
[k, l, m, n]
****************************************
[one, three]
****************************************
abc, bac
****************************************
[Svetlana, Dmitry]
****************************************
[100, 234]
****************************************

count: 8, sum: 45,
average: 5.625
****************************************

Process finished with exit code 0

 */