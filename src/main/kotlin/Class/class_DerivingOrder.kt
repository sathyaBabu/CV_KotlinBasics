package Class

// Inheritance..  Data security falls apart ..

// Car Wheel Door Str, AC
// Car is composed of .... RIGHT

// S O L I D

// Extended String  closed for Modification Opend for extension....

open class  MyBase {
    init {
          println("I'm at Base class")
    }
}

open class  MyChild : MyBase() {
    init {
        println("I'm at Child  class")
    }

}

class  GrandChild : MyChild() {
    init {
        println("I'm at Grand Child  class")
    }

}

fun main()
{
    var a = GrandChild();
}

/*
I'm at Base class
I'm at Child  class
I'm at Grand Child  class

Process finished with exit code 0

 */