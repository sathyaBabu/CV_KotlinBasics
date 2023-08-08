package Lambda

import java.text.SimpleDateFormat
import java.util.*
/*

let’s add a Collection to our model. For example, from now on, a Person can have multiple addresses
and these are stored in a List<Address>. This is quite easy. We just change the address property
in our builder to a MutableList<Address>, add a new Address in the address function and pass the List
to the constructor.

 */

class  Button

data class Person_Class(val name: String,
                        val dateOfBirth: Date,
                        var addresses: List<Address_Class>) // changed

data class Address_Class(val street: String,
                         val number: Int,
                         val city: String)

fun personfun_(block: PersonCollectionBuilder.() -> Unit): Person_Class = PersonCollectionBuilder().apply(block).build()

// Till you understand.. compare both the blocks

//    fun person2(block: (Person2) -> Unit): Person2 {
//        val per = Person2()
//        block(per)
//        return per
//    }



class PersonCollectionBuilder {

    var name: String = ""

    private var dob: Date = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
        }

    private var addresses = mutableListOf< Address_Class >()  // changed

    //    // Phase I
    //    fun address(block: AddressCollectionBuilder.() -> Unit) {
    //        address.add(AddressCollectionBuilder().apply(block).build())  // changed
    //    }
    // phase II
    fun addresses(block: ADDRESSES.() -> Unit) { // chnged
        addresses.addAll(ADDRESSES().apply(block) )  // changed
    }
    //////////////
    // returning PersonClass when build() is called!!!
    fun build(): Person_Class = Person_Class(name, dob, addresses)

}
// phase II    changed
// To make it clear this is just a helper class, I’ve named it in capital letters.

class ADDRESSES: ArrayList<Address_Class>(){

    fun address(block: AddressCollectionBuilder.() -> Unit) {
        add(AddressCollectionBuilder().apply(block).build() )  // changed

    }
}
/////////////////////////

class AddressCollectionBuilder {

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
        // Button_Input  Button_DisplayData
        addresses {

                address {
                    street = "CommercialStreet"
                    number = 102
                    city = "Bangalore"
                    // Button_Input  Button_DisplayData
                }
                address {
                    street = "Black lick"
                    number = 614
                    city = "Ohio"
                    // Button_Input  Button_DisplayData
                }
                address {
                    street = "Dev Avenue"
                    number = 42
                    city = "Paris"
                    // Button_Input  Button_DisplayData
                }
        }
    }

    println(person)

    /*


       Assignment : Create a Button class ( Input / Display ) with listenears in it.. onClickListeners..
       Buttons will be under all objects
       By pressing the relevent number of the button display the object content
       By pressing input : accept and store the data on to the object


       Address 1
        street = "CommercialStreet"
                    number = 102
                    city = "Bangalore"

        Button_Input(1)  Button_DisplayData(2)

     */
/*
Because we’re creating lambdas within other lambdas, we can still access the receivers of the outer lambdas!
 The code snippet below can compile and run perfectly.
 */
    val person2 = personfun_ {
        name = "Sathya"
        dateOfBirth = "1980-12-01"
        addresses {
            address {
                addresses {
                    name = "Suresh kamath." // this@personfun_.name = "Suresh kamath."

                }
                street = "Bull streat"
                number = 420
                city = "Mangalore."
            }
        }
    }
    println(person2)

    println("Please type xxxx ")
    var input:String = readln()
    println(" You typed.. $input")

}
/*
PHASE I
Person_Class(name=Sathya, dateOfBirth=Mon Dec 01 00:00:00 IST 1980,
 address=[Address_Class(street=Commmercial  Street, number=102, city=Bangalore),
Address_Class(street=Brigade Avenue, number=42, city=Ohio),
 Address_Class(street=Dev Avenue, number=42, city=Paris)])

 // Phase II
 Person_Class(name=Sathya, dateOfBirth=Mon Dec 01 00:00:00 IST 1980,
 addresses=[Address_Class(street=CommercialStreet, number=102, city=Bangalore),
 Address_Class(street=Brigade Avenue, number=42, city=Ohio),
 Address_Class(street=Dev Avenue, number=42, city=Paris)])

// Phase III NOTE SATHYA IS MISSING
Person_Class(name=Suresh kamath., dateOfBirth=Mon Dec 01 00:00:00 IST 1980,
addresses=[Address_Class(street=Bull streat, number=420, city=Mangalore.)])


So this is really simple to do. But perhaps we don’t like our DSL like that, and we much rather see it within
an addresses block. This is where it gets tricky ;-)


 */