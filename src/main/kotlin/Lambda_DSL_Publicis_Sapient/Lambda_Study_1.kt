package Lambda

import Lambda_HighOrderFunctions.HTML


data class Person_(var name: String? = null,
                   var age: Int? = null,
                   var address: Address? = null)


data class Address(var street: String? = null,
                   var number: Int? = null,
                   var city: String? = null)

//Phase I
fun person(block: Person_.() -> Unit): Person_ {
    val per = Person_()
    block( per )
   // per.block()
    return per
}

fun main(){

    val person = person {
        name = "John"
        age = 25
//            address!!.street = "CMH Rd"  // !! non null asserted call
//            address!!.number=323
//             address!!.city="Bangalore"
        address = Address().apply {
            street = "CMH Rd"
            number = 323
            city = "Bangalore"
        }
    }.apply { println("apply -> Name $name Age $age Street ${address?.street} City ${address?.city}") }
    // "if address is not null, then access its street
    println("Regular way!! BORING...")

    println(person.name);
    println(person.age);
    println(person.address!!.number);
}


//John
//25

