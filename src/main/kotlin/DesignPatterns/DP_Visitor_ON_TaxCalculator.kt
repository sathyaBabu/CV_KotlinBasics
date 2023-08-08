package DesignPatterns

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
interface _Visitor{

    fun visit( _Car      : _Car )
    fun visit( _Education: _Education)
    fun visit( _Housing  : _Housing)

//    fun   visit( taxCalculator: TaxCalculator)
    // fun visit( < T > )
}
//
//            interface IndTaxcCalculator : _Visitor{
//
//                fun   visit( taxCalculator: TaxCalculator)
//            }
// Visit Male , Female , Teen, Male_Sr_cit
// Manish
interface _Visitable{
    fun accept( _Visitor: _Visitor)
}

// Auditor to cal tax on the _Car
class _Car( val price : Double)  : _Visitable {
    override fun accept(_Visitor: _Visitor) {
        _Visitor.visit(_Car = this)

    }
}

// Auditor to cal tax on your _Education
open class _Education( val price : Double): _Visitable{
    override fun accept(_Visitor: _Visitor) {
        _Visitor.visit(_Education = this)
    }

}

class _MyClass(val price1:Double) : _Visitable, _Education( price1){

    override fun accept(_Visitor: _Visitor) {

        super.accept(_Visitor)
        println(" At MyCalss accept() ")
        _Visitor.visit(_Education = this)
    }
}


// Auditor to cal tax on your  property
class _Housing( val price : Double) : _Visitable{
    override fun accept(_Visitor: _Visitor) {
        _Visitor.visit(_Housing = this)
    }

}

// Job of the Auditor in turn will have various class to work on tax
// CalTax . TaxWaveOff
class TaxHoliday_Visitor : _Visitor{

    var df = DecimalFormat("#.##")

    override fun visit(_Car: _Car) {
        println(" _Car On Road Price with Tax ")
        println("${df.format(_Car!!.price * .15 + _Car.price).toDouble() }")
    }

    override fun visit(_Education: _Education) {
        println("_Education Tax lavied  ")
        println("${df.format(_Education!!.price * .1 + _Education.price).toDouble() }")
    }

    override fun visit(_Housing: _Housing) {
        println(" Property  Tax ")
        println("${df.format(_Housing!!.price * .5 + _Housing.price).toDouble() }")
    }

}


class Tax_Visitor : _Visitor{
    var df = DecimalFormat("#.##")
    override fun visit(_Car: _Car) {


        println(" _Car On Road Price with Tax ")
        println("${df.format(_Car!!.price * .28 + _Car.price).toDouble() }")
    }

    override fun visit(_Education: _Education) {
        println("_Education Tax lavied  ")
        println("${df.format(_Education!!.price * .4 + _Education.price).toDouble() }")
    }

    override fun visit(_Housing: _Housing) {
        println(" Property  Tax ")
        println("${df.format(_Housing!!.price * .15 + _Housing.price).toDouble() }")
    }
}




fun main()
{

    val taxCal = Tax_Visitor()
    val taxHoliday_Visitor = TaxHoliday_Visitor()

    val _Education    = _Education( price = 8000.90)
    val _Car          = _Car( 178000.00)
    val _Housing      = _Housing( 7000000.30)
    val _MyClass      = _MyClass( 3434.00)

    val taxableIncome = mutableListOf( _MyClass(3434.00),_Education(8000.00),_Car(170000.00),_Housing(700000.00))

    taxableIncome.forEach { it.accept( _Visitor = taxCal) }
    println(taxCal.toString())

    println("-###-".repeat(40))


    taxableIncome.forEach { it.accept( _Visitor = taxHoliday_Visitor) }
    println(taxCal.toString())

    println("-$$$-".repeat(40))

    println(""" 
        ${_Education.accept(taxCal)}
    """.trimIndent())


    println(""" 
        ${_Car.accept(taxCal)}
    """.trimIndent())

    println(""" 
        ${_Housing.accept(taxCal)}
    """.trimIndent())

    println("-*".repeat(40))


    println(""" 
        ${_Education.accept(taxHoliday_Visitor)}
    """.trimIndent())


    println(""" 
        ${_Car.accept(taxHoliday_Visitor)}
    """.trimIndent())

    println(""" 
        ${_Housing.accept(taxHoliday_Visitor)}
    """.trimIndent())


}