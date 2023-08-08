package Lambda

import java.text.SimpleDateFormat
import java.util.*
fun takeInput(outputMessage: String): String? {
    println(outputMessage)
    return readLine()
}
interface Button_I {
    fun onClick()
    fun showButton_IOption()
}
data class person___Class_(
    val name: String,
    val dateOfBirth: Date,
    var __addressES: List<_address_Class_>
)
data class _address_Class_(
    val street: String,
    val number: Int,
    val city: String
)
fun person__(block: person__CollectionBuilder.() -> Unit): person___Class_ = person__CollectionBuilder().apply(block).build()
class person__CollectionBuilder {
    var name: String = ""
    private var dob: Date = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
        }
    private var __addressES = mutableListOf<_address_Class_>()  // changed
    fun __addressES(block: __addressES.() -> Unit) { // chnged
        __addressES.addAll(__addressES().apply(block))  // changed
    }
    fun build(): person___Class_ = person___Class_(name, dob, __addressES)
}
class __addressES : Button_I, ArrayList<_address_Class_>() {
    fun _address(block: _addressCollectionBuilder.() -> Unit) {
        val _address = _addressCollectionBuilder().apply(block).build()
        add(_address)  // changed
    }
    override fun onClick() {
        _address {
            street = takeInput("Please enter street")!!
            number = takeInput("Please enter number")!!.toInt()
            city = takeInput("Please enter city")!!
            showButton_IOption()
        }
    }
    override fun showButton_IOption() {
        val value = takeInput("\"Please choose an option 1 for Insert , 2 for Display\"")
        if (value!! == "1") {
            onClick()
        }
    }
}
class _addressCollectionBuilder {
    var street: String = ""
    var number: Int = 0
    var city: String = ""
    fun build(): _address_Class_ = _address_Class_(street, number, city)
}
fun main() {
    val person__ = person__ {
        name = "Sathya"
        dateOfBirth = "1980-12-01"
        __addressES {
            showButton_IOption()
        }
    }
    println(person__)
}

//            _address {
//                city = "Vadodara"
//                number = 123
//                street = "MG Road"
//            }

/*
"Please choose an option 1 for Insert , 2 for Display"
1
Please enter street
OXford
Please enter number
123
Please enter city
London
"Please choose an option 1 for Insert , 2 for Display"
2
person___Class_(name=Sathya, dateOfBirth=Mon Dec 01 00:00:00 IST 1980, __addressES=[_address_Class_(street=OXford, number=123, city=London)])

Process finished with exit code 0

 */