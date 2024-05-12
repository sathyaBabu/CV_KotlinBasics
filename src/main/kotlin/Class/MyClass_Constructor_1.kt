package Class

class  LibManagement{

    var name : String
    var age : Int
    var salary : Double

    constructor( _name : String , _age : Int){
        this.name = _name
        this.age = _age
        this.salary = 0.00

               println("name = $name")
                println("Age = $age")
                println("Salary  = $salary")
    }

    constructor( _name : String , _age : Int, _salary : Double){
        this.name = _name
        this.age = _age
        this.salary = 0.00

        println("name = $name")
        println("Age = $age")
        println("Salary  = $salary")
    }
}

fun main()
{
    val user1 = LibManagement("SAthya",34)
    val user2 = LibManagement("Atif",39)
}