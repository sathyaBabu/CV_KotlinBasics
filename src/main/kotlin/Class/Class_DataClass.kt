package Class

// POJO class..  it just dose store and retrive the data..


// no body no get setters in or data class..
// they have taken out all the boiler plate code

// proxy is out, since dataclass has come in to kotlin..

// + automatically generated equals(), hashCode(), toString(), and copy()



data class _Books(val name: String, val publisher: String, var reviewScore: Int)

fun main(args: Array<String>) {

    val book: _Books = _Books("Kotlin", "Packet", 5)
    println("Name of the Book is--"+book.name) // "Kotlin"
    println("Puclisher Name--"+book.publisher) // "TutorialPoint.com"
    println("Review of the book is--"+book.reviewScore) // 5
    book.reviewScore = 7
    println("Printing all the info all together--"+book.toString())
    //using inbuilt function of the data class

    println("Example of the hashCode function--"+book.hashCode())
    println(book)

    // phase II
    val( name, _, reviewScore) = book
    println(" Name $name review $reviewScore")  // Name Kotlin review 7

    val( _, publisher, reviewScore2) = book
    println(" Name $publisher review $reviewScore2")  // Name Packet review 7
}
