package Class


// Class are not completed. So far


class LibMemberPrototype

// primary constructor also kotlin has secondry constructor..
// Kotlin will not deal with getter and setters..


//data class  LibraryUVC(val _name :String, val _age:Int = 20 )

// PRIMARY CONSTRUCTOR CAN BE CALLED BY SOME OTHER CLASS
// constructor injection and dependency injections but secondry cant
// constructor key word can be omited

class LibMember  constructor ( val _name :String, val _age:Int = 20   ) {

    var name :String
    var age:  Int


    // Initializer block
        init{
            this.name = _name
             this.age =  _age

        }

    fun DisplayData(){
        println("name $name Age $age")
    }

}

fun main()
{

    val member1 = LibMember("aditya")
    val member2 = LibMember("Sai Venkat",23)

    member1.DisplayData()
    member2.DisplayData()

}