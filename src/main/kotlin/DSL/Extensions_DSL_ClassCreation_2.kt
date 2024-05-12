


// Phase I
data class Person2(var name: String? = null,
                   var age: Int? = null,
                   var address: Address? = null)


data class Address2(var street: String? = null,
                   var number: Int? = null,
                   var city: String? = null)

//Phase I
//    fun person2(block: (Person2) -> Unit): Person2 {
//        val per = Person2()
//        block(per)
//        return per
//    }


// Phase II  A better approach   Please watch Person_ declaration carefully may confuse you guys!!
fun person2(block: Person2.() -> Unit): Person2 = Person2().apply(block)
//                  Person2.() reffers to this


fun main(){
// Phase I
//
//    val person2 = person2 {
//        it.name = "John"
//        it.age = 25
//    }


// Phase II
    val person2 = person2 {
        name = "John"
        age = 25

    }

    // old way
    println(person2.name);
    println(person2.age);
}
