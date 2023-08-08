package Lambda

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

    println(person)
}

/*
/Users/malsneha/Library/Java/JavaVirtualMachines/corretto-11.0.11/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=52936:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/malsneha/AndroidStudioProjects/A_Kotlin/PS_Day1/build/classes/kotlin/main:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk8/1.6.10/e80fe6ac3c3573a80305f5ec43f86b829e8ab53d/kotlin-stdlib-jdk8-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-jdk7/1.6.10/e1c380673654a089c4f0c9f83d0ddfdc1efdb498/kotlin-stdlib-jdk7-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib/1.6.10/b8af3fe6f1ca88526914929add63cf5e7c5049af/kotlin-stdlib-1.6.10.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains/annotations/13.0/919f0dfe192fb4e063e7dacadee7f8bb9a2672a9/annotations-13.0.jar:/Users/malsneha/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-stdlib-common/1.6.10/c118700e3a33c8a0d9adc920e9dec0831171925/kotlin-stdlib-common-1.6.10.jar Lambda.Lambda_study_5Kt
PersonClass(name=John, dateOfBirth=Mon Dec 01 00:00:00 IST 1980, address=AddressClass(street=Main Street, number=12, city=London))

Process finished with exit code 0

 */