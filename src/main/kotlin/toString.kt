



 class Student(var rollno: Int, var name: String, var city: String)
  {
//    override fun toString(): String
//    { //overriding the toString() method
//        return "$rollno $name $city"
//
//
//    }

     //  override fun toString(): String = "$rollno $name $city"

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s1 = Student(101, "Raj", "Bangalore")
            val s2 = Student(102, "Vijay", "Mysore")

            println(s1.toString()) //compiler writes here s1.toString()
            println(s2) //compiler writes here s2.toString()


        }
    }
}