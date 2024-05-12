package DesignPatterns

import SOLID.Individual1
import java.text.DecimalFormat

interface  _Visitor {
    // Created to automatically use the right
    // code based on the Object sent
    // Method Overloading
    fun visit(cellPhone: Cell)
    fun visit(housing  : Housing)
    fun visit(education: Education)


    //fun visit(burger : Burger)

}

                    interface  Ind : _Visitor{
                        fun visit(individual1: Individual1)
                    }

interface Visitable {
    // Allows the Visitor to pass the object so
    // the right operations occur on the right
    // type of object.
    // accept() is passed the same visitor object
    // but then the method visit() is called using
    // the visitor object. The right version of visit()
    // is called because of method overloading
    fun accept(visitor: _Visitor)
}
interface  _Visitable {
    fun accept(visitor: _Visitor)
}
class Cell(val price: Double)  : Visitable {

    override fun accept(visitor: _Visitor) {
        visitor.visit(cellPhone = this)
    }


}
//  multiple inheritance

//open class kk
//class Education(val price: Double) : Visitable, kk() {
//}

//class MyClass(val price: Double)

open class Education(val price: Double) : Visitable {

    override fun accept(visitor: _Visitor) {
         visitor.visit(education = this)
    }
}

/// extending Education without touching it  ********* PHase II ********

class MyClass(val price1: Double) : Visitable , Education(price1) {


//    fun saySomething(){
//         println(" At MyCalass extended from Education now")
//     }
    override fun accept(visitor: _Visitor) {

        visitor.visit(education = this)
    }
}


////////////

class Housing(val price: Double) : Visitable {

    override fun accept(visitor: _Visitor) {
        visitor.visit(housing = this)
    }
}
//-----------------

class TaxHolidayVisitor  // This is created so that each item is sent to the
// right version of visit() which is required by the
// Visitor interface and defined below
    : _Visitor {
    // This formats the item prices to 2 decimal places
    var df = DecimalFormat("#.##")

    // Calculates total price based on this being taxed
    // as a Cell item
    override fun visit(cellPhone: Cell) {
        println("Cell Phone Price with Tax")
         println("${df.format(cellPhone!!.price * .15 + cellPhone.price).toDouble() }")
    }

    // Calculates total price based on this being taxed
    // as a Housing item
    override fun visit(housing: Housing) {
        println("Housing Property: Property with Tax")
        println("${df.format(housing!!.price * .5 + housing.price).toDouble() }")

    }
    override fun visit(education: Education) {

        println("Education : Schooling  Tax")
        println("${df.format(education!!.price * .01 +education.price).toDouble() }")

    }



}

class TaxVisitor  // This is created so that each item is sent to the
// right version of visit() which is required by the
// Visitor interface and defined below
    : _Visitor {
    // This formats the item prices to 2 decimal places
    var df = DecimalFormat("#.##")

    // Calculates total price based on this being taxed
    // as a Cell item
    override fun visit(cellPhone: Cell) {
        println("Cell Phone: Price with Tax")
        println("${df.format(cellPhone!!.price * .28 + cellPhone.price).toDouble() }")
    }

    // Calculates total price based on this being taxed
    // as a Housing item
    override fun visit(housing: Housing) {
        println("Housing Property: Property with Tax")
        println("${df.format(housing!!.price * .18 + housing.price).toDouble() }")

    }
    override fun visit(education: Education) {

        println("Education : Schooling  Tax")
        println("${df.format(education!!.price * .5 +education.price).toDouble() }")

    }




}


fun main(){
    val taxCalc        = TaxVisitor()
    val taxHolidayCalc = TaxHolidayVisitor()

    val education = Education(8000.00)
    val cellPhone = Cell(16700.99)
    val housing   = Housing(700000.30)

    val products = mutableListOf(Education(8000.00),Cell(16700.99),Housing(700000.30))
   // val products = mutableListOf(MyClass(1000.00),Education(8000.00),Cell(16700.99),Housing(700000.30))

    products.forEach{ it.accept(visitor = taxCalc)}
    println(taxCalc.toString())
    println("-*-".repeat(50))


    products.forEach{ it.accept(visitor = taxHolidayCalc)}
    println(taxHolidayCalc.toString())
    println("-#-".repeat(50))

    println(
        """
                ${education.accept(taxCalc)}

                """.trimIndent()
    )
    println(
        """
                ${cellPhone.accept(taxCalc)}

                """.trimIndent()
    )
    println(
        """
                ${housing.accept(taxCalc)}

                """.trimIndent()
    )

    println("TAX HOLIDAY PRICES\n")

    println(
        """
                ${education.accept(taxHolidayCalc)}

                """.trimIndent()
    )
    println(
        """
                ${cellPhone.accept(taxHolidayCalc)}

                """.trimIndent()
    )
    println(
        """
                ${housing.accept(taxHolidayCalc)}

                """.trimIndent()
    )

}

/*
Education : Schooling  Tax
12000.0
Cell Phone: Price with Tax
21377.27
Housing Property: Property with Tax
826000.35
DesignPatterns.TaxVisitor@2344fc66
-*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*-
Education : Schooling  Tax
8080.0
Cell Phone Price with Tax
19206.14
Housing Property: Property with Tax
1050000.45
DesignPatterns.TaxHolidayVisitor@36d4b5c
-#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#--#-
Education : Schooling  Tax
12000.0
kotlin.Unit

Cell Phone: Price with Tax
21377.27
kotlin.Unit

Housing Property: Property with Tax
826000.35
kotlin.Unit

TAX HOLIDAY PRICES

Education : Schooling  Tax
8080.0
kotlin.Unit

Cell Phone Price with Tax
19206.14
kotlin.Unit

Housing Property: Property with Tax
1050000.45
kotlin.Unit


Process finished with exit code 0
 */