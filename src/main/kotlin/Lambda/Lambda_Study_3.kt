package Lambda


// Phase I
data class Person3(var name: String? = null,
                   var age: Int? = null,
                   var address: Address3? = null)


data class Address3(var street: String? = null,
                    var number: Int? = null,
                    var city: String? = null)


fun person3(block: Person3.() -> Unit): Person3 = Person3().apply(block)
// reffers to person.address now( this )

// ------------------> Extension function   O principle
//
 infix fun Person3.address(block: Address3.() -> Unit) : Address3{
    val address3 = Address3().apply(block)
    return address3
}


fun main(){
// Phase I
//
//    val person2 = person2 {
//        it.name = "John"
//        it.age = 25
//    }


// Phase II
//    val person3 = person3 {
//        name = "John"
//        age = 25
//    }

//    println(person3.name);
//    println(person3.age);


    // 2nd step as a surprise


    val person3 = person3 {
        name = "Sandep"
        age = 21

//        address = null
          address =  address {
            street = "Havens Road"
            number = 614
            city = "Ohio"
        }
    }



                        // 1st
                        println(person3.name);
                        println(person3.age);



       person3.address?.let {
//
           println("NOT NULL")
           println(it.city);
           println(it.number);
           println(it.city);
       }

//            println(" Avoiding the null safty Its NULL")
//           // println(it.city);
//            println(person3.address?.number);
//            println(person3.address?.city);

//    // after infix
//
//    println("${person3 address { street } } ");
//    println("${person3 address { number } } ");
//
//    println("${person3 address { city } } ");

}



//Phase I
//    fun person2(block: (Person2) -> Unit): Person2 {
//        val per = Person2()
//        block(per)
//        return per
//    }


// Phase II  A better approach   Please watch Person_ declaration carefully may confuse you guys!!
//fun person3(block: Person3.() -> Unit): Person3 = Person3().apply(block)


// Phase III Lets add Address part here
/*
We’re almost there. We’re just missing one more thing, the Address class.
 In our desired result, it looks a lot like the person function we’ve just created.
 The only difference here is that we have to assign it to the address property of the Person object. To do this,
 we’ll use the last of our three mentioned Kotlin language features: Extension functions.

Extension functions give us the ability to add functions to classes without accessing
the source code of the class itself. This is perfect for creating an Address object
and directly assign it to the address property of Person. This is the final version
of our Dsl file (for now).


We add an address function to Person that accepts a lambda with Address as receiver,
 just like we did with the person constructor function. It then sets the created Address object
 to the property of Person. Now we have created a domain-specific language for creating our model.


go above change the class declaration in main
 */

//
//fun person(block: Person.() -> Unit): Person = Person().apply(block)
//
//fun Person.address(block: Address.() -> Unit) {
//    address = Address().apply(block)
//}
//
//fun person3(block: Person3.() -> Unit): Person3 = Person3().apply(block)
// fun Person3.address(block: Address3.() -> Unit) {
//   val address = Address3().apply(block)
//}
//

