package Class


data class DataEmployee(
    val name: String,
    val email: String,
    val company: String
) // + automatically generated equals(), hashCode(), toString(), and copy()

// in line of a static class
//Objects like this are often created in Java as anonymous class instances.
object  MyCompany{                                // A singleton
    const val name: String = "MyCompany"
}



fun main() {                                      // Function at the top level
    val employee = DataEmployee("Sathya",               // No `new` keyword
        "sathya@gmail.com", MyCompany.name)
//    println(employee.email)
//    println(employee.name)
//    println(employee.company)


    println(employee.company)  // MyCompany
    println(employee)      // toString  returns all the string back to us here
}

/*
MyCompany
DataEmployee(name=Sathya, email=sathya@gmail.com, company=MyCompany)

Process finished with exit code 0

 */