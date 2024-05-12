package DesignPatterns
/*

Android :

Splash screen
Menu UI

On selection display a card with ( Burger Image and info ) -> Add this to the cart/delete
add all the selected product on to recycler view - card

On cart display selected item / delete

 To bill -> store the bill info on to  MV   VM -

 M V C

Using job scheduler work manager  push this on a specific time date / net availability to server

Back end Preparing the product
(  Bottom )


Sales query
By Day
By Week
By Month

Backend



Display KFC on map
Display the distance


Bottom


Use case 


  The following use case is spread over the project This needs min three days for the participants to culminate 
   Over view on KFC stores Which we have already worked on it.

   Porting builder and its acceptable ways.
   Arranging all the ingredient's names, calories and its cost.
   using a template to hide the way we create a product( Burger )

 UI ->  recycler view creates various adapters to display the feel of the product (Day 3)

   Store it in prototype( as the threshold of the product reduces request the(Builder) template to construct more )
   Creating MVC for the communication layer

  As the user orders a Burger, Combo, meal plan
   let's have all the plans designed in a composite 
  The visitor is implemented to get the cost from the composite/builder ( Iterator is used to iterate over the product )


  Just in case the user changes the mind to have a double cheese Command helps us in navigation over created product


  When user orders a product it's created using the above layers and the observer notifies the user about the product created
Factory pulls the product from a  prototype and its kept ready for further billing process l ( library DLL  dependency )
The user has to move to the cash counter
The strategy works on accepting cash by Card, cash, or by Gpay.

as the product sells data is stored in MVVM
Ingredients, Customer info to is stored at MVVM

BIG O notation.. IMP


memory Profiler...  100      memory usage 67777772222


 */

enum class BankerLoan{ HOUSE, EDU,CAR }

//
//
//open class RBI
//
//class  FD : RBI()
//
//class Loan : RBI()



interface  iBankLoan {

    public fun rateOfIntrest()


}

interface  iBankFD {


    public fun fixedDepositRate()

}
 class HOUSE: iBankLoan {
     override fun rateOfIntrest() {
         println(" Housing rate of intrest 14%")
     }

 }

class EDU : iBankLoan {
    override fun rateOfIntrest() {
        println(" Edu rate of intrest 4%")
    }

}


class CAR : iBankLoan {
    override fun rateOfIntrest() {
        println(" For Car  rate of intrest 18%")
    }

}


//////   factory  provider  (  Dependency injections are provider )

class  BankLoanFactory {

    // Loan FD  MFunds  Insur...
    // use Generic type

    fun queryFactory( type: BankerLoan) : iBankLoan? {

        return when( type ){

            BankerLoan.HOUSE -> HOUSE()
            BankerLoan.EDU   -> EDU()
            BankerLoan.CAR   -> CAR()

            else -> null
        }
    }
}

fun main(){

    val factory = BankLoanFactory()
    val bank1 = factory.queryFactory(BankerLoan.HOUSE)
    bank1?.rateOfIntrest()



    val bank2 = factory.queryFactory(BankerLoan.CAR)
    bank2?.rateOfIntrest()


    val bank3 = factory.queryFactory(BankerLoan.EDU)
    bank3?.rateOfIntrest()

}






















