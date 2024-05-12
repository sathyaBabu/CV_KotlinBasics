/*
package ParticipantsCode


import DesignPatterns.ReportVisitor

// NOTE : Its throwing error due ti the usage of same class names.. Else its a good and simple code for you guys to reffer to
interface ReportVisitor<out R> {

    // 3 elements..
    fun visit( contract: NIKE) :R // Sal   Niki
    fun visit( contract: PUMA) :R // Property   rebok
    fun visit( contract: ADDIDAS) :R // Share      puma
}
// Double dispatch mach...  B

interface ReportVisitable{
    fun <R> accept( visitor: ReportVisitor<R>) : R
}

// 3 elements..
// let's implement accept with all the 3 elements ( Class )


class NIKE( val  costPerPiece_NIKE: Long ): ReportVisitable {     // Share and Stock
    override fun <R> accept(visitor: ReportVisitor<R>): R {
        return visitor.visit(this)  // Legacy way of writing our code... PLEASE change to the following way...
    }

}

class PUMA ( val  costPerPiece_PUMA: Long ) : ReportVisitable    {   // Property
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)


}


class ADDIDAS ( val  costPerPiece_ADDIDAS: Long) : ReportVisitable {    // Sal
    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)

}


class Small_Order : ReportVisitor<Long> {
    override fun visit(contract: NIKE): Long = contract. costPerPiece_NIKE

    override fun visit(contract: PUMA): Long = contract. costPerPiece_PUMA

    override fun visit(contract: ADDIDAS): Long = contract. costPerPiece_ADDIDAS

}

class  Bulk_Order : ReportVisitor<Long> {
    override fun visit(contract: NIKE): Long = contract.costPerPiece_NIKE * 10

    override fun visit(contract: PUMA): Long = contract. costPerPiece_PUMA * 5

    override fun visit(contract: ADDIDAS): Long = contract. costPerPiece_ADDIDAS * 17

}

fun main(){


    val projectNIKE           = NIKE(  costPerPiece_NIKE = 1000)
    val projectADDIDAS              = ADDIDAS( 1500)
    val projectTimeAndMaterialsContract     = PUMA( 2000)
    val projectTimeAndMaterialsContract2     = PUMA( 2500 )

    val projects = arrayOf(projectNIKE,projectADDIDAS,projectTimeAndMaterialsContract,projectTimeAndMaterialsContract2)
    val Small_Order = Small_Order()

    //      projectNIKE.accept(Small_Order )


    val Small_Cost = projects.map {  it.accept( Small_Order)}. sum()
    println("Small Order Cost : $Small_Cost")

    val Bulk_Order = Bulk_Order()
    val Bulk_Cost = projects.map { it.accept(Bulk_Order) }.sum()
    println("Bulk Order Cost : $Bulk_Cost")



}

*/
