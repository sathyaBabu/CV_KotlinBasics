package DesignPatterns


// Relation Ship   :    IS - A

// Cricket player - Stadium
// VB Player     - Ground
// TT Player    - Court
// Student      - School
// Patient      - Hospital
// people       - rest..



class Calculation {
    fun calArea(length: Int, breadth: Int): Int {
        return length * breadth
    }
}

class Rectangle3 {
    var cal // Use of Aggregation.
            : Calculation? = null

    fun area(length: Int, breadth: Int): Int {
        cal = Calculation()
        return cal!!.calArea(length, breadth)
    }
}



fun main() {
    val rec = Rectangle3()
    val result: Int = rec.area(25, 60)
    println("Area of rectangle: $result")
}
