import java.text.SimpleDateFormat
import java.util.*

// works perfect
// Variable repeat on other apps ERROR
//
//fun takeInput(outputMessage: String): String? {
//    println(outputMessage)
//    return readLine()
//}
//interface Button {
//    fun onClick()
//    fun showButtonOption()
//}
//data class person___Class_(
//    val name: String,
//    val dateOfBirth: Date,
//    var addresses: List<Address_Class_>
//)
//data class Address_Class_(
//    val street: String,
//    val number: Int,
//    val city: String
//)
//fun person__(block: person__CollectionBuilder.() -> Unit): person___Class_ = person__CollectionBuilder().apply(block).build()
//class person__CollectionBuilder {
//    var name: String = ""
//    private var dob: Date = Date()
//    var dateOfBirth: String = ""
//        set(value) {
//            dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
//        }
//    private var addresses = mutableListOf<Address_Class_>()  // changed
//    fun addresses(block: ADDRESSES.() -> Unit) { // chnged
//        addresses.addAll(ADDRESSES().apply(block))  // changed
//    }
//    fun build(): person___Class_ = person___Class_(name, dob, addresses)
//}
//class ADDRESSES : Button, ArrayList<Address_Class_>() {
//    fun address(block: AddressCollectionBuilder.() -> Unit) {
//        val address = AddressCollectionBuilder().apply(block).build()
//        add(address)  // changed
//    }
//    override fun onClick() {
//        address {
//            street = takeInput("Please enter street")!!
//            number = takeInput("Please enter number")!!.toInt()
//            city = takeInput("Please enter city")!!
//            showButtonOption()
//        }
//    }
//    override fun showButtonOption() {
//        val value = takeInput("\"Please choose an option 1 for Insert , 2 for Display\"")
//        if (value!! == "1") {
//            onClick()
//        }
//    }
//}
//class AddressCollectionBuilder {
//    var street: String = ""
//    var number: Int = 0
//    var city: String = ""
//    fun build(): Address_Class_ = Address_Class_(street, number, city)
//}
//fun main() {
//    val person__ = person__ {
//        name = "Sathya"
//        dateOfBirth = "1980-12-01"
//        addresses {
//            showButtonOption()
//        }
//    }
//    println(person__)
//}
//
////            address {
////                city = "Vadodara"
////                number = 123
////                street = "MG Road"
////            }