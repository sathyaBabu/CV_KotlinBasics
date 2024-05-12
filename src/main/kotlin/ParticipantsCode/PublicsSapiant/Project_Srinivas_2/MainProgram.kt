package bugertestprogram

/*

SRINIVASAN Palani
Attachments
22:06 (9 hours ago)
to me

Hi Sathya,

    As per discuss with you I did changes and completed my code . please review it . I changed the whole code and simplified as much I know. Please share your Phone number I won’t disturb you so much . If I have any doubt in Future for this reason, I need your contact number.



Step 1.  IncredientDist.kt          Create the Interface contain fields like cal,cost,name and quantity

Step 2   BurgerBuilder.kt           To create a list of items to create a Burger Like tomato  cheese etc. common for all the ingredients

Step 3    AddIngredeintsDish.Kt     Contain Implementation details of IncredientDish and Total Interface with implementation

Step 4  CompositeMeal.Kt            composite related files to get the node leaf

Step 5  Iterator.kt                 To iterator the Composite list

Step 6  Vistor                      calculate the amount

Step 7  Stragegy.kt.                payment

Step 8  MainProgram.kt              send the input file


Thanks & Regards,

Srinivasan.p


 */




fun main() {




    var burgerMealTwo=MealTypes {
        addIngredients(AddIngredientDish("One",1,20,10))
        addIngredients(AddIngredientDish("Two",1,20,20))
    }.build()

    var nugetMealTwo=MealTypes {
        addIngredients(AddIngredientDish("Three",1,20,30))
        addIngredients(AddIngredientDish("Four",1,20,40))
    }.build()



    var WingsMealTwo=MealTypes {
        addIngredients(AddIngredientDish("Five",1,20,50))
        addIngredients(AddIngredientDish("Six",1,20,60))
    }.build()


    val list: MutableList<IngredientDish> = ArrayList()
    list.addAll(burgerMealTwo)
    list.addAll(nugetMealTwo)
    list.addAll(WingsMealTwo)



    println("------------Meal One-----------------")
     var mealtwoBurger=MealDishImpl{
         this.name=list
     }
    

    val compositeMealTwo=CompositeMeal()
    compositeMealTwo.add(mealtwoBurger);
     //compositeMealTwo.add(mealTwoNuget)
     var mealpaycomposite=compositeMealTwo.display_Node_Leaf()



    val MealsAmount=MealsAmount()

    val BurgerComboBill=BurgerComboBill(calculateTotal(mealpaycomposite))
    val BurgerComboBill_accpt=BurgerComboBill(calculateTotal(mealpaycomposite))


    println(BurgerComboBill_accpt.accept(MealsAmount))


    println("Total Cal ${BurgerComboBill.amount.cal()} --- Total Amount ${BurgerComboBill.amount.cost()}")


    var paymentGateway=PaymentGateWay_ {

        checkNetwork(true)
        cardNum(1234567890)
        paymentMethod("CARD")
        amount(BurgerComboBill.amount.cost())

    }

    paymentGateway.pay()


//end of Meal one with payment

// Meal Two Starts


    /*var burger=MealTypes {
        addIngredients(AddIngredientDish("Tomato",1,20,30))
        addIngredients(AddIngredientDish("Lettuce",1,20,30))
    }.build()

    var nuget=MealTypes {
        addIngredients(AddIngredientDish("Tomato",1,20,30))
        addIngredients(AddIngredientDish("Lettuce",1,20,30))
    }.build()



    println("------------Meal Two-----------------")


    var mealOnefinal= MealDishImpl {
        name=burger
        name=nuget
    }
    val compositeMealOne=CompositeMeal()
    compositeMealOne.add(mealOnefinal);
    compositeMealOne.display_Node_Leaf()
    */







}



fun calculateTotal(displayNodeLeaf: MutableList<IngredientDish>): TotalAmount {

    var total :Int=0;
    var totalcal :Int =0;
    var totalItems :Int=0


    for(displayList in displayNodeLeaf)
    {
        totalcal += displayList.cal()
        total+=displayList.cost()
    }

    totalItems=displayNodeLeaf.size




    return TotalAmount(totalItems,totalcal,total)





}
/*
------------Meal One-----------------
One has calories= 20----> cost=10
Two has calories= 20----> cost=20
Three has calories= 20----> cost=30
Four has calories= 20----> cost=40
Five has calories= 20----> cost=50
Six has calories= 20----> cost=60
 	After Visit Total cals 120 ---- Totaal amount 210kotlin.Unit
Total Cal 120 --- Total Amount 210
Amount Pay By Card is - 210

Process finished with exit code 0

 */