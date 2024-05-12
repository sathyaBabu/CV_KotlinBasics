import java.text.SimpleDateFormat
import java.util.*
/*

let’s add a Collection to our model. For example, from now on, a Person can have multiple ADDRESSES_
and these are stored in a List<Address>. This is quite easy. We just change the address property
in our builder to a MutableList<Address>, add a new Address in the address function and pass the List
to the constructor.

 */
data class Person_Class(val name: String,
                       val dateOfBirth: Date,
                       var ADDRESSES_: List<Address_Class>) // changed

data class Address_Class(val street: String,
                        val number: Int,
                        val city: String)

fun personfun_(block: PersonCollectionBuilder_.() -> Unit): Person_Class = PersonCollectionBuilder_().apply(block).build()

// Till you understand.. compare both the blocks

//    fun person2(block: (Person2) -> Unit): Person2 {
//        val per = Person2()
//        block(per)
//        return per
//    }



class PersonCollectionBuilder_ {

    var name: String = ""

    private var dob: Date = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
        }

    private var ADDRESSES_ = mutableListOf< Address_Class >()  // changed

                    //    // Phase I
                    //    fun address(block: AddressCollectionBuilder_.() -> Unit) {
                    //        address.add(AddressCollectionBuilder_().apply(block).build())  // changed
                    //    }
    // phase II
        fun ADDRESSES_(block: ADDRESSES_.() -> Unit) { // chnged
            ADDRESSES_.addAll(ADDRESSES_().apply(block) )  // changed
        }
    //////////////
    // returning PersonClass when build() is called!!!
    fun build(): Person_Class = Person_Class(name, dob, ADDRESSES_)

}
// phase II    changed
// To make it clear this is just a helper class, I’ve named it in capital letters.

class ADDRESSES_: ArrayList<Address_Class>(){
    fun address(block: AddressCollectionBuilder_.() -> Unit) {
        add(  AddressCollectionBuilder_().apply(block).build() )  // changed
    }
}
/////////////////////////

class AddressCollectionBuilder_ {

    var street: String = ""
    var number: Int = 0
    var city: String = ""

    fun build() : Address_Class = Address_Class(street, number, city)

}

fun main(){

    // Phase I
//                val person = personfun_ {
//                    name = "Sathya"
//                    dateOfBirth = "1980-12-01"
//                    address {
//                        street = "Commmercial  Street"
//                        number = 102
//                        city = "Bangalore"
//                    }
//                    address {
//                        street = "Brigade Avenue"
//                        number = 42
//                        city = "Ohio"
//                    }
//                    address {
//                        street = "Dev Avenue"
//                        number = 42
//                        city = "Paris"
//                    }
//                }
//                println(person)

    // Phase II

    val person = personfun_ {
        name = "Sathya"
        dateOfBirth = "1980-12-01"
        ADDRESSES_ {

            address {
                street = "CommercialStreet"
                number = 102
                city = "Bangalore"
            }
            address {
                street = "Black lick"
                number = 614
                city = "Ohio"
            }
            address {
                street = "Dev Avenue"
                number = 42
                city = "Paris"
            }
        }
    }

    println(person)
/*
Because we’re creating lambdas within other lambdas, we can still access the receivers of the outer lambdas!
 The code snippet below can compile and run perfectly.
 */
    val person2 = personfun_ {
        name = "Sathya"
        dateOfBirth = "1980-12-01"
        ADDRESSES_ {
            address {
                ADDRESSES_ {
                    name = "Suresh kamath." // this@personfun_.name = "Suresh kamath."

                }
                street = "Bull streat"
                number = 420
                city = "Mangalore."
            }
        }
    }
    println(person2)

}
/*
PHASE I
Person_Class(name=Sathya, dateOfBirth=Mon Dec 01 00:00:00 IST 1980,
 address=[Address_Class(street=Commmercial  Street, number=102, city=Bangalore),
Address_Class(street=Brigade Avenue, number=42, city=Ohio),
 Address_Class(street=Dev Avenue, number=42, city=Paris)])

 // Phase II
 Person_Class(name=Sathya, dateOfBirth=Mon Dec 01 00:00:00 IST 1980,
 ADDRESSES_=[Address_Class(street=CommercialStreet, number=102, city=Bangalore),
 Address_Class(street=Brigade Avenue, number=42, city=Ohio),
 Address_Class(street=Dev Avenue, number=42, city=Paris)])

// Phase III NOTE SATHYA IS MISSING
Person_Class(name=Suresh kamath., dateOfBirth=Mon Dec 01 00:00:00 IST 1980,
ADDRESSES_=[Address_Class(street=Bull streat, number=420, city=Mangalore.)])


So this is really simple to do. But perhaps we don’t like our DSL like that, and we much rather see it within
an ADDRESSES_ block. This is where it gets tricky ;-)


 */