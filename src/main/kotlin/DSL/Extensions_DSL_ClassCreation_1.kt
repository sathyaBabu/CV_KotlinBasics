


data class Person_(var name: String? = null,
                  var age: Int? = null,

                  var address: Address? = null)


data class Address(var street: String? = null,
                   var number: Int? = null,
                   var city: String? = null)

 //Phase I
    fun person(block: (Person_) -> Unit): Person_ {
        val per = Person_()
        block(per)
        return per
    }


fun main(){

    val person = person {
        it.name = "John"
        it.age = 25

    }
    println(person.name);
    println(person.age);
}


//John
//25

