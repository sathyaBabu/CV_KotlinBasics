


// Phase I
data class _Person2(var name: String? = null,
                   var age: Int? = null,
                   var address: _Address2? = null)


data class _Address2(var street: String? = null,
                    var number: Int? = null,
                    var city: String? = null)

//Phase I
//    fun _Person2(block: (_Person2) -> Unit): _Person2 {
//        val per = _Person2()
//        block(per)
//        return per
//    }


// Phase II  A better approach   Please watch Person_ declaration carefully may confuse
// you guys!!
fun _Person2(block: _Person2.() -> Unit): _Person2 = _Person2().apply(block)
//                  _Person2.() reffers to this




fun main(){
// Phase I
//
//    val _Person2 = _Person2 {
//        it.name = "John"
//        it.age = 25
//    }


// Phase II
   // _Person2 is a this * which provides name and age
    val _Person2 = _Person2 {
        name = "John"
        age = 25
    }.apply { println("apply -> Name $name Age $age ") } // apply -> Name John Age 25

    println("Old way of coding!!! ")
    println(_Person2.name);
    println(_Person2.age);
}
