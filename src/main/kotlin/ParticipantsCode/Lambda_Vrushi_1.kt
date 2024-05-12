import java.text.SimpleDateFormat
import java.util.*
fun takeInput(outputMessage: String): String? {
    println(outputMessage)
    return readLine()
}
//private val button =

// It cant be..  Button Widgets..

val ADDRESSES.button: () -> Unit
    get() = {
        val value = takeInput("\"Please choose an option 1 for Insert , 2 for Display\"")
        if (value!! == "1") {
            address {
                street = takeInput("Please enter street")!!
                number = takeInput("Please enter number")!!.toInt()
                city = takeInput("Please enter city")!!!!
            }
            button
        }
    }

data class Person_Class(
    val name: String,
    val dateOfBirth: Date,
    var addresses: List<Address_Class>
)
/*
Basic design..

Diagram - Object( Component ) Connectivity   Under the address
Approach..  Innerclas????   xxxxx
Comanion Object   xx

inheritance..

Composition   ---> May be...

CAn I have the button to be indipendent can I use an interface to exten the Button in my App..


interface OnClickListener{

}

data class Button(

    val text: String,
    val color: Int,
    var size :Int

)

 */
data class Address_Class(
    val street: String,
    val number: Int,
    val city: String
)
fun person(block: PersonCollectionBuilder.() -> Unit): Person_Class = PersonCollectionBuilder().apply(block).build()
class PersonCollectionBuilder {
    var name: String = ""
    private var dob: Date = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
        }
    private var addresses = mutableListOf<Address_Class>()  // changed
    fun addresses(block: ADDRESSES.() -> Unit) { // chnged
        addresses.addAll(ADDRESSES().apply(block))  // changed
    }
    fun build(): Person_Class = Person_Class(name, dob, addresses)
}
class ADDRESSES : ArrayList<Address_Class>() {
    fun address(block: AddressCollectionBuilder.() -> Unit) {
        val address = AddressCollectionBuilder().apply(block).build()
        add(address)  // changed
    }
}
class AddressCollectionBuilder {
    var street: String = ""
    var number: Int = 0
    var city: String = ""
    fun build(): Address_Class = Address_Class(street, number, city)
}

fun main() {
    val person = person {
        name = "Sathya"
        dateOfBirth = "1980-12-01"
        addresses {
            button
//            address {
//                city = "Vadodara"
//                number = 123
//                street = "MG Road"
//            }
        }
    }
    println(person)
}