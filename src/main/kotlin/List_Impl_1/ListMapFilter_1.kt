
data class     User(val id:Int, val name:String)

data class PaidUser(val id:Int, val name:String, val type:String)

fun isODD( x:Int):Boolean{
    // Abiksha
    // we need to find the reminder..
    // modules   %
    return ( x % 2) != 0
}
/*
trailing return type in JAVA
 func() -> int
{
    return 90 ;
}*/

fun main(){


    // Phase I

    val nums: List<Int> = listOf(1,2,3,4,5)

    println(  isODD( 3 )  )  // true
    println(  isODD( 12 )  )  // false


    // 1 3 5  ODD
    // Phase II
    val list:List<Int> = nums.filter(    ::isODD       )  // 1 3 5
    println(list)  // 1 3 5


    // Phase III

    val list37 :List<Int> = nums.filter({ it % 2 != 0 })  // [1, 3, 5]
    val list3 :List<Int> = nums.filter( {  myVariable  ->   myVariable % 2 != 0})   // [1, 3, 5]

    println(list3)

    // Phase VI  Moved out of the bracket since its a lambda expression..
    val list4 :List<Int> = nums.filter {  myVariable:Int ->   myVariable % 2 != 0}   // [1, 3, 5]
    println(list4)
    // Phase V                           ( int )  -> Boolean

    val list5:List<Int> = nums.filter { (it % 2 ) != 0 }   //  // [1, 3, 5]
    println(list5)

    //  val nums: List<Int> = listOf(1,2,3,4,5)
    val mapListSqr: List<Int> = nums.map {  it * it  }  // [1, 4, 9, 16, 25]
    println(mapListSqr)

    // Phase Vi

    val userList : List< User > =  listOf(
    User(1,"Abhipsa"),
    User(2,"Sandeep"),
    User(3,"Sathya")
    )

    userList.filter {  it.id == 2  }
    println(userList)  // [User(id=1, name=Abhipsa), User(id=2, name=Sandeep), User(id=3, name=Sathya)]


    println( userList.filter {  it.id == 2  }) // [User(id=2, name=Sandeep)]

    // Lets move the data on to the paidUser

    val paidUserList : List<PaidUser> = userList.map{
            PaidUser( it.id,it.name,"Paid.")
        // [PaidUser(id=1, name=Abhipsa, type=Paid.), PaidUser(id=2, name=Sandeep, type=Paid.), PaidUser(id=3, name=Sathya, type=Paid.)]
    }

    println("Paid user ")
    println(paidUserList)

    // Assignment..
    // To over come the above problem
    // First we need to ****filter
    // then we need to call the ***map
    // display the users..

    // Phase X

    // Thoughts..
    // Let me find a number which is > 3
    // from 3 onwards take all the even numbers
    // Sum(ADD) up all the even numbers
    // Display the first  number from the list now

    // 4
    // 4 6 8 10
    // 8 12 16 20
    // 8

    // functional composition.. Passed as a function into the builder in form of higher order functions
    fun isGT( n:Int ) = n > 3
    fun isEVEN( n:Int) =  n % 2 == 0
    fun doubleIT(n:Int) = n * 2


    val numbersWithConditions = listOf(1,2,3,4,5,6,7,8,9,10)


    println(  numbersWithConditions   // .filter (::isGT)     // 4
                                    .filter( ::isEVEN )  // 4 6 8 10
                                    .map( ::doubleIT)    // 8 12 16 20
                                   // .first()             //  8
    )

    // we need all even then double stored in a diffrent list..
    // lets append all the changed values ( isGT Even double store it on to a new list

    val fruits = listOf("Bananna","Grape","Avocado","Apple","Kiwi Fruit")
    fruits
        //.filter{ it.startsWith("A")  or it.startsWith("a")}
            .sortedBy{it}
        .map{ it.uppercase() }
        .forEach { println(it) }

/*
APPLE
AVOCADO
BANANNA
GRAPE
KIWI FRUIT
 */

    var people = listOf<User>( User(10,"Manas"),User(12,"Sanath"),User(12,"Aditya"),User(16,"Suresh"))
    var filteredUsers = people.filter {  people -> people.name.startsWith("S") }.map { it.name }

    for( name in filteredUsers) {
        println(name)
        println()


    }

    //  mapof with out
//                            open class Vehicle
//                            class  Motorcycle : Vehicle()
//                            class Skateboard : Vehicle()
//                            class _Car       : Vehicle()
//
//                           // val vehicleInfo : Map<KClass<Vehicle>, Map<String, String>> mapOf(
//                            val vehicleInfo : Map<KClass<out Vehicle>, Map<String, String>> mapOf(
//                            _Car::class to mapOf("wheels" to "4", "license_required" to "true"),
//                            Motorcycle::class to mapOf("wheels" to "2", "license_required" to "true"),
//                            Skateboard::class to mapOf("wheels" to "4", "license_required" to "false"),
//                            )

    val theMap = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)

    val itr = theMap.keys.iterator()
    while (itr.hasNext()) {
        val key = itr.next()
        val value = theMap[key]
        println("${key}=$value")
    }


}








