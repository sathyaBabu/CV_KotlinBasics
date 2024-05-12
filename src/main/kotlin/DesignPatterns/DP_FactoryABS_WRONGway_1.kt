//package DesignPatterns
//
//
//const val HOUSING_LOAN = 1
//const val STUDY_LOAN = 2
//const val CAR_LOAN = 3
//
//const val FIXED_DEPOSIT = 1
//const val MUTUAL_FUNDS_DEPOSIT = 2
//const val RECCURING_DEPOSIT = 3
//
//interface BankDeposit {
//    fun GetDepositType(loanType: Int)
//}
//
//
//interface BankLoan {
//    fun GetLoanType(loanType: Int)
//}
//
//
//class AmanathBank : BankDeposit {
//    override fun GetDepositType(loanType: Int) {
//        // TODO Auto-generated method stub
//        println("get 11% from Amanath Bank Mutual Funds")
//    }
//}
//
//class Bankruptcy {
//    init {
//        // TODO Auto-generated constructor stub
//        println("You are Grounded.. Reality check of the bank being in bank....")
//    }
//}
//
//class CitiBank : BankDeposit {
//    override fun GetDepositType(loanType: Int) {
//        // TODO Auto-generated method stub
//        println("get 8% from CitiBank")
//        println(
//            "A situation u will get 0% on FD "
//                    + "This Bank will close Soon...... "
//        )
//        Bankruptcy()
//    }
//}
////
////class tcitiToInvest : CitiBank() {
////    init {
////        // TODO Auto-generated constructor stub
////        println("Sub Class of citi ")
////    }
////
////    fun Hook() {}
////}
///////////////////////////////// bank loan
//
//
//class carLoan : BankLoan {
//    override fun GetLoanType(loanType: Int) {
//        // TODO Auto-generated method stub
//        println("12% for car loan")
//       // YouAreBlackListed()
//    }
//}
//
//
//class housingLoan : BankLoan {
//    override fun GetLoanType(loanType: Int) {
//        // TODO Auto-generated method stub
//        println("HousingLoan  is 8%")
//    }
//}
//
//class studyLoan : BankLoan {
//    override fun GetLoanType(loanType: Int) {
//        // TODO Auto-generated method stub
//        println("Study loan is 3%")
//    }
//}
//
//class YouAreBlackListed {
//    init {
//        // TODO Auto-generated constructor stub
//        println("Caught you ...")
//    }
//}
//
//
//////////////////////////////// Abs factory
//
//// Factory Producer..
//abstract class AbstractFactory {
//    abstract fun GetLoanType(ltype: Int): BankLoan?
//
//    // virtual  BankLoan GetLoanType(int lType) = 0 ;
//    // can return all the objects using this interface
//    // like fd,mf,recursive etc
//    // Let people inherit and return dynamic objects back to the caller
//    abstract fun GetDepositType(Dtype: Int): BankDeposit?
//}
//// SOLID
//// Interface segrigation principle comes into play
//
//
//class BankDepositFactory : AbstractFactory() {
//    //	// Un wanted!!!!
//    override fun GetLoanType(ltype: Int): BankLoan? {
//        // TODO Auto-generated method stub
//        return null
//    }
//
//    override fun GetDepositType(Dtype: Int): BankDeposit? {
//        TODO("Not yet implemented")
//    }
////
////    // sathyahelp123@gmail.com
////    override fun GetDepositType(DepositType: Int): BankDeposit? {
////        // This function is confined to returnable types
////        // TODO Auto-generated method stub
////        if (DepositType == 0) return null
////        // x = prototypeManager( n );
////        if (DepositType == 1) return CitiBank() // prototype factory
////        if (DepositType == 2) return AmanathBank() // Concrete class
////        // return if (DepositType == 3) SwizzBank() // OCP
////        //  else null // Null pointer factory
////         }}
//}
//
//// people enter bank or kfc by one server SIngleTon
//// factory acts as a menu
//// Abstract factory
//// return new CitiBank(); can be a class in server or a component
//// user can place the order via observer and wait for a notification
//// every layer content cost has been build ( name, calories, cost )
//// after building say a burger store it on prototype
//// Ifts a meal plan : get cost via iterator will hold god
//// if its a combo composite will hold good
//// visitor will calculate cost incurred in various department
//// Insertion of a new condiment can call for adapter
//// or a bridge
//// after placing an order check the state and dispatch.
//// report flyweight or prototype about consumption and report observer for delivery
//// Bring in template to hide the secret of preparing a burger
//// Momento can capture the state of the obj while preparing can help debug
//// Command can teach a new recruit about making burger
//// decorator can do dressing after completion of a product
//// strategy can help in billing the item by card cash cheque
//// chain of responsibility can help  from steward to head captain cook packer stock delivery
////
//
//
//class BankLoanFactory : AbstractFactory() {
//    override fun GetDepositType(Dtype: Int): BankDeposit? {
//        // TODO Auto-generated method stub
//        return null
//    }
//
//    override fun GetLoanType(LoanType: Int): BankLoan? {
//        // TODO Auto-generated method stub
//
//
//        // Room Door wall  FACTORY ???? not Dynamic
//        //  20   50    80   = 150   ( 1  1  1  ) 3 obj
//
//        // Bin tree nx2  ( nested for loop 50000 x 500000 ) how would you search for a key? -> Algo
//        if (LoanType == 0) return null
//        if (LoanType == 1) return studyLoan()
//        // saw the construction with the help of director?/help of Abstractions
//        //
//        if (LoanType == 2) return housingLoan()
//        return if (LoanType == 3) carLoan() else null
//    }
//}
//
//
//object FactoryProducer {
//    // static
//    fun getFactory(choice: Int): AbstractFactory? {
//        if (choice == 1) {
//            return BankLoanFactory() // prototype
//        } else if (choice == 2) {
//            return BankDepositFactory()
//        }
//        // Break OCP Principle - voilation of OCP..
////	      else if( choice == 3 ) // new addition..MODIFICATION
////	      {
////	    	  return new MFunds();
////	      }
//        return null
//    }
//}
///*
//NOTE :
//Violating the ISP also leads to violation of other principles like the Single Responsibility Principle.
//
//*/
//
//
////////////////////////////////
//
////////////////////////////////
//
////////////////////////////////
//fun main(){
//
//    // TODO Auto-generated method stub
//    val sb = StringBuilder("Hello")
//    sb.append("World")
//    sb.replace(1, 2, "Sathya")
//    println("...$sb")
//
//
//    val blFactory = BankLoanFactory()
//    //blFactory.getLoanType(1); //
//    //blFactory.getLoanType(1); //
//    val housing = blFactory.GetLoanType(HOUSING_LOAN)
//
//    housing!!.GetLoanType(0)
//    val study = blFactory.GetLoanType(STUDY_LOAN)
//    study!!.GetLoanType(0)
//    val carloan = blFactory.GetLoanType(CAR_LOAN)
//    carloan!!.GetLoanType(0)
//
//
//    val DepositFactory = BankDepositFactory()
//    //blFactory.getLoanType(1);
//
//    //blFactory.getLoanType(1);
//    val fd = DepositFactory.GetDepositType(FIXED_DEPOSIT)
//    fd!!.GetDepositType(1) //call for citi bank
//
//    val mf = DepositFactory.GetDepositType(MUTUAL_FUNDS_DEPOSIT)
//    mf!!.GetDepositType(2) // 2 amanath
//
//    val recurring = DepositFactory.GetDepositType(RECCURING_DEPOSIT)
//    recurring!!.GetDepositType(3) //3swiz
//
//
//}