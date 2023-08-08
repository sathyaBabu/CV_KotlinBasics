package DesignPatterns

import Main_Basics.array
import SOLID.TaxCalculator
import java.text.DecimalFormat


/*




//    // Create fixed sized array for stack as follows and create an inheritance to fix the stack over flow bug
//    val point = IntArray(2)
//    point.set(0,990)
//    point.set(1,10)
//    point.set(2,20)
//    point.set(3,30)
//
//    println(point.get(3))  // error Index 2 out of bounds for length 2
//













     Road Map  for today and Tomorrow

     Builder
         ------> Visitor
     Command
     Composite
     Iterator

     and its dependency


      {
        Iterator...    He gets the cot of the ordered prod. like meal plan....
          {
             Menu -> factory to get the product
           Composite -> He will create a tree of the product.. Meal plan, combo
             {
              Command -> Do / Undo / redo
                     {


                         Visitor -> calculate the cost of the product / Gst / profitmade
                                 {
                                       Builder-> KFC products  ( Creational pattren -> breaking the classs.. )
                                  }
                      }
            }

// A
//                       B                                   B
var button = Button( some object )   -> onClickListener



 */

// Auditor is going to work upon the following class

interface Visitor{

    fun visit( car      : Car )
    fun visit( education: Education)
    fun visit( housing  : Housing)

//    fun   visit( taxCalculator: TaxCalculator)

   // fun visit( < T > )

}
//
//            interface IndTaxcCalculator : Visitor{
//
//                fun   visit( taxCalculator: TaxCalculator)
//            }

// Visit Male , Female , Teen, Male_Sr_cit

// Manish
interface Visitable{
    fun accept( visitor: Visitor)
}

// Auditor to cal tax on the car
class Car( val price : Double)  : Visitable {
    override fun accept(visitor: Visitor) {
        visitor.visit(car = this)

    }
}

// Auditor to cal tax on your education
open class Education( val price : Double): Visitable{
    override fun accept(visitor: Visitor) {
        visitor.visit(education = this)
    }

}

class MyClass(val price1:Double) : Visitable, Education( price1){

    override fun accept(visitor: Visitor) {

        super.accept(visitor)
        println(" At MyCalss accept() ")
        visitor.visit(education = this)
    }
}


// Auditor to cal tax on your  property
class Housing( val price : Double) : Visitable{
    override fun accept(visitor: Visitor) {
        visitor.visit(housing = this)
    }

}

// Job of the Auditor in turn will have various class to work on tax
// CalTax . TaxWaveOff

class TaxHolidayVisitor : Visitor{

    var df = DecimalFormat("#.##")

    override fun visit(car: Car) {
       println(" Car On Road Price with Tax ")
        println("${df.format(car!!.price * .15 + car.price).toDouble() }")
    }

    override fun visit(education: Education) {
        println("Education Tax lavied  ")
        println("${df.format(education!!.price * .1 + education.price).toDouble() }")
    }

    override fun visit(housing: Housing) {
        println(" Property  Tax ")
        println("${df.format(housing!!.price * .5 + housing.price).toDouble() }")
    }

}


class TaxVisitor : Visitor{
    var df = DecimalFormat("#.##")
    override fun visit(car: Car) {


        println(" Car On Road Price with Tax ")
        println("${df.format(car!!.price * .28 + car.price).toDouble() }")
    }

    override fun visit(education: Education) {
        println("Education Tax lavied  ")
        println("${df.format(education!!.price * .4 + education.price).toDouble() }")
    }

    override fun visit(housing: Housing) {
        println(" Property  Tax ")
        println("${df.format(housing!!.price * .15 + housing.price).toDouble() }")
    }
}




fun main()
{

    val taxCal = TaxVisitor()
    val taxHolidayVisitor = TaxHolidayVisitor()

    val education    = Education( price = 8000.90)
    val car          = Car( 178000.00)
    val housing      = Housing( 7000000.30)
    val myClass      = MyClass( 3434.00)

    val taxableIncome = mutableListOf( MyClass(3434.00),Education(8000.00),Car(170000.00),Housing(700000.00))

    taxableIncome.forEach { it.accept( visitor = taxCal) }
    println(taxCal.toString())

    println("-###-".repeat(40))


    taxableIncome.forEach { it.accept( visitor = taxHolidayVisitor) }
    println(taxCal.toString())

    println("-$$$-".repeat(40))

    println(""" 
        ${education.accept(taxCal)}
    """.trimIndent())


    println(""" 
        ${car.accept(taxCal)}
    """.trimIndent())

    println(""" 
        ${housing.accept(taxCal)}
    """.trimIndent())

    println("-*".repeat(40))


    println(""" 
        ${education.accept(taxHolidayVisitor)}
    """.trimIndent())


    println(""" 
        ${car.accept(taxHolidayVisitor)}
    """.trimIndent())

    println(""" 
        ${housing.accept(taxHolidayVisitor)}
    """.trimIndent())


}