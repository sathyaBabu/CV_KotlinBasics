import java.text.SimpleDateFormat
import java.util.*

/*

The classes had mutable variables, making it easy to alter its properties.
 If we could change this to immutable vals, we’ll get a compile error saying Val cannot be reassigned.
  To avoid this, we’ll create a builder for our classes.

 */
data class PersonClass(val name: String,
                  val dateOfBirth: Date,
                  var address: AddressClass?)

data class AddressClass(val street: String,
                   val number: Int,
                   val city: String)

fun personfun(block: PersonBuilder.() -> Unit): PersonClass = PersonBuilder().apply(block).build()

// Till you understand.. compare both the blocks

//    fun person2(block: (Person2) -> Unit): Person2 {
//        val per = Person2()
//        block(per)
//        return per
//    }



class PersonBuilder {

    var name: String = ""

    private var dob: Date = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("yyyy-MM-dd").parse(value)
        }

    private var address: AddressClass? = null

    // Link list to hold on to numerous class..
    fun address(block: AddressBuilder.() -> Unit) {
        address = AddressBuilder().apply(block).build()
    }
    // returning PersonClass when build() is called!!!
    fun build(): PersonClass = PersonClass(name, dob, address)

}

class AddressBuilder {

    var street: String = ""
    var number: Int = 0
    var city: String = ""

    fun build() : AddressClass = AddressClass(street, number, city)

}

fun main(){

    val person = personfun {
        name = "John"
        dateOfBirth = "1980-12-01"
        address {
            street = "Main Street"
            number = 12
            city = "London"
        }

    }
}