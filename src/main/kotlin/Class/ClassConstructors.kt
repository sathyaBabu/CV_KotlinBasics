package Class
/*
As mentioned earlier, Kotlin allows to create one or more secondary constructors
for your class.
This secondary constructor
is created using the constructor keyword. It is required whenever you want to
create more than one constructor in Kotlin or whenever you want to include more logic
in the
primary constructor and you cannot do that because the primary constructor may be called
by some other class.

Secondary constructor do not allow to use val or var with secondary constructor parameters.
Now let's see one example with two secondary constructors:
 */

class LibManagement{
    // Member Variables
    var name: String
    var age: Int
    var salary:Double

    // First Secondary Constructor  : do not allow to use val or var
    constructor ( _name: String, _age: Int) {
        this.name = _name
        this.age = _age
        this.salary = 0.00
                    println("Name = $name")
                    println("Age = $age")
                    println("Salary = $salary")
    }

    // Second Secondary Constructor  : do not allow to use val or var
  //  private  class cannot be constructed
    constructor ( _name: String, _age: Int, _salary: Double) {
        this.name = _name
        this.age = _age
        this.salary = _salary

        println("Name = $name")
        println("Age = $age")
        println("Salary = $salary")
    }
}

fun main(args: Array<String>) {
    val member1 = LibManagement("Sujatha", 34)
    val member2 = LibManagement("Abhi", 50, 20000.00)

}
/*
Name = Sujatha
Age = 34
Salary = 0.0
Name = Abhi
Age = 50
Salary = 20000.0
 */