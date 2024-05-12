package DesignPatterns
/*

      Bin Tree 3 way of trversal.. in order pre order. from the top
      Using Composite and Iterator Media player
      Composite
      Iterator.    Local date  .. Range Assignment. Iterator... hasNext next

      Adapter
      Bridge..


      Visitor   IMP -> we shall integrate Builder with  Visitor
      Command ->  Word Doc Undo redo Cal -> Undo redo check on all calculations History
               -> Media Player assignment.
      Stratergy -> tak a call at runtime.. By Card , By cash , GPay
      memento


     Visitor : Double dispatching interface..

    A (Represent an operation to be performed on the elements of an object structure.)
     YOU : Visitable...
     elements of the Object structure  YOU
                                                                     Auditor :  Visitor
                                                                     Auditor works upon 3 elements( Class ){YOU : Income/Property/Shares}

                                                                    B ( Visitor lets you define a new operation without changing the classes
                                                                      of the elements on which it operates.
                                                                      )
     Various Elements(Class) of Mine..

     Calc the tax on my INCOME
     calc the tax on my PROPERTY
     Calc the tax on my STOCK/ SHARES


    ***When Auditor works on your class he will not change any of the elements that he is working upon..

    Visitable :  MAll                                                : Visitor YOU want to visit all the 3 stores to get the price.

    NIkie< 12,000,95 > implement the interface Node { fun Accept( visitor ) }
    Reboke< Double >
    Puma< Double  >
    New Balance.



Assignment :

  get the price of S10/HTC  Phone.. from the Builder..
  Visitor will visit builder S10 class and get the cost..

  For a composition or inheritance of builder to get the cost of the phone..

 */

// Double dispatch mach...  A
// Auditor //  YOU

interface ReportVisitor< R> {

    // 3 elements..
    fun visit( contract: FixedPriceContract) :R // Sal   Niki
    fun visit( contract: TimeAndmaterialContract) :R // Property   rebok
    fun visit( contract: SupportContract) :R // Share      puma
}

// Double dispatch mach...  B

interface ReportVisitable{

    fun < R > accept( visitor: ReportVisitor< R >) : R
}

// 3 elements..
// let's implement accept with all the 3 elements ( Class )


class FixedPriceContract( val costPerYear: Long): ReportVisitable {     // Share and Stock
    override fun < R > accept(visitor: ReportVisitor< R >): R {

        return visitor.visit(this)  // Legacy way of writing our code... PLEASE change to the following way...
    }
    fun foo()="Hello from  Fixed price"

}

class TimeAndmaterialContract ( val costPerHour: Long , val hours : Long) : ReportVisitable    {   // Property
    override fun < R > accept(visitor: ReportVisitor< R >): R = visitor.visit(this)


}


class SupportContract ( val costPerMonth: Long) : ReportVisitable {    // Sal
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)

}

// ReportVisitor( FixedPriceContract,TimeAndmaterialContract,SupportContract) shall visit the following
class MonthlyCostReportVisitor : ReportVisitor<Long>{

    override fun visit(contract: FixedPriceContract): Long = contract.costPerYear /12

    /*override fun visit(contractCall: FixedPriceContract):Long{
        contractCall.foo()
        return  12
    }*/

    override fun visit(contract: TimeAndmaterialContract): Long = contract.costPerHour * contract.hours

    override fun visit(contract: SupportContract): Long = contract.costPerMonth

}

class  YearlyReportVisitor : ReportVisitor<Long> {
    override fun visit(contract: FixedPriceContract): Long = contract.costPerYear

    override fun visit(contract: TimeAndmaterialContract): Long = contract.costPerHour * contract.hours

    override fun visit(contract: SupportContract): Long = contract.costPerMonth * 12

}

fun main(){


    val projectFixedPriceContract           = FixedPriceContract( costPerYear = 100000)
    val projectSupportContract              = SupportContract( costPerMonth = 500)
    val projectTimeAndMaterialsContract     = TimeAndmaterialContract( 200, 10)
    val projectTimeAndMaterialsContract2    = TimeAndmaterialContract( 50, 50 )

    val projects = arrayOf(projectFixedPriceContract,projectSupportContract,projectTimeAndMaterialsContract,projectTimeAndMaterialsContract2)

    // Simple way to understand
    val monthlyCostReportVisitor = MonthlyCostReportVisitor()
    val yearlyReportVisitor = YearlyReportVisitor()

    println(" result for Fixed Price Monthly is ${projectFixedPriceContract.accept(monthlyCostReportVisitor)}")
    println(" result for Fixed Price  Yearly is ${projectFixedPriceContract.accept(yearlyReportVisitor)}")

    println(" result for Support Contract Monthly is ${projectSupportContract.accept(monthlyCostReportVisitor)}")
    println(" result for Support Contract   Yearly is ${projectSupportContract.accept(yearlyReportVisitor)}")


    println(" result for Time Andmaterial Contract  Monthly is ${projectTimeAndMaterialsContract.accept(monthlyCostReportVisitor)}")
    println(" result for Time Andmaterial Contract   Yearly is ${projectTimeAndMaterialsContract.accept(yearlyReportVisitor)}")


    //  projectFixedPriceContract.accept(monthlyCostReportVisitor )

println("--".repeat(50))

    val monthlyCost = projects.map {  it.accept( monthlyCostReportVisitor)}. sum()
    println("Consolidation for  Monthly Cost : $monthlyCost")

    println("--".repeat(50))

    val yearlyCost = projects.map { it.accept(yearlyReportVisitor) }.sum()
    println("Consolidation for  Yearly Cost : $yearlyCost")



}


/* OutPut
Monthly Cost : 13333
 Yearly Cost : 110500
 */